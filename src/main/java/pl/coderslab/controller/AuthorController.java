package pl.coderslab.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;

@RequestMapping("/author")
@Controller
public class AuthorController {
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	Validator validator;

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("author", new Author());
		return "form/author";
	}
	
	@PostMapping("/form")
	public String postForm(@Valid Author author, BindingResult result) {
		if (result.hasErrors()) {
			return "form/author";
		} else {
			authorDao.save(author);
			return "redirect:validate";
		}
	}
	@RequestMapping("/validate")
	@ResponseBody
	public String validate() {
		Author author = new Author();
		author.setYearOfBirth(2000);
		Set<ConstraintViolation<Author>> errors = validator.validate(author);
		if(!errors.isEmpty()) {
			String error ="";
			for (ConstraintViolation<Author> constraintViolation : errors) {
				error += constraintViolation.getPropertyPath()+":"+constraintViolation.getMessage()+"<br>";
			}
			return error;
		}
		return "ok";
	}
	@RequestMapping("/find/{id}")
	@ResponseBody
	public String find(@PathVariable long id) {
		Author author = authorDao.findById(id);
		return author.getId() + " " + author.getFirstName() + " " + author.getLastName() + " ";
	}

	@RequestMapping("/create")
	@ResponseBody
	public String create() {
		Author author = new Author();
		author.setFirstName("Bruce");
		author.setLastName("Eckel");
		authorDao.save(author);
		return "Id dodanego autora to:" + author.getId();
	}

	@RequestMapping("/edit/{id}")
	@ResponseBody
	public String update(@PathVariable long id) {
		Author author = authorDao.findById(id);
		author.setFirstName("ja");
		return author.getId() + " " + author.getFirstName() + " " + author.getLastName() + " ";
	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable long id) {
		authorDao.delete(authorDao.findById(id));
		return "Usunięto autora o id = " + id;
	}
}
