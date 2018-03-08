package pl.coderslab.controller;


import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.model.Book;

@Controller
@RequestMapping("/validate")
public class ValidationController {
	@Autowired
	Validator validator;

	@RequestMapping("")
	@ResponseBody
	public String validate() {
		Book book = new Book();
		book.setTitle("asd");
		Set<ConstraintViolation<Book>> err = validator.validate(book);
		if(!err.isEmpty()) {
			String result = "";
			for (ConstraintViolation<Book> constraintViolation : err) {
				result += constraintViolation.getPropertyPath()+":"+constraintViolation.getMessage()+"<br>";
			}
			return result;
		}
		return "validation ok";
	}


	@RequestMapping("/book")
	public String validateBook(Model model) {
		Book book = new Book();
		book.setTitle("asd");
		Set<ConstraintViolation<Book>> err = validator.validate(book);
		model.addAttribute("errors", err);
		return "validation/book";
	}

}
