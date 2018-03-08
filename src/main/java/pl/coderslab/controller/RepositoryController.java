package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.model.Book;
import pl.coderslab.repository.BookRepository;

@Controller
@RequestMapping("/repo")
public class RepositoryController {
	@Autowired
	BookRepository bookRepository;

	
	
	@GetMapping("")
	public String findAll(Model model) {
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books", books);
		return "showbooks";
	}
	
	@GetMapping("/count/{title}")
	@ResponseBody
	public String countByTitle(@PathVariable String title) {
		return bookRepository.countByTitle(title) +"";
	}
	@GetMapping("/findauthor/{id}")
	public String findByAuthor(Model model, @PathVariable long id) {
		model.addAttribute("books", bookRepository.findByAuthors(id));
		return "showbooks";
	}
	@GetMapping("/find/{title}")
	public String findOneByTitle(Model model, @PathVariable String title) {
		List<Book> books = new ArrayList<>(); 
		books.add(bookRepository.findOneByTitle(title));
		model.addAttribute("books", books);
		return "showbooks";
	}
}
