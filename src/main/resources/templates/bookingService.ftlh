<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Service - PawCare</title>
    <link rel="stylesheet" href="/css/services.css">
</head>
<body>
<header>
    <h1>Book a Service</h1>
</header>

<div class="service-details">
    <form action="/customer/bookingServices" method="post">
        <label>Service Type:</label><br>
        <input type="text" name="serviceType" required><br>
        <label>Your Name:</label><br>
        <input type="text" name="customerName" required><br>
        <label>Pet Name:</label><br>
        <input type="text" name="petName" required><br>
        <label>Date:</label><br>
        <input type="date" name="appointmentDate" required><br>
        <button type="submit">Book Now</button>
    </form>
</div>
</body>
</html>
