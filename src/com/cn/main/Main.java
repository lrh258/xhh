package com.cn.main;

/**

* Copyright (C), 03.06-03.11

* FileName: Main.java

* 具体实现

* @author Lipeishan
* @Date    2020.03.06

* @version 1.00

*/
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import com.cn.chart.BarChartStudent;
import com.cn.chart.BarChartTeacher;
import com.cn.dao.AllDao;
import com.cn.dao.StudentDao;
import com.cn.dao.TeacherDao;
import com.cn.pojo.Student;
import com.cn.pojo.Studentinfo;
import com.cn.pojo.Teacher;
import com.cn.pojo.Teacherinfo;
import com.cn.util.AbUtil;
public class Main {
	public static void main(String[] args) throws Exception {
		Menu();
		ArrayList<Teacher> t = new ArrayList<Teacher>();
		ArrayList<Teacherinfo> tinfo = new ArrayList<Teacherinfo>();
		ArrayList<Student> s = new ArrayList<Student>();
		ArrayList<Studentinfo> sinfo = new ArrayList<Studentinfo>();
		int choice;
		int choice1;
		int choice2;
		int choice3;
		int choice4;
		// 菜单显示
		while (true) {
			Scanner in = new Scanner(System.in);
			choice = in.nextInt();
			switch (choice) {
			case 1:
				// 某人某天情况查询
				Menu2();
				do {
					Scanner in2 = new Scanner(System.in);
					choice2 = in.nextInt();
					switch (choice2) {
					case 1:
						// 根据工号查询
						SelectionTeacherById();
						Menu2();
						break;

					case 2:
						// 根据学号查询
						SelectionStudentById();
						Menu2();
						break;
					}

				} while (choice2 != 6);
				break;						
			case 2:
				// 全部信息显示
				Menu1();
				do {
					Scanner in1 = new Scanner(System.in);
					choice1 = in1.nextInt();
					switch (choice1) {
					case 1:
						// 教师信息
						SelectionAllTeacher();
						Menu1();
						break;

					case 2:
						// 学生信息
						SelectionAllStudent();
						Menu1();
						break;
						

					case 3:
						// 查看学生确诊情况
						SelectionStudentCheck();
						Menu2();
						break;

					case 4:
						// 查看教师确诊情况
						SelectionTeacherCheck();
						Menu2();
						break;
					}
				} while (choice1 != 5);
				break;

			case 3:
				// 添加操作
				MenuAdd();
				do {
					Scanner in_addteacher = new Scanner(System.in);
					choice3 = in_addteacher.nextInt();
					switch (choice3) {
					case 1:
						// 添加教师信息
						TeacherAdd(t);
						MenuAdd();
						break;

					case 2:
						// 添加学生信息
						StudentAdd(s);
						MenuAdd();
						break;

					case 3:
						// 添加教师防疫信息
						AddTeacherInfo(tinfo);
						MenuAdd();
						break;

					case 4:
						// 添加学生防疫信息
						AddStudentInfo(sinfo);
						MenuAdd();
						break;

					}
				} while (choice3 != 5);
				break;
				
			case 4:
				// 柱状图
				MenuFrame();
				do {
					Scanner in4 = new Scanner(System.in);
					choice4 = in.nextInt();
					switch (choice4) {
					case 1:
						// 教师确诊男女情况图
						TeacherCheckInfo();
						MenuFrame();
						break;

					case 2:
						// 学生确诊男女情况图
						StudentCheckInfo();
						MenuFrame();
						break;
					}
				} while (choice4 != 3);
				break;
				
				
				
			case 5:
				System.exit(0);

			}
			Menu();
		}
	}

