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
    * SQL statement is passed to executeQuery method of Statement class
    * which will return Object of ResultSet type. 
    * @param con gets connection from database.
	* @throws SQLException
	*/
	
	public boolean results(Connection con) throws SQLException
	{
        String s1 = "select *from students";
        
        Statement st = con.createStatement();
        
        /**
         * SQL statement is passed to executeQuery method of Statement class
         * which will return Object of ResultSet type. 
         */
      
        ResultSet rs = st.executeQuery(s1);
        boolean temp;
        
        /**
         * next() Moves the cursor forward one row from its current position. 
         *
         * When a call to the next method returns false, the cursor is positioned
         *  after the last row.
         */
        
        while(temp=rs.next())
        {
        	System.out.print(rs.getRow()+"  ");
        	
        	/*prints data in each row */
        	
        	System.out.print(rs.getInt(2)+"  ");
        	System.out.print(rs.getString(3));
        	System.out.println();
        }
        /* returns false if all rows are printed */
        return temp;
	}
}
