package com.kh.java.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.java.model.AccountVO;

public class AccountDAO {

	// SQL 쿼리 상수
	public static final String ACCOUNT_SELECT = "SELECT * FROM ACCOUNT";
	public static final String ACCOUNT_INSERT = "INSERT INTO ACCOUNT(USERNAME, PASSWORD, REGISTRATION_DATE, MEMBERSHIP_TYPE) VALUES(?, ?, ?, ?)";
	public static final String ACCOUNT_UPDATE = "UPDATE ACCOUNT SET PASSWORD = ?, MEMBERSHIP_TYPE = ? WHERE USERNAME = ?";
	public static final String ACCOUNT_DELETE = "DELETE FROM ACCOUNT WHERE USERNAME = ?";
	public static final String ACCOUNT_SORT = "SELECT * FROM ACCOUNT ORDER BY REGISTRATION_DATE";

	// 전체 계정 조회
	public static ArrayList<AccountVO> accountSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AccountVO> accountList = new ArrayList<>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(ACCOUNT_SELECT);

		while (rs.next()) {
			String username = rs.getString("USERNAME");
			String password = rs.getString("PASSWORD");
			String registrationDate = rs.getString("REGISTRATION_DATE");
			String membershipType = rs.getString("MEMBERSHIP_TYPE");

			AccountVO account = new AccountVO(username, password, registrationDate, membershipType);
			accountList.add(account);
		}

		DBUtility.dbClose(con, stmt, rs);
		return accountList;
	}

	// 계정 추가
	public static boolean accountInsert(AccountVO avo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(ACCOUNT_INSERT);
		pstmt.setString(1, avo.getUsername());
		pstmt.setString(2, avo.getPassword());
		pstmt.setString(3, avo.getRegistrationDate());
		pstmt.setString(4, avo.getMembershipType());

		int result = pstmt.executeUpdate();
		successFlag = (result != 0);

		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}

	// 계정 업데이트
	public static boolean accountUpdate(AccountVO avo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(ACCOUNT_UPDATE);
		pstmt.setString(1, avo.getPassword());
		pstmt.setString(2, avo.getMembershipType());
		pstmt.setString(3, avo.getUsername());

		int result = pstmt.executeUpdate();
		successFlag = (result != 0);

		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}

	// 계정 삭제
	public static boolean accountDelete(String username) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(ACCOUNT_DELETE);
		pstmt.setString(1, username);

		int result = pstmt.executeUpdate();
		successFlag = (result != 0);

		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}

	// 계정 정렬 조회 (등록일 기준)
	public static ArrayList<AccountVO> accountSort() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AccountVO> accountList = new ArrayList<>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(ACCOUNT_SORT);

		while (rs.next()) {
			String username = rs.getString("USERNAME");
			String password = rs.getString("PASSWORD");
			String registrationDate = rs.getString("REGISTRATION_DATE");
			String membershipType = rs.getString("MEMBERSHIP_TYPE");

			AccountVO account = new AccountVO(username, password, registrationDate, membershipType);
			accountList.add(account);
		}

		DBUtility.dbClose(con, stmt, rs);
		return accountList;
	}
}