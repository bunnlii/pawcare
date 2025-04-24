<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/prov.css">
    <link rel="icon" type="image/png" href="/image/paw.png">
    <title>PawCare</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
            integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
            crossorigin="anonymous"></script>
</head>
<body>
<header>
    <h1>PawCare
        <img src="/image/paw.png" alt="paw" width="75" height="75">
    </h1>
</header>

<nav>
    <ul>
        <li><a href="/static/index.html">Home</a></li>
        <li><a href="/static/ServiceList.html">Services</a></li>
        <li><a href="/static/SignUp.html">Signup</a></li>
        <li><a href="/static/Login.html">Login</a></li>
    </ul>
</nav>

<section class="admin-section">
    <h2>Flagged Reviews</h2>
    <div class="content-box">
        <table class="table mt-3">
            <thead>
            <tr>
                <th>Appointment ID</th>
                <th>Customer</th>
                <th>Provider</th>
                <th>Rating</th>
                <th>Comment</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody id="userTableBody">
            <#list flaggedReviews as review>
                <tr>
                    <td><a href="/admin/appointments/${review.id}">Appointment ID: ${review.id}</a></td>
                    <td>${review.customerId}</td>
                    <td>${review.providerId}</td>
                    <td>${review.rating}</td>
                    <td>${review.comment}</td>
                    <td>
                        <button class="btn btn-success btn-sm dismiss-review" data-review-id="${review.id}">Dismiss</button>
                        <button class="btn btn-danger btn-sm delete-review" data-review-id="${review.id}">Delete</button>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</section>
<div class="text-center mt-3">
    <a href="/admin/reviews/all-reviews" class="btn btn-primary">View All Reviews</a>
</div>

<script src="/js/flaggedReviews.js"></script>
</body>
</html>
