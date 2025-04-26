<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="CustomerSignup.css">
    <title>Your Profile</title>
</head>
<header>
    <h1>PawCare</h1>
    <img src="image/paw_logo_main.svg" alt="paw logo" width="100" height="100">
</header>

<nav>
    <ul>
        <li><a href="index.html">Home</a></li>
        <li><a href="services.html">Services</a></li>
        <li><a href="index.html">Log Out</a></li>
    </ul>
</nav>

<section class="profile">
    <h2>My Profile</h2>


    <div class="profile-info">
        <h3>User Information</h3>
        <p><strong>Name:</strong> ${customer.name}</p>
        <p><strong>Email:</strong> ${customer.email}</p>
        <p><strong>Phone:</strong> ${customer.phone}</p>
        <p><strong>Address:</strong> ${customer.address}</p>
    </div>

    <h2>My Pets:</h2>
    <#if customer.pets?size == 0>
        <p>No pets added yet.</p>
    <#else>
        <ul>
            <#list customer.pets as pet>
                <li>${pet.name} - ${pet.type} (${pet.age} years old)</li>
            </#list>
        </ul>
    </#if>

    <a href="/customers/add-pet/${customer.id}">Add a New Pet</a>



    <div class="pet-info">
        <h2>My Pets:</h2>
        <#if customer.pets?size == 0>
            <p>No pets added yet.</p>
        <#else>
            <ul>
                <#list customer.pets as pet>
                    <li>${pet.name} - ${pet.type} (${pet.age} years old)</li>
                </#list>
            </ul>
        </#if>

        <a href="/customers/add-pet/${customer.id}">Add a New Pet</a>

</section>
<section class="services">
    <h2>My Appointments:</h2>
    <#if customer.bookings?size == 0>
        <p>You have no upcoming appointments.</p>
    <#else>
        <ul>
            <#list customer.bookings as booking>
                <li>
                    <strong>Service:</strong> ${booking.service.name} <br>
                    <strong>Date:</strong> ${booking.date} <br>
                    <strong>Time:</strong> ${booking.time} <!-- If you have time field -->
                </li>
                <br>
            </#list>
        </ul>
    </#if>
</section>
<section class="test">
    <h2>My Reviews:</h2>
    <#if customer.reviews?size == 0>
    <p>You have not written any reviews yet.</p>
    <#else>
    <ul>
        <#list customer.reviews as review>
            <li>
                <strong>Rating:</strong> ${review.rating} / 5<br>
                <strong>Review:</strong> ${review.content}<br>
                <strong>For Service:</strong> ${review.service.name} <!-- Assuming you linked Review to Service -->
            </li>
            <br>
        </#list>
    </ul>
</section>
</section>


</body>
</html>

