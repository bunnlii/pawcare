<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Profile (Details) Page</title>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Poppins&display=swap" rel="stylesheet">
    <link rel="icon" type="image/png" href="/images/paw.png">

    <style>
        * {
            box-sizing: border-box;
        }

        html, body{
            height: 100%;
            margin: 0;
            padding: 0;
        }
        body {
            font-family: 'Poppins', sans-serif;
            color: #344960;
            background-color: #EDECEB;
            display: flex;
            flex-direction: column;
        }

        header {
            background-color: #344960;
            color: #FBF3EE;
            padding: 50px 20px;
            text-align: center;
            position: relative;
        }

        header h1 {
            font-family: 'Pacifico', cursive;
            font-size: 4rem;
            margin: 0;
        }

        .header-logo {
            position: absolute;
            right: 20px;
            top: 20px;
        }

        .header-logo img {
            width: 75px;
            height: 75px;
        }

        nav {
            background-color: #E3DAD0;
            padding: 10px 0;
        }

        nav ul {
            display: flex;
            justify-content: center;
            list-style: none;
            padding: 0;
            margin: 0;
            gap: 20px;
        }

        nav ul li a {
            display: inline-block;
            padding: 10px 20px;
            background-color: #cad2c5;
            color: black;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        nav ul li a:hover {
            background-color: #B0C4B1;
        }

        .content {
            background-color: white;
            padding: 50px;
            text-align: center;
            height: 100%;
        }

        h2 {
            color: #344960;
        }

        table {
            width: 80%;
            margin: 0 auto;
            border-collapse: collapse;
            border-radius: 10px;
            overflow: hidden;
            height: 100%;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #344960;
            color: white;
        }

        td a {
            color: #344960;
            text-decoration: none;
        }

        td a:hover {
            text-decoration: underline;
        }

            .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #cad2c5;
            color: black;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .button a:hover {
            background-color: #B0C4B1;
        }

    </style>

</head>

<body>
<header>
    <h1>PawCare</h1>
</header>

<nav>
    <ul>
        <li><a href="/provider/all">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/provider/update/${provider.providerID?c}">Settings</a></li>
        <li><a href="index.html">Logout</a></li>
    </ul>
</nav>

<div class="content">
    <h2>Hello ${provider.name}, Welcome To Your Profile</h2>

        <p>
            <strong>ID:</strong> ${provider.providerID?c}
        </p>
    <p>
       <strong> Name:</strong> ${provider.name}
    </p>
    <p>
        <strong>Username:</strong> ${provider.username}
    </p>
    <p>
        <strong>Password:</strong> ${provider.password}
    </p>
    <p>
        <strong>Email:</strong> ${provider.email}
    </p>
    <p>
        <strong> Bio:</strong> ${provider.bio}
    </p>
        <br>
        <a class="button" href="/provider/update/${provider.providerID?c}">Edit Profile</a>
        <a class="button" href="/service/${provider.providerID?c}/serviceForm" style="margin-left: 10px;">Create Service</a>
</div>

</body>

</html>
