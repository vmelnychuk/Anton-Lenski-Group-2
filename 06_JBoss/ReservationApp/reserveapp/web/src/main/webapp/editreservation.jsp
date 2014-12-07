<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Edit Reservation</title>
</head>
<body>
  <h1>Edit Reservation</h1>
  <form action="reservation?action=save" method="POST">
    <table>
      <tr>
        <td>first name</td>
        <td><input type="text" name="fistName"
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
        <td><input type="text" name="checkIn"
          value="${item.getCheckInDate()}"></td>
      </tr>
      <tr>
        <td>check out</td>
        <td><input type="text" name="checkOut"
          value="${item.getCheckOutDate()}"></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="hidden" name="id" value="${item.getReservationId()}">
          <input type="hidden" name="attendeeId" value="${item.getAttendee().getAttendeeId()}">
          <input type="submit" value="save"></td>
      </tr>
    </table>
  </form>
</body>
</html>