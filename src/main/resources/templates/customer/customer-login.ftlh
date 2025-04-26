<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - PawCare</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>

<header>
    <h1>Login</h1>
</header>

<nav>
    <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="services.html">Services</a></li>
        <li><a href="signup.html">Sign Up</a></li>
    </ul>
</nav>

<section class="login">
    <h2>Login</h2>
    <form action="EditCusProfile.html" method="POST">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit" class="btn">Login</button>
    </form>
</section>