package com.cn.pojo;
/**

* Copyright (C), 03.06-03.11

*/
public class Teacher {
	/** ��ʦ���� */
	private int teacher_id;
	/** ��ʦ�Ա� */
	private String sex;
	/** ��ʦ���� */
	private String teacher_name;
	/** ��ʦ����ʡ�� */
	private String t_pro;
	/** ��ʦ���ڳ���*/
	private String t_city;

	public Teacher() {
		super();
	}

	public Teacher(int teacher_id, String sex, String teacher_name, String t_pro, String t_city) {
		super();
		this.teacher_id = teacher_id;
		this.sex = sex;
		this.teacher_name = teacher_name;
		this.t_pro = t_pro;
		this.t_city = t_city;

	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getT_pro() {
		return t_pro;
	}

	public void setT_pro(String t_pro) {
		this.t_pro = t_pro;
	}

	public String getT_city() {
		return t_city;
	}

	public void setT_city(String t_city) {
		this.t_city = t_city;
	}

}
