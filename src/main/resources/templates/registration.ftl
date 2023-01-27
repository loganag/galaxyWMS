<!DOCTYPE html>
<html lang="en">
<head>
    <title>Spring Security Example </title>
</head>
<body>
Add new user
${message!""}
<form action="/registration" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
</body>
</html>