package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class TubeStatusController {
	
	@GetMapping ("/")
	public String getStatusAllLines (Model model) {
		 RestTemplate restTemplate = new RestTemplate();
	     TubeStatus[] tubeStatus = restTemplate.getForObject("https://api.tfl.gov.uk/Line/Mode/tube/Status", TubeStatus[].class);
	     model.addAttribute("status_info", tubeStatus);
	     return "status" ;
	}

}
