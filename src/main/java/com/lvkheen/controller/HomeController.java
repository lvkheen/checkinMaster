package com.lvkheen.controller;

import java.util.List;

import com.lvkheen.entity.Location;
import com.lvkheen.entity.User;
import com.lvkheen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String welcomePage(){
		return "welcome-page";
	}

	@GetMapping("/home")
	public String homePage(Model model){

		List<Location> locations = userService.getLocations();
		model.addAttribute("locations", locations);

		return "home";
	}

	@GetMapping("/moderator-panel")
	public String leadersPage(Model model){

		List<User> users = userService.getUsers();
		model.addAttribute("users", users);

		return "moderator-panel";
	}

	@GetMapping("/admin-panel")
	public String adminPage(Model model){

		List<User> users = userService.getUsers();
		model.addAttribute("users", users);

		return "admin-panel";
	}

	@GetMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("locationId") int id, Model model){
		userService.deleteLocation(id);
		return "redirect:/home";
	}

	@GetMapping("/newLocationForm")
	public String newLocationForm(Model model){
		Location location = new Location();
		model.addAttribute("location", location);
		return "newLocationForm";
	}

	@PostMapping("/saveLocation")
	public String saveLocation(@Valid @ModelAttribute("location") Location location, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "newLocationForm";
		} else {
			userService.saveLocation(location);
			return "redirect:/home";
		}
	}

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder){
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}


}
