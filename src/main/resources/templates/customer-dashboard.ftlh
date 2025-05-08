<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="/css/all.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
</head>
<body>
<header class="main-header">
    <h1 class="logo">PawCare</h1>
    <img src="/image/logo_adopt.svg" alt="paw logo" width="50">
</header>

<nav class="main-nav">
    <ul>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/customers/profile/${customer.id}">Profile</a></li>
        <li><a href="/customers/logout">Logout</a></li>
    </ul>
</nav>

<div class="dashboard-container">
    <#if customer??>
        <h1>Welcome, ${customer.username}!</h1>
        <p>Your email: ${customer.email}</p>
    <#else>
        <h1>Welcome!</h1>
        <p>(No customer data available)</p>
    </#if>

    <p>You are now logged in to PawCare.</p>

    <ul>
        <li><a href="/service/all">View Available Services</a></li>
        <li><a href="/customers/profile/${customer.id}">View Profile</a></li>
        <li><a href="/customers/edit/${customer.id}">Edit Profile</a></li>
    </ul>
</div>
</body>
