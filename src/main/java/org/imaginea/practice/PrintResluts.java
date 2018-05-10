package org.imaginea.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 
 * all the data in the tables will be printed in this code.
 * values from tables are taken by using getString() , getInt() methods.
 * 
 * @author saikrishnak
 *
 */

public class PrintResluts {
	
	/**
	 * 
	 * SQL statement is passed to executeQuery method of Statement class
	 * which will return Object of ResultSet type. 
	 * next() Moves the cursor forward one row from its current position. 
	 * A ResultSet cursor is initially positioned before the first row 
	 * the first call to the method next makes the first row the current row; 
	 * the second call makes the second row the current row, and so on.
	 * When a call to the next method returns false, the cursor is positioned
	 *  after the last row.
	 * 
	 * @param con
	 * @throws SQLException
	 */
	
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
