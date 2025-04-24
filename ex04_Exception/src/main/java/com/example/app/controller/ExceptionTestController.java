package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/except")
public class ExceptionTestController {

	@ExceptionHandler(Exception.class)
	public String ArithmeticExceptionHandler(Exception e, Model model) {
		log.error("error : " + e);
		return "except/error";
	}
	@GetMapping("/ex")
	public void ex1_1() throws Exception{
		log.info("GET -");
		throw new Exception("파일을 찾을 수 없습니다");
	}
	@GetMapping("/page01")
	public void ex1() throws Exception{
		log.info("GET /except/page01");
		throw new Exception("파일을 찾을 수 없습니다");
	}
	@GetMapping("/page02/{num}/{div}")
	public String ex2(@PathVariable("num") int num, @PathVariable("div") int div, Model model) throws Exception{
		log.info("GET /except/page02" + (num/div));
		model.addAttribute("result",(num / div));
		return "except/page02";
	}
}
