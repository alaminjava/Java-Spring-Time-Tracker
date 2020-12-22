package com.exam.crud;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {
	private UserRepository userRepository;

	@Autowired
	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping("/login")
	public String userSearchShow(User user) {
		return "login";
	}
	@GetMapping("/signup")
	public String usersignup(User user) {
		return "signup";
	}

	@PostMapping("/login")
	public String userSearch(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "home";
		}

		List<User> list = userRepository.findByUseridAndPassword(user.getUserid(),user.getPassword());
		if (list.size() < 1) {
			return "error";
		} else {
			model.addAttribute("users", list);
			return "home";
		}

	}
	
	@GetMapping("add")
	public String showSaveStudent(User user) {
		return "/login";
	}

	@PostMapping("add")
	public String SaveUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "/login";
		}
		userRepository.save(user);
		model.addAttribute("user", userRepository.findAll());
		return "redirect:/login";
	}
}
