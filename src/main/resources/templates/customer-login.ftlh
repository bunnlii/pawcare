<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - PawCare</title>
    <link rel="stylesheet" href="/css/unified-style.css">
</head>
<body>

<header>
    <h1>Login</h1>
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
    <form action="/customers/login" method="post">
        <label for="username">Email:</label>
        <input type="text" name="username" required />

        <label for="password">Password:</label>
        <input type="password" name="password" required />

        <button type="submit">Login</button>
    </form>

    <#if error??>
        <p style="color: darkslateblue;">Login failed. Please try again.</p>
    </#if>


</section>