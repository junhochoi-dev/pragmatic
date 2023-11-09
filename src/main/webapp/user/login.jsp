<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.rtl.min.css" integrity="sha384-gXt9imSW0VcJVHezoNQsP+TNrjYXoGcrqBZJpry9zJt8PCQjobwmhMGaDHTASo9N" crossorigin="anonymous">
  <title>Document</title>
</head>
<body>
    <h1> ${alert} </h1>
    <div>
      <form class="container" action="/user/login" method="post">
        <h1>PRAGMATIC에 오신 것을 환영합니다.</h1>
        <p>ID</p>
        <input class="form-control" id="userid" name="userid" placeholder="ID"/>
        <p>PASSWORD</p>
        <input class="form-control" id="userpw" name="userpw" placeholder="PASSWORD"/>
        <button type="submit" class="btn btn-primary" onclick="console.log({userid})">LOGIN</button>
      </form>
      <a href="/">Back</a>
    </div>
</body>
</html>