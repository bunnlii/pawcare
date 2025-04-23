<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/png" href="/image/paw.png">
    <link rel="stylesheet" href="/css/style.css">
    <title>PawCare</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>

    <style>
        header {
            text-align: center;
            padding: 40px;
            color: white;
            background-color: #B0C4B1
        }

        nav {
            background: #4A5759;
            padding: 20px;
        }

        nav ul {
            display: inline-flex;
            list-style-type: none;
        }

        td {
            color: white;
        }

    </style>

</head>
<body>
<header>
    <h1>PawCare
        <img src="/image/paw.png" alt="paw" width="75" height="75">
    </h1>
</header>

<nav>
    <ul>
        <li><a href="/index.html">Home</a></li>
    </ul>
    <ul>
        <li><a href="#">About Us</a></li>
    </ul>
</nav>

<div style="background-color: #DEDBD2; padding: 20px; text-align: center;">

    <h2>Admin Login</h2>
    <form action="/admin/login" method="post">
        <label for="email">Email :</label>
        <input type="text" id="email" name="email" required><br><br>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>
