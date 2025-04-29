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
        <img src="image/paw_logo_main.svg" alt="paw logo" width="100" height="100">
</header>

<nav>
    <ul>
        <li><a href="services.ftlh">Services</a></li>
        <li><a href="ProviderSignup.html">Provider</a></li>
        <li><a href="customer-signup.ftlh">Signup</a></li>
        <li><a href="customer-login.ftlh">Login</a></li>
    </ul>
</nav>

<section id="intro" class="intro">
    <div class="toonlogo">
        <img src="image/toon_dog.svg" alt="dog " width="200" height="200">
    </div>
    <div class="cus">
        <h2>Your Pet Deserves the Best Care</h2>
        <p>Professional and loving care for your furry friend.</p>
    </div>
    <a href="services.html" class="btn">Explore Our Services</a>
</section>

<section class="services">
    <h2>SERVICES</h2>
        <#list services as service>
            <div class="service-card">
                <img src="${service.imagePath}" alt="${service.title}" width="200" height="200">
                <h3>${service.title}</h3>
                <p>Price: $${service.price}</p>
                <p>${service.description}</p>
                <a href="/customer/services/${service.id}" class="btn">View more</a>
            </div>
        </#list>
    </section>
    <div class="service-cards">
        <div class="service-card">
            <h3>Grooming</h3>
            <p>$80</p>
            <a href="grooming.html" class="btn">Book Now</a>
        </div>
        <div class="service-card">
            <h3>Veterinary Care</h3>
            <p>$60</p>
            <a href="vet-care.html" class="btn">Book Now</a>
        </div>
        <div class="service-card">
            <h3>Pet Sitting</h3>
            <p>$40</p>
            <a href="pet-sitting.html" class="btn">Book Now</a>
        </div>
        <div class="service-card">
            <h3>Pet Walking</h3>
            <p>$30</p>
            <a href="petwalking.html" class="btn">Book Now</a>
        </div>
        <div class="service-card">
            <h3>Pet Training</h3>
            <p>$20/hr</p>
            <a href="pet-training.html" class="btn">Book Now</a>
        </div>
        <div class="service-card">
            <h3>Adoption Assistance</h3>
            <p>free</p>
            <a href="adoption-ass.html" class="btn">Book Now</a>
        </div>
    </div>
</section>

<!-- Testimonials Section -->
<section class="test">
    <h2>What Our Customers Are Saying</h2>
    <div class="test">
        <p>"PawCare has been a lifesaver for me. Their grooming services are top-notch, and my dog loves the vets!"</p>
        <p>- Sarah J., Happy Customer</p>
    </div>
    <div class="test">
        <p>"I trust PawCare for all my pet care needs. Their pet sitting services are amazing, and my cat is always well taken care of."</p>
        <p>- John D., Loyal Client</p>
    </div>
</section>

<!-- Call to Action Section -->
<section class="call">
    <h2>Ready to Give Your Pet the Best Care?</h2>
    <p>Sign up today and experience the best pet care services for your furry friend!</p>
    <a href="CustomerSignup.html" class="btn">Sign Up Now</a>
</section>

</body>
</html>

</html>




