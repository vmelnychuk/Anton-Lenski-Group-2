<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Room type</title>
</head>
<body>
  <h1>Room types</h1>
  <a href="welcome">to main page</a>
  <h2>List of available room types</h2>
  <table>
    <tr>
      <th>id</th>
      <th>name</th>
      <th>price</th>
      <th>quantity</th>
    </tr>
    <c:forEach var="item" items="${rooms}" varStatus="counter">
      <tr>
        <td>${item.getRoomTypeId()}</td>
        <td>${item.getName()}</td>
        <td>${item.getPrice()}</td>
        <td>${item.getQuantity()}</td>
        <td>
          <form action="room/${item.getRoomTypeId()}" method="post">
            <input type="submit" value="edit">
          </form>
        </td>
        <td>
          <form action="room/${item.getRoomTypeId()}" method="post">
            <input type="submit" value="remove">
            <input type="hidden" name="_method" value="DELETE" />
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
  <h2>Add new room type</h2>
  <form:form method="POST" modelAttribute="room">
  <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name"/></td>
    </tr>
    <tr>
        <td><form:label path="price">Price</form:label></td>
        <td><form:input path="price" /></td>
    </tr>
    <tr>
        <td></td>
        <td><input type="submit" value="Add"></td>
    </tr>
  </table>
  </form:form>
</body>
</html>