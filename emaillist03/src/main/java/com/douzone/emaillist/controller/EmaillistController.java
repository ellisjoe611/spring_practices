package com.douzone.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.douzone.emaillist.repository.EmaillistRepository;
import com.douzone.emaillist.vo.EmaillistVO;

@Controller
public class EmaillistController {
	
	@Autowired
	private EmaillistRepository repository;
	
	@RequestMapping("")
	public String index(Model model) {
		List<EmaillistVO> list = repository.findAll();
		model.addAttribute("list", list);
		
		return "index";
	}
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.GET)
	public String add() {
		return "add"; 
	}
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public String add(EmaillistVO newVo) {
		repository.insert(newVo);
		return "redirect:/";
	}
	
}
