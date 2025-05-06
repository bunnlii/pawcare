<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider List Page</title>

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
        <li><a href="/provider/createForm">Signup</a></li>
        <li><a href="/login">Login</a> </li>
    </ul>
</nav>

<div class="content">
    <h2>List of Providers</h2>
    <div class="card-container">
        <#list providerList as provider>
        <div class="card">
            <h3>${provider.username}</h3>
            <p><strong>Provider ID:<br></strong> ${provider.providerID}</p>
            <p><strong>Name:<br></strong> ${provider.name}</p>
            <p><strong>Bio:<br></strong> ${provider.bio}</p>
            <a href="/provider/${provider.providerID?c}">View Profile</a>
        </div>
    </#list>
</div>
</div>

</body>

</html>
