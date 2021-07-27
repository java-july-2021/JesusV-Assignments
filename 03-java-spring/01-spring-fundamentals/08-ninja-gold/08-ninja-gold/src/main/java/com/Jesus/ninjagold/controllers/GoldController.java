package com.Jesus.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	@GetMapping("/")
	public String goldHome(HttpSession session, Model viewModel) {
		ArrayList<String> activityList = new ArrayList<String>();
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 10);
		}
		if(session.getAttribute("activities") == null) {
			session.setAttribute("activities", activityList);
		}
		viewModel.addAttribute("totalGold", session.getAttribute("gold"));
		viewModel.addAttribute("activities", session.getAttribute("activities"));
		return "gold.jsp";
	}
	
	@PostMapping("/getGold")
	public String getGold(HttpSession session, @RequestParam("building") String building) {
		ArrayList<String> activity = (ArrayList<String>)session.getAttribute("activities");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM dd YYYY h:mma");
		Random r = new Random();
		int gold = (int)session.getAttribute("gold");
		int goldThisTurn;
		if(building.equals("farm")) {
			goldThisTurn = r.nextInt((20 -10) + 1) - 10;
			activity.add(String.format("You entered a %s and earned %d gold \n", building, goldThisTurn));
		}
		else if(building.equals("cave")) {
			goldThisTurn = r.nextInt((10 -5) + 1) - 5;
			activity.add(String.format("You entered a %s and earned %d gold \n", building, goldThisTurn));
		}
		else if(building.equals("house")) {
			goldThisTurn = r.nextInt((5 -2) + 1) - 2;
			activity.add(String.format("You entered a %s and earned %d gold \n", building, goldThisTurn));
		}
		else {
			goldThisTurn = r.nextInt((50 + 50) + 1) - 50;
			if(goldThisTurn > 0) {
			activity.add(String.format("You entered a %s and earned %d gold \n", building, goldThisTurn));
			}
			else {
				activity.add(String.format("You entered a %s and lost %d gold. OUCH! \n", building, goldThisTurn));
			}
		}
		
		int totalGold = gold + goldThisTurn;
		session.setAttribute("gold", totalGold);
		session.setAttribute("activities", activity);
		return "redirect:/";
	}

}