	/**
	 * 菜单
	 */
	private static void Menu() {
		// TODO Auto-generated method stub
		System.out.println("***********************疫情查询系统菜单********************************");
		System.out.println("1.查询某人某天的疫情情况(学生/教师)");
		System.out.println("2.查询全部信息(全部教师信息/全部学生信息/学生确诊信息/教师确诊信息)");
		System.out.println("3.添加信息(添加教师信息/添加学生信息/添加教师疫情信息/添加学生疫情信息)");
		System.out.println("4.疫情统计柱状图(教师/学生确诊情况统计图)");
		System.out.println("5.exit");
	}

	/**
	 * 添加信息菜单
	 */
	private static void MenuAdd() {
		// TODO Auto-generated method stub
		System.out.println("1.添加教师");
		System.out.println("2.添加学生");
		System.out.println("3.添加教师防疫信息");
		System.out.println("4.添加学生防疫信息");
		System.out.println("5.exit");
	}

	/**
	 * 显示信息菜单
	 */
	private static void Menu1() {
		// TODO Auto-generated method stub
		System.out.println("1.查询全部教师信息");
		System.out.println("2.查询全部学生信息");
		System.out.println("3.显示学生确诊信息");
		System.out.println("4.显示教师确诊信息");
		System.out.println("5.exit");
	}

	/**
	 * 特征查询菜单
	 */
	private static void Menu2() {
		// TODO Auto-generated method stub
		System.out.println("1.根据工号查询教师信息");
		System.out.println("2.根据学号查询学生信息");
		System.out.println("3.exit");

	}

	/**
	 * 柱状图菜单
	 */
	private static void MenuFrame() {
		// TODO Auto-generated method stub
		System.out.println("1.教师确诊情况统计");
		System.out.println("2.学生确诊情况统计");
		System.out.println("3.exit");
	}

	/**
	教师信息添加
**/
	private static ArrayList<Teacher> TeacherAdd(ArrayList<Teacher> arrayList) throws Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		TeacherDao dao = new TeacherDao(con);
		System.out.println("请输入教师信息：");
		Scanner t = new Scanner(System.in);
		int teacher_id = t.nextInt();
		String teacher_name = t.next();
		String sex = t.next();
		String t_pro = t.next();
		String t_city = t.next();
		Teacher teacher = new Teacher();
		teacher.setTeacher_id(teacher_id);
		teacher.setTeacher_name(teacher_name);
		teacher.setSex(sex);
		teacher.setT_pro(t_pro);
		teacher.setT_city(t_city);

