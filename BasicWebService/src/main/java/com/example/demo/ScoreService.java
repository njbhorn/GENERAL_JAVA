package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreService {

	@RequestMapping(value="/score"
					, method=RequestMethod.PUT
					, produces=MediaType.APPLICATION_JSON_VALUE )
	public String updateScore(int wins, int losses, int ties) {
		  Score.WINS = wins;
		  Score.TIES = ties;
		  Score.LOSSES = losses;
		  String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
		  return String.format(pattern,Score.WINS, Score.LOSSES, Score.TIES);     
	}
	
//	@RequestMapping(value="/score"
//			, method=RequestMethod.GET
//			, produces=MediaType.APPLICATION_JSON_VALUE )
//	public String updateScore(@RequestParam ( value="wins" ) int wins,
//								@RequestParam ( value="ties") int ties,
//								@RequestParam ( value="losses") int losses) {
//	  Score.WINS = wins;
//	  Score.TIES = ties;
//	  Score.LOSSES = losses;
//	  String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
//	  return String.format(pattern,Score.WINS, Score.LOSSES, Score.TIES);     
//	}

	@RequestMapping(value = "/score/wins", method = RequestMethod.POST)
	public int increaseWins() {
		return ++Score.WINS;
	}

	@RequestMapping(value = "/score/ties", method = RequestMethod.POST)
	public int increaseTies() {
		return ++Score.TIES;
	}

	@RequestMapping(value = "/score/losses", method = RequestMethod.POST)
	public int increaseLosses() {
		return ++Score.LOSSES;
	}

	@RequestMapping(value = "/score/wins", method = RequestMethod.GET)
	public int getWins() {
		return Score.WINS;
	}

	@RequestMapping(value = "/score/ties", method = RequestMethod.GET)
	public int getTies() {
		return Score.TIES;
	}

	@RequestMapping(value = "/score/losses", method = RequestMethod.GET)
	public int getLosses() {
		return Score.LOSSES;
	}
	
	@RequestMapping(value="/score"
					, method=RequestMethod.GET
					, produces=MediaType.APPLICATION_JSON_VALUE)
	public String getScore() {
		String pattern = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
		return String.format(pattern,  Score.WINS, Score.LOSSES, Score.TIES);
	}
}
