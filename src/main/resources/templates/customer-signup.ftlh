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
    <li><a href="index.html">Home</a></li>
    <li><a href="services.ftlh">Services</a></li>
    <li><a href="EditCusProfile.html">Profile</a></li>
    <li><a href="ProvHome.html">Provider</a></li>
    <li><a href="customer-login.ftlh">Login</a></li>
  </ul>
</nav>

<section class="signup-form">
  <h2>Create Your Account</h2>
  <form action="/customers/register" method="POST">
    <label for="full-name">Full Name:</label>
    <input type="text" id="name" name="name" required>

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

