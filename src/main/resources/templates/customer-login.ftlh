<#-- customer-login.ftlh -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login - PawCare</title>
    <link rel="stylesheet" href="/css/all.css">
</head>
<body>

<header>
    <h1>Login</h1>
    <img src="/image/logocare.svg" alt="paw logo" width="100" height="100">
</header>

<nav>
    <ul>
        <li><a href="/customers/index">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/customers/register">Sign Up</a></li>
    </ul>
</nav>

<section class="login">
    <h2>Login</h2>

    <form action="/login" method="post">
        <input type="text" name="username" placeholder="Email" required />
        <input type="password" name="password" placeholder="Password" required />
        <button type="submit">Login</button>
    </form>

</section>

</body>
</html>

