package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
//	@RequestMapping(value="/",method=RequestMethod.GET)
	@GetMapping(value="/")
	public String demoGet(Model model) {
		model.addAttribute("msg", "Nigel's Demo Thymeleaf") ;
		model.addAttribute("person", new Person() ) ;
		return "demoForm" ;
	}
	
//	@RequestMapping(value="/create",method=RequestMethod.POST)
	@PostMapping(value="/create")
	public String demoPost(@ModelAttribute Person person, Model model ) {
		System.out.println(person);
		return "demoResult" ;
	}

}
