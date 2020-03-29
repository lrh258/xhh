package com.cn.chart;
/**

* Copyright (C), 03.06-03.11

* FileName: BarChartStudent.java

* ������ѧ��ȷ�����������״ͼ

* @author Lipeishan
* @Date    2020.03.10

* @version 1.00

*/
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.cn.pojo.Studentinfo;
import com.cn.util.AbUtil;

public class BarChartStudent {
	ChartPanel frame1;

	public BarChartStudent() throws Exception {
		CategoryDataset dataset = getDataSet();
		JFreeChart chart = ChartFactory.createBarChart3D(
				// ͼ�����
				"ѧ��ȷ�����ͳ��",
				// �ļ��������ʾ��ǩ
				"�Ա�",
				// ��ֵ�����ʾ��ǩ
				"����",
				// ���ݼ�
				dataset,
				// ͼ����
				PlotOrientation.VERTICAL,
				// �Ƿ���ʾͼ��
				true,
				// �Ƿ����ɹ���
				false,
				// �Ƿ�����URL����
				false);

		// ��ȡͼ���������
		CategoryPlot plot = chart.getCategoryPlot();
		// ˮƽ�ײ��б�
		CategoryAxis domainAxis = plot.getDomainAxis();
		// ˮƽ�ײ�����
		domainAxis.setLabelFont(new Font("����", Font.BOLD, 14));
		// ��ֱ����
		domainAxis.setTickLabelFont(new Font("����", Font.BOLD, 12));
		// ��ȡ��״
		ValueAxis rangeAxis = plot.getRangeAxis();
		rangeAxis.setLabelFont(new Font("����", Font.BOLD, 15));
		chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
		// ���ñ�������
		chart.getTitle().setFont(new Font("����", Font.BOLD, 20));

		frame1 = new ChartPanel(chart, true);

	}

	/**
	 * ʹ�ò�ѯ���ݿ������
	 */
	private static CategoryDataset getDataSet() throws Exception {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		java.util.List<Studentinfo> list = CheckStudent();
		// װ��JFreeChart��Ҫ�����ݼ�
		for (Studentinfo studentinfo : list) {
			// ������ʽ��ʾΪ��-����
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
			String str = sdf.format(studentinfo.getDate());
			dataset.addValue(studentinfo.getChecknum(), studentinfo.getSex(), str);
		}
		return dataset;
	}

	/**
	 * ������������״ͼ�Ľ����
	 */
	public static java.util.List<Studentinfo> CheckStudent() throws SQLException, Exception {
		Connection con = null;
		con = AbUtil.getCon();
		java.util.List<Studentinfo> list = new ArrayList<Studentinfo>();
		try {
			String sql = "select date,stu_sex,sum(check1='Y') from (select date,stu_sex,check1 from student s left join stu_info s1 on s.student_id = s1.s_id ) a group by date,stu_sex ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new Studentinfo(rs.getDate(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;

	}

	public ChartPanel getChartPanel() {
		return frame1;

	}

}
