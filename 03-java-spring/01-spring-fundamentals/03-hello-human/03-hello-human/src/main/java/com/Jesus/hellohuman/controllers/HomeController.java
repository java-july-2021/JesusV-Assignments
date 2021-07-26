package com.Jesus.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@RequestMapping("/{name}/{lastName}")
	public String helloThere(@PathVariable("name") String name, @PathVariable("lastName") String lastName, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("lastName", lastName);
		return "index.jsp";
	}

}
