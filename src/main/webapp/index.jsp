<%@ page import="com.project.pragmatic.user.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  UserDto userDto = (UserDto) session.getAttribute("userDto");
  String name = userDto.getName();
  out.println(name);
%>

<!doctype html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.rtl.min.css" integrity="sha384-gXt9imSW0VcJVHezoNQsP+TNrjYXoGcrqBZJpry9zJt8PCQjobwmhMGaDHTASo9N" crossorigin="anonymous">
    <title>Document</title>
  </head>
  <body>
    <div class="m-3">
      <h1>BE PRAGMATIC</h1>
      <h3> ${name} 님 환영합니다. </h3>
    </div>
  </body>
</html>