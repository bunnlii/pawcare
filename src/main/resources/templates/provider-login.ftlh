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

.button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #cad2c5;
    border: none;
    border-radius: 5px;
    text-decoration: none;
    transition: background-color 0.3s ease;
    font-size: 16px;  /* Set a consistent font size */
    text-align: center;  /* Ensure text is centered */
}

.button:hover {
    background-color: #B0C4B1;
}

.button-group {
    display: flex;
    gap: 10px;
    justify-content: center;
    margin-bottom: 20px;
}

.btn-primary {
    background-color: #cad2c5;
}

.btn-cancel {
    background-color: #E3DAD0;
}

.btn-cancel:hover {
    background-color: #d5c6ba;
}

.btn-danger {
    background-color: #e63946;
    color: white;
}

.btn-danger:hover {
    background-color: #d62828;
}

.login-box {
    max-width: 350px;
    margin: 60px auto;
    padding: 30px;
    background-color: #f8f9fa;
    border-radius: 12px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
    text-align: center;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

.login-box h2 {
    margin-bottom: 20px;
    color: #2b2d42;
}

.login-box input[type="text"],
.login-box input[type="password"] {
    width: 90%;
    padding: 10px;
    margin: 10px 0;
    border: 1px solid #ccc;
    border-radius: 6px;
    font-size: 14px;
}

.login-box button {
    padding: 10px 20px;
    background-color: #cad2c5;
    border: none;
    border-radius: 6px;
    font-size: 16px;
    color: black;
    cursor: pointer;
    margin-top: 10px;
    transition: background-color 0.3s ease;
}

.login-box button:hover {
    background-color: #B0C4B1;
}

.alt-login {
    margin-top: 15px;
    font-size: 14px;
}

.alt-login a {
    color: #B0C4B1;
    text-decoration: none;
}

.alt-login a:hover {
    text-decoration: underline;
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


<div class="container" style="max-width: 500px; margin: 0 auto; padding: 40px;">
    <div class="login-box">
        <form action="/provider/home" method="post">
            <h2>Login as Provider</h2>

            <input type="text" name="username" placeholder="Username" required />
            <input type="password" name="password" placeholder="Password" required />

            <button type="submit">Log In</button>

            <p class="alt-login">
                Not a provider? <a href="/customer/login">Log in as Customer</a>
            </p>
        </form>
    </div>


</div>

</body>
</html>

