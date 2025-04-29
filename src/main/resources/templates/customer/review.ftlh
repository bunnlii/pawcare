<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Review</title>
</head>
<body>
<h1>Leave a Review</h1>

<form action="/customer/services/${serviceId}/review" method="post">
    <label for="content">Your Review (optional):</label><br>
    <textarea id="content" name="content" rows="5" cols="40" placeholder="Write your feedback..."></textarea><br><br>

    <label for="rating">Rating (optional):</label><br>
    <select id="rating" name="rating">
        <option value="">Select Rating (optional)</option>
        <option value="5">5 - Excellent</option>
        <option value="4">4 - Very Good</option>
        <option value="3">3 - Good</option>
        <option value="2">2 - Poor</option>
        <option value="1">1 - Terrible</option>
    </select><br><br>

    <button type="submit">Submit Review</button>
</form>

