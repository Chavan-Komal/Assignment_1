<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search</title>
<style>
    #box{
    margin: auto;
    width: 500px;
    height: auto;
    }
  </style>
</head>
<body bgcolor="pink">

  <div id="box">
     
      <h1> ✈️ Search Flight ✈️</h1>
       <form action="serchFlight" method="post">
           
           from:<input type="text" name="from"/><br>
           <br>
           <br>
           to:<input type="text" name="to"/><br>
           <br>
            <br>
           Date:<input type="date" name="date"/><br>
           <br>
            <br>
            <input type="submit" value="Search"/>
       
       </form>
     
     </div>
     

</body>
</html>