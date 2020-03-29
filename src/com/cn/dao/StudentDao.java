package com.cn.dao;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.cn.pojo.Student;
import com.cn.pojo.Studentinfo;
import com.cn.pojo.Teacher;

public class StudentDao {
	/** ����Statement���� */
	Statement stmt;
	/** ��������� */
	ResultSet rs;

	public Statement getStmt() {
		return stmt;
	}

	
	public StudentDao(Connection con) {
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public int AddStudent(Connection con, Student student) throws SQLException {
		String sql = "insert into student value(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, student.getStudent_id());
		pstmt.setString(2, student.getStu_name());
		pstmt.setString(3, student.getStu_sex());
		pstmt.setString(4, student.getStu_pro());
		pstmt.setString(5, student.getStu_city());
		return pstmt.executeUpdate();

	}

	
	public int AddStudentInfo(Connection con, Studentinfo sinfo) throws SQLException {
		String sql = "insert into stu_info value(?, ?, ?,?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, sinfo.getStudent_id());
		pstmt.setString(2, sinfo.getSymptom());
		pstmt.setString(3, sinfo.getCheck());
		pstmt.setBigDecimal(4, sinfo.getTemperature());
		pstmt.setDate(5, (java.sql.Date) sinfo.getDate());
		return pstmt.executeUpdate();
	}

	/** ��ʾ����ѧ����Ϣ */
	public void selectAllStudent() throws SQLException {
		String sql = "select * from student s, stu_info s1 where s.student_id = s1.s_id order by s.student_id";
		rs = stmt.executeQuery(sql);
		System.out.println("ѧ����Ϣ");
		System.out.println("ѧ��\t����\t�Ա�\t����ʡ��\t����\t�����¶�\t֢״\t�ʱ��\t\t�Ƿ�ȷ��\t");
		display();

	}

	/**
	 * ���ݹ��Ų�ѯ��Ϣ
	 * 
	 * @param con        �������ݿ�
	 * @param student_id ���student_id���в�ѯ
	 */

	public void selectStudentById(Connection con, int student_id) throws SQLException {
		String sql = "select * from student s, stu_info s1 where s.student_id = s1.s_id and s.student_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, student_id);
		rs = pstmt.executeQuery();
		display();
	}
	
	public void SelectByDateIdStudent(Connection con, Date date, int student_id) throws SQLException {
		String sql = "select * from student s, stu_info s1 where s.student_id = s1.s_id and s1.date = ? and s.student_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDate(1, (java.sql.Date) date);
		pstmt.setInt(2, student_id);
		rs = pstmt.executeQuery();
		display();
	}

	/**
	 * �����ݶ�����ѯ���
	 * 
	 * @throws �׳�SQLException
	 */
	private void display() throws SQLException {
		// TODO Auto-generated method stub
		while (rs.next()) {
			String id = rs.getString("s_id");
			String name = rs.getString("student_name");
			String stu_sex = rs.getString("stu_sex");
			String student_pro = rs.getString("student_pro");
			String student_city = rs.getString("student_city");
			BigDecimal temprature = rs.getBigDecimal("temperature");
			Date date = rs.getDate("date");
			String symptom = rs.getString("symptom");
			String check = rs.getString("check1");
			System.out.print(id + "\t" + name + "\t" + stu_sex + "\t" + student_pro + "\t" + student_city + "\t"
					+ temprature + "\t" + symptom + "\t" + date + "\t" + check + "\n" + "\n");
		}

	}
}
