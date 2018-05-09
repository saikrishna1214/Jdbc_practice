package org.imaginea.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PrintResluts {
	public void results(Connection con) throws SQLException
	{
        String s1 = "select *from students";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(s1);
        while(rs.next())
        {
        	System.out.print(rs.getRow()+"  ");
        	System.out.print(rs.getString(1)+"  ");
        	System.out.print(rs.getInt(2)+"  ");
        	System.out.print(rs.getString(3));
        	System.out.println();
        }
	}
}
