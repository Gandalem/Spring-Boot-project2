package com.mysite.sbb2.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {
	
	@Autowired
	private final UsersRepository usersRepository;
	
	@GetMapping("/users_list")
	@PostMapping("/users_list")
	public String list(Model model) {
		
		List<Users> all = this.usersRepository.findAll();
		
		model.addAttribute("usersList", all);
		
		return "users_list";
	}
}
