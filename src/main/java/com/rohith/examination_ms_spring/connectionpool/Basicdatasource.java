package com.rohith.examination_ms_spring.connectionpool;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.stereotype.Component;

@Component
public class Basicdatasource{
	
	public DataSource getdatasourceobj()
	{
		
		BasicDataSource bds = new BasicDataSource();
		
		bds.setDriverClassName("com.mysql.cj.jdbc.Driver");
	    bds.setUrl("jdbc:mysql://localhost:3306/examination_ms");
	    bds.setUsername("root");
	    bds.setPassword("password");

	    // For Maximum connections in the connection Pool
	    bds.setMaxTotal(20);
	    // For minimum connections
	    bds.setMinIdle(5);

	    // To make the user wait untill if any connection available if all connections are in use.
	    bds.setMaxWaitMillis(5000);
	    
	    return bds;
	}
	
}
