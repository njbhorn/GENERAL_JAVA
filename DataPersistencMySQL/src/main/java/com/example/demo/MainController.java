package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
	@Autowired
	private PersonRepository personRepository;

	@GetMapping(path = "/add")
	public @ResponseBody String addNewUser(@RequestParam String name) {
		Person p = new Person();
		p.setName(name);
		personRepository.save(p);
		return "Saved";
	}

	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Person> getAllUsers() {

		return personRepository.findAll();
	}

	@GetMapping(path = "/update")
	public @ResponseBody String updateUser(@RequestParam int id, @RequestParam String name) {
		if (personRepository.existsById(id)) {
			Optional<Person> op = personRepository.findById(id);
			System.out.println(op);
			Person p = op.get();
			p.setName(name);
			personRepository.save(p);
			return "Updated";
		}

		return "ID not valid!";

	}

	@GetMapping(path = "/delete")
	public @ResponseBody String deleteUser(@RequestParam int id) {
		
		if (personRepository.existsById(id)) {
			personRepository.deleteById(id);
			return "Deleted";
		}

		return "ID not valid!";
	}
}
