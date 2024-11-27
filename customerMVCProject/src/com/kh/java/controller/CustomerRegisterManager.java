package com.kh.java.controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.java.model.CustomerVO;

public class CustomerRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	// 전체 고객 리스트 출력 요청
	public static void totalSelectManager() throws SQLException {
		ArrayList<CustomerVO> customerList = CustomerDAO.customerSelect();
		if (customerList == null || customerList.isEmpty()) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printCustomerList(customerList);
	}

	public static void insertManager() throws SQLException {
		System.out.print("고객 이름을 입력하세요: ");
		String name = sc.nextLine();

		System.out.print("생년월일(YYYY-MM-DD)을 입력하세요: ");
		String birthDate = sc.nextLine();

		System.out.print("전화번호를 입력하세요: ");
		String phoneNumber = sc.nextLine();

		System.out.print("이메일을 입력하세요: ");
		String email = sc.nextLine();

		System.out.print("등록일(YYYY-MM-DD)을 입력하세요: ");
		String registerDateInput = sc.nextLine();

		CustomerVO customerVO = new CustomerVO();
		customerVO.setName(name);
		customerVO.setBirthday(birthDate);
		customerVO.setPhone(phoneNumber);
		customerVO.setEmail(email);
		customerVO.setSdate(registerDateInput);

		boolean successFlag = CustomerDAO.customerInsert(customerVO);

		if (successFlag) {
			System.out.println("입력처리 성공");
		} else {
			System.out.println("입력처리 실패");
		}
	}

	public static void updateManager() throws SQLException {
		System.out.print("수정할 고객의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		System.out.print("새로운 이름을 입력하세요: ");
		String name = sc.nextLine();

		System.out.print("새로운 생년월일(YYYY-MM-DD)을 입력하세요: ");
		String birthDate = sc.nextLine();

		System.out.print("새로운 전화번호를 입력하세요: ");
		String phoneNumber = sc.nextLine();

		System.out.print("새로운 이메일을 입력하세요: ");
		String email = sc.nextLine();

		System.out.print("새로운 등록일(YYYY-MM-DD)을 입력하세요: ");
		String registerDateInput = sc.nextLine();

		CustomerVO cvo = new CustomerVO();
		cvo.setNo(no);
		cvo.setName(name);
		cvo.setBirthday(birthDate);
		cvo.setPhone(phoneNumber);
		cvo.setEmail(email);
		cvo.setSdate(registerDateInput);

		boolean successFlag = CustomerDAO.customerUpdate(cvo);

		if (successFlag) {
			System.out.println("수정처리 성공");
		} else {
			System.out.println("수정처리 실패");
		}
	}

	public static void deleteManager() throws SQLException {
		System.out.print("삭제할 고객 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		boolean successFlag = CustomerDAO.customerDelete(no);

		if (successFlag) {
			System.out.println("삭제처리 성공");
		} else {
			System.out.println("삭제처리 실패");
		}
	}

	public static void sortManager() throws SQLException {
		ArrayList<CustomerVO> customerList = CustomerDAO.customerSort();
		if (customerList == null || customerList.isEmpty()) {
			System.out.println("정렬된 데이터가 없습니다.");
			return;
		}
		printCustomerList(customerList);
	}

	// 전체 고객 리스트 출력 진행
	public static void printCustomerList(ArrayList<CustomerVO> customerList) {
		System.out.println("============================================");
		for (CustomerVO cv : customerList) {
			System.out.println(cv.toString());
		}
		System.out.println("============================================");
	}
}
