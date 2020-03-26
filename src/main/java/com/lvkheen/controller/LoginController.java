package com.lvkheen.controller;

import com.lvkheen.entity.CrmUser;
import com.lvkheen.entity.User;
import com.lvkheen.service.UserService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login-page";
    }

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access-denied";
    }

    @GetMapping("/registration")
    public String registrationPage(Model model){
        model.addAttribute("userForm", new CrmUser());
        return "registration-page";
    }

    @PostMapping("/registration")
    public String registerUser(@ModelAttribute("userForm") CrmUser crmUser, Model model, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "registration-page";
        }
        User existingUser = userService.getUser(crmUser.getUsername());
        if (existingUser != null){
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("registrationError", "Username already exists");
            System.out.println("Error");
            return "registration-page";
        } else {
            userService.saveUser(crmUser);
            return "redirect:/login";
        }
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

}
