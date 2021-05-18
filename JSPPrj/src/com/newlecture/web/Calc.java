package com.newlecture.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Calc extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		// 1. 입/출력 도구가 추가되었다..	
		int x = 0;
		int y = 0;
		int result = 0;
		String x_ = null;
		String y_ = null;		
		String r_ = req.getParameter("r");
		
		if(r_ != null)
			result = Integer.parseInt(r_);
		
		PrintWriter out = resp.getWriter();
		
		// 제조/생산 -> 기계 -> 전자기계 -> 자동화된 전자기계 -> AI -> 공부->      
		// Jasper
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<section>");
		out.write("		<h1>계산기</h1>");
		out.write("		<div>");
		
		if(x_ != null)
			out.write("			<div>"+x+"+"+y+"=</div>");
		
		out.write("			<form action=\"/add\" method=\"post\">");
		out.write("				<input type=\"text\" name=\"x\">+<input type=\"text\" name=\"y\"><br>");
		out.write("				<input type=\"submit\" value=\"덧셈\"><span>"+result+"</span>");
		out.write("			</form>");
		out.write("		</div>");
		out.write("	</section>");
		out.write("</body>");
		out.write("</html>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 1. 입/출력 도구가 추가되었다..
		int x = 0;
		int y = 0;
		int asdf = 0;
		String x_ = null;
		String y_ = null;
		
		//if(req.getMethod().equals("POST")){
		System.out.println("post");
		
		x_ = req.getParameter("x");
		if(x_ != null && !x_.equals(""))
			x = Integer.parseInt(x_);
		
		y_ = req.getParameter("y");
		if(x_ != null && !x_.equals(""))
			y = Integer.parseInt(y_);
		
		asdf = x+y;

		// doGet 요청을 하는 것이 더 효율적이다.
		// doGet(req, resp);
		resp.sendRedirect("/add?r="+asdf);
		
		// get 요청하면서 get을 처리하는 로직에게 내가 만든 값 또는 상태를 전달할 수 있는 방법이 필요하다.
		// 1. 파일을 이용하는 방법
		// 2. 서블릿의 저장소(Application/Session/Request/Cookie/..)를 이용하는 방법
		// 3. QueryString을 이용하는 방법
		//}
	}
		
	/*
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
				
		
		// 1. 입/출력 도구가 추가되었다..		
		int x = 0;
		int y = 0;
		int result = 0;
		String x_ = null;
		String y_ = null;
		
		if(req.getMethod().equals("POST")){
			System.out.println("calc");
			
			x_ = req.getParameter("x");
			if(x_ != null && !x_.equals(""))
				x = Integer.parseInt(x_);
			
			y_ = req.getParameter("y");
			if(x_ != null && !x_.equals(""))
				y = Integer.parseInt(y_);
			
			result = x+y;
		}
		
		// 1. 계산을 계속할 수 있도록 계산기 UI를 출력하기
		// 2. 한글 깨짐문제 해결하기
		// 3. 계산기에서 계산한 결과 값 외에 계산했던 연산식도 함께 보여주기
		// 4. POST 요청의 기본 값
		// 5. GET요청과 POST의 이해와 코드 분리하기
		
		// 동사무소 : 인감증명서를 발급 받기 -> 인감증명서를 떼러 왔습니다.(GET)->입력폼->제출(POST)
		
		// 회원목록을 주세요 / 검색 정보를 주세요 / .... (GET)
		
		// 문서를 동적으로 만드는 코드 : 이 코드로 만들어진 결과물 : 동적인 문서 : 서버문서
		PrintWriter out = resp.getWriter();				
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<section>");
		out.write("		<h1>계산기</h1>");
		out.write("		<div>");
		
		if(x_ != null)
			out.write("			<div>"+x+"+"+y+"=</div>");
		
		out.write("			<form action=\"/add\" method=\"post\">");
		out.write("				<input type=\"text\" name=\"x\">+<input type=\"text\" name=\"y\"><br>");
		out.write("				<input type=\"submit\" value=\"덧셈\"><span>"+result+"</span>");
		out.write("			</form>");
		out.write("		</div>");
		out.write("	</section>");
		out.write("</body>");
		out.write("</html>");
		
//		[iso-8859-1]	-  'a'(97)	- '솔'(3432 | 332) - 0000032
//		[ascii][utf-8]	-  'a'(97)	- '솔'(3432332)
//		[ascii][euc-kr] -  'a'(97)	- '솔'(15323) / '뾱'(3432332)
				
		//add?x=3&y=5 // 순수 GET 요청만으로 값을 전달하고 결과를 얻는 요청
		
		//add -> 입력폼 요청(GET)
		//add*submit-> 제출 요청(POST)
		
//		//resp.getOutputStream()
//		resp.getWriter().println(x+y);
//		// 2. 실행을 직접 할 수 없다. 톰캣에 의해서 실행되도록 한다.
		
		super.service(req, resp);
	}
	*/
}
