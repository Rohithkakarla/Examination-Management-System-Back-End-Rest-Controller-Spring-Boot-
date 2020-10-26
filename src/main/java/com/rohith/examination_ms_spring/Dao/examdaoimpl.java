package com.rohith.examination_ms_spring.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.connectionpool.Basicdatasource;
import com.rohith.examination_ms_spring.models.exam;
import com.rohith.examination_ms_spring.models.faculty;

@Component
public class examdaoimpl implements examDaoInterface {

	@Autowired
	Basicdatasource basicdatasource;

	public List<exam> getallexams() {

		List<exam> al = new ArrayList<exam>();

		try {
			DataSource bds = basicdatasource.getdatasourceobj();

			Connection con = bds.getConnection();

			PreparedStatement pst = con.prepareStatement("select * from exam");

			ResultSet rs = pst.executeQuery();

			System.out.println(rs);

			while (rs.next()) {
				al.add(new exam(rs.getString(2), rs.getString(3), rs.getString(4)));
				// System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return al;
	}

	@Override
	public List<exam> getexamsoffaculty(faculty facultyobj) {

		List<exam> al = new ArrayList<exam>();

		try {
			DataSource bds = basicdatasource.getdatasourceobj();

			Connection con = bds.getConnection();

			PreparedStatement pst = con.prepareStatement("select * from exam where facultyid = ?");

			pst.setString(1, facultyobj.getFacultyid());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				al.add(new exam(rs.getString(2), rs.getString(3), rs.getString(4)));
				// System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return al;
	}

	@Override
	public boolean addexam(exam examobj) {

		int i = 0;

		try {
			DataSource bds = basicdatasource.getdatasourceobj();

			Connection con = bds.getConnection();

			PreparedStatement pst = con.prepareStatement("insert into exam(name, courseid, facultyid) values(?,?,?)");

			pst.setString(1, examobj.getName());
			pst.setString(2, examobj.getCourseid());
			pst.setString(3, examobj.getFacultyid());

			i = pst.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (i == 1) {
			return true;
		} else {
			return false;
		}
	}

}
