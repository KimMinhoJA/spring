<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">



<table align="center" border="0" cellpadding="5" cellspacing="2" width="100%" bordercolordark="white" bordercolorlight="black">
<caption>상품 LIST</caption>
	<colgroup>
		<col width="7%"/>
		<col width="8%"/>
		<col width="30%"/>
		<col width="16%"/>
		<col width="16%"/>
		<col width="7%"/>
		<col width="7%"/>
		<col width="7%"/>
	</colgroup>
	<tr>
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">순서</span></b></font></p>
        </td>
        
        <td bgcolor="#00cc00">
            <p align="center">
            <font color="white"><b><span style="font-size:9pt;">번호</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">제목</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">작성자</span></b></font></p>
        </td>
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">날짜</span></b></font></p>
        </td>
        
       
        <td bgcolor="#00cc00">
            <p align="center"><font color="white"><b><span style="font-size:9pt;">조 회 수</span></b></font></p>
        </td>
    </tr>
    <c:choose>
    <c:when test="${empty requestScope.list}">
	<tr>
        <td colspan="6">
            <p align="center"><b><span style="font-size:9pt;">등록된 게시물이 없습니다.</span></b></p>
        </td>
    </tr>
    </c:when>
    <c:otherwise>
	<c:forEach items="${requestScope.list}" var="board" varStatus="state">
		    <tr onmouseover="this.style.background='#eaeaea'" onmouseout="this.style.background='white'">
		    	<td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${state.count}</span></p>
		        </td>
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${board.id}</span></p>
		        </td>
		        <td bgcolor="">
					<p><span style="font-size:9pt;">
					<a href="${pageContext.request.contextPath}/board/read/${board.id}">
					  ${board.subject}
					</a>
					</span></p>
		        </td>
		        
		       
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${board.writer}</span></p>
		        </td>
		         
		        
		        <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${board.writeday}</span></p>
		        </td>
		         <td bgcolor="">
		            <p align="center"><span style="font-size:9pt;">
		            ${board.readnum}</span></p>
		        </td>
		    </tr>
    </c:forEach>
	</c:otherwise>
    </c:choose>
</table>
<hr>
<div align=center>
	<c:forEach begin="0" end="${totalPage - 1}" var="i">
		<c:choose>
			<c:when test="${i==nowPageNum}">
				[<a href="${pageContext.request.contextPath}/board/list?nowPage=${i}" style="color:red;">${i + 1}</a>]
			</c:when>
			<c:otherwise>
				[<a href="${pageContext.request.contextPath}/board/list?nowPage=${i}" style="color:blue;">${i + 1}</a>]
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
<div align=right>
<span style="font-size:9pt;">&lt;<a href="${pageContext.request.contextPath}/board/write">글쓰기</a>&gt;</span></div>














