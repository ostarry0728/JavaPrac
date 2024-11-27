package com.kh.java.model;

import java.sql.Date;

//기본고객정보
public class CustomerVO {
	private int no; // --pk, seq
	private String name; // --이름
	private String birthday; // --생년월일
	private String phone; // --전화번호
	private String email; // --이메일
	private String sdate; // --등록일

	public CustomerVO() {
	}

	public CustomerVO(int no, String name, String birthday, String phone, String email, String registerDate) {
		super();
		this.no = no;
		this.name = name;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.sdate = registerDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String date) {
		this.birthday = date;
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

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", name=" + name + ", birthday=" + birthday + ", phone=" + phone + ", email=" + email
				+ ", sdate=" + sdate + "]";
	}
}