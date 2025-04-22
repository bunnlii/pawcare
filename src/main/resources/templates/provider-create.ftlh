<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="prov.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="icon" type="image/png"  href="image/paw.png">
    <title>Provider Signup</title>


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
    <h1>PawCare
        <rightside>
            <img src = "image/paw.png" alt ="paw" width = "75" height="75">
        </rightside>
    </h1>
</header>

<nav>
    <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="ServiceList.html">Services</a></li>
        <li><a href="SignUp.html">Signup</a></li>
        <li><a href="Login.html">Login</a> </li>
    </ul>
</nav>


<div class="container" style="max-width: 500px; margin: 0 auto; padding: 40px;">
    <h4 style="text-align: center; margin-bottom: 30px;">Sign Up as a Provider</h4>

    <form id="new-provider" action="/provider/new" method="post" style="display: flex; flex-direction: column; gap: 15px;">

        <label for="name">Name</label>
        <input type="text" id="name" name="name" placeholder="Name" required />

        <label for="bio">Bio</label>
        <input type="text" id="bio" name="bio" placeholder="Short bio" required />

        <label for="email">Email</label>
        <input type="email" id="email" name="email" placeholder="Email" required />

        <label for="password">Password</label>
        <input type="password" id="password" name="password" placeholder="Password" required />

        <label for="username">Username</label>
        <input type="text" id="username" name="username" placeholder="Username" required />

        <div style="display: flex; justify-content: space-between; margin-top: 20px;">
           <a class = "button"> <button type="submit" class="btn btn-primary">Save</button></a>
            <a href="/provider/all" class="btn btn-outline-danger">Cancel</a>
        </div>
    </form>
</div>

</body>
</html>

