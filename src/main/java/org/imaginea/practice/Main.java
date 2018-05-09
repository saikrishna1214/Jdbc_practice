package org.imaginea.practice;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws SQLException, IOException
	{
		Scanner sc = new Scanner(System.in);
		InsertDetails i = new InsertDetails();
		Update u = new Update();
		PrintResluts p = new PrintResluts();
		CreateTable c = new CreateTable();
		ConnectionUtils cn = new ConnectionUtils();
		Connection con = cn.getConnection();
		System.out.println("enter: 1.to create table \n 2. to insert details \n 3. to update \n 4. to print results \n 5. to exit");
		while(true)
		{
			System.out.println("enter your choice : ");
			int n = sc.nextInt();
			switch(n)
			{
			case 1:
				c.create(con);
				break;
			case 2:	
				i.insert(con);
				break;
			case 3:
				u.updateTable(con);
				break;
			case 4:
				p.results(con);
			}
			if(n==5)
				break;
		}
	}
}
