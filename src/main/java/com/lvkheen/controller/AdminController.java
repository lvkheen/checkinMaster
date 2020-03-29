package com.lvkheen.controller;

import com.lvkheen.entity.User;
import com.lvkheen.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin-panel")
    public String adminPage(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "admin-panel";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") String username){
        userService.deleteUser(username);
        return "redirect:/admin/admin-panel";
    }

    @GetMapping("/banUser")
    public String banUser(@RequestParam("userId") String username){
        userService.banUser(username);
        return "redirect:/admin/admin-panel";
    }

    @GetMapping("/restoreUser")
    public String restoreUser(@RequestParam("userId") String username){
        userService.restoreUser(username);
        return "redirect:/admin/admin-panel";
    }

    @GetMapping("/setAdminPermissions")
    public String setAdminPermissions(@RequestParam("userId") String username){
        userService.setAdmin(username);
        return "redirect:/admin/admin-panel";

    }	@GetMapping("/setModeratorPermissions")
    public String setModeratorPermissions(@RequestParam("userId") String username){
        userService.setModerator(username);
        return "redirect:/admin/admin-panel";
    }

}
