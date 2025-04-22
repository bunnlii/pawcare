<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Services - PawCare</title>
    <link rel="stylesheet" href="/css/services.css">
</head>
<body>
<header>
    <h1>Our Services</h1>
    <img src="/images/catNdog.svg" alt="catndog" width="200" height="200">
</header>

<nav>
    <ul>
        <li><a href="/customer/services">Services</a></li>
        <li><a href="/customer/profile">Profile</a></li>
        <li><a href="/provider">Provider</a></li>
        <li><a href="/login">Login</a></li>
    </ul>
</nav>

<section class="services">
    <#list services as service>
        <div class="service-card">
            <img src="${service.imagePath}" alt="${service.title}" width="200" height="200">
            <h3>${service.title}</h3>
            <p>${service.description}</p>
            <a href="/customer/services/${service.id}" class="btn">Book Now</a>
        </div>
    </#list>
</section>

<section class="call">
    <h2>Ready to Give Your Pet the Best Care?</h2>
    <p>Sign up today and experience the best pet care services for your furry friend!</p>
    <a href="/customer/signup" class="btn">Sign Up Now</a>
</section>
</body>
</html>

