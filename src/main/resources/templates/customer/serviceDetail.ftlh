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

<form action="/customer/services/${service.id}/book" method="post">
    <label>Choose Provider:</label>
    <select name="provider.id">
        <#list providers as provider>
            <option value="${provider.id}">${provider.name}</option>
        </#list>
    </select>

    Name: <input type="text" name="customerName"><br>
    Pet Name: <input type="text" name="petName"><br>
    Appointment Date: <input type="text" name="appointmentDate"><br>

    <button type="submit">Book Now</button>
    <a href="/customer/services/${service.id}/review">Leave a Review</a>

</form>


</body>
</html>
