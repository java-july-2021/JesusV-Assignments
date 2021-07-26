package com.Jesus.routing.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DojoController {
	
	@RequestMapping("{name}")
	public String showName(@PathVariable("name") String name, Model viewModel) {
		viewModel.addAttribute("name", name);
		return "index.jsp";
	}
	
	@RequestMapping("/{name}/{location}")
	public String showLocation(@PathVariable("name") String name, @PathVariable("location") String location, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("location", location);
		return "index.jsp";
	}
	
	@RequestMapping("/{name}/{headquarters}")
	public String showHeadquarters(@PathVariable("name") String name, @PathVariable("headquarters") String headquarters, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("headquarters", headquarters);
		return "index.jsp";
	}

}
