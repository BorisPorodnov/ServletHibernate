<%@page import="com.hibcrud.entity.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home</title>

    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>


</head>
<body>
<h2>CRUD operations in hierbante using JSP and Servlet</h2>
<pre>
<form  action="AddEmpCtl" method="post">

<jsp:useBean id="bean" class="com.hibcrud.entity.Employee" scope="request"></jsp:useBean>

<input type="hidden" name="id" value="<%=bean.getId()%>">

UserName: <input type="text" name="username" id="username" value="<%=(bean.getUsername()!=null)?bean.getUsername():" "%>">

Password: <input type="text" name="password" id="password" value="<%=(bean.getPassword()!=null)?bean.getPassword():" "%>">

Name: <input type="text" name="name" id="name" value="<%=(bean.getName()!=null)?bean.getName():" "%>">

<input type="submit" value="SignUP">


</form>

</pre>

<h2>Employee List</h2>

<table>
    <tr>
        <th>UserName</th>
        <th>Password</th>
        <th>Name</th>
    </tr>
</table>



</body>
</html>