<jsp:include page="common/header.jsp" />


<%@ page import="com.project.pragmatic.user.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  UserDto userDto = (UserDto) session.getAttribute("userDto");
  String name = userDto.getName();
%>

  <div class="col-sm-8 row-sm-8 mx-auto">
    <h1>BE PRAGMATIC</h1>
    <h3> <%=name%> 님 환영합니다. </h3>
    <p> <%=name%> </p>
  </div>


<jsp:include page="common/footer.jsp" />