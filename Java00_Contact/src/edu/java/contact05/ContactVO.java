package edu.java.contact05;

import java.io.Serializable;

// 데이터 클래스(이름, 전화번호, 이메일)
public class ContactVO implements Serializable {
	// 멤버 변수
	private String name;
	private String phone;
	private String email;
	
	// 기본 생성자
	public ContactVO() {}

	// 매개변수 생성자
	public ContactVO(String name, String phone, String email) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	// getter/setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// toString()
	@Override
	public String toString() {
		return "Contact [name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

}
