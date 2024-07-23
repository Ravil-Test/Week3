<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create supplier page</title>
</head>
<body>
<form name="supplier" action="/updateUser" method="post">
    <p>Id</p>
    <input title="Id" type="text" name="id" value="${supplier.id}">
    <p>Org. name</p>
    <input title="Org. name" type="text" name="orgname" value="${supplier.orgname}">
    <p>Org. address</p>
    <input title="Org. address" type="text" name="address" value="${supplier.address}">
    <br>
    <input type="submit" value="Ok">
</form>
</body>
</html>