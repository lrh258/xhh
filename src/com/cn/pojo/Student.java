package com.cn.pojo;
/**

* Copyright (C), 03.06-03.11


*/

public class Student {
	/** ѧ��ѧ��*/
	private int student_id;
	/** ѧ���Ա�*/
	private String stu_sex;
	/** ѧ������*/
	private String stu_name;
	/** ѧ������ʡ��*/
	private String stu_pro;
	/** ѧ�����ڳ���*/
	private String stu_city;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int student_id, String stu_sex, String stu_name, String stu_pro, String stu_city) {
		super();
		this.student_id = student_id;
		this.stu_sex = stu_sex;
		this.stu_name = stu_name;
		this.stu_pro = stu_pro;
		this.stu_city = stu_city;

	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_pro() {
		return stu_pro;
	}

	public void setStu_pro(String stu_pro) {
		this.stu_pro = stu_pro;
	}

	public String getStu_city() {
		return stu_city;
	}

	public void setStu_city(String stu_city) {
		this.stu_city = stu_city;
	}

}