		try {
			dao.AddTeacher(con, teacher);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}
		if (arrayList != null) {
			System.out.println("添加成功");
			return arrayList;
		}
		System.out.println("添加失败");
		return null;

	}

	/**
	 * 学生信息添加
	 */
	private static ArrayList<Student> StudentAdd(ArrayList<Student> arrayList) throws Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		StudentDao dao = new StudentDao(con);
		System.out.println("请输入学生信息：");
		Scanner t = new Scanner(System.in);
		int student_id = t.nextInt();
		String student_name = t.next();
		String stu_sex = t.next();
		String student_pro = t.next();
		String student_city = t.next();
		Student student = new Student();
		student.setStudent_id(student_id);
		student.setStu_name(student_name);
		student.setStu_sex(stu_sex);
		student.setStu_pro(student_pro);
		student.setStu_city(student_city);

		try {
			dao.AddStudent(con, student);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}
		if (arrayList != null) {
			System.out.println("添加成功");
			return arrayList;
		}
		System.out.println("添加失败");
		return null;
	}

	/**
	 * 教师防疫信息添加
	 * 
	 */
	private static ArrayList<Teacherinfo> AddTeacherInfo(ArrayList<Teacherinfo> arrayList) throws Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		TeacherDao dao = new TeacherDao(con);

		System.out.println("请输入教师防疫信息：");
		Scanner info = new Scanner(System.in);
		int teacher_id = info.nextInt();
		String symptom = info.next();
		String check = info.next();
		BigDecimal temperature = info.nextBigDecimal();

		java.util.Date curDate = new java.util.Date();
		// 进行日期的转换
		java.sql.Date date = new java.sql.Date(curDate.getTime());

		Teacherinfo tinfo = new Teacherinfo();
		tinfo.setTeacher_id(teacher_id);
		tinfo.setSymptom(symptom);
		tinfo.setCheck(check);
		tinfo.setTemperature(temperature);
		tinfo.setDate(date);

		try {
			dao.AddTeacherInfo(con, tinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}

		if (arrayList != null) {
			System.out.println("添加成功");
			return arrayList;
		}
		System.out.println("添加失败");
		return null;

	}

	/**
	 * 学生防疫信息添加
	 */
	private static ArrayList<Studentinfo> AddStudentInfo(ArrayList<Studentinfo> arrayList) throws Exception {
		// TODO Auto-generated method stub
		Connection con =AbUtil.getCon();
		StudentDao dao = new StudentDao(con);

		System.out.println("请输入学生防疫信息：");
		Scanner info = new Scanner(System.in);
		int student_id = info.nextInt();
		String symptom = info.next();
		String check = info.next();
		BigDecimal temperature = info.nextBigDecimal();
		java.util.Date curDate = new java.util.Date();
		java.sql.Date date = new java.sql.Date(curDate.getTime());

		Studentinfo sinfo = new Studentinfo();
		sinfo.setStudent_id(student_id);
		sinfo.setSymptom(symptom);
		sinfo.setCheck(check);
		sinfo.setTemperature(temperature);
		sinfo.setDate(date);
		try {
			dao.AddStudentInfo(con, sinfo);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}

		if (arrayList != null) {
			System.out.println("添加成功");
			return arrayList;
		}
		System.out.println("添加失败");
		return null;

	}

	/**
	 * 教师确诊信息
	 */
	private static void SelectionTeacherCheck() throws Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		AllDao dao = new AllDao(con);
		try {
			dao.selectTeacherCheck();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}
	}

	/**
	 * 学生确诊信息
	 */
	private static void SelectionStudentCheck() throws Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		AllDao dao = new AllDao(con);
		try {
			dao.selectStudentCheck();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}
	}

	/**
	 * 根据学号进行学生信息查询
	 */
	private static void SelectionStudentById() throws Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		Scanner in = new Scanner(System.in);
		System.out.println("请输入学号：");
		int id = in.nextInt();
		StudentDao dao = new StudentDao(con);
		try {
			dao.selectStudentById(con, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}
	}

	/**
	 * 根据工号进行教师信息查询
	 */
	private static void SelectionTeacherById() throws Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		Scanner in = new Scanner(System.in);
		System.out.println("请输入教师工号：");
		int id = in.nextInt();
		TeacherDao dao = new TeacherDao(con);
		try {
			dao.selectTeacherById(con, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}

	}

	/**
	 * 显示所有学生信息以及防疫信息
	 */
	private static void SelectionAllStudent() throws Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		StudentDao dao = new StudentDao(con);
		try {
			dao.selectAllStudent();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}

	}

	/**
	 * 显示所有教师信息以及防疫信息
	 */
	private static void SelectionAllTeacher() throws Exception {
		// TODO Auto-generated method stub
		Connection con =AbUtil.getCon();
		TeacherDao dao = new TeacherDao(con);
		try {
			dao.selectAllTeacher();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			AbUtil.closeCon(con);
		}

	}
	/**
	 * 教师每日确诊情况
	 */
	private static void TeacherCheckInfo() throws SQLException, Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		JFrame frame = new JFrame("疫情统计柱状图");
		frame.add(new BarChartTeacher().getChartPanel()); // 添加柱形图
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);

	}

	/**
	 * 学生每日确诊情况
	 */
	private static void StudentCheckInfo() throws SQLException, Exception {
		// TODO Auto-generated method stub
		Connection con = AbUtil.getCon();
		JFrame frame = new JFrame("疫情统计柱状图");
		frame.add(new BarChartStudent().getChartPanel()); // 添加柱形图
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);

	}

}
