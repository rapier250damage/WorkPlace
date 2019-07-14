<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customer confirmation form</title>
</head>
<body>

	The customer is confirmed: ${customer.firstName} ${customer.lastName}
	<br><br>
	Free passes: ${customer.freePasses}
	<br><br>
	PostalCode: ${customer.postalCode}
	<br><br>
	CourseCode: ${customer.courseCode}
</body>
</html>