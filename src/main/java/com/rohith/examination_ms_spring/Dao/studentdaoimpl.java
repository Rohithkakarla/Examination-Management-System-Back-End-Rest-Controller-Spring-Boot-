package com.rohith.examination_ms_spring.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rohith.examination_ms_spring.connectionpool.Basicdatasource;
import com.rohith.examination_ms_spring.models.Student;

@Component
public class studentdaoimpl implements StudentDaoInterface {

	@Autowired
	Basicdatasource basicdatasource;

	@Override
	public List<Student> getallstudents() {
		List<Student> al = new ArrayList<Student>();

		try {

			DataSource ds = basicdatasource.getdatasourceobj();

			Connection con = ds.getConnection();

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from students");

			while (rs.next()) {
				al.add(new Student(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getBoolean(6)));
				// System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+"
				// "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getBoolean(6));
			}

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return al;

	}

	@Override
	public boolean addstudent(Student student) {

		int i = 0;

		try {
			DataSource ds = basicdatasource.getdatasourceobj();

			Connection con = ds.getConnection();

			PreparedStatement pst = con
					.prepareStatement("insert into students(userid, name, email, password, status) values(?,?,?,?,?)");

			pst.setString(1, student.getUserid());
			pst.setString(2, student.getName());
			pst.setString(3, student.getEmail());
			pst.setString(4, student.getPassword());
			pst.setBoolean(5, student.isStatus());

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

	@Override
	public Student checkstudent(Student studentobj) {
		Student obj = null;

		try {
			DataSource ds = basicdatasource.getdatasourceobj();

			Connection con = ds.getConnection();

			PreparedStatement pst = con.prepareStatement("select * from students Where userid=? and password=?");

			pst.setString(1, studentobj.getUserid());
			pst.setString(2, studentobj.getPassword());

			ResultSet rs = pst.executeQuery();

			obj = new Student();
			while (rs.next()) {
				obj.setUserid(rs.getString(2));
				obj.setName(rs.getString(3));
				obj.setEmail(rs.getString(4));
				obj.setPassword(rs.getString(5));
				obj.setStatus(rs.getBoolean(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obj;
	}

}
