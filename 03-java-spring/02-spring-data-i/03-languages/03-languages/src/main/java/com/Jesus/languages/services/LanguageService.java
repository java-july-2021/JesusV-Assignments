package com.Jesus.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Jesus.languages.models.Language;
import com.Jesus.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository lRepo;
	
	public LanguageService(LanguageRepository repo) {
		this.lRepo = repo;
	}
	
	public List<Language> allLanguages(){
		return this.lRepo.findAll();
	}
	
	public Language findLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	public Language createLanguage(Language newLang) {
		return this.lRepo.save(newLang);
	}
		
	public Language updateLanguage(Language updatedLang) {
		return this.lRepo.save(updatedLang);
	}
	
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}

}
