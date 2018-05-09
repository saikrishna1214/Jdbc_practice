package org.imaginea.practice;

import java.sql.*;
import java.util.List;
import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class InsertDetails 
{
    public void insert(Connection con) throws SQLException
    {
    	PreparedStatement ps;
    	Scanner sc = new Scanner(System.in);
        String s2 = "insert into students values(?,?,?)";
        ps = con.prepareStatement(s2);
        System.out.println("enter no. of students: ");
        int n = sc.nextInt();
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
    }
}
