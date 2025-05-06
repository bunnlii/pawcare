<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/index.css">
    <title>Your Profile</title>
</head>
<body>
<header>
    <h1>PawCare</h1>
    <img src="image/paw_logo_main.svg" alt="paw logo" width="100" height="100">
</header>

<nav>
    <ul>
        <li><a href="/customers/index">Home</a></li>
        <li><a href="/services">Services</a></li>
        <li><a href="/customers/logout">Log Out</a></li>
    </ul>
</nav>

<section class="profile">
    <h2>My Pets:</h2>
    <#if customer.pets?? && (customer.pets?size > 0)>
        <ul>
            <#list customer.pets as pet>
                <li>${pet.name!"Unnamed"} - ${pet.type!"Unknown"} (${pet.age!"?"} years old)</li>
            </#list>
        </ul>
    <#else>
        <p>No pets added yet.</p>
    </#if>

    <a href="/customers/add-pet/${customer.id}">Add a New Pet</a>
</section>

<section class="services">
    <h2>My Appointments:</h2>
    <#if bookings?? && (bookings?size > 0)>
        <ul>
            <#list bookings as booking>
                <li>
                    <strong>Service:</strong> ${booking.service?if_exists.serviceType!"N/A"} <br>
                    <strong>Date:</strong> ${booking.appointmentDate!"N/A"} <br>
                    <strong>Pet:</strong> ${booking.petName!"N/A"}
                </li>
            </#list>
        </ul>
    <#else>
        <p>You have no upcoming appointments.</p>
    </#if>

</section>




<section class="test">
    <h2>My Reviews:</h2>
    <#if reviews?? && (reviews?size > 0)>
        <ul>
            <#list reviews as review>
                <li>
                    <strong>Rating:</strong> ${review.rating} / 5<br>
                    <strong>Review:</strong> ${review.content}<br>
                    <strong>For Service:</strong> ${review.service?if_exists.name!"N/A"}
                </li>
                <br>
            </#list>
        </ul>
    <#else>
        <p>You have not written any reviews yet.</p>
    </#if>
</section>



</body>
</html>

