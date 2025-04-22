<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${service.title} - PawCare</title>
    <link rel="stylesheet" href="/css/services.css">
</head>
<body>
<header>
    <h1>${service.title}</h1>
</header>

<div class="service-details">
    <div class="info-service-details">
        <h2>${service.title}</h2>
        <p>${service.description}</p>
    </div>
    <div class="right-image">
        <img src="${service.imagePath}" alt="${service.title}" width="260">
    </div>
</div>

<div class="book-service-details">
    <h4>Ready to book this service?</h4>
    <form action="/customer/bookingServices" method="post">
        <input type="hidden" name="serviceType" value="${service.title}">
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
