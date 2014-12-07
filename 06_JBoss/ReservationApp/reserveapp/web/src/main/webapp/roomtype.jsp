<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Room type</title>
</head>
<body>
  <h1>Room types</h1>
  <h2>List of available room types</h2>
  <table>
    <tr>
      <th>id</th>
      <th>name</th>
      <th>price</th>
      <th>quantity</th>
    </tr>
    <c:forEach var="item" items="${list}" varStatus="counter">
      <tr>
        <td>${item.getRoomTypeId()}</td>
        <td>${item.getName()}</td>
        <td>${item.getPrice()}</td>
        <td>${item.getQuantity()}</td>
        <td>
          <form action="room_type?action=edit" method="POST">
            <input type="hidden" name="id"
              value="${item.getRoomTypeId()}"> <input
              type="submit" value="edit">
          </form>
        </td>
        <td>
          <form action="room_type?action=remove" method="POST">
            <input type="hidden" name="id"
              value="${item.getRoomTypeId()}"> <input
              type="submit" value="remove">
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
  <h2>Add new room type</h2>
  <form action="room_type?action=add" method="POST">
    <table>
      <tr>
        <td>Name</td>
        <td><input type="text" name="roomName"></td>
      </tr>
      <tr>
        <td>Price</td>
        <td><input type="text" name="price"></td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Add"></td>
      </tr>
    </table>
  </form>
</body>
</html>