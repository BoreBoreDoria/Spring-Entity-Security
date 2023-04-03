<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>SignIn</title>
</head>
<body>

<fieldset>
    <legend>Авторизация</legend>
    <form name="user" action="/user" method="post">
        Username : <input type="text" name="name"/><br/>
        Password: <input type="password" name="password"/><br/>
        <input type="submit" value="SignIn" />
    </form>
</fieldset>

</body>
</html>