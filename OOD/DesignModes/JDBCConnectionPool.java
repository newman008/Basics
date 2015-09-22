package designModes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionPool extends ObjectPool<Connection> {

	 private String url, usr, pwd;
	 public JDBCConnectionPool(String driver, String url, String usr, String pwd) {
		 super();
	
		  try {
			  Class.forName(driver).newInstance();
		  }
		  catch(Exception e) {
			  e.printStackTrace();
		  }
		
		  this.url = url;
		  this.usr = usr;
		  this.pwd = pwd;
	 }
	
	 @Override
	 protected Connection create() {
		  try {
			  return DriverManager.getConnection(url, usr, pwd);
		  }
		  catch(SQLException e) {
			  e.printStackTrace();
		  }
		
		  return null;
	 }
	 
	 @Override
	 public boolean validate(Connection o) {
		  try {
			  return o.isClosed();
		  }
		  catch(SQLException e) {
			  e.printStackTrace();
		  }
		
		  return false;
	 }
	 
	 @Override
	 public void expire(Connection o) {
		  try {
			  o.close();
		  }
		  catch(SQLException e) {
			  e.printStackTrace();
		  }
		  finally {
			  o = null;
		  }
	 }
	
	 public static void main(String[] args) {
		  JDBCConnectionPool dbConnPool = new JDBCConnectionPool("com.mysql.jdbc.Driver", "jdbc:mysql://127.0.0.1:3306/test", "root", "123");
		
		  Connection conn = dbConnPool.checkOut();
		
		  dbConnPool.checkIn(conn);
	
	 }
}
