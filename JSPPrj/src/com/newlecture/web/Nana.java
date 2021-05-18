package com.newlecture.web;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class Nana extends HttpServlet{
    public void service(HttpServletRequest request, HttpServletResponse response)
                                                         throws IOException, ServletException {

    	int count =10;
    	
    	String c = request.getParameter("c");
    	   
    	PrintWriter out = response.getWriter();
    	out.println("[2,3,4,5]");
    	
    	// 문서를 출력 -> Browser : 문서를 백엔드에서 개발
    	
    	// 데이터를 출력 -> Javascript : 문서는 프론트에서 개발
        // Notice notice = new Notice();
    	// Exam exam = new Exam();
    	
        
    }
}