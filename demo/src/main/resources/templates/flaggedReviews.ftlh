<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>PawCare - Flagged Reviews</title>
    <link rel="icon" type="image/png" href="/image/paw.png">
    <link rel="stylesheet" href="/css/style.css">
    <link rel="stylesheet" href="/css/prov.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<header class="d-flex align-items-center p-3" style="background-color: #374357; color: white;">
    <h1 style="display: flex; align-items: center; gap: 10px;">
        PawCare
        <img src="/image/paw.png" alt="paw" width="75" height="75">
    </h1>
</header>

<nav>
    <ul>
        <li><a href="/index.html">Home</a></li>
        <li><a href="/ServiceList.html">Services</a></li>
        <li><a href="/SignUp.html">Signup</a></li>
        <li><a href="/Login.html">Login</a></li>
    </ul>
</nav>

<section class="admin-section">
    <h2>Flagged Reviews</h2>
    <div class="content-box">
        <table class="table table-striped mt-3">
            <thead>
            <tr>
                <th>ID</th>
                <th>Customer</th>
                <th>Provider</th>
                <th>Rating</th>
                <th>Comment</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <#list reviews as review>
                <tr>
                    <td>${review.id}</td>
                    <td>${review.customerId}</td>
                    <td>${review.providerId}</td>
                    <td>${review.rating}</td>
                    <td>${review.comment}</td>
                    <td>
                        <a href="/admin/reviews/${review.id}/toggle-flag" class="btn btn-warning btn-sm">Dismiss</a>
                        <a href="/admin/reviews/${review.id}" class="btn btn-danger btn-sm">Delete</a>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</section>

<script src="/js/adminPanel.js"></script>
</body>
</html>
