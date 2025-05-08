<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Pet</title>
    <link rel="stylesheet" href="/css/all.css">
    </head>
<body>

<header class="main-header">
<h1 class="logo">Add Pet</h1>
<img src="/image/dogandcat.svg" alt="paw logo">
</header>
<!-- Navigation -->
<nav class="main-nav">
    <ul>
        <li><a href="/customers/index">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/customers/profile/${customerId}">Profile</a></li>
        <li><a href="/customers/logout">Logout</a></li>
    </ul>
</nav>

<!-- Add Pet Form -->
<section class="boxed">
    <h2>Add Your Pet</h2>
    <form action="/customers/add-pet/${customerId}" method="post" style="max-width: 600px; margin: 0 auto; text-align: left;">
        <label for="name">Pet Name:</label><br>
        <input type="text" id="name" name="name" required><br><br>

        <label for="type">Type (Dog, Cat, etc.):</label><br>
        <input type="text" id="type" name="type" required><br><br>

        <label for="breed">Breed:</label><br>
        <input type="text" id="breed" name="breed"><br><br>

        <label for="age">Age:</label><br>
        <input type="number" id="age" name="age" min="0" required><br><br>

        <button type="submit" class="btn">Add Pet</button>
    </form>

    <div style="margin-top: 1.5rem; text-align: center;">
        <a href="/customers/profile/${customerId}" class="btn btn-danger">Cancel</a>
    </div>
</section>

</body>
</html>