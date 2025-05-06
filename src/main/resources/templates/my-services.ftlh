<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My Services | PawCare</title>
    <link rel="icon" type="image/png" href="/images/paw.png">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Poppins&display=swap" rel="stylesheet">

    <style>
        * {
            box-sizing: border-box;
        }

        html, body {
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

        .card-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 25px;
            padding: 40px;
        }

        .card {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 15px;
            padding: 20px;
            width: 280px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            transition: transform 0.2s ease;
            text-align: left;
        }

        .card:hover {
            transform: translateY(-5px);
        }

        .card h3 {
            margin-top: 0;
            color: #2E4A62;
        }

        .card p {
            margin: 8px 0;
        }

        .card a {
            display: inline-block;
            margin-top: 12px;
            background-color: #CAD2C5;
            color: #000;
            padding: 8px 14px;
            border-radius: 5px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .card a:hover {
            background-color: #B0C4B1;
        }

        .no-services {
            text-align: center;
            padding: 50px;
        }

        .no-services a {
            margin-top: 20px;
            display: inline-block;
            padding: 12px 20px;
            background-color: #CAD2C5;
            color: #000;
            border-radius: 6px;
            text-decoration: none;
            transition: background-color 0.3s ease;
        }

        .no-services a:hover {
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
        <li><a href="/home">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/provider/${provider.providerID}">View Profile</a></li>
        <li><a href="/provider/statistics">Statistics</a></li>
        <li><a href="/provider/${provider.providerID}/services">My Services</a></li>
        <li><a href="/logout">Logout</a></li>
    </ul>
</nav>

<#if serviceList?size == 0>
<div class="no-services">
    <h2>You haven't created any services yet.</h2>
    <a href="/service/${provider.providerID}/serviceForm">Create Your First Service</a>
</div>
<#else>
<div class="card-container">
    <#list serviceList as service>
    <div class="card">
        <h3>${service.serviceType}</h3>
        <p><strong>Details:</strong> ${service.details}</p>
        <p><strong>Price:</strong> ${service.price}</p>
        <p><strong>Location:</strong> ${service.location}</p>
        <a href="/service/update/form/${service.serviceID}/${provider.providerID}">Edit Service</a>
    </div>
</#list>
</div>
</#if>

</body>
</html>
