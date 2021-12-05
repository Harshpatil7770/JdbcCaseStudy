package com.ecart.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconfig {

	public static Connection con=null;
	
	public static Connection getConnection() {
		if(con==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				System.out.println("=========== Creation Created Succesfully========");
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Issue Present at the time of creating connection");
			}
		}
		return con;
	}
	
	public static void closeConnection() {
		if(con!=null) {
			try {
				con.close();
			}catch(Exception e) {
			e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		getConnection();
	
	}
}
