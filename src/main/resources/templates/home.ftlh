<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider List Page</title>
    <link rel="stylesheet" href="/css/all.css">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Poppins&display=swap" rel="stylesheet">
  <!--  <link rel="icon" type="image/png" href="/images/paw.png">-->

   <!--<style>
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
        }

        h2 {
            color: #344960;
        }

        .card-container {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
  padding: 40px;
}

.card {
  background-color: #fff;
  border: 1px solid #ccc;
  border-radius: 15px;
  padding: 25px;
  width: 250px;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
  transition: transform 0.2s ease;
  text-align: center;
}

.card:hover {
  transform: translateY(-5px);
}

.card h3 {
  margin-top: 0;
  color: #344960;
}

.card a {
  display: inline-block;
  margin-top: 10px;
  color: #344960;
  text-decoration: none;
  background-color: #cad2c5;
  padding: 8px 12px;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.card a:hover {
  background-color: #B0C4B1;
}

    </style>-->
</head>

<</head>
<body>

<header class="main-header">
    <h1 class="logo">PawCare</h1>
    <img src="/image/paw_logo_main.svg" alt="Paw Logo" width="60" height="60">
</header>

<nav class="main-nav">
    <ul>
        <li><a href="/service/all">All Services</a></li>
        <li><a href="/provider/createForm">Create Account</a></li>
        <li><a href="/provider/login">Login</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>
</nav>

<section class="dashboard-container">
    <h1>Welcome, ${provider.username}!</h1>
    <p><strong>Email:</strong> ${provider.email}</p>
    <p><strong>Specialty:</strong> ${provider.specialty!"Not specified"}</p>

    <div class="profile-actions">
        <a href="/provider/${provider.providerID}/services" class="btn">View My Services</a>
        <a href="/service/${provider.providerID}/serviceForm" class="btn">Add New Service</a>
        <a href="/provider/update/${provider.providerID}" class="btn">Edit Profile</a>
        <a href="/provider/delete/${provider.providerID}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete your account?')">Delete My Account</a>
    </div>
</section>

</body>
</html>
