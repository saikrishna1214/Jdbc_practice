package org.imaginea.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update {
	public static void main(String a[]) throws SQLException
	{
    	Scanner sc = new Scanner(System.in);
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        System.out.println("connected..."+con.getClass());
        /*System.out.println("enter the row no. to update : ");
        int rno = sc.nextInt();
        System.out.println("enter modified details : ");
        String name = sc.next();
    	int id = sc.nextInt();
    	String branch = sc.next();*/
        Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        String s1 = "select name,id,branch from students";
        ResultSet rs = st.executeQuery(s1);
        rs.absolute(1);
        rs.updateString(1, "sai");
        rs.updateInt(2, 125);
        rs.updateString(3, "cse");
        rs.updateRow();
	}
}
