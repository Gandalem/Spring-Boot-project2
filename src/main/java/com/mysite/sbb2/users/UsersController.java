package com.mysite.sbb2.users;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UsersController {
	
	
	private final UsersService usersService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/users_list";
	}
	
	@GetMapping("/users_list")
	public String list(Model model,@RequestParam(value = "page",defaultValue = "0")int page) {
		
		Page<Users> all = this.usersService.usersList(page);
		
		model.addAttribute("usersList", all);
		
		return "users_list";
	}
	
	@GetMapping("/users/detail/{idx}")
	public String detail(Model model,@PathVariable("idx")Integer idx) {
		
		Users getUsers = this.usersService.getUsers(idx);
		
		model.addAttribute("getUsers", getUsers);
		
		return "users_detail";
	}
	
	@GetMapping("/users/insert")
	public String info(UsersForm usersForm) {
		return "users_insert";
	}
	@PostMapping("/users/create")
	public String insert(@Valid UsersForm usersForm,BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "users_insert";
		}
		this.usersService.insertUsers(usersForm.getName(),usersForm.getPass(),usersForm.getEamil());
		
		return "redirect:/users_list";
	}
	
}
