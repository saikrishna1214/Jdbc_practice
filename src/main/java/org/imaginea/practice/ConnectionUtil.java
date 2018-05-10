package org.imaginea.practice;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * In this code a Connection is established to database.
 * 
 * values for variables host,port,dbname,user,pwd are taken
 * from JVM arguments if any of them is null then values from
 * property file are taken.
 * After establishing a connection it return an object of type
 * Connection class.
 * 
 * @author saikrishnak
 *
 */
public class ConnectionUtil {

	/**
	 * @getConnection method will connect to database by using JVM 
	 * arguments if any one of them is null it will take values from 
	 * config.properties file. if there is no such file then it throws
	 * an exception.
	 * DriverManager.getConnection method will take url, username, password
	 * as arguments and returns a Connection object if connection is
	 * established.
	 * 
	 * @return will return Object of type connection class.
	 * @throws IOException
	 * @throws SQLException
	 */
	public Connection getConnection() throws IOException, SQLException {
		Properties pr=new Properties();
		String host,port,dbname,user,pwd,url;
		host = System.getProperty("host");
		port = System.getProperty("port");
		dbname = System.getProperty("dbname");
		user = System.getProperty("user");
		pwd = System.getProperty("pwd");
		if(host == null||port == null||dbname == null||user == null||pwd == null)
		{
				InputStream ip = getClass().getClassLoader().getResourceAsStream("config.properties");
				if(ip != null)
				{
				pr.load(ip);
				host = pr.getProperty("mysql.host");
				port = pr.getProperty("mysql.port");
				dbname = pr.getProperty("mysql.dbname");
				user = pr.getProperty("mysql.user");
				pwd = pr.getProperty("mysql.pwd");
				}
				else
					System.out.println("please provide properties file..");	
		}
		url = "jdbc:mysql://"+host+":"+port+"/"+dbname;
		Connection con = DriverManager.getConnection(url, user, pwd);
        System.out.println("connected..."+con.getClass());
		return con;
	}
   
}
