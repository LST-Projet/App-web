package net.codejava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AppController {

	
	@RequestMapping("/")
	public String viewHomePage() {
		
		return "Login";
	}

	@RequestMapping("/header")
	public String viewheaderPage() {
		
		return "header";
	}
	
}
