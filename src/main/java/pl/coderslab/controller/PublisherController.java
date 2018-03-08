package pl.coderslab.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;

@RequestMapping("/publisher")
@Controller
public class PublisherController {
	@Autowired
	private PublisherDao publisherDao;

	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("publisher", new Publisher());
		return "form/publisher";
	}

	@PostMapping("/form")
	public String saveForm(@Valid Publisher publisher, BindingResult result) {
		if (result.hasErrors()) {
			return "form/publisher";
		} else {
			publisherDao.save(publisher);
			return "redirect:edit/" + publisher.getId();
		}
	}

	@RequestMapping("/find/{id}")
	@ResponseBody
	public String find(@PathVariable long id) {
		Publisher publisher = publisherDao.findById(id);
		return publisher.getId() + " " + publisher.getName();
	}

	@RequestMapping("/create")
	@ResponseBody
	public String create() {
		Publisher publisher = new Publisher();
		publisher.setName("dowolne wydawnictwo");
		publisherDao.save(publisher);
		return "Id dodanego wydawnictwa to:" + publisher.getId();
	}

	@RequestMapping("/edit/{id}")
	@ResponseBody
	public String update(@PathVariable long id) {
		Publisher publisher = publisherDao.findById(id);
		return publisher.getId() + " " + publisher.getName();
	}

	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable long id) {
		publisherDao.delete(publisherDao.findById(id));
		return "Usunięto wydawnictwo o id = " + id;
	}

}
