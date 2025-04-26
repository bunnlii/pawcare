<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Pet</title>
</head>
<body>
<h1>Add Your Pet</h1>

<form action="/customers/add-pet/${customerId}" method="post">
    <label>Pet Name:</label><br>
    <input type="text" name="name" required><br><br>

    <label>Type (Dog, Cat, etc.):</label><br>
    <input type="text" name="type" required><br><br>

    <label>Breed:</label><br>
    <input type="text" name="breed"><br><br>

    <label>Age:</label><br>
    <input type="number" name="age" min="0" required><br><br>

    <button type="submit">Add Pet</button>
</form>

<br>
<a href="/customers/profile/${customerId}">Cancel</a>
</body>
</html>
