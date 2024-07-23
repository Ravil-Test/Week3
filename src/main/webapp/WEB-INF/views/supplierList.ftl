<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Suppliers list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Org. name</th>
        <th>Org. address</th>
    </tr>
<#list suppliers as supplier>
    <tr>
        <th><a href="/user/${supplier.id}">${supplier.id}</a></th>
        <th>${supplier.orgname}</th>
        <th>${supplier.address}</th>
        <th><a href="/delete/${supplier.id}">DELETE</a></th>
        <th><a href="/update/${supplier.id}">UPDATE</a></th>
    </tr>
</#list>
</table>
<form>
    <input type="button" onclick="document.location='http://localhost:8080/addUser'" value="Add new supplier"/>
</form>
</body>
</html>