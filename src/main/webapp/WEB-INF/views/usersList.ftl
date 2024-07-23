<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Owners list</h1>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Telephone Number</th>
    </tr>
<#list owners as owner>
    <tr>
        <th><a href="/user/${owner.id}">${owner.id}</a></th>
        <th>${owner.name}</th>
        <th>${owner.surname}</th>
        <th>${owner.email}</th>
        <th>${owner.telnumber}</th>
        <th><a href="/delete/${owner.id}">DELETE</a></th>
        <th><a href="/update/${owner.id}">UPDATE</a></th>
    </tr>
</#list>
</table>
<form>
    <input type="button" onclick="document.location='http://localhost:8080/addUser'" value="Add new owner"/>
</form>
</body>
</html>