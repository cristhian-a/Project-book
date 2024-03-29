package com.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.BookDAO;
import com.project.model.Book;
//
@Controller
public class BookController {

	@Autowired
	private BookDAO dao;
	
	@GetMapping("/book")
	public ModelAndView start(Model model) {
		model.addAttribute("book", new Book());
		
		List<Book> books = dao.findAll();
		
		ModelAndView mov = new ModelAndView("books-view");
		mov.addObject("books", books);
		
		return mov;
	}
	
	@PostMapping("/book/{id}")
	public ModelAndView getBookById (@PathVariable(value = "id")int id) {
		
		Optional<Book> book = dao.findById(id);
		
		ModelAndView mov = new ModelAndView("edit-book-view");
		mov.addObject("book", book.get());
		
		return mov;
	}
	
	@PostMapping("/book")
	public String saveBook (Book book) {
		dao.save(book);
		return "redirect:/book";
	}
	
	@PostMapping("/book/delete")
	public String deleteBook (Book book) {
		dao.delete(book);
		return "redirect:/book";
	}
}
