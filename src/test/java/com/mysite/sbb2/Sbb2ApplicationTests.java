package com.mysite.sbb2;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb2.users.UsersRepository;

@SpringBootTest
class Sbb2ApplicationTests {
	@Autowired
	private UsersRepository usersRepository;
	
	/*
	@Test
	public void selectUsers() {
		List<Users> ul = this.usersRepository.findAllByOrderByRegdateDesc();
		for(Users u:ul) {
			System.out.println("================");
			System.out.println(u.getIdx());
			System.out.println(u.getName());
			System.out.println(u.getPass());
			System.out.println(u.getEmail());
			System.out.println(u.getCnt());
			System.out.println("================");
		}
	}
	
	
	@Test
	public void deletUsers() {
		Optional<Users> ul = this.usersRepository.findById(4);
		Users u = ul.get();
		this.usersRepository.delete(u);
	}
	
	
	@Test
	public void updateUsers() {
		Optional<Users> ul = this.usersRepository.findById(3);
		Users u = ul.get();
		u.setName("수정된 이민창");
		u.setEmail("수정된 이메일");
		this.usersRepository.save(u);
		
	}
	
	@Test
	public void insertUser() {
		Users u = new Users();
		u.setName("이준호");
		u.setPass("1234");
		u.setEmail("aaa@aaa.com");
		u.setRegdate(LocalDateTime.now());
		this.usersRepository.save(u);
	}
	 */
}
