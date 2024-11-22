package com.kh.subjectMVCProject.controller.model;

import java.sql.Date;

public class StudentVO {
	private int no; // pk, seq
	private String num; // varchar2(8) not null, 학번(년도학과번호)
	private String name; // varchar2(12) not null, 이름
	private String id; // varchar2(12) not null, 아이디
	private String passwd; // varchar2(12) not null, 패스워드
	private String sNum; // varchar2(2) not null, 학과번호(fk)
	private String birthday; // varchar2(8) not null, 생년월일
	private String phone; // varchar2(15) not null, 전화번호
	private String address; // varchar2(80) not null, 주소
	private String email; // varchar2(40) not null, 이메일
	private Date sdate; // date default sysdate 등록일

	public StudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentVO(int no, String num, String name, String id, String passwd, String sNum, String birthday,
			String phone, String address, String email, Date sdate) {
		super();
		this.no = no;
		this.num = num;
		this.name = name;
		this.id = id;
		this.passwd = passwd;
		this.sNum = sNum;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.sdate = sdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getSdate() {
		return sdate;
	}

	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", num=" + num + ", name=" + name + ", id=" + id + ", passwd=" + passwd
				+ ", sNum=" + sNum + ", birthday=" + birthday + ", phone=" + phone + ", address=" + address + ", email="
				+ email + ", sdate=" + sdate + "]";
	}

}
