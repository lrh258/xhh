package com.cn.dao;

/**

* Copyright (C), 03.06-03.11

* FileName: SelectionAllDao.java

* 用来对教师和学生共同查找

* @author Lipeishan
* @Date    2020.03.09

* @version 1.00

*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class AllDao {
	/** 创建Statement对象 */
	Statement stmt;
	/** 创建结果集 */
	ResultSet rs;

	public Statement getStmt() {
		return stmt;
	}

	public AllDao(Connection con) {
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 查询所有确诊学生信息
	 */

	public void selectStudentCheck() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from student s,stu_info s1 where s1.check1='Y' and s.student_id = s1.s_id order by s.student_id";
		rs = stmt.executeQuery(sql);
		System.out.println("确诊学生信息");
		System.out.println("学号\t" + "\t姓名\t性别\t所处省份\t市区\t当日温度\t" + "    " + "日期");
		displayStudent();
	}

	/**
	 * 查询所有确诊教师信息
	 */

	public void selectTeacherCheck() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id and t1.check1='Y' order by t.teacher_id";
		rs = stmt.executeQuery(sql);
		System.out.println("确诊教师信息");
		System.out.println("工号\t姓名\t性别\t所处省份\t市区\t当日温度\t填报时间\t");
		displayTeacher();

	}

	/**
	 * 从数据读出查询关于学生结果并输出
	 * 
	 * @throws 抛出SQLException
	 */
	public void displayStudent() throws SQLException {
		while (rs.next()) {
			String id = rs.getString("s_id");
			String name = rs.getString("student_name");
			String stu_sex = rs.getString("stu_sex");
			String student_pro = rs.getString("student_pro");
			String student_city = rs.getString("student_city");
			Float temprature = rs.getFloat("temperature");
			Date date = rs.getDate("date");
			System.out.print(id + "\t" + name + "\t" + stu_sex + "\t" + student_pro + "\t" + student_city + "\t"
					+ temprature + "\t" + date + "\t" + "\n" + "\n");
		}
	}

	/**
	 * 从数据读出关于教师查询结果并输出
	 * 
	 * @throws 抛出SQLException
	 */
	public void displayTeacher() throws SQLException {
		while (rs.next()) {
			String id = rs.getString("teacher_id");
			String name = rs.getString("teacher_name");
			String sex = rs.getString("sex");
			String t_pro = rs.getString("t_pro");
			String t_city = rs.getString("t_city");
			Float temprature = rs.getFloat("temprature");
			Date date = rs.getDate("date");
			System.out.print(id + "\t" + name + "\t" + sex + "\t" + t_pro + "\t" + t_city + "\t" + temprature + "\t"
					+ date + "\n" + "\n");
		}
	}

}
