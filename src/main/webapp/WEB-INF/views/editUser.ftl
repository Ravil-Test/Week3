<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create owner page</title>
</head>
<body>
<form name="owner" action="/updateUser" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id" value="${owner.id}">
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${owner.name}">
    <p>Surname</p>
    <input title="Surname" type="text" name="surname" value="${owner.surname}">
    <p>Email</p>
    <input title="Email" type="text" name="email" value="${owner.email}">
    <p>Telephone number</p>
    <input title="Telephone number" type="text" name="telnumber" value="${owner.telnumber}">
    <br>
    <input type="submit" value="Ok">
</form>
</body>
</html>