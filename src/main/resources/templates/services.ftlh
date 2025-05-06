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
        <li><a href="/provider/createForm">Provider</a></li>
        <li><a href="/customers/login">Login</a></li>
    </ul>
</nav>

<section class="services">
    <#list services as service>
        ${service.serviceType}
        ${service.price}
        ${service.details}
        ${service.location}
    </#list>

</section>

<section class="call">
    <h2>Ready to Give Your Pet the Best Care?</h2>
    <p>Sign up today and experience the best pet care services for your furry friend!</p>
    <a href="/customer/signup" class="btn">Sign Up Now</a>
</section>
</body>
</html>

