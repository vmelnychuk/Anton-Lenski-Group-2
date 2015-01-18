<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Edit Reservation</title>
</head>
<body>
  <h1>Edit Reservation</h1>
  <form action="../reservation/${item.getReservationId()}" method="post">
    <table>
      <tr>
        <td>first name</td>
        <td><input type="text" name="firstName"
          value="${item.getAttendee().getFirstName()}"></td>
      </tr>
      <tr>
        <td>last name</td>
        <td><input type="text" name="lastName"
          value="${item.getAttendee().getLastName()}"></td>
      </tr>
      <tr>
        <td>email</td>
        <td><input type="text" name="email"
          value="${item.getAttendee().getEmail()}"></td>
      </tr>
      <tr>
        <td>room type</td>
        <td><input type="text" name="roomTypeId" value="${item.getRoomType().getRoomTypeId()}"></td>
      </tr>
      <tr>
        <td>check in</td>
        <td>
        <fmt:formatDate value="${item.getCheckInDate()}" pattern="yyyy-MM-dd" var="chIn" />
        <input type="text" name="checkIn" value="${chIn}">
        </td>
      </tr>
      <tr>
        <td>check out</td>
        <td><fmt:formatDate value="${item.getCheckOutDate()}" pattern="yyyy-MM-dd" var="chOut" />
        <input type="text" name="checkOut" value="${chOut}">
        </td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="hidden" name="_method" value="PUT" />
          <input type="hidden" name="attendeeId" value="${item.getAttendee().getAttendeeId()}">
          <input type="submit" value="save">
          </td>
      </tr>
    </table>
  </form>
</body>
</html>