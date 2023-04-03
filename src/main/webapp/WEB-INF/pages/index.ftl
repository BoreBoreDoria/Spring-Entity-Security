<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to My App</title>
</head>
<body>

<h1>Hello user: ${user.name} </h1>

<h3>User Info</h3>
<h5>Email: ${user.email}</h5>
<h5>Age: ${user.age}</h5>
<h5>Role: ${user.role.name}</h5>
<h5>Info: ${user.info.name()}</h5>

<a href="/user/list">Информация о пользователях</a>

</body>
</html>