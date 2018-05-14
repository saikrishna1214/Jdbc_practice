package jdbc_practice.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import org.imaginea.practice.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *  tests the code with given input data
 */

public class TestJunitConnection {
	
	
	static private ConnectionUtil conn = new ConnectionUtil();
	
	static private Connection con;
	
	InsertDetails ins = new InsertDetails();
	
	/**
	 *  connects to data base and stores returned object in con variable
	 */
	@BeforeClass
	public static  void connectToDatabase() throws IOException, SQLException
	{
		con = conn.getConnection();
	}
	
	
	/**
	 * closes connection after testing data
	 */
	@AfterClass
	public static void closeConnection() throws SQLException
	{
		con.close();
	}
	
	/**
	 *  tests the insert function returns 0 if data is inserted 
	 *  1 if data is not inserted
	 */
	
	@Test
	public void testInsert()throws SQLException, IOException
	{
		String str = "1 ravi 207 eee";
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		System.setIn(in);
		assertEquals(0, ins.insert(con));
	}
	
	/**
	 * tests whether data is deleted properly or not 
	 * returns 1 if data is deleted properly otherwise 0.
	 */
	
	@Test
	public void testDelete() throws SQLException
	{
		String str = "200";
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		DeleteData d = new DeleteData();
		System.setIn(in);
		assertEquals(1, d.delete(con));
	}
	
	/**
	 * returns true if data is properly printed other wise false.
	 */
	@Test
	public void testResult()throws SQLException
	{
		PrintResluts p = new PrintResluts();
		assertEquals(false, p.results(con));
	}
	
	/**
	 * tests whether data is correctly updated or not
	 * @throws SQLException
	 */
	@Test
	public void testUpdate()throws SQLException
	{
		String str = "2 raju 122 ece";
		ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
		System.setIn(in);
		Update u = new Update();
		assertEquals(true, u.updateTable(con));
	}

}