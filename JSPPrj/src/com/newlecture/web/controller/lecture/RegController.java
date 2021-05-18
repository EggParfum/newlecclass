/*조작하는애.
 * 클라이언트의 요청을 받아서 처리*/
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
      //post요청이 들어오면 작동하는거.
      String title = request.getParameter("title"); //name으로 넘겨준거. 갖고 오는 애가 request.
      String content = request.getParameter("content");
      
      NoticeService service = new NoticeService(); //insert를 이용하기 위해
      
//      service.update(id, title, content);
           
      try {
         
         Notice notice = new Notice(); //저장소 만들어줬
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