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
 * this code will update the data in a row 
 * absolute() method moves pointer to respective row and update
 * operation is done to it.
 * 
 * @author saikrishnak
 *
 */

public class Update {
	
	/**
	 * 
	 * Prepared statement will take values dynamically (at run time) Creates a 
	 * PreparedStatement object for sending parameterized SQL statements to the database.
	 * @id is taken as input from scanner class and setInt() will go to respective row
	 * executeUpdate() will execute the SQL statement. 
	 * row number is taken as input to update the given row.
	 * updateString(), updateInt() methods of ResultSet updates the row. 
	 * 
	 * @param con
	 * @throws SQLException
	 */
	
	public void updateTable(Connection con) throws SQLException
	{
    	Scanner sc = new Scanner(System.in);
        System.out.println("enter the row no. to update : ");
        int rno = sc.nextInt();
        System.out.println("enter modified details : ");
        String name = sc.next();
    	int id = sc.nextInt();
    	String branch = sc.next();
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String s1 = "select name,id,branch from students";
        ResultSet rs = st.executeQuery(s1);
        rs.absolute(rno);
        rs.updateString(1, name);
        rs.updateInt(2, id);
        rs.updateString(3, branch);
        rs.updateRow();
	}
}
