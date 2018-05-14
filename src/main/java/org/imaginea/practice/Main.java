package org.imaginea.practice;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
/**
 * This code is used to call a method for a respective operation on 
 * database. getConnection of ConnectionUtil method is called to establish
 * connection to database. 
 * 
 * @author saikrishnak
 * 
 */
public class Main {
	
	/**
	 * objects for all the classes are created and initialized for respective
	 * operations. 
	 * options for operations are given and they should be entered as input
	 * in an endless while loop. switch case will call respective methods by 
	 * using case labels. and control will come out from while loop if exit 
	 * option is chosen.
	 * 
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
	
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
				System.out.println("no. of rows inserted is "+i.insert(con));
				break;
			case 2:
				if(u.updateTable(con))
				{
					System.out.println("given row is updated");
				}
				else
					System.out.println("given row is not there in table");
				break;
			case 3:
				p.results(con);
			case 4:
				int rowsdeleted = d.delete(con);
				System.out.println("no. of rows deleted is "+rowsdeleted);
			}
			if(n==5)
				break;
		}
	}
}
