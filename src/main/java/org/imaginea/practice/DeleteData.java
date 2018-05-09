package org.imaginea.practice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;


public class DeleteData {
	
	public void delete(Connection con) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		String s1 = "delete from students where id=?";
		PreparedStatement ps = con.prepareStatement(s1);
		System.out.println("enter the student id to delete : ");
		int id = sc.nextInt();
		ps.setInt(1,id);
		ps.executeUpdate();
	}
	
}
