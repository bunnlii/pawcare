<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Leave a Review</title>
    <link rel="stylesheet" href="/css/all.css">
</head>
<body>
<header class="main-header">
    <h1 class="logo">PawCare</h1>
    <img src="/image/dogandcat.svg" alt="paw logo">
</header>
<nav class="main-nav">
    <ul>
        <li><a href="/customers/index">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/customers/profile">Profile</a></li>
        <li><a href="/customers/logout">Logout</a></li>
    </ul>
</nav>

<!-- Review Form -->
<section class="boxed">
    <h2>Leave a Review</h2>

    <form action="/customers/add-review/${serviceId}/${customerId}" method="post" style="max-width: 600px; margin: 0 auto; text-align: left;">
        <input type="hidden" name="serviceId" value="${serviceId}">
        <input type="hidden" name="customerId" value="${customerId}">

        <label for="rating">Rating (1-5):</label>
        <input type="number" id="rating" name="rating" min="1" max="5" required><br><br>

        <label for="content">Your Review:</label>
        <textarea id="content" name="content" rows="5" placeholder="Write something nice..." required></textarea><br><br>

        <button type="submit" class="btn">Submit Review</button>
    </form>

    <div style="margin-top: 1.5rem; text-align: center;">
        <a href="/service/all" class="btn">← Back to Services</a>
        <a href="/customers/index" class="btn">← Back to Home</a>
    </div>
</section>

</body>
</html>