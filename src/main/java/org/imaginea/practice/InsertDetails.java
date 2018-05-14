package org.imaginea.practice;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


/**
 * This code will inserts the given data into students table 
 * by taking data as input using scanner class.
 * 
 * @Connection establishes connection with database and an object
 * of type Connection class is passed as an argument.
 */
public class InsertDetails 
{
	/**
	 * Prepared statement will take values dynamically (at run time) Creates a 
	 * PreparedStatement object for sending parameterized SQL statements to the database.
	 * 
	 * @insert method will take value for integer variable n (number of students 
	 * data to be entered) and while loop will run for n times and each time it will 
	 * student details and they should be entered in an order (name ,id ,branch).
	 * @ps PreparedStatement object will insert values into tables by using setString(),
	 * setInt() methods.
	 *  
	 * @param con
	 * @throws SQLException
	 */
    public int insert(Connection con) throws SQLException
    {
    	PreparedStatement ps;
    	Scanner sc = new Scanner(System.in);
        String s2 = "insert into students values(?,?,?)";
        ps = con.prepareStatement(s2);
        System.out.println("enter no. of students: ");
        int n = sc.nextInt();
        int m=0;
        while(n-->0)
        {
        	System.out.println("enter student details(name,id,branch) in order: ");
        	String name = sc.next();
        	int id = sc.nextInt();
        	String branch = sc.next();
        	ps.setString(1, name);
        	ps.setInt(2, id);
        	ps.setString(3, branch);
        	ps.executeUpdate();
        }
        return m;
    }
}
