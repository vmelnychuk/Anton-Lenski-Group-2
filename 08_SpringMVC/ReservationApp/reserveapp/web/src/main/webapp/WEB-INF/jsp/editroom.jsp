<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Edit Room</title>
</head>
<body>
  <h1>Edit Room type</h1>
  <form action="../room/${room.getRoomTypeId()}" method="post">
    <table>
      <tr>
        <td>Name</td>
        <td><input type="text" name="name" value="${room.getName()}"></td>
      </tr>
      <tr>
        <td>Price</td>
        <td><input type="text" name="price" value="${room.getPrice()}"></td>
      </tr>
      <tr>
        <td></td>
        <td>
          <input type="hidden" name="quantity" value="${room.getQuantity()}">
          <input type="hidden" name="_method" value="PUT" />
          <input type="submit" value="save">
        </td>
      </tr>
    </table>
  </form>
</body>
</html>