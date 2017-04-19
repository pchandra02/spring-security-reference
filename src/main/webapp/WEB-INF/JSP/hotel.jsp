
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Hotel Page</title>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

</head>
<style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
</style>
<body>
<form action="<c:url value='/app/hotel/search'/>" method="post">
    <table>
        <tr>
            <td>
                <input name="hotelname" type="text" placeholder="Enter Hotel Name">
            </td>
            <td>
                <input name="hotelcity" type="text" placeholder="Enter City">
            </td>
            <td>
                <input type="submit" name="searchHotel" value="<spring:message text="Search Hotel"/>">
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" name="addHotel" value="<spring:message text="Add Hotel"/>"
                       onclick="form.action='/app/hotels';" formmethod="get">
            </td>
        </tr>
    </table>
</form>
<br>
<h1>Hotels List</h1>
<%--@elvariable id="hotelList" type="com.reference.spring.security.model.Hotel"--%>
<c:if test="${!empty hotelList }">
    <table class="tg">
        <tr>
            <th width="60">ID</th>
            <th width="60">Hotel_Id</th>
            <th width="80">Name</th>
            <th width="120">Address</th>
            <th width="80">City</th>
            <th width="80">State</th>
            <th width="80">Country</th>
            <th width="60">Pincode</th>
            <th width="60">Contact_No</th>
            <th width="80">Email</th>
            <th width="40">Currency</th>
            <th width="40">Lat</th>
            <th width="40">Long</th>
            <th width="60">Locality</th>
            <th width="60">Date_Created</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${hotelList}" var="hotel">
            <tr>
                <td>${hotel.id}</td>
                <td>${hotel.hotel_id}</td>
                <td>${hotel.name}</td>
                <td>${hotel.address}</td>
                <td>${hotel.city}</td>
                <td>${hotel.state}</td>
                <td>${hotel.country}</td>
                <td>${hotel.pincode}</td>
                <td>${hotel.contact_no}</td>
                <td>${hotel.email}</td>
                <td>${hotel.currency}</td>
                <td>${hotel.lat}</td>
                <td>${hotel.longitude}</td>
                <td>${hotel.locality}</td>
                <td>${hotel.date_created}</td>
                <td><a href="<c:url value='/app/edit/${hotel.id}' />" >Edit</a></td>
                <td><a href="<c:url value='/app/remove/${hotel.id}' />" >Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br>
<a href="<c:url value='/app/logout'/>">Logout</a>
</body>
</html>
