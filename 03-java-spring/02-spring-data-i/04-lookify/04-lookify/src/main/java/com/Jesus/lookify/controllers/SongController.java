package com.Jesus.lookify.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.Jesus.lookify.models.Song;
import com.Jesus.lookify.services.SongService;

@Controller
public class SongController {
	@Autowired
	private final SongService songService;
	
	public SongController(SongService service) {
		this.songService = service;
	}

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping("/dashboard")
	public String songDashboard(Model model, @ModelAttribute("songs") Song songs) {
		model.addAttribute("allSongs", this.songService.allSongs());
		return "songs.jsp";
	}
	
	@PostMapping("/dashboard")
	public String addSong(@Valid @ModelAttribute("songs") Song songs, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allSongs", this.songService.allSongs());
			return "songs.jsp";
		}
		this.songService.createSong(songs);
		return "redirect:/dashboard";
	}
	

	@RequestMapping("/songs/{id}")
	public String Show(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", songService.findSong(id));
		return "show.jsp";
	}
	
	@RequestMapping("/songs/search")
	public String Search(@RequestParam("artist") String artist, Model model) {
		model.addAttribute("songs",	songService.songsContainingArtist(artist));
		model.addAttribute("artist", artist);
		return "search.jsp";
	}

	@GetMapping("/songs/new")
	public String newSong(Model viewModel, @ModelAttribute("song") Song song) {
		return "new.jsp";
	}
	
	@PostMapping("/songs/new")
	public String createdSong(@Valid @ModelAttribute("song") Song song, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("allSongs", this.songService.allSongs());
			return "new.jsp";
		}
			songService.createSong(song);
			return "redirect:/dashboard";
	}
	
	
	@RequestMapping("/songs/topTen")
	public String TopTen(Model model) {
		model.addAttribute("songs", songService.topTenByRating());
		return "topTen.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String Delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/songs";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		this.songService.deleteSong(id);
		return "redirect:/dashboard";
	}
		
}
