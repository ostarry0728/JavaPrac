package com.kh.java.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.java.model.AccountVO;

public class AccountRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	// 전체 고객 리스트 출력 요청
	public static void totalSelectManager() throws SQLException {
		ArrayList<AccountVO> customerList = AccountDAO.accountSelect();
		if (customerList == null || customerList.isEmpty()) {
			System.out.println("데이터가 존재하지 않습니다.");
			return;
		}
		printCustomerList(customerList);
	}

	public static void insertManager() throws SQLException {
		System.out.print("사용자명을 입력하세요: ");
		String username = sc.nextLine();

		System.out.print("비밀번호를 입력하세요: ");
		String password = sc.nextLine();

		System.out.print("등록일을 입력하세요: ");
		String registrationDate = sc.nextLine();

		System.out.print("멤버쉴 유형을 입력하세요: ");
		String membershipType = sc.nextLine();

		AccountVO accountVO = new AccountVO();
		accountVO.setUsername(username);
		accountVO.setPassword(password); // String을 Date로 변환
		accountVO.setRegistrationDate(registrationDate);
		accountVO.setMembershipType(membershipType);

		boolean successFlag = AccountDAO.accountInsert(accountVO);

		if (successFlag) {
			System.out.println("입력처리 성공");
		} else {
			System.out.println("입력처리 실패");
		}
	}

	public static void accountUpdate() throws SQLException {
		System.out.print("새로운 사용자명을 입력하세요: ");
		String username = sc.nextLine();

		System.out.print("새로운 비밀번호를 입력하세요: ");
		String password = sc.nextLine();

		System.out.print("새로운 등록일 입력하세요: ");
		String registrationDate = sc.nextLine();

		System.out.print("새로운 멤버쉽 유형을 입력하세요: ");
		String membershipType = sc.nextLine();

		AccountVO cvo = new AccountVO();
		cvo.setUsername(username);
		cvo.setPassword(password);
		cvo.setRegistrationDate(registrationDate);
		cvo.setMembershipType(membershipType);

		boolean successFlag = AccountDAO.accountUpdate(cvo);

		if (successFlag) {
			System.out.println("수정처리 성공");
		} else {
			System.out.println("수정처리 실패");
		}
	}

	public static void deleteManager() throws SQLException {
		System.out.print("삭제할 사용자명을 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());

		String username = null;
		boolean successFlag = AccountDAO.accountDelete(username);

		if (successFlag) {
			System.out.println("삭제처리 성공");
		} else {
			System.out.println("삭제처리 실패");
		}
	}

	public static void sortManager() throws SQLException {
		ArrayList<AccountVO> customerList = AccountDAO.accountSort();
		if (customerList == null || customerList.isEmpty()) {
			System.out.println("정렬된 데이터가 없습니다.");
			return;
		}
		printCustomerList(customerList);
	}

	// 전체 고객 리스트 출력 진행
	public static void printCustomerList(ArrayList<AccountVO> customerList) {
		System.out.println("============================================");
		for (AccountVO cv : customerList) {
			System.out.println(cv.toString());
		}
		System.out.println("============================================");
	}
}
