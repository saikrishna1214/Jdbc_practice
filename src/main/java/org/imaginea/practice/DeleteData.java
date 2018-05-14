package org.imaginea.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * this code will delete data from tables in our database
 * student id is used to delete a respective row from database.
 * 
 */
public class DeleteData {
	
	/**
	 * rows are deleted from tables using delete operation with
	 * respective to student id's. 
	 * Prepared statement will take values dynamically (at run time) Creates a 
	 * PreparedStatement object for sending parameterized SQL statements to the database.
	 * @id is taken as input from scanner class and setInt() will go to respective row
	 * executeUpdate() will execute the SQL statement.  
	 * 
	 * @param con
	 * @throws SQLException
	 */
	
	public int delete(Connection con) throws SQLException
	{
		
		Scanner sc = new Scanner(System.in);
		
		String s1 = "delete from students where id=?";
		
		PreparedStatement ps = con.prepareStatement(s1);
		
		System.out.println("enter the student id to delete : ");
		
		int id = sc.nextInt();
		
		ps.setInt(1,id);
		
		return ps.executeUpdate();
		
	}
	
}
