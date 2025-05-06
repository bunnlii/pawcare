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
    <h2>Manage user access</h2>
    <div class="content-box">
        <p>This section will display options to manage user access and user accounts.</p>

        <label for="roleFilter">Filter by role:</label>
        <select id="roleFilter">
            <option value="">All</option>
            <option value="CUSTOMER">Customer</option>
            <option value="PROVIDER">Provider</option>
        </select>

        <table class="table mt-3" id="usersTable">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Role</th>
                <th>Status</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody id="userTableBody">
            <#list users as user>
                <tr>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td>${user.status}</td>
                    <td>
                        <#if user.status == 'BANNED'>
                            <button class="btn btn-success btn-sm toggle-ban" data-user-id="${user.id}">Unban</button>
                        <#else>
                            <button class="btn btn-danger btn-sm toggle-ban" data-user-id="${user.id}">Ban</button>
                        </#if>
                    </td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</section>

<section class="admin-section">
    <h2>Manage user access</h2>
    <div class="content-box">
        <p>This section will allow you to manage flagged reviews</p>
        <button class="btn btn-primary btn-sm" onclick="window.location.href='/admin/reviews/flagged-reviews'">Manage Flagged Reviews</button>
    </div>
</section>

<section class="admin-section">
    <h2>Statistics</h2>
    <div class="content-box" style="display: flex; justify-content: space-between; align-items: flex-start; gap: 2rem; flex-wrap: wrap;">
        <div>
            <p>This section will show relevant statistics about the platform.</p>
            <p>Total Users: ${totalUsers!0}</p>
            <p>Total Reviews: ${totalReviews}</p>
            <p>Flagged Reviews: <strong>${flaggedReviewsCount}</strong></p>
            <p>Total Customers: ${totalCustomers}</p>
            <p>Total Providers: ${totalProviders}</p>
            <p>Total Appointments: ${totalAppointments}</p>
            <p>New Users in Last Month: ${newUsersInLastMonth}</p>
        </div>

        <div style="width: 300px; height: 300px;">
            <canvas id="userChart"></canvas>
        </div>


    </div>

</section>

<script src="/js/adminPanel.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
    const ctx = document.getElementById('userChart').getContext('2d');
    new Chart(ctx, {
        type: 'doughnut',
        data: {
            labels: ['Customers', 'Providers'],
            datasets: [{
                label: 'User Types',
                data: [${totalCustomers}, ${totalProviders}],
                backgroundColor: ['#f06292', '#64b5f6'],
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            maintainAspectRatio: false,
            plugins: {
                legend: { position: 'bottom' },
                title: { display: true, text: 'User Distribution' }
            }
        }
    });
</script>
</body>
</html>
