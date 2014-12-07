<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Edit Room</title>
</head>
<body>
  <h1>Edit Room type</h1>
  <form action="room_type?action=save" method="POST">
    <table>
      <tr>
        <td>Name</td>
        <td><input type="text" name="name"
          value="${item.getName()}"></td>
      </tr>
      <tr>
        <td>Price</td>
        <td><input type="text" name="price"
          value="${item.getPrice()}"></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="hidden" name="id" value="${item.getRoomTypeId()}">
          <input type="hidden" name="quantity" value="${item.getQuantity()}">
          <input type="submit" value="save">
        </td>
      </tr>
    </table>
  </form>
</body>
</html>