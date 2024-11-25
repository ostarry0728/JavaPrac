package com.kh.java.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtility {

	public static Connection dbCon() {
		Connection con = null;
		// db.properties 에서 id, pw 가져오기
		String filePath = "D:\\JavaPrac\\customerMVCProject\\src\\db.properties";
		Properties pt = new Properties();
		try {
			pt.load(new FileReader(filePath));
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		String id = pt.getProperty("id");
		String pw = pt.getProperty("pw");
		String url = pt.getProperty("url");

		// 1. jdbc driver load 2. connection
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		return con;
	}

	public static void dbClose(Connection con, Statement stmt, ResultSet rs) {
		if (con != null) {
			try {
				con.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (rs != null) {
			try {
				rs.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	}

	public static void dbClose(Connection con, Statement stmt) {
		if (con != null) {
			try {
				con.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}

	}

	public static void dbClose(Connection con, Statement stmt, CallableStatement cstmt) {
		if (con != null) {
			try {
				con.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (stmt != null) {
			try {
				stmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (cstmt != null) {
			try {
				cstmt.close();

			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
}