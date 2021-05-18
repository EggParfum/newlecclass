<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* response.setCharacterEncoding("UTF-8"); */
	int result = 13;
	//request / response
	//pageContext : 현재페이지 / request : 두 서블릿 간의 저장소 / session : 사용자별 저장소  / appication - 전역 저장소
	//out : 문자열 출력 도구/ 
	
	//-> ??.jsp -> 톰캣(jsp 요청이 왔네?) : Jasper~ 도와줘~~ -> Jasper가 ??.jsp 파일을 받아서 ??_jsp 클래스를 생성
	//-> test.java -> test.class -> $java test -> java(자바실행환경)
	// $javac test.java -> $dir => test.java / test.class
	// $java test : 중간코드를 번역해야 하는데... (JIT-Just in Time Compiler)Jitter야 ~  이것 좀 번역해줘~
%>
<%!
	public int add(int x, int y){
		return x + y;
	}
%>
<%-- 
<%= %> 
<%! %> 
<%@ %> 
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section>
		<h1>계산기</h1>
		<div>
			<form action="/add">
				<input type="text" name="x">+<input type="text" name="y"><br>
				<input type="submit" value="덧셈"><span><%= result %></span>
			</form>
		</div>
	</section>
</body>
</html>