
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="com.newlecture.web.service.NoticeService"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
<%
	String id_ = request.getParameter("id");
	int id = Integer.parseInt(id_);
	//html
	NoticeService noticeService = new NoticeService();
	Notice notice = noticeService.get(id);
	//이 notice 객체로 데이터를 꽂아 넣을 것임.
	//목륵을 달라하는 건 getlist 이건 단일 객체니까 get
	System.out.println(notice);
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="../css/style.css" type="text/css" rel="stylesheet">
    <script src="list.js"></script>
</head>

<body>
    <div id="root">
        <header id="header">
            <div class="float-content">
                <h1 class="logo"><img src="../images/logo.png" alt="뉴렉처 온라인"></h1>
                <section>
                    <h1 class="d-none">헤더</h1>
                    <nav class="main-menu">
                        <h1 class="d-none">메인메뉴</h1>
                        <ul>
                            <li><a class="redsun" href="" dir="ltr">학습가이드</a></li>
                            <li><a href="">강좌선택</a></li>
                            <li><a href="">AnswerIs</a></li>
                        </ul>
                    </nav>                    
                    <section class="lecture-search-form">
                        <h1 class="d-none">강좌검색폼</h1>
                        <form>
                            <fieldset>
                                <legend class="d-none">과정 검색 필드</legend>
                                <label>과정검색</label>
                                <input id="a1" type="text" value="테스트">
                                <input class="button" type="submit" value="검색">
                            </fieldset>
                        </form>
                    </section>

                    <nav class="member-menu">
                        <h1 class="d-none">회원메뉴</h1>
                        <ul>
                            <li><a href="index.html">HOME</a></li>
                            <li><a href="member/login.html">로그인</a></li>
                            <li><a href="">회원가입</a></li>
                        </ul>
                    </nav>

                    <nav class="customer-menu">
                        <h1 class="d-none">고객센터메뉴</h1>
                        <ul>
                            <li><a class="button mypage-button" href="">마이페이지</a></li>
                            <li><a class="button customer-button" href="">고객센터</a></li>
                        </ul>
                    </nav>
                </section>
            </div>
        </header>

        <div id="visual">
            <div class="float-content">

            </div>
        </div>

        <div id="body">
            <div class="float-content">
                <aside id="aside">
                    <h1 id="aside-title">고객센터</h1>                    
                    <nav class="main-aside-menu">
                        <h1>고객센터메뉴</h1>
                        <ul>
                            <li><a class="current" href="list.html">공지사항</a></li>
                            <li><a href="">자주하는 질문</a></li>
                            <li><a href="">수강문의</a></li>
                            <li><a href="">이벤트</a></li>
                        </ul>
                    </nav>

                    <nav class="aside-menu recommend-aside-menu">
                        <h1>협력업체</h1>
                        <ul>
                            <li><a class="img img-notepubs" href="">노트펍스</a></li>
                            <li><a class="img img-namoolab" href="">나무랩연구소</a></li>
                        </ul>
                    </nav>

                </aside>
                <main id="main">
                    <section>
                        <h1 class="main-title">공지사항</h1>
						
                        <section class="breadcrumb">
                            <h1 class="d-none">경로</h1>
                            <ol>
                                <li>home</li>
                                <li>고객센터</li>
                                <li>공지사항</li>
                            </ol>
                        </section>
                        
						<table border="1">

                           <tr>
                              <th>제목</th>
                              <td colspan="3"><%=notice.getTitle()%></td>

                           </tr>
                           <tr>
                              <th>작성일</th>
                              <td colspan="3"><%=notice.getRegDate()%></td>
                           </tr>
                           <tr>
                              <th>작성자</th>
                              <td><%=notice.getWriterId()%></td>
                              <th>조회수</th>
                              <td><%=notice.getHit()%></td>
                           </tr>
                           <tr>
                              <th>첨부파일</th>
                              <td colspan="3"><%=notice.getFiles()%></td>
                           </tr>
                           <tr>
                              <td colspan="4">
                                 <%=notice.getContent() %>
                              </td>
                           </tr>
                        </table>
                  <div>
                     <a href="list.jsp">목록</a>
                     <a href="edit.jsp?id=<%=id %>">수정</a>  
                     <a href="del?id=<%=id %>" onclick="if(!confirm('정말 삭제하려고?')) return false;">삭제</a>
                     <!-- false를 함으로써 아예 끝내버림 -->                             
                  </div>


                    </section>

                </main>
            </div>
        </div>

        <footer id="footer">
            <div class="float-content">
                <!-- 회사정보
        Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information -->
            </div>
        </footer>
    </div>

</body>


</html>