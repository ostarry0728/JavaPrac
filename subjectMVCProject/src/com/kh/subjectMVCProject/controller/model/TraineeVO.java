package com.kh.subjectMVCProject.controller.model;

import java.sql.Date;

public class TraineeVO {
	private int no; // number, pk, seq
	private String sNum; // varchar2(8) not null, 학생번호(student fk)
	private String abbre; // varchar2(2) not null, 과목요약(lesson fk)
	private String section; // varchar2(20) not null, 전공, 부전공, 교양
	private Date tdate; // date default sysdate 수강신청일

	public TraineeVO() {
		super();
	}

	public TraineeVO(int no, String sNum, String abbre, String section, Date tdate) {
		super();
		this.no = no;
		this.sNum = sNum;
		this.abbre = abbre;
		this.section = section;
		this.tdate = tdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getAbbre() {
		return abbre;
	}

	public void setAbbre(String abbre) {
		this.abbre = abbre;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	@Override
	public String toString() {
		return "[no=" + no + ", sNum=" + sNum + ", abbre=" + abbre + ", section=" + section + ", tdate="
				+ tdate + "]";
	}

}
