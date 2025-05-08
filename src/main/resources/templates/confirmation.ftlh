<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Confirmation</title>
    <link rel="stylesheet" href="/css/all.css">
</head>
<body>
<header class="main-header">
    <h1 class="logo">PawCare</h1>
    <img src="/image/paw_logo_main.svg" alt="paw logo">
</header>

<!-- Nav -->
<nav class="main-nav">
    <ul>
        <li><a href="/customers/index">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/customers/profile/${customerId}">Profile</a></li>
        <li><a href="/customers/logout">Logout</a></li>
    </ul>
</nav>

<!-- Confirmation Message -->
<section class="boxed">
    <h2>Thank You for Your Submission!</h2>
    <p>Your booking was successfully submitted. We appreciate you choosing PawCare for your pet care needs!</p>
    <p>We'll reach out to you soon with the details.</p>

    <div class="confirmation-actions" style="margin-top: 1.5rem;">
        <a href="/customers/index" class="btn">Back to Home</a>
        <a href="/customers/profile/${customerId}" class="btn">Go to Profile</a>
        <a href="/customers/add-review/${serviceId}/${customerId}" class="btn">Write a Review</a>
    </div>
</section>

</body>
</html>
