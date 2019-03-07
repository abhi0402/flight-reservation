<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
<h3>Complete Reservation</h3>
Airline: ${flight.operatingAirlines }<br>
Departure-City: ${flight.departureCity }<br>
Arrival-City: ${flight.arrivalCity }<br><br>

<form action="completeReservation" method="post">
<pre>
<h4>Passenger Details</h4>
First Name:<input type="text" name="passengerFirstName" />
Last Name:<input type="text" name="passengerLastName" />
Email:<input type="text" name="passengerEmail" />
Contact Number:<input type="text" name="passengerPhone" />

<h4>Card Details</h4>
Name:<input type="text" name="nameOnTheCard" />
Card no:<input type="text" name="cardNumber" />
Expiry Date:<input type="text" name="expirationDate" />
Cvv:<input type="text" name="SecurityCode" />
<input type="hidden" name="flightId" value="${flight.id }" />
<input type="submit" value="Confirm" />
</pre>
</form>
</body>
</html>