package com.cn.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class AbUtil {
	private static String dbUrl = "jdbc:mysql://localhost:3306/test2?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true";
	private static String dbUserName = "root";
	private static String dbPassword = "root";
	private static String jdbcName = "com.mysql.cj.jdbc.Driver";

	public static Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}

	public static void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

	public static void main(String[] args) {
		AbUtil dbUtil = new AbUtil();
		try {
			dbUtil.getCon();
			System.out.println("³É¹¦");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}








