package com.newlecture.web.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@WebServlet("/api/notice/list")
public class NoticeList extends HttpServlet{

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	   response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      
   
   try {
      String p = request.getParameter("p");   
      String f = request.getParameter("f");   
      String q = request.getParameter("q");   
      
      
      
      int page = 1;
      String field = "title";
      String query = "";
      
      
      
      //체크방법
   
      if(p !=null && !p.equals(""))
         page = Integer.parseInt(p);
         
      if(f !=null && !f.equals(""))
         field = f;
         
      if(q !=null && !q.equals(""))
         query = q;
         
      NoticeService noticeService = new NoticeService();
      List<Notice> list = noticeService.getList(page, field, query);
      
      //로딩시간


      
      Gson gson = new Gson();
      String json = gson.toJson(list);
      
      out.println(json);
      
   }catch(ClassNotFoundException e) {
      e.printStackTrace();
      
   }catch(SQLException e) {
      e.printStackTrace();
      
   }
   
   }

}