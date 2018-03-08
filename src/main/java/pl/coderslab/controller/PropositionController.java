package pl.coderslab.controller;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.validator.PropositionValidation;

@RequestMapping("/proposition")
@Controller
public class PropositionController {
	@Autowired
	private BookDao bookDao;
	@Autowired
	private PublisherDao publisherDao;
	@Autowired
	private AuthorDao authorDao;
	@Autowired
	private Validator validator;

	@GetMapping("/form")
	public String showForm(Model model) {
		Book book = new Book();
		book.setProposition(false);
		model.addAttribute("book", book);
		return "form/book";
	}

	@PostMapping("/form")
	public String saveForm(@ModelAttribute Book book) {
		Set<ConstraintViolation<Book>> result = validator.validate(book, PropositionValidation.class);
		if (result.isEmpty()) {
			bookDao.saveBook(book);
			return "redirect:/book";
		} else {
			return "form/book";
		}
	}

	@RequestMapping("/find/{id}")
	@ResponseBody
	public String find(@PathVariable long id) {
		Book book = bookDao.findById(id);
		return book.getId() + " " + book.getTitle() + " " + Arrays.toString(book.getAuthors().toArray()) + " "
				+ book.getPublisher().getName();
	}

	@RequestMapping("/create")
	@ResponseBody
	public String create() {
		Book book = new Book();
		book.setTitle("Thinking in Java");
		book.getAuthors().add(authorDao.findById(1));
		book.setPublisher(publisherDao.findById(1));
		bookDao.saveBook(book);
		return "Id dodanej książki to:" + book.getId();
	}

	@GetMapping("/edit/{id}")
	public String update(@PathVariable long id, Model model) {
		model.addAttribute("book", bookDao.findById(id));
		return "form/book";
	}

	@PostMapping("/edit/{id}")
	public String postUpdate(@ModelAttribute Book book) {
		bookDao.update(book);
		return "redirect:/proposition";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		bookDao.delete(bookDao.findById(id));
		return "redirect:/proposition";
	}

	@RequestMapping("")
	public String books(Model model) {
		model.addAttribute("books", bookDao.getAllPropositions());
		return "showbooks";
	}

	@ModelAttribute("publishers")
	public Collection<Publisher> publishers() {
		return publisherDao.getAll();
	}
}
