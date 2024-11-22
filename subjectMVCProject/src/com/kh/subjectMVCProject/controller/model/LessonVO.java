package com.kh.subjectMVCProject.controller.model;

public class LessonVO {
	private int no; // number, pk, seq
	private String abbre; // varchar2(2) not null, -- 과목요약
	private String name; // varchar2(20) not null -- 과목이름

	public LessonVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LessonVO(int no, String abbre, String name) {
		super();
		this.no = no;
		this.abbre = abbre;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getAbbre() {
		return abbre;
	}

	public void setAbbre(String abbre) {
		this.abbre = abbre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", abbre=" + abbre + ", name=" + name + "]";
	}

}
