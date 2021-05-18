package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {
   
   public List<Notice> getList() throws ClassNotFoundException, SQLException{
      
      return getList(1, "title", "");
   }
      
   public List<Notice> getList(int page, String field, String query) throws SQLException, ClassNotFoundException{
      List<Notice> list = new ArrayList<>();
      //int i = 0;
      int size = 10;
      int startNum = 1+(page-1)*size;
      int endNum = page*size;
      
      /*
      page :    startNum    :    endNum
      1        1            10
      2      11            20
      3      21            30
      4      ..            ..
      n      an=1+(page-1)*size, an=page*size
       */
      
      String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
      //String sql = "SELECT * FROM MEMBER WHERE NICNAME=" + "'" + nickname +"'";
      //String sql = String.format("SELECT * FROM MEMBER WHERE NICNAME='%s'", nickname);
      // ���͸�, ����, �׷���, .... -> SQL���� ����� ��.
      String sql = "SELECT * FROM ("
            + "    SELECT ROWNUM NUM, N.* "
            + "    FROM ("
            + "        SELECT * "
            + "        FROM NOTICE"
            + "        WHERE "+field+" LIKE '%"+query+"%'"
            + "        ORDER BY REGDATE DESC"
            + "    ) N "
            + ")"
            + "WHERE NUM BETWEEN "+startNum+" AND "+endNum;
      
      Class.forName("oracle.jdbc.OracleDriver");
      Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
      
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      
      // ��� ������   
      while(rs.next()) {
         int id = rs.getInt("id");
         String title = rs.getString("title");
         String content = rs.getString("content");
         String writerId = rs.getString("writer_id");
         Date regDate = rs.getDate("regDate");
         int hit = rs.getInt("hit");
         String files = rs.getString("files");
         
         //System.out.printf("id:%d, nicname:%s, pwd:%s\n", id, nicName, pwd);
         Notice notice = new Notice();
         notice.setId(id);
         notice.setTitle(title);
         notice.setContent(content);
         notice.setWriterId(writerId);
         notice.setRegDate(regDate);
         notice.setHit(hit);
         notice.setFiles(files);
         
         list.add(notice);                  
      }
      
      rs.close();
      st.close();
      con.close();
      
      return list;
   }
   
   public Notice get(int id) throws ClassNotFoundException, SQLException {
      
      Notice notice = null;
      
      String sql = "SELECT * FROM NOTICE WHERE ID="+id;
      
      String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
      
      Class.forName("oracle.jdbc.OracleDriver");
      Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
      
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);
      
      if(rs.next()) {
         //int id = rs.getInt("id");
         String title = rs.getString("title");
         String content = rs.getString("content");
         String writerId = rs.getString("writer_id");
         Date regDate = rs.getDate("regDate");
         int hit = rs.getInt("hit");
         String files = rs.getString("files");
         
         //System.out.printf("id:%d, nicname:%s, pwd:%s\n", id, nicName, pwd);
         notice = new Notice();
         notice.setId(id);
         notice.setTitle(title);
         notice.setContent(content);
         notice.setWriterId(writerId);
         notice.setRegDate(regDate);
         notice.setHit(hit);
         notice.setFiles(files);                           
      }
      
      rs.close();
      st.close();
      con.close();
      
      return notice;
   }

   public int getCount(String field, String query) throws SQLException, ClassNotFoundException{
      
      int count = 0;
      
      
      String sql = "SELECT COUNT(ID) COUNT"
            + "   FROM NOTICE"
            + "   WHERE "+field+" LIKE '%"+query+"%'";
      
      String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
      Class.forName("oracle.jdbc.OracleDriver");
      Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
      
      Statement st = con.createStatement();
      ResultSet rs = st.executeQuery(sql);      
      
      
      if(rs.next())  //rs�� �����ϰ� ������ �ϳ� �����;� ��.
         count = rs.getInt("COUNT");
      
      rs.close();
      st.close();
      con.close();
      
      
      return count;      
   }

   public int update(Notice notice) throws ClassNotFoundException, SQLException {      
      int result = 0;
      //sql�Ʒ��� url�� ���°� ���� �˰����� ������ ����. �� ���߿� ���ַ���.
      String sql = "INSERT INTO NOTICE(TITLE, WRITER_ID, CONTENT) VALUES(?,?,?)";
      String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
      Class.forName("oracle.jdbc.OracleDriver");
      Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
      
      
      PreparedStatement st = con.prepareStatement(sql);
      st.setString(1, notice.getTitle());
      st.setString(2, notice.getContent());
      st.setInt(3, notice.getHit());
      st.setString(4, notice.getFiles());
      st.setInt(5, notice.getId());
      
      result = st.executeUpdate(); // ex..Query():Select , ex..Update(): Update/Delete/Insert
      //������Ʈ �� ���ڵ� ������ �˷��ִ� result
      //������ ���� sql ��������. ������. ������ �غ��������ϱ�.
      st.close();
      con.close();
      
      return result;      
   }
   

   public int insert(Notice notice) throws ClassNotFoundException, SQLException {      
	      int result = 0; 
	      //sql�Ʒ��� url�� ���°� ���� �˰����� ������ ����. �� ���߿� ���ַ���.
	      String sql = "INSERT INTO NOTICE (TITLE,WRITER_ID, CONTENT) VALUES(?,?,?)";
	      
	      String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	      Class.forName("oracle.jdbc.OracleDriver");
	      Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
	      
     
	      PreparedStatement st = con.prepareStatement(sql);
	      st.setString(1, notice.getTitle()); //���� oracle DB�� set�ϴ� �迭.
	      st.setString(2, notice.getWriterId()); //get�ؼ� DB�� set.
	      st.setString(3, notice.getContent());

	      
	      result = st.executeUpdate(); // ex..Query():Select , ex..Update(): Update/Delete/Insert
	      
	      st.close();
	      con.close();
	      
	      return result;      
	   }

   
   public int delete(int id) throws ClassNotFoundException, SQLException {      
	      int result = 0;
	      //sql�Ʒ��� url�� ���°� ���� �˰����� ������ ����. �� ���߿� ���ַ���.
	      String sql = "DELETE FROM NOTICE WHERE ID=?";
	      
	      String url = "jdbc:oracle:thin:@hi.namoolab.com:1521/xepdb1";
	      Class.forName("oracle.jdbc.OracleDriver");
	      Connection con = DriverManager.getConnection(url, "NEWLEC", "11111");
	      
	      
	      PreparedStatement st = con.prepareStatement(sql);
	      st.setInt(1, id);
	      
	      result = st.executeUpdate(); // ex..Query():Select , ex..Update(): Update/Delete/Insert
	      
	      st.close();
	      con.close();
	      
	      return result;      
	   }


}





