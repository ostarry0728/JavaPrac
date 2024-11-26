package com.kh.java.model;

import java.sql.Date;

//계정 정보
public class AccountVO {
	private int no; // --pk, seq 
	private String username; // --사용자명
	private String password; // --비밀번호
	private String registrationDate; // --등록일
	private String membershipType; // --멤버십 유형 (일반, VIP, 프리미엄)s

	public AccountVO() {
	}

	public AccountVO(String username, String password, String registrationDate, String membershipType) {
		super();
		this.username = username;
		this.password = password;
		this.registrationDate = registrationDate;
		this.membershipType = membershipType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	@Override
	public String toString() {
		return "[username=" + username + ", password=" + password + ", registrationDate=" + registrationDate
				+ ", membershipType=" + membershipType + "]";
	}
}
