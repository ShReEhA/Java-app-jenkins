<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leads</title>
</head>
<body>
<h2>Display Flights</h2>
	<table border="1">
	<tr>
	<th>Airlines</th>
	<th>Departure</th>
	<th>Arrival City</th>
	<th>Departure Time</th>
	<th>Select Flights</th>
	</tr>
	
	<c:forEach items="${findFlights}" var="findFlights">
     <tr>
       <td>${findFlights.operatingAirlines}</td>
        <td>${findFlights.departureCity}</td>
         <td>${findFlights.arrivalCity}</td>
          <td>${findFlights.estimatedDepartureTime}</td>
          <td><a href="showCompleteReservation?flightId=${findFlights.id}">select</a></td>
      
     </tr>
 
</c:forEach>
	</table>

</body>
</html>