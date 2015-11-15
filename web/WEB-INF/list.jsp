<%--
  Created by IntelliJ IDEA.
  User: HasanMert
  Date: 15.11.2015
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Store by Hasan Mert</title>
</head>
<body>
<header>
  <table>
    <tr>
      <td>
        <a href="/index.jsp">Anasayfa</a>
      </td>
      <td>
        <a href="/addBook.jsp">Kitap Ekle</a>
      </td>
      <td>
        <a href="/list.jsp">Kitap Listesi</a>
      </td>
    </tr>
  </table>
</header>
<c:if test="${not empty books}">
  <table border="1">
    <caption>All Books</caption>
    <tr>
      <td>BookName</td>
      <td>Author</td>
      <td>ISBN</td>
      <td>Price</td>
    </tr>
    <c:forEach var="book" items="${books}">
      <tr>
        <td>${book.getId()}</td>
        <td>${book.getName()}</td>
        <td>${book.getISBN()}</td>
        <td>${book.getPrice()}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>
