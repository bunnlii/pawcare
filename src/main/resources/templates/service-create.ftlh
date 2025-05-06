<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="icon" type="image/png"  href="image/paw.png">
    <title>Create Service</title>

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
        <li><a href="/login">Login</a></li>
    </ul>
</nav>


    <div class="container" style="max-width: 500px; margin: 0 auto; padding: 40px;">
    <h3 style="text-align: center; margin-bottom: 30px;">Create Service</h3>

    <form action="/service/${providerID}/add-service" method="post" style="display: flex; flex-direction: column; gap: 15px;">
        <label for="serviceType">Service Name</label>
        <input type="text" id="serviceType" name="serviceType" placeholder="Service Type" required />

        <label for="details">Description</label>
        <input type="text" id="details" name="details" placeholder="Short description" required/>

        <label for="price">Price</label>
        <input type="number" id="price" name="price" step="0.01" placeholder="Price (e.g., 29.99)" required />

        <label for="location">Location</label>
        <input type="text" id="location" name="location" placeholder="1234 UNCG street" required />

        <div style="display: flex; justify-content: space-between; margin-top: 20px;">
            <button type="submit" class="button">Save</button>
            <a href="/service/all" class="button btn-cancel">Cancel</a>
        </div>
    </form>
</div>

</body>
</html>
