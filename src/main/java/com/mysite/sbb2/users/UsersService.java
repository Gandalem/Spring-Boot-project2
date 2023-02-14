package com.mysite.sbb2.users;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mysite.sbb2.DateNotFoundExceptoin;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {
	
	private final UsersRepository usersRepository;
	
	/* 2월 14일 페이징 처리위해 수정
	public List<Users> usersList(){
		
		return this.usersRepository.findAll();
		
	}
	 */
	
	public Page<Users> usersList(int page){
		
		List<Sort.Order> sorts = new ArrayList();
		sorts.add(Sort.Order.desc("regdate"));
		Pageable pageable = PageRequest.of(page, 10,Sort.by(sorts));
		
		return this.usersRepository.findAll(pageable);
	}
	
	public Users getUsers(Integer idx) {
		
		Optional<Users> gu = this.usersRepository.findById(idx);
		if(gu.isPresent()) {
		return gu.get();
		}else {
			throw new DateNotFoundExceptoin("요청한 파일을 찾지 못했습니다.");
		}
		
	}
	public void insertUsers(String name, String pass,String email) {
		Users u = new Users();
		u.setName(name);
		u.setPass(pass);
		u.setEmail(email);
		u.setRegdate(LocalDateTime.now());
		u.setCnt(0);
		this.usersRepository.save(u);
	}
	
	
}
