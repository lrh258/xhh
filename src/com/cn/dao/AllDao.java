package com.cn.dao;

/**

* Copyright (C), 03.06-03.11

* FileName: SelectionAllDao.java

* �����Խ�ʦ��ѧ����ͬ����

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
	/** ����Statement���� */
	Statement stmt;
	/** ��������� */
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
	 * ��ѯ����ȷ��ѧ����Ϣ
	 */

	public void selectStudentCheck() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from student s,stu_info s1 where s1.check1='Y' and s.student_id = s1.s_id order by s.student_id";
		rs = stmt.executeQuery(sql);
		System.out.println("ȷ��ѧ����Ϣ");
		System.out.println("ѧ��\t" + "\t����\t�Ա�\t����ʡ��\t����\t�����¶�\t" + "    " + "����");
		displayStudent();
	}

	/**
	 * ��ѯ����ȷ���ʦ��Ϣ
	 */

	public void selectTeacherCheck() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id and t1.check1='Y' order by t.teacher_id";
		rs = stmt.executeQuery(sql);
		System.out.println("ȷ���ʦ��Ϣ");
		System.out.println("����\t����\t�Ա�\t����ʡ��\t����\t�����¶�\t�ʱ��\t");
		displayTeacher();

	}

	/**
	 * �����ݶ�����ѯ����ѧ����������
	 * 
	 * @throws �׳�SQLException
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
	 * �����ݶ������ڽ�ʦ��ѯ��������
	 * 
	 * @throws �׳�SQLException
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
