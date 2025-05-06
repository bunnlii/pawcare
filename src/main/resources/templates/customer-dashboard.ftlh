<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/unified-style.css">
    <title>Customer Dashboard</title>
</head>
<body>
<h1>Welcome, ${customer.name}!</h1>

<p>You are now logged in to PawCare.</p>

<ul>
    <li><a href="/service/all">View Available Services</a></li>
    <li><a href="/customer/profile">Edit Profile</a></li>
    <li><a href="/customers/logout">Logout</a></li>
</ul>
<p>Your email: ${customer.email}</p>
<a href="/logout">Logout</a>

</body>
</html>
