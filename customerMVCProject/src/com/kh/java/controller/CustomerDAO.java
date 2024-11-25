package com.kh.java.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.java.model.CustomerVO;

public class CustomerDAO {

	// SQL 쿼리 상수
	private static final String CUSTOMER_SELECT = "SELECT * FROM CUSTOMER";
	private static final String CUSTOMER_INSERT = "INSERT INTO CUSTOMER(NAME, BIRTHDAY, PHONE, EMAIL, REGISTER_DATE) VALUES(?, ?, ?, ?, ?)";
	private static final String CUSTOMER_UPDATE = "UPDATE CUSTOMER SET NAME = ?, BIRTHDAY = ?, PHONE = ?, EMAIL = ?, REGISTER_DATE = ? WHERE NO = ?";
	private static final String CUSTOMER_DELETE = "DELETE FROM CUSTOMER WHERE NO = ?";
	private static final String CUSTOMER_SORT = "SELECT * FROM CUSTOMER ORDER BY NAME ASC";

	// 전체 고객 조회
	public static ArrayList<CustomerVO> customerSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<CustomerVO> customerList = new ArrayList<>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(CUSTOMER_SELECT);

		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String birthday = rs.getString("BIRTHDAY");
			String phone = rs.getString("PHONE");
			String email = rs.getString("EMAIL");
			String registerDate = rs.getString("REGISTER_DATE");

			CustomerVO customer = new CustomerVO(no, name, birthday, phone, email, registerDate);
			customerList.add(customer);
		}

		DBUtility.dbClose(con, stmt, rs);
		return customerList;
	}

	// 고객 추가
	public static boolean customerInsert(CustomerVO cvo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(CUSTOMER_INSERT);
		pstmt.setString(1, cvo.getName());
		pstmt.setString(2, cvo.getBirthday());
		pstmt.setString(3, cvo.getPhone());
		pstmt.setString(4, cvo.getEmail());
		pstmt.setString(5, cvo.getSdate());

		int result = pstmt.executeUpdate();
		successFlag = (result != 0);

		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}

	// 고객 정보 업데이트
	public static boolean customerUpdate(CustomerVO cvo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(CUSTOMER_UPDATE);
		pstmt.setString(1, cvo.getName());
		pstmt.setString(2, cvo.getBirthday());
		pstmt.setString(3, cvo.getPhone());
		pstmt.setString(4, cvo.getEmail());
		pstmt.setString(5, cvo.getSdate());
		pstmt.setInt(6, cvo.getNo());

		int result = pstmt.executeUpdate();
		successFlag = (result != 0);

		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}

	// 고객 정보 삭제
	public static boolean customerDelete(int no) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(CUSTOMER_DELETE);
		pstmt.setInt(1, no);

		int result = pstmt.executeUpdate();
		successFlag = (result != 0);

		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}

	// 고객 리스트 정렬 조회 (이름 기준)
	public static ArrayList<CustomerVO> customerSort() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<CustomerVO> customerList = new ArrayList<>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(CUSTOMER_SORT);

		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			String birthday = rs.getString("BIRTHDAY");
			String phone = rs.getString("PHONE");
			String email = rs.getString("EMAIL");
			String registerDate = rs.getString("REGISTER_DATE");

			CustomerVO customer = new CustomerVO(no, name, birthday, phone, email, registerDate);
			customerList.add(customer);
		}

		DBUtility.dbClose(con, stmt, rs);
		return customerList;
	}
}
