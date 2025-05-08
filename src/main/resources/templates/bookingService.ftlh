<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Service</title>
    <link rel="stylesheet" href="/css/all.css">
</head>
<body>

<header>
    <h2>Book This Service</h2>
    <img src="/image/logo_pet_vet.svg" alt="paw logo">
</header>

<nav class="main-nav">
    <ul>
        <li><a href="/customers/index">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/customers/dashboard">Dashboard</a></li>
        <li><a href="/customers/logout">Logout</a></li>
    </ul>
</nav>

<!-- Booking Form -->
<section class="boxed">
    <h2>Book: ${service.serviceType}</h2>

    <p><strong>Details:</strong> ${service.details}</p>
    <p><strong>Location:</strong> ${service.location}</p>
    <p><strong>Price:</strong> $${service.price}</p>

    <form action="/customer/bookingServices" method="post">
        <input type="hidden" name="serviceID" value="${service.serviceID}">

        <label>Service Type:</label><br>
        <input type="text" value="${service.serviceType}" readonly><br><br>

        <label>Your Name:</label><br>
        <input type="text" name="customerName" required><br><br>

        <label>Select Pet:</label><br>
        <select name="petName" required>
            <#if pets?? && pets?size gt 0>
                <#list pets as pet>
                    <option value="${pet.name}">${pet.name} - ${pet.type}</option>
                </#list>
            <#else>
                <option disabled>No pets found — add one first</option>
            </#if>
        </select><br><br>

        <label>Date:</label><br>
        <input type="date" name="appointmentDate" required><br><br>

        <button type="submit" class="btn">Book Now</button>
    </form>

</section>

</body>
</html>