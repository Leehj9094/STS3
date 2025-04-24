package com.example.app.controller;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.dto.MemoDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {

	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("MemoController's dataBinder " + webDataBinder);
		webDataBinder.registerCustomEditor(LocalDate.class, "dateTest", new DateTestEditor());
	}

	@GetMapping("/ex")
	public void ex1_1() throws Exception{
		log.info("GET -");
		throw new Exception("파일을 찾을 수 없습니다");
	}
	
	@GetMapping("/add")
	public void add_get() {
		log.info("GET /memo/add");
	}

	@PostMapping("/add")
	public void add_post(@Valid MemoDto dto, BindingResult bindingResult, Model model) {
		log.info("POST /memo/add" + dto);
		if (bindingResult.hasErrors()) {
//			log.info("유효성 에러발생 : " + bindingResult.getFieldError("id").getDefaultMessage());

			for (FieldError error : bindingResult.getFieldErrors()) {
				log.info("Error Field : " + error.getField() + "Error Msg : " + error.getDefaultMessage());
				model.addAttribute(error.getField(), error.getDefaultMessage());
			}
		}
	}

	// static private
	private static class DateTestEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String dateTest) throws IllegalArgumentException {
			log.info("DateTestEditor's setAsText invoke" + dateTest);
			LocalDate date = null;
			if(dateTest.isEmpty()) {
//				dateTest = LocalDate.now().toString();
				date = LocalDate.now();
			}else {
				// yyyy#MM#dd -> yyyy-MM-dd(LocalDate format)
				dateTest = dateTest.replaceAll("#", "-");
				date = LocalDate.parse(dateTest,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			}
			setValue(date);
		}

	}

}
