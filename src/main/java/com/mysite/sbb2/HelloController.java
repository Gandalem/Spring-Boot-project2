package com.mysite.sbb2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Controller
public class HelloController {
	
	private String str;
	
	
	@ResponseBody
	@GetMapping("/hello")
	public String hello() {
		String hello = "hello"; 
		
		return hello;
	}
	
	
	
	public static void main(String[] args) {
		HelloController hello = new HelloController();
		
		hello.setStr("hello2");
		
		System.out.println(hello.getStr());
		System.out.println(hello);
		
	}
}
