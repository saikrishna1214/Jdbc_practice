package org.imaginea.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateTable {
	 public void create(Connection con) throws SQLException
	    {
	    	PreparedStatement ps;
	        String s1 = "create table students(name varchar(20), id numeric(10) primarykey unique notnull, branch varchar(20))";
	        ps = con.prepareStatement(s1);
	        ps.executeUpdate();
	    }
}
