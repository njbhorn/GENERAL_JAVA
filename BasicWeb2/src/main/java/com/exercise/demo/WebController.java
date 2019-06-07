package com.exercise.demo;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebController {
	
	@GetMapping ("/playagame")
	public String playGame(
			@RequestParam(name="choice", required=false) 
			    String theChoice, 
			       Model model) {
		
		if (theChoice == null) {
			return "index";
		}
		
		String theOutcome = "error";
		if (theChoice.equals("rock")) {
			theOutcome = "tie";
		}
		if (theChoice.equals("paper")) {
			theOutcome = "win";
		}
		if (theChoice.equals("scissors")) {
			theOutcome = "loss";
		}
		
		model.addAttribute("outcome", theOutcome);
		return "results";
		
	}
	
	@GetMapping ("/help")
	public String demo(Model m) {
		m.addAttribute("msg", "Hello World");
		return "help" ;
	}
}
