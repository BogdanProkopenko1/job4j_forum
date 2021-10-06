<%@ page import="ru.job4j.forum.model.Post" %><%--
  Created by IntelliJ IDEA.
  User: pvzar
  Date: 28.09.2021
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<%
    Post post = (Post) request.getAttribute("post");
%>
<body>
<div class="container mt-3">
    <div class="row">
        <h3><a style="font-weight: bold; color: black" href="<c:url value="/"/>">FORUM job4j</a></h3>
    </div>
<div class="container pt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <% if (post == null) { %>
                <h5>Create post</h5>
                <% } else { %>
                <h5>Edit post</h5>
                <% } %>
            </div>
            <div class="card-body">
                <% if (post == null) { %>
                <form action="<c:url value='/save'/>" method="post">
                        <% } else { %>
                    <form action="${pageContext.request.contextPath}/save?id=<%=post.getId()%>" method="post">
                        <%  }%>
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input required type="text" class="form-control" name="name" id="name"
                                <% if (post != null) { %> value="<%=post.getName()%>" <% } %>>
                        </div>
                        <div class="form-group">
                            <label for="description">Description</label>
                            <textarea rows="3" required class="form-control" name="description" id="description"<% if (post != null) { %> value="<%=post.getDescription()%>" <% } %>></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary">Update</button>
                    </form>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>