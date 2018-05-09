package org.imaginea.practice;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

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
