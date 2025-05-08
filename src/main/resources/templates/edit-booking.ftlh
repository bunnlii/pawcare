<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Booking - PawCare</title>
    <link rel="stylesheet" href="/css/all.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&family=Poppins&display=swap" rel="stylesheet">
</head>
<body>

<!-- Header -->
<header class="main-header">
    <h1 class="logo">PawCare</h1>
    <img src="/image/logo_pet_train.svg" alt="paw logo">
</header>

<!-- Navigation -->
<nav class="main-nav">
    <ul>
        <li><a href="/customers/index">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/customers/profile/${booking.customer.id}">Profile</a></li>
        <li><a href="/customers/logout">Logout</a></li>
    </ul>
</nav>

<!-- Edit Booking Form -->
<section class="boxed">
    <h2>Edit Your Booking</h2>

    <form action="/customer/bookings/edit/${booking.id}" method="post" style="max-width: 600px; margin: 0 auto; text-align: left;">
        <p><strong>Service:</strong> ${booking.service.serviceType}</p>

        <label for="petName">Pet Name:</label><br>
        <input type="text" id="petName" name="petName" value="${booking.petName}" required><br><br>

        <label for="appointmentDate">Appointment Date:</label><br>
        <input type="date" id="appointmentDate" name="appointmentDate" value="${booking.appointmentDate?date("yyyy-MM-dd")}" required>
        <button type="submit" class="btn">Update Booking</button>
    </form>

    <div style="margin-top: 1.5rem; text-align: center;">
        <a href="/customers/profile/${booking.customer.id}" class="btn btn-danger">Cancel</a>
    </div>
</section>

</body>
</html>
