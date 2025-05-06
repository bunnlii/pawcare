<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Service Page</title>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Poppins&display=swap" rel="stylesheet">
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

    </style>

</head>

<body>
<header>
    <h1>PawCare</h1>
</header>
<!--provider id doesnt work-->
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

<div class="content">
    <h2>Hello ${provider.providerID}, Update Service:</h2>
    <form id="service-update" action="/service/update/${service.serviceID}/${provider.providerID}" method="post">

        <p><strong>Current Service Type:</strong> ${service.serviceType}</p>
        <input type="text" id="serviceType" name="serviceType" placeholder="Service Type" value="${service.serviceType}" />

        <p><strong>Current Details:</strong> ${service.details}</p>
        <input type="text" id="details" name="details" placeholder="Details" value="${service.details}" />

        <p><strong>Current Price:</strong> ${service.price}</p>
        <input type="text" id="price" name="price" placeholder="Price" value="${service.price}" />

        <p><strong>Current Location:</strong> ${service.location}</p>
        <input type="text" id="location" name="location" placeholder="Location" value="${service.location}" />

        <br><br>
        <div class="button-group">
            <button type="submit" class="button btn-primary">Save</button>
            <a href="/service/${service.serviceID?c}" class="button btn-cancel">Cancel</a>
        </div>
        <br>
        <a href="/service/delete/${provider.providerID}/${service.serviceID?c}" class="button btn-danger" onclick="return confirmDelete()">Delete Service</a>
    </form>
</div>

<script>
    function confirmDelete() {
        return confirm("Are you sure you want to delete this service? This action cannot be undone.");
    }
</script>

</body>

</html>
