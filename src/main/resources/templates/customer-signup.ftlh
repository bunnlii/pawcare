<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/unified-style.css">
  <title>Signup</title>
</head>
<body>
<header>
  <h1>PawCare</h1>
  <img src="image/paw_logo_main.svg" alt="paw logo" width="100" height="100">
</header>

<nav>
  <ul>
    <li><a href="/customers/index">Home</a></li>
    <li><a href="/service/all">Services</a></li>
    <li><a href="/customers/profile/{id}">Profile</a></li>
    <li><a href="/provider/createForm">Provider</a></li>
    <li><a href="customers/login">Login</a></li>
  </ul>
</nav>

<section class="signup-form">
  <h2>Create Your Account</h2>
  <form id="customer-signup" action="/customers/register" method="POST">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required>

    <label for="phone">Phone Number:</label>
    <input type="text" id="phone" name="phone" required>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required>

    <button type="submit">Sign Up</button>
  </form>

</section>
</body>
</html>

