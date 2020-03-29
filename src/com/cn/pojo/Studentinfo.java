package com.cn.pojo;
/**

* Copyright (C), 03.06-03.11

* FileName: Studentinfo.java

* ѧ����Ϣ��ʵ����

* @author Lipeishan
* @Date  2020.03.07

* @version 1.00

*/
import java.math.BigDecimal;
import java.util.Date;

public class Studentinfo {
	/** ѧ��ѧ��*/
	private int student_id = -1;
	/** ѧ��ȷ������*/
	private int checknum;
	/** ѧ����������*/
	private BigDecimal temperature;
	/** ѧ���Ƿ����֢״*/
	private String symptom;
	/** ѧ����д����*/
	private Date date;
	/** ѧ������ȷ�����*/
	private String check;
	/** ѧ���Ա�*/
	private String sex;

	public Studentinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Studentinfo(int student_id, BigDecimal temperature, String symptom, Date date, String check) {
		super();
		this.student_id = student_id;
		this.temperature = temperature;
		this.symptom = symptom;
		this.date = date;
		this.check = check;

	}


	public Studentinfo(java.sql.Date date, String sex, int checknum) {
		// TODO Auto-generated constructor stub
		super();
		this.checknum=checknum;
		this.date=date;
		this.sex=sex;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public BigDecimal getTemperature() {
		return temperature;
	}

	public void setTemperature(BigDecimal temperature2) {
		this.temperature = temperature2;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public int getChecknum() {
		return checknum;
	}

	public void setChecknum(int checknum) {
		this.checknum = checknum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
