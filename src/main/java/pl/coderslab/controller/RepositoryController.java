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

import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.PublisherRepository;

@Controller
@RequestMapping("/repo")
public class RepositoryController {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	AuthorRepository authorRepository;
	@Autowired
	PublisherRepository publisherRepository;

	
	
	@GetMapping("")
	public String findAll(Model model) {
		List<Book> books = bookRepository.findAll();
		model.addAttribute("books", books);
		return "showbooks";
	}
	
	@GetMapping("/find/rating/{val}")
	public String findByPublisherId(Model model,@PathVariable int val) {
		model.addAttribute("books", bookRepository.findByRating(val));
		return "showbooks";
	}
	
	
	
	@GetMapping("/find/publisher/{id}")
	public String findByPublisherId(Model model,@PathVariable long id) {
		model.addAttribute("books", bookRepository.findByPublisherId(id));
		return "showbooks";
	}
	
	@GetMapping("/count/{title}")
	@ResponseBody
	public String countByTitle(@PathVariable String title) {
		return bookRepository.countByTitle(title) +"";
	}
	@GetMapping("/find/author/{id}")
	public String findByAuthor(Model model, @PathVariable long 	id) {
		model.addAttribute("books", bookRepository.findByAuthorsId(id));
		return "showbooks";
	}
	
	@GetMapping("/find/authorobj/{id}")
	public String findByAuthorObj(Model model, @PathVariable long id) {
		model.addAttribute("books", bookRepository.findByAuthors(authorRepository.findOne(id)));
		return "showbooks";
	}
	
	@GetMapping("/find/author/lastname/{lastname}")
	@ResponseBody
	public String findAuthorByLastNameLike (@PathVariable String lastname) {
		List<Author> authors = authorRepository.findAuthorByLastNameLike(lastname); 
		return "ok";
	}
	
	@GetMapping("/find/publisher/{nip}")
	@ResponseBody
	public String findPublisherByNip (@PathVariable String nip) {
		Publisher publisher = publisherRepository.findFirstPublisherByNip(nip); 
		return publisher.getName();
	}
	@GetMapping("/find/first/{id}")
	public String findFirstByAuthorOrderByTitle(Model model, @PathVariable long id) {
		List<Book> books = new ArrayList<>(); 
		books.add(bookRepository.findFirstByAuthorsOrderByTitle(authorRepository.findOne(id)));
		model.addAttribute("books", books);
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
