<!DOCTYPE html>
<html>
<head>
    <title>Book a Service</title>
</head>
<body>
<h1>Book a Pet Care Service</h1>
<form method="post" action="/customer/book">
    Your Name: <input type="text" name="customerName" required><br><br>
    Pet Name: <input type="text" name="petName" required><br><br>
    Service Type: <input type="text" name="serviceType" required><br><br>
    Appointment Date: <input type="date" name="appointmentDate" required><br><br>
    <button type="submit">Submit Booking</button>
</form>
</body>
</html>
