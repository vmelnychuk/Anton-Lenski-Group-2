<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Reservation</title>
</head>
<body>
  <h1>Reservation</h1>
  <a href="index.jsp">to main page</a>
  <h2>List of available reservations</h2>
  <table>
    <tr>
      <th>id</th>
      <th>first name</th>
      <th>last name</th>
      <th>email</th>
      <th>reservation type</th>
      <th>check in</th>
      <th>check out</th>
      <th>cost</th>
      <th>status</th>
    </tr>
     <c:forEach var="item" items="${reservations}" varStatus="counter">
        <tr>
          <td>${item.getReservationId()}</td>
          <td>${item.getAttendee().getFirstName()}</td>
          <td>${item.getAttendee().getLastName()}</td>
          <td>${item.getAttendee().getEmail()}</td>
          <td>${item.getRoomType().getName()}</td>
          <td>${item.getCheckInDate()}</td>
          <td>${item.getCheckOutDate()}</td>
          <td>${item.getCost()}</td>
          <td>${item.getStatus()}</td>
          <td>
            <form action="reservation?action=edit" method="POST">
                <input type="hidden" name="id" value="${item.getReservationId()}">
                <input type="submit" value="edit">
            </form>
          </td>
          <td>
            <form action="reservation?action=remove" method="POST">
                <input type="hidden" name="id" value="${item.getReservationId()}">
                <input type="submit" value="remove">
            </form>
          </td>
        </tr>
      </c:forEach>
  </table>
  <h2>Add new reservation</h2>
  <form action="reservation?action=add" method="POST">
    <table>
      <tr>
        <td>Room type</td>
        <td><select name="roomTypeId">
            <c:forEach var="item" items="${roomTypes}"
              varStatus="counter">
              <option value="${item.getRoomTypeId()}">${item.getName()}</option>
            </c:forEach>
        </select></td>
      </tr>
      <tr>
        <td>Check in date</td>
        <td><input type="text" name="checkIn"></td>
      </tr>
      <tr>
        <td>Check out date</td>
        <td><input type="text" name="checkOut"></td>
      </tr>
      <tr>
        <td>First name</td>
        <td><input type="text" name="firstName"></td>
      </tr>
      <tr>
        <td>Last name</td>
        <td><input type="text" name="lastName"></td>
      </tr>
      <tr>
        <td>Email</td>
        <td><input type="text" name="email"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Add"></td>
      </tr>
    </table>
  </form>
</body>
</html>