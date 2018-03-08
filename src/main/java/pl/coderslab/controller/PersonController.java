package pl.coderslab.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.GroupDao;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.Person;

@RequestMapping("/person")
@Controller
public class PersonController {
	
	@Autowired
	PersonDao personDao;
	
	@Autowired
	GroupDao groupDao;
	
	@GetMapping("/form")
	public String getForm(Model model) {
		model.addAttribute("person" , new Person());
		return "personform";
	}
	
	@PostMapping("/form")
	@ResponseBody
	public String postForm(@ModelAttribute Person person) {
		personDao.save(person);
		return "person added "+person.getId() ;
	}
	
	@ModelAttribute("groups")
	public Collection<Group> groups(){
	return groupDao.getAll();
	}
}
