<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
</head>
<body>
<h1>Edit Your Profile</h1>

<form action="/customers/edit/${customer.id}" method="post">
    <label>Name:</label><br>
    <input type="text" name="name" value="${customer.name}" required><br><br>

    <label>Email:</label><br>
    <input type="email" name="email" value="${customer.email}" required><br><br>

    <label>Phone:</label><br>
    <input type="text" name="phone" value="${customer.phone}" required><br><br>

    <label>Address:</label><br>
    <input type="text" name="address" value="${customer.address}" required><br><br>

    <button type="submit">Save Changes</button>
</form>

<br>
<a href="/customers/dashboard">Cancel</a>
</body>
</html>