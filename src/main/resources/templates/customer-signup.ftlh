<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="/css/index.css">
  <link rel="stylesheet" href="/css/unified-style.css">
  <title>Signup</title>
  <style>
    * Base Reset */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Fonts */
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f5eded; /* soft white pink */
    color: #213448; /* dark navy */
    line-height: 1.6;
}

/* Header */
header {
    background-color: #213448; /* dark navy */
    color: #f5eded; /* soft white pink */
    padding: 20px;
    text-align: center;
}

header img {
    margin-top: 10px;
}

/* Navigation */
nav ul {
    display: flex;
    justify-content: center;
    list-style: none;
    background-color: #547792; /* slate blue */
    padding: 10px;
}

nav ul li {
    margin: 0 15px;
}

nav ul li a {
    color: #f5eded; /* soft white pink */
    text-decoration: none;
    font-weight: bold;
    transition: color 0.3s ease;
}

nav ul li a:hover {
    color: #e2dad6; /* lighter neutral */
}

/* Buttons */
.btn {
    background-color: #7fa1c3; /* soft cornflower blue */
    color: #213448;
    padding: 10px 20px;
    border-radius: 10px;
    text-decoration: none;
    font-weight: bold;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #6482ad;
    color: white;
}

/* Sections */
section {
    padding: 40px 20px;
    text-align: center;
}

/* Cards */
.service-cards {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    gap: 30px;
}

.service-card {
    background-color: #ecefca;
    padding: 20px;
    border-radius: 15px;
    width: 250px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
}

.service-card img {
    width: 100%;
    border-radius: 10px;
}

.service-card h3 {
    margin: 10px 0;
    color: #213448;
}

.service-card p {
    color: #547792;
}

  </style>
</head>
<body>
<header>
  <h1>PawCare</h1>
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
    <input type="text" id="full-name" name="full-name" required>

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

