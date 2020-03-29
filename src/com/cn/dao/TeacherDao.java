package com.cn.dao;


import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.cn.pojo.Teacher;
import com.cn.pojo.Teacherinfo;

//��ʦ��ѯ
public class TeacherDao {
	/** ����Statement���� */
	Statement stmt;
	/** ��������� */
	ResultSet rs;

	public Statement getStmt() {
		return stmt;
	}

	public TeacherDao(Connection con) {

		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public int AddTeacher(Connection con, Teacher teacher) throws SQLException {
		String sql = "insert into teacher value(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, teacher.getTeacher_id());
		pstmt.setString(2, teacher.getTeacher_name());
		pstmt.setString(3, teacher.getSex());
		pstmt.setString(4, teacher.getT_pro());
		pstmt.setString(5, teacher.getT_city());
		return pstmt.executeUpdate();
	}

	
	public int AddTeacherInfo(Connection con, Teacherinfo tinfo) throws SQLException {
		String sql = "insert into teacher_info value(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, tinfo.getTeacher_id());
		pstmt.setString(2, tinfo.getSymptom());
		pstmt.setString(3, tinfo.getCheck());
		pstmt.setBigDecimal(4, tinfo.getTemperature());
		pstmt.setDate(5, (java.sql.Date) tinfo.getDate());
		return pstmt.executeUpdate();
	}
	

	public void SelectByDateIdTeacher(Connection con, Date date, int id) throws SQLException {
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id and t1.date = ? and t.teacher_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setDate(1, (java.sql.Date) date);
		pstmt.setInt(2, id);
		rs = pstmt.executeQuery();
		display();
	}

	/** ��ʾ���н�ʦ��Ϣ */
	public void selectAllTeacher() throws SQLException {
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id order by t.teacher_id";
		rs = stmt.executeQuery(sql);
		System.out.println("��ʦ��Ϣ");
		System.out.println("����\t����\t�Ա�\t����ʡ��\t����\t�����¶�\t֢״\t�ʱ��\t\t�Ƿ�ȷ��\t");
		display();
	}

	
	public void selectTeacherById(Connection con, int teacher_id) throws SQLException {
		String sql = "select * from teacher t, teacher_info t1 where t.teacher_id = t1.teacher_id and t.teacher_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, teacher_id);
		rs = pstmt.executeQuery();
		display();
	}

	
	private void display() throws SQLException {
		// TODO Auto-generated method stub
		while (rs.next()) {
			String id = rs.getString("teacher_id");
			String name = rs.getString("teacher_name");
			String sex = rs.getString("sex");
			String t_pro = rs.getString("t_pro");
			String t_city = rs.getString("t_city");
			BigDecimal temprature = rs.getBigDecimal("temprature");
			Date date = rs.getDate("date");
			String symptom = rs.getString("symptom");
			String check = rs.getString("check1");
			System.out.print(id + "\t" + name + "\t" + sex + "\t" + t_pro + "\t" + t_city + "\t" + temprature + "\t"
					+ symptom + "\t" + date + "\t" + check + "\n" + "\n");
		}
	}

}
