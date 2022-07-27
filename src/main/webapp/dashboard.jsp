<%@ page import="services.NoteService" %>
<%@ page import="java.util.List" %>
<%@ page import="entities.Note" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% NoteService service = new NoteService(); %>
<html>
<head>
    <meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
    <c:import url="inc/navmenu.jsp"></c:import>
    <div class="row">
        <div class="col-sm-6">
            <h3>Note Add</h3>
            <form action="noteAdd" method="post">
                <div class="mb-3">
                    <input name="title" class="form-control" placeholder="Title">
                </div>
                <div class="mb-3">
                    <input name="detail" class="form-control" placeholder="Detail">
                </div>
                <div class="mb-3">
                    <input name="date" type="date" class="form-control" placeholder="Date">
                </div>
                <button type="submit" class="btn btn-success">Send</button>
            </form>
        </div>
        <div class="col-sm-6">
            <h3>Note List</h3>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Title</th>
                    <th scope="col">Detail</th>
                    <th scope="col">Date</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>
                <tbody>

                <%
                    List<Note> ls = service.allNote( request );
                    if ( ls != null ){
                        for ( Note item : ls ) {
                %>
                <tr>
                    <th scope="row"><%=item.getNid()%></th>
                    <td><%=item.getTitle()%></td>
                    <td><%=item.getDetail()%></td>
                    <td><%=item.getDate()%></td>
                    <td>
                        <a href="noteDelete?nid=<%=item.getNid()%>" class="btn btn-danger btn-sm"><i class="bi bi-trash"></i></a>
                    </td>
                </tr>
                <%}}%>

                </tbody>
            </table>
        </div>
    </div>


</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
