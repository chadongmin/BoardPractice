<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cha
  Date: 2023/08/08
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script
          src="https://code.jquery.com/jquery-3.4.1.js"
          integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
          crossorigin="anonymous"></script>
  <style>
    a{
      text-decoration : none;
    }
    table{
      border-collapse: collapse;
      width: 1000px;
      margin-top : 20px;
      text-align: center;
    }
    td, th{
      border : 1px solid black;
      height: 50px;
    }
    th{
      font-size : 17px;
    }
    thead{
      font-weight: 700;
    }
    .table_wrap{
      margin : 50px 0 0 50px;
    }
    .bno_width{
      width: 12%;
    }
    .writer_width{
      width: 20%;
    }
    .regdate_width{
      width: 15%;
    }
    .updatedate_width{
      width: 15%;
    }
    .top_btn{
      font-size: 20px;
      padding: 6px 12px;
      background-color: #fff;
      border: 1px solid #ddd;
      font-weight: 600;
    }
    .pageInfo{
      list-style : none;
      display: inline-block;
      margin: 50px 0 0 100px;
    }
    .pageInfo li{
      float: left;
      font-size: 20px;
      margin-left: 18px;
      padding: 7px;
      font-weight: 500;
    }
    a:link {color:black; text-decoration: none;}
    a:visited {color:black; text-decoration: none;}
    a:hover {color:black; text-decoration: underline;}
    .active{
      background-color: #cdd5ec;
    }
    .search_area{
      display: inline-block;
      margin-top: 30px;
      margin-left: 260px;
    }
    .search_area input{
      height: 30px;
      width: 250px;
    }
    .search_area button{
      width: 100px;
      height: 36px;
    }
    .search_area select{
      height: 35px;
    }

  </style>
</head>
<body>
<h1>목록페이지입니다.</h1>

<div class="table_wrap">
  <a href="/board/write" class="top_btn">게시글 등록</a>
  <table border="1">
    <tr>
      <th>번호</th>
      <th>제목</th>
      <th>내용</th>
      <th>작성자</th>
      <th>등록일</th>
      <th>조회수</th>
    </tr>
    <c:forEach var="boardDto" items="${list}">
      <tr>
        <td>${boardDto.bno}</td>
        <td><a href="<c:url value = '/board/read?bno=${boardDto.bno}'/>">${boardDto.title}<a/></td>
        <td>${boardDto.content}</td>
        <td>${boardDto.writer}</td>
        <td>${boardDto.reg_date}</td>
        <td>${boardDto.view_cnt}</td>
      </tr>
    </c:forEach>
  </table>
  <div>
    <c:if test="${ph.showPrev}">
      <a href="<c:url value="/board/list?page=${ph.beginPage-10}&pageSize=${ph.pageSize}"/>">[PREV]</a>
    </c:if>
    <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
      <a href="<c:url value="/board/list?page=${i}&pageSize=${ph.pageSize}"/>">${i}</a>
    </c:forEach>
    <c:if test="${ph.showNext}">
      <a href="<c:url value="/board/list?page=${ph.endPage+1}&pageSize=${ph.pageSize}"/>">[NEXT]</a>
    </c:if>
  </div>


</div>



</body>
</html>
