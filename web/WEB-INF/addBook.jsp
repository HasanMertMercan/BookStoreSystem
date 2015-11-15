<%--
  Created by IntelliJ IDEA.
  User: HasanMert
  Date: 15.11.2015
  Time: 17:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<form action="add" method="post">
  <table>
    <tr>
      <td>BookName:</td>
      <td><input type="text" name="name" /></td>
    </tr>
    <tr>
      <td>Author:</td>
      <td><input type="text" name="author" /></td>
    </tr>
    <tr>
      <td>ISBN:</td>
      <td><input type="text" name="isbn" /></td>
    </tr>
    <tr>
      <td>Price:</td>
      <td><input type="text" name="price" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <button type="submit">Add!</button>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <p>${message}</p>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
