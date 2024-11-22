package com.kh.subjectMVCProject.controller.model;

public class SubjectVO {
	private int no; // number, -- pk, seq
	private String num; // varchar2(2) not null, -- 학과번호 01, 02, 03, 04, 05
	private String name; // varchar2(24) not null -- 학과이름

	public SubjectVO() {
		super();
	}

	public SubjectVO(int no, String num, String name) {
		super();
		this.no = no;
		this.num = num;
		this.name = name;
	}

	public SubjectVO(String num, String name) {
		super();
		this.num = num;
		this.name = name;
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

	@Override
	public String toString() {
		return "[no=" + no + ", num=" + num + ", name=" + name + "]";
	}

}
