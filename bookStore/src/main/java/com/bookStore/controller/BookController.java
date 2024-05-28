package com.bookStore.controller;

import com.bookStore.service.BookManager;
import com.bookStore.service.MyBookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

	private Long id;

	@Autowired
	private BookManager service;

	@Autowired
	private MyBookManager mybookservice;

	@Autowired
	private MyBookManager myBookService;




	@GetMapping("/register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/available")
	public ModelAndView getAllBook() {
		List<Book> list = service.getAllBook();
		return new ModelAndView("bookList", "book", list);
	}



	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
		service.save(b);
		return "redirect:/books/available";
	}


	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getImage(), b.getName(), b.getAuthor(), b.getPrice(),b.getCategory(),b.getDescription());
		myBookService.saveMyBooks(mb);
		return "redirect:/books/my_books";
	}

	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = service.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		service.deleteById(id);
		return "redirect:/books/available";
	}

	@GetMapping("/deleteMyBook")
	public String deleteLaboratoire(Model model, @RequestParam(name = "id") Integer id) {
		if (mybookservice.deleteById(id)) {
			return "redirect:/books/my_books";
		} else {
			return "error";
		}
	}


}
