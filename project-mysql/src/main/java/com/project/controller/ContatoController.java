package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.dao.ContatoDAO;
import com.project.model.Contato;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	@Autowired
	private ContatoDAO dao;
	
	@PostMapping("/bookContatos")
	public String bookContato (@RequestBody List<Contato> contatos) {
		dao.saveAll(contatos);
		return "All Right";
	}
	
	@GetMapping("/getContatos")
	public List<Contato> getContatos() {
		return (List<Contato>) dao.findAll(); 
	}
	
//	@GetMapping
//	public ModelAndView listar() {
//		List<Contato> lista = (List<Contato>) dao.findAll();
//		
//		ModelAndView mov = new ModelAndView("contatos");
//		mov.addObject("contatos", lista);
//		
//		return mov;
//	}
}
