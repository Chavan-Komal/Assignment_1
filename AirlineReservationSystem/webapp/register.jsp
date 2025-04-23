<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
<style>
    #box{
    margin: auto;
    width: 500px;
    height: auto;
    }
  </style>
</head>
<body>
     <div id="box">
     
      <h1> Welcome to Airlines</h1>
       <form action="register" method="post">
           
           Name:<input type="text" name="name"/><br>
           <br>
           <br>
           Email:<input type="text" name="email"/><br>
           <br>
            <br>
           Password:<input type="text" name="password"/><br>
           <br>
            <br>
            <input type="submit" value="Register"/>
       
       </form>
     
     </div>
     
</body>
</html>