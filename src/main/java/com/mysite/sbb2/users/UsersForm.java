package com.mysite.sbb2.users;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersForm {
	
	@NotEmpty(message="이름을 입력해주세요")
	private String name;
	
	@NotEmpty(message="비번을 입력해주세요")
	private String pass;
	
	
	//@Email(message="이메일형식으로 입력해주세요")
	private String eamil;

}
