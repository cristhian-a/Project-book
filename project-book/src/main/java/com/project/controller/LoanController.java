package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.BookDAO;
import com.project.dao.LoanDAO;
import com.project.model.Book;
import com.project.model.Loan;

@Controller
public class LoanController {

	@Autowired
	private LoanDAO dao;
	
	@GetMapping("/book/{id}/loan")
	private ModelAndView start(Model model, @PathVariable(value = "id") int bookId) {
		Book book = new Book();
		book.setId(bookId);
		model.addAttribute("book", book);
		
		List<Loan> loans = dao.findAll();
		
		ModelAndView mov = new ModelAndView("loan-view");
		mov.addObject("loans", loans);
		
		return mov;
	}
	
	@PostMapping("/book/{id}/loan/save")
	private String saveLoan(Loan loan, @PathVariable(value = "id") int id) {
		dao.save(loan);
		return "redirect:/book/" + id + "/loan";
	}
	
	@PostMapping("/book/{id}/loan/delete")
	private String deleteLoan(Loan loan, @PathVariable(value = "id") int id) {
		dao.delete(loan);
		return "redirect:/book/" + id + "/loan";
	}
}
