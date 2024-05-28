package com.bookStore.controller;

import com.bookStore.service.MyBookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class MyBookListController {

	@Autowired
	private MyBookManager service;

//	@GetMapping("/deleteMyBook/{id}")
//	public String deleteMyList(@PathVariable("id") int id) {
//		service.deleteById(id);
//				return "myBooks";
//	}


}
