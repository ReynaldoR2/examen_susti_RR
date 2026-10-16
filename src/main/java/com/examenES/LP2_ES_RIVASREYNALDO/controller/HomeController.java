package com.examenES.LP2_ES_RIVASREYNALDO.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home () {
		return "redirect:/mascota/listado";
	}
}
