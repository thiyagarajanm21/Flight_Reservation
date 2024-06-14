<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Successful Animation</title>
    <link rel="stylesheet" href="confirmation.css">
</head>
<body>
<%
		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");

		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("signin.jsp");
		}
		%>

    <div class="checkmark-container">
        <div class="checkmark">
            <div class="checkmark-circle"></div>
            <div class="checkmark-stem"></div>
            <div class="checkmark-kick"></div>
        </div>
        <div class="text-container">
            <div class="content">Booking Successful</div>
            <div class="sub-content">Your booking has been confirmed.</div>
        </div>
    </div>
</body>
</html>
