package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {

	@Autowired
	PerformanceRepository performanceRepository;

	@Autowired
	TheatreGroupRepository theatreGroupRepository;

	@ResponseBody
	@GetMapping(value = "/")
	public List<TheatreGroup> index() {

		List<TheatreGroup> theatreGroupInfo = this.getTheatreGroupInfo();

		return theatreGroupInfo;

	}

	@ResponseBody
	@GetMapping(value = "/g")
	public TheatreGroup groupInfo(@RequestParam(name = "groupid", required = false) Integer groupid) {

		TheatreGroup theatreGroupInfo = this.getTheatreGroupInfo(groupid);
		
		return theatreGroupInfo ;

	}
	
//	@ResponseBody
//	@GetMapping(value = "/p")
//	public List<Performance> index() {
//
//		List<TheatreGroup> theatreGroupInfo = this.getTheatreGroupInfo();
//
//		return theatreGroupInfo;
//
//	}


	private List<TheatreGroup> getTheatreGroupInfo() {

		List<TheatreGroup> list_tgs = theatreGroupRepository.findAll();
		System.out.println("here...");
		for ( TheatreGroup tg : list_tgs ) {
			System.out.println(tg);
		}
		return list_tgs;

	}

	private TheatreGroup getTheatreGroupInfo(Integer groupid) {

		Optional<TheatreGroup> list_perf_group = theatreGroupRepository.findById(groupid);

		return list_perf_group.get();
	}

}
