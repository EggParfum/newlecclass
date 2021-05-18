package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Member;

public class MemberService {
	public List<Member> getList() throws ClassNotFoundException, SQLException {
		List<Member> list = new ArrayList<>();
		//int i = 0;
		
		String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	    //String sql = "SELECT * FROM MEMBER WHERE NICNAME=" + "'" + nickname +"'";
	    /*뎃셈은 코드를 복잡하게 만듬. 그래서 아래와 같이 좀 빼서.*/
	    //String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'", nickname);
	    String sql = "SELECT * FROM MEMBER";
	    Class.forName("oracle.jdbc.OracleDriver");
	    Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
	    
	    Statement st = con.createStatement();
	    ResultSet rs = st.executeQuery(sql);
	    
	    
	    // 멤버 데이터
	    while(rs.next()) {
		       int id = rs.getInt("id");
		       String nicName = rs.getString("nicname");
		       String pwd = rs.getString("pwd");
		       
		       //System.out.printf("id:%d, nicname:%s, pwd:%s\n", id, nicName, pwd);
		       Member member = new Member();
		       member.setId(id);
		       member.setNicName(nicName);
		       member.setPwd(pwd);
		       
		       
		       list.add(member);
		    }
		    
		    return list;
	}

}
