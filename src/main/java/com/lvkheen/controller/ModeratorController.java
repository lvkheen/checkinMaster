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
@RequestMapping("/moderator")
public class ModeratorController {

    private UserService userService;

    public ModeratorController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/moderator-panel")
    public String moderatorPanel(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "moderator-panel";
    }

    	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") String username){
		userService.deleteUser(username);
		return "redirect:/moderator/moderator-panel";
	}

	@GetMapping("/banUser")
	public String banUser(@RequestParam("userId") String username){
		userService.banUser(username);
		return "redirect:/moderator/moderator-panel";
	}

	@GetMapping("/restoreUser")
	public String restoreUser(@RequestParam("userId") String username){
		userService.restoreUser(username);
		return "redirect:/moderator/moderator-panel";
	}

}
