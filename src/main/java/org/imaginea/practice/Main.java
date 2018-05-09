package org.imaginea.practice;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * 
 * @author saikrishnak
 * 
 * 
 *
 */
public class Main {
	
	public static void main(String args[]) throws SQLException, IOException
	{
		Scanner sc = new Scanner(System.in);
		InsertDetails i = new InsertDetails();
		Update u = new Update();
		PrintResluts p = new PrintResluts();
		DeleteData d = new DeleteData();
		ConnectionUtil cn = new ConnectionUtil();
		Connection con = cn.getConnection();
		System.out.println("enter: 1.to insert details \n 2. to update \n 3. to print results \n 4. to delete \n 5. to exit");
		while(true)
		{
			System.out.println("enter your choice : ");
			int n = sc.nextInt();
			switch(n)
			{
			case 1:	
				i.insert(con);
				break;
			case 2:
				u.updateTable(con);
				break;
			case 3:
				p.results(con);
			case 4:
				d.delete(con);
			}
			if(n==5)
				break;
		}
	}
}
