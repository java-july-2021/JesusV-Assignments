package com.Jesus.beltexamreview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Jesus.beltexamreview.models.EventUser;
import com.Jesus.beltexamreview.models.State;
import com.Jesus.beltexamreview.services.UserService;
import com.Jesus.beltexamreview.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String Index(@ModelAttribute("registration") EventUser user, Model model) {
		model.addAttribute("states", State.States);
		return "/users/index.jsp";
	}
	
	@PostMapping("/")
	public String Register(@Valid @ModelAttribute("registration") EventUser user, BindingResult result, HttpSession session, Model model) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			model.addAttribute("states", State.States);
			return "/users/index.jsp";
		}
		EventUser newUser = this.uService.registerUser(user);
		session.setAttribute("userId", newUser.getId());
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String Login(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirs) {
		if(this.uService.authenticateUser(email, password)) {
			EventUser user = this.uService.getUserByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/events";
		}
		redirs.addFlashAttribute("error", "Invalid Email/Password");
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "/users/index.jsp";
	}
	
	public Long userId(HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return null;
		}
		return (Long)session.getAttribute("userId");
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}