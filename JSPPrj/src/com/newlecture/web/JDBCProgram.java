package com.newlecture.web;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProgram {

	public static void main(String[] args) throws  ClassNotFoundException, SQLException {
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE ID < 20";
				
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		
//		while(rs.next())
//		System.out.printf("id:%d, nicname : %s pwd:%s\n", rs.getInt("ID"), rs.getString("NICNAME"),rs.getString("PWD"));
//	
		
		int id =rs.getInt("id");
		String nicName = rs.getString("nicname");
		String pwd = rs.getString("pwd");
		
		while(rs.next()) 
			System.out.printf("id:%d, nicname : %s pwd:%s\n", rs.getInt("ID"), rs.getString("NICNAME"),rs.getString("PWD"));
	}

}
