package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.model.PersonDTO;

@Component
@RequestMapping("/person")
public class PersonDetailController {

	@GetMapping("/form/detailed")
	public String showDetailedForm(Model model) {
		model.addAttribute("persondto",new PersonDTO());
		return "detailedpersonform";
	}
	@PostMapping("/form/detailed")
	public String getDetailedForm(Model model, @ModelAttribute PersonDTO persondto) {
		model.addAttribute("persondto", persondto);
		return "detailedpersonform";
	}
	
	@PostMapping("/showform")
	public String asdfgetDetailedForm(Model model, @ModelAttribute PersonDTO persondto) {
		model.addAttribute("persondto", persondto);
		return "detailedpersonform";
	}
	@ModelAttribute("countries")
	public Collection<String> countries(){
		List<String> countries = new ArrayList<>();
		countries.add("Poland");
		countries.add("other");
		return countries;
	}
	
	@ModelAttribute("hobbies")
	public Collection<String> hobbies(){
		List<String> hobbies = new ArrayList<>();
		hobbies.add("Programming");
		hobbies.add("other");
		return hobbies;
	}
	
	@ModelAttribute("programmingSkills")
	public Collection<String> programmingSkills(){
		List<String> programmingSkills = new ArrayList<>();
		programmingSkills.add("Java");
		programmingSkills.add("other");
		return programmingSkills;
	}
	
	

}
