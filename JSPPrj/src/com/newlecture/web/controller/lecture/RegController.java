/*�����ϴ¾�.
 * Ŭ���̾�Ʈ�� ��û�� �޾Ƽ� ó��*/
package com.newlecture.web.controller.lecture;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/reg")
public class RegController extends HttpServlet{
   // PUT / POST -> 
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //post��û�� ������ �۵��ϴ°�.
      String title = request.getParameter("title"); //name���� �Ѱ��ذ�. ���� ���� �ְ� request.
      String content = request.getParameter("content");
      
      NoticeService service = new NoticeService(); //insert�� �̿��ϱ� ����
      
//      service.update(id, title, content);
           
      try {
         
         Notice notice = new Notice(); //����� �������
         notice.setTitle(title);
         notice.setWriterId("IDID");
         notice.setContent(content);
         service.insert(notice); 
         
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      
      response.sendRedirect("list.jsp");      
      
   }
}