package com.kh.java.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.kh.java.controller.CustomerRegisterManager;
import com.kh.java.view.CustomerCURDMenu;
import com.kh.java.view.CustomerMenu;

public class CustomerMVCProject {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		while (!exitFlag) {
			CustomerMenu.printMenu();
			int num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case CustomerCURDMenu.PRINT: {
				CustomerRegisterManager.totalSelectManager();
				break;
			}
			case CustomerCURDMenu.INSERT: {
				CustomerRegisterManager.insertManager();
				break;
			}
			case CustomerCURDMenu.UPDATE: {
				CustomerRegisterManager.updateManager();
				break;
			}
			case CustomerCURDMenu.DELETE: {
				CustomerRegisterManager.deleteManager();
				break;
			}
			case CustomerCURDMenu.SORT: {
				CustomerRegisterManager.sortManager();
				break;
			}
			case CustomerCURDMenu.EXIT: {
				exitFlag = true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + num);
			}
			System.out.println("The end");
		}

	}
}