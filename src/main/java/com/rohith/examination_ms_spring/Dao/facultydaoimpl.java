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
import com.rohith.examination_ms_spring.models.faculty;

@Component
public class facultydaoimpl implements facultyDaoInterface {

	@Autowired
	Basicdatasource basicdatasource;

	@Override
	public List<faculty> getallfaculty() {

		List<faculty> al = new ArrayList<faculty>();

		try {
			DataSource bds = basicdatasource.getdatasourceobj();

			Connection con = bds.getConnection();

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from faculty");

			while (rs.next()) {
				al.add(new faculty(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
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
	public boolean addfaculty(faculty facultyobj) {
		int i = 0;

		try {
			DataSource bds = basicdatasource.getdatasourceobj();

			Connection con = bds.getConnection();

			PreparedStatement pst = con.prepareStatement(
					"insert into faculty(facultyid, name, email, password, status) values(?,?,?,?,?)");

			pst.setString(1, facultyobj.getFacultyid());
			pst.setString(2, facultyobj.getName());
			pst.setString(3, facultyobj.getEmail());
			pst.setString(4, facultyobj.getPassword());
			pst.setBoolean(5, facultyobj.isStatus());

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
	public faculty checkfaculty(faculty facultyobj) {
		faculty obj = null;

		try {
			DataSource bds = basicdatasource.getdatasourceobj();

			Connection con = bds.getConnection();

			PreparedStatement pst = con.prepareStatement("select * from faculty Where facultyid=? and password=?");

			pst.setString(1, facultyobj.getFacultyid());
			pst.setString(2, facultyobj.getPassword());

			ResultSet rs = pst.executeQuery();

			obj = new faculty();
			while (rs.next()) {
				obj.setFacultyid(rs.getString(2));
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
