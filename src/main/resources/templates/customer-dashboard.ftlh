<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="/css/unified-style.css">
    <meta charset="UTF-8">
    <title>Customer Dashboard</title>
</head>
<body>
<h1>Welcome, ${customer.name}!</h1>

<p>You are now logged in to PawCare.</p>

<ul>
    <li><a href="/services">View Available Services</a></li>
    <li><a href="/customer/profile">Edit Profile</a></li>
    <li><a href="/customer/logout">Logout</a></li>
</ul>

<a href="/customers/edit/${customer.id}">Edit My Profile</a>

</body>
</html>
