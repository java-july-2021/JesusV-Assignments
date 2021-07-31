package com.Jesus.languages.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.Jesus.languages.models.Language;
import com.Jesus.languages.services.LanguageService;

@Controller
public class LanguageControllers {
	@Autowired
	private final LanguageService lService;
	
	public LanguageControllers(LanguageService service) {
		this.lService = service;
	}
	
	@GetMapping("/")
	public String index(Model viewModel, @ModelAttribute("language") Language language) {
		viewModel.addAttribute("allLanguages", this.lService.allLanguages());
		return "index.jsp";
	}
	
	@PostMapping("/")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("allLanguages", this.lService.allLanguages());
			return "index.jsp";
		}
			this.lService.createLanguage(language);
			return "redirect:/";
	}
	
	@GetMapping("/show/{id}")
	public String showLang(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("thisLang",this.lService.findLanguage(id));
		return "show.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String editLang(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("language", this.lService.findLanguage(id));
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}")
	public String editLang(@Valid @ModelAttribute("language") Language language, BindingResult result, Model viewModel, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			viewModel.addAttribute("language", this.lService.findLanguage(id));
			return "edit.jsp";
		}
		this.lService.updateLanguage(language);
		return "redirect:/show/{id}";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
		return "redirect:/";
	}
	
}	