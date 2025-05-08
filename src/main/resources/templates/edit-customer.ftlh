<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Profile - PawCare</title>
    <link rel="stylesheet" href="/css/all.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Poppins&display=swap" rel="stylesheet">
</head>
<body>

<!-- Header -->
<header class="main-header">
    <h1 class="logo">PawCare</h1>
    <img src="/image/logo_pet_walk.svg" alt="paw logo">
</header>

<!-- Navigation -->
<nav class="main-nav">
    <ul>
        <li><a href="/customers/index">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/customers/profile/${customer.id}">Profile</a></li>
        <li><a href="/customers/logout">Logout</a></li>
    </ul>
</nav>

<!-- Form Section -->
<section class="boxed">
    <h2>Edit Your Profile</h2>

    <form action="/customers/edit/${customer.id}" method="post" style="max-width: 600px; margin: 0 auto; text-align: left;">
        <label for="username">Name:</label><br>
        <input type="text" id="username" name="username" value="${customer.username}" required><br><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" value="${customer.email}" required><br><br>

        <label for="phone">Phone:</label><br>
        <input type="text" id="phone" name="phone" value="${customer.phone}" required><br><br>

        <label for="address">Address:</label><br>
        <input type="text" id="address" name="address" value="${customer.address}" required><br><br>

        <button type="submit" class="btn">Save Changes</button>
    </form>

    <div style="margin-top: 1.5rem; text-align: center;">
        <a href="/customers/profile/${customer.id}" class="btn btn-danger">Cancel</a>
    </div>
</section>

</body>
</html>
