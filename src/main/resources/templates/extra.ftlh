<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Review</title>
    <style>
        body {
            background-color: #FBF3EE;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #344960;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 90%;
            max-width: 600px;
            margin: 40px auto;
            background-color: white;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            padding: 30px;
        }

        h2 {
            text-align: center;
            color: #344960;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-top: 15px;
            margin-bottom: 5px;
            font-weight: 600;
        }

        input[type="number"],
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            background-color: #F5EDED;
        }

        textarea {
            resize: vertical;
        }

        .btn {
            display: block;
            width: 100%;
            margin-top: 25px;
            padding: 12px;
            font-size: 16px;
            font-weight: bold;
            color: white;
            background-color: #94B4C1;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #7FA1C3;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #344960;
            text-decoration: none;
            font-size: 14px;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Leave a Review</h2>
    <form action="/customers/add-review/${serviceId}/${customerId}" method="post">
        <label for="rating">Rating (1-5):</label>
        <input type="number" id="rating" name="rating" min="1" max="5" required>

        <label for="comment">Your Review:</label>
        <textarea id="comment" name="comment" rows="5" placeholder="Write something nice..." required></textarea>

        <button type="submit" class="btn">Submit Review</button>
    </form>

    <a href="/customers/services" class="back-link">← Back to Services</a>
</div>
</body>
</html>

