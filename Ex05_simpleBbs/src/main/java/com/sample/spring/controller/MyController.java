package com.sample.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.spring.dao.ISimpleBbsDao;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	
	@Autowired
	ISimpleBbsDao dao;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String listPage(Model model) {
		model.addAttribute("lists", dao.listDao());
		model.addAttribute("count", dao.countDao());
		return "list";
	}
	
	@RequestMapping("/view")	// view?id=1
	public String viewPage(HttpServletRequest request, Model model) {
		String sId = request.getParameter("id");
		model.addAttribute("dto", dao.viewDao(sId));
		return "view";
	}
	
	@RequestMapping("/writeForm")
	public String writePage() {
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request) {
		dao.writeDao(
				request.getParameter("writer"),
				request.getParameter("title"),
				request.getParameter("content"));
		return "redirect:list";
	}
	
	@RequestMapping("/delete")	// delete?id=1
	public String deletePage(HttpServletRequest request) {
		dao.deleteDao(request.getParameter("id"));
		return "redirect:list";
	}
}
