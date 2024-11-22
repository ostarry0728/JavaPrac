package com.kh.subjectMVCProject.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.subjectMVCProject.controller.model.LessonVO;

public class LessonRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	// 전체 학생리스트를 출력요청
	public static void totalSelectManager() throws SQLException {
		ArrayList<LessonVO> studentList = new ArrayList<LessonVO>();
		studentList = LessonDAO.studentSelect();
		if (studentList == null) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printStudentList(studentList);
	}

	public static void insertManager() throws SQLException {
		// 3.statement
		System.out.print("학생 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());

		LessonVO studentVO = new LessonVO();
		boolean successFlag = LessonDAO.studentInsert(studentVO);

		if (successFlag == true) {
			System.out.println("입력처리 성공");
		} else {
			System.out.println("입력처리 실패");
		}
	}

	public static void updateManager() throws SQLException {
		System.out.print("수정할 학생의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("새로운 국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());

		LessonVO svo = new LessonVO();
		boolean successFlag = LessonDAO.studentUpdate(svo);

		if (successFlag == true) {
			System.out.println("입력처리 성공");
		} else {
			System.out.println("입력처리 실패");
		}
	}

	public static void deleteManager() throws SQLException {
		System.out.print("삭제할 학생 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		LessonVO svo = new LessonVO();
		svo.setNo(no);
		boolean successFlag = LessonDAO.studentDelete(svo);

		if (successFlag == true) {
			System.out.println("삭제처리 성공");
		} else {
			System.out.println("삭제처리 실패");
		}
	}

	public static void sortManager() throws SQLException {
		ArrayList<LessonVO> studentList = null;
		studentList = LessonDAO.studentSort();
		printStudentList(studentList);
	}

	// 전체 학생리스트를 출력진행
	public static void printStudentList(ArrayList<LessonVO> studentList) {
		System.out.println("============================================");
		for (LessonVO sv : studentList) {
			System.out.println(sv.toString());
		}
		System.out.println("============================================");
	}
}