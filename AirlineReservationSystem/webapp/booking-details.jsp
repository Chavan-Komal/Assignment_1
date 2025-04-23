<%@page import="com.Airline.entity.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Booking Details</title>
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
      <h1>Your Bookings</h1>
     <%
     List<Booking> bookings =(List<Booking>)request.getAttribute("bookings");
     for(Booking book : bookings){
     %>
     <p>
     Booking id :<%=book.getId()%><br><br>
     Flight id :<%=book.getFlightId()%><br>
     Date :<%=book.getBookingDate()%>
     </p>
     <%
     }
     %>
     </div>
   </body>
</html>