<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">LMS</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">All Books</a></li>
      <li><a href="#">New Book</a></li>
    </ul>
  </div>
</nav>

<div class="container">
  <table class="table">
    <thead>
      <tr>
        <th>Id</th>
        <th>Book Name</th>
        <th>Author</th>
        <th>Purchase Date</th>
      </tr>
    </thead>
    <tbody>
        <c:forEach var = "book" items = "${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.bookName}</td>
                <td>${book.author}</td>
                <td>${book.purchaseDate}</td>
            </tr>
         </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
