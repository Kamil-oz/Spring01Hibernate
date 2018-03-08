package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;

@Controller
public class HomeController {
	@Autowired
	private BookDao bookDao;
	
//	@RequestMapping("/find/{id}")
//	@ResponseBody
//	public String find(@PathVariable long id) {
//		Book book = bookDao.findById(id);
//		return book.getId()+" "+book.getTitle()+" "+book.getAuthor()+" ";
//	}

//	@RequestMapping("/")
//    @ResponseBody
//    public String hello(){
//        Book book  = new Book();
//        book.setTitle("Thinking in Java");
//        book.setAuthor("Bruce Eckel");
//        bookDao.saveBook(book);
//        return "Id dodanej książki to:"
//               +  book.getId(); }
}
