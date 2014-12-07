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
  <h2>Add new reservation</h2>
  <form action="reservation?action=add" method="POST">
    <table>
      <tr>
        <td>Room type</td>
        <td>
            <select>
                <c:forEach var="item" items="${roomTypes}" varStatus="counter">
                    <option value="${item.getRoomTypeId()}">${item.getName()}</option>
                </c:forEach>
            </select>
        </td>
      </tr>
      <tr>
        <td>Check in date</td>
        <td><input type="date" name="checkIn"></td>
      </tr>
      <tr>
        <td>Check out date</td>
        <td><input type="date" name="checkOut"></td>
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
        <td><input type="email" name="email"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Add"></td>
      </tr>
    </table>
  </form>
</body>
</html>