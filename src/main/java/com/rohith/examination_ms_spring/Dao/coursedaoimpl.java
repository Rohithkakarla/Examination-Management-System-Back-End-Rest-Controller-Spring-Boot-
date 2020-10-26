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
import com.rohith.examination_ms_spring.models.course;
import com.rohith.examination_ms_spring.models.faculty;

@Component
public class coursedaoimpl implements courseDaoInterface {

	@Autowired
	Basicdatasource basicdatasource;
	
	@Override
	public List<course> getallcourses() {
		
		List<course> al = new ArrayList<course>();
		
		try
		{
			DataSource bds = basicdatasource.getdatasourceobj();
			
			Connection con = bds.getConnection();
		    
		    Statement stmt= con.createStatement();
			
			ResultSet rs=  stmt.executeQuery("select * from courses");
			
			while(rs.next()) {
				al.add(new course(rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5)));
				//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getBoolean(6));
			}
			
		    con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return al;
	}

	@Override
	public boolean addcourse(course courseobj) {
		int i = 0;
		
		try
		{
			DataSource bds = basicdatasource.getdatasourceobj();
			
			Connection con = bds.getConnection();
			
		    PreparedStatement pst=con.prepareStatement("insert into courses(courseid, name, facultyid, status) values(?,?,?,?)");  
		    
		    pst.setString(1, courseobj.getCourseid());
		    pst.setString(2, courseobj.getName());
		    pst.setString(3, courseobj.getFacultyid());
		    pst.setBoolean(4, courseobj.isStatus());
		    
		    i = pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(i == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<course> getcourseoffaculty(faculty faculty) {
		
		List<course> al = new ArrayList<course>();
		
		try
		{
			DataSource bds = basicdatasource.getdatasourceobj();
			
			Connection con = bds.getConnection();
		    
		    PreparedStatement pst=con.prepareStatement("select * from courses where facultyid = ?");  
		    
		    pst.setString(1, faculty.getFacultyid());
			
			ResultSet rs=  pst.executeQuery();
			
			while(rs.next()) {
				al.add(new course(rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5)));
				//System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getBoolean(6));
			}
			
		    con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return al;
	}
	
	

}
