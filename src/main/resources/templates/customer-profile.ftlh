<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Profile</title>
    <link rel="stylesheet" href="/css/all.css">
</head>
<body>

<header class="main-header">
    <h1 class="logo">PawCare</h1>
    <img src="/image/groom_tools.svg" alt="paw logo" width="100" height="100">
</header>

<nav class="main-nav">
    <ul>
        <li><a href="/customers/index">Home</a></li>
        <li><a href="/service/all">Services</a></li>
        <li><a href="/customers/logout">Log Out</a></li>
    </ul>
</nav>
<div class="profile-grid">
<section class="boxed profile-info">
    <h2>My Info:</h2>
    <p><strong>Username:</strong> ${customer.username}</p>
    <p><strong>Email:</strong> ${customer.email}</p>
    <p><strong>Phone:</strong> ${customer.phone}</p>
    <p><strong>Address:</strong> ${customer.address}</p>
</section>

<section class="boxed profile">
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

    <a href="/customers/add-pet/${customer.id}" class="btn btn-edit">Add a New Pet</a>
</section>
</div>

<section class="boxed appointments">
    <h2>My Appointments:</h2>
    <#if bookings?? && (bookings?size > 0)>
        <ul class="appointment-list">
            <#list bookings as booking>
                <li class="appointment-item">
                    <p><strong>Service:</strong> ${booking.service?if_exists.serviceType!"N/A"}</p>
                    <p><strong>Date:</strong> ${booking.appointmentDate!"N/A"}</p>
                    <p><strong>Pet:</strong> ${booking.petName!"N/A"}</p>

                    <div class="appointment-actions">
                        <a href="/customer/bookings/edit/${booking.id}" class="btn btn-edit">Edit</a>
                        <a href="/customer/bookings/delete/${booking.id}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this booking?')">Delete</a>
                        <#if booking.review??>
                            <div class="review-summary">
                                <p><strong>Your Review:</strong> ${booking.review.content!"No review content"}</p>
                                <p><strong>Rating:</strong> ${booking.review.rating} / 5</p>
                            </div>
                        <#else>
                            <a href="/customers/add-review/${booking.service.serviceID}/${customer.id}" class="btn btn-review">Write a Review</a>
                        </#if>
                    </div>
                </li>
            </#list>
        </ul>
    <#else>
        <p>You have no upcoming appointments.</p>
    </#if>
</section>

<section class="boxed test">
    <h2>My Reviews:</h2>
    <#if reviews?? && (reviews?size > 0)>
        <ul class="appointment-list">
            <#list reviews as review>
                <li class="appointment-item">
                    <p><strong>For Service:</strong> ${review.service?if_exists.serviceType!"N/A"}</p>
                    <#if review.booking??>
                        <p><strong>Appointment Date:</strong> ${review.booking.appointmentDate!"N/A"}</p>
                    </#if>
                    <p><strong>Rating:</strong> ${review.rating} / 5</p>
                    <p><strong>Review:</strong> ${review.content!"No comment"}</p>
                </li>
            </#list>
        </ul>
    <#else>
        <p>You have not written any reviews yet.</p>
    </#if>
</section>

<div class="boxed profile-actions">
    <a href="/customers/edit/${customer.id}" class="btn">Edit Profile</a>
    <a href="/customers/delete/${customer.id}" class="btn btn-danger">Delete My Account</a>
</div>

</body>
</html>
