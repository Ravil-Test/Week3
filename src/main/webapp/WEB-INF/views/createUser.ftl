<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create user page</title>
</head>
<body>
<form name="user" action="/addUser" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id">
    <p>Name</p>
    <input title="Name" type="text" name="name">
    <p>Email</p>
    <input title="Email" type="text" name="email">
    <p>Age</p>
    <input title="Age" type="text" name="age">
    <br>
    <input type="submit" value="Add user">
</form>
</body>
</html>