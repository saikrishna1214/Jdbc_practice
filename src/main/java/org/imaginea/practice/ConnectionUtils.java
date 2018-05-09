package org.imaginea.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

	public Connection getConnection() throws IOException, SQLException {
		/*Properties pr=new Properties();
		InputStream ip = getClass().getClassLoader().getResourceAsStream("config.properties");
		pr.load(ip);
		String host = pr.getProperty("mysql.host");
		String port = pr.getProperty("mysql.port");
		String dbname = pr.getProperty("mysql.dbname");
		String user = pr.getProperty("mysql.user");
		String pwd = pr.getProperty("mysql.pwd");*/
		String host = System.getProperty("host");
		String port = System.getProperty("port");
		String dbname = System.getProperty("dbname");
		String user = System.getProperty("user");
		String pwd = System.getProperty("pwd");
		String url = "jdbc:mysql://"+host+":"+port+"/"+dbname;
		Connection con = DriverManager.getConnection(url, user, pwd);
        System.out.println("connected..."+con.getClass());
		return con;
	}
}
