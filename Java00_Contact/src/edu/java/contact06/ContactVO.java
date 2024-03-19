package edu.java.contact06;

// 데이터 클래스(이름, 전화번호, 이메일)
public class ContactVO {
	private int contactId;
	private String name;
	private String phone;
	private String email;
	
	public ContactVO() {
		}

	
	public ContactVO(int contactId, String name, String phone, String email) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

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

	@Override
	public String toString() {
		return "ContactVO [contactId=" + contactId + ", name=" + name + ", phone=" + phone + ", email=" + email + "]";
	}

}
