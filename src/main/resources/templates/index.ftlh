<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PawCare - Home</title>
    <link rel="stylesheet" href="index.css">
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="services.css">
</head>
<body>

<header>
    <h1>PawCare</h1>
    <img src="/static.css/image/paw_logo_main.svg" alt="paw logo" width="100" height="100">
</header>

<nav>
    <ul>
        <li><a href="/customers/services">Services</a></li>
        <li><a href="/provider">Provider</a></li>
        <li><a href="/customers/register">Signup</a></li>
        <li><a href="/customers/login">Login</a></li>
    </ul>
</nav>

<section class="intro">
    <div class="toonlogo">
        <img src="/static.css/image/toon_dog.svg" alt="dog logo" width="200" height="200">
    </div>
    <div class="cus">
        <h2>Your Pet Deserves the Best Care</h2>
        <p>Professional and loving care for your furry friend.</p>
        <a href="/customers/services" class="btn">Explore Our Services</a>
    </div>
</section>

<section class="services">
    <h2>SERVICES</h2>
    <div class="service-cards">
        <#list services as service>
            <div class="service-card">
                <img src="${service.imagePath}" alt="${service.title}" width="200" height="200">
                <h3>${service.title}</h3>
                <p>Price: $${service.price}</p>
                <p>${service.description}</p>
                <a href="/customers/services/${service.id}" class="btn">View More</a>
            </div>
        </#list>
    </div>
</section>

<#list reviews as review>
    <div class="test">
        <p>"${review.message}"</p>
        <p>- ${review.customer.name}, ${review.service.title}</p>
    </div>
</#list>


<section class="call">
    <h2>Ready to Give Your Pet the Best Care?</h2>
    <p>Sign up today and experience the best pet care services for your furry friend!</p>
    <a href="/customers/register" class="btn">Sign Up Now</a>
</section>

</body>
</html>