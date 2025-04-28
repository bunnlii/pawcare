<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Review</title>
</head>
<body>
<h1>Leave a Review</h1>

<form action="/customers/add-review/${serviceId}/${customerId}" method="post">
    <label>Review Content:</label><br>
    <textarea name="content" rows="5" cols="40" required></textarea><br><br>

    <label>Rating (1-5):</label><br>
    <input type="number" name="rating" min="1" max="5" required><br><br>

    <button type="submit">Submit Review</button>
</form>

<br>
<a href="/services">Back to Services</a>
</body>
</html>
