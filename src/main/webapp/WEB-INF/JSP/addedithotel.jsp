
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Add/Edit Hotel Page</title>
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
        .errors {
            color: red;
        }
    </style>
</head>
<script LANGUAGE="JavaScript">

    function validation(){

        var c = document.getElementById("country_id");
        var country = c.options[c.selectedIndex].value;
        var s = document.getElementById("state_id");
        var state = s.options[s.selectedIndex].value;
        var e = document.getElementById("city_id");
        var city = e.options[e.selectedIndex].value;
        var cur = document.getElementById("currency_code");
        var currency = cur.options[cur.selectedIndex].value;
        var date = document.getElementById("date_created").value;
        var pattern = /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/;
        if(document.getElementById("name").value === '') {
            alert("Please enter the name");
            return;
        }
        if(date === '' || !pattern.test(date)) {
            alert("Please enter a valid date: dd/MM/yyyy");
            return;
        }
        if(document.getElementById("address").value === ''){
            alert("Please enter the address");
            return;
        }
        if(document.getElementById("email").value === ''){
            alert("Please enter the email");
            return;
        }
        if(country == 0){
            alert("Please enter the country");
            return;
        }
        if(currency === ''){
            alert("Please enter the currency");
            return;
        }
        if(state == 0){
            errors = true;
            alert("Please enter the state");
            return;
        }
        if(city == 0){
            errors = true;
            alert("Please enter the city");
        }
        else
            document.form1.submit();
    }
    $(document).ready(
            function() {

                $('#country_id').change(
                        function() {
                            $.getJSON('/loadStates', {
                                country_id : $(this).val(),
                                ajax : 'true'
                            }, function(data) {

                                var html = '<option value="">----Select State----</option>';
                                var len = data.length;

                                for ( var i = 0; i < len; i++) {
                                    html += '<option value="' + data[i].state_id + '">' + data[i].state_name + '</option>';
                                }
                                html += '</option>';

                                $('#state_id').html(html);
                            });
                        });

            });

    $(document).ready(
            function() {

                $('#state_id').change(
                        function() {

                            $.getJSON('/loadCities', {
                                state_id : $(this).val(),
                                ajax : 'true'
                            }, function(data) {

                                var html = '<option value="">----Select City----</option>';
                                var len = data.length;

                                for ( var i = 0; i < len; i++) {
                                    html += '<option value="' + data[i].city_id + '">' + data[i].city_name + '</option>';
                                }
                                html += '</option>';

                                $('#city_id').html(html);
                            });
                        });

            });



</script>
<style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
</style>
<body>
<p>
    <c:if test="${errors == true}">
        <b class="errors"></b>
    </c:if>
</p>

<c:url var="addAction" value="/app/hotel/add" />

<form:form action="${addAction}" commandName="hotel" name="form1">
    <c:if test="${not empty error}">
        <b class="errors">Error: ${error} </b>
    </c:if>
    <table>
        <c:if test="${!empty hotel.hotel_id}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="id" />
                </td>

                <td>
                    <form:label path="hotel_id">
                        <spring:message text="Hotel_ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="hotel_id" readonly="true" size="8"  disabled="true" />
                    <form:hidden path="hotel_id" />
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name" />
            </td>
            <td><form:errors path="name" cssClass="errors"/></td>

            <td>
                <form:label path="contact_no">
                    <spring:message text="Contact_No"/>
                </form:label>
            </td>
            <td>
                <form:input path="contact_no" />
            </td>
            <td><form:errors path="contact_no" cssClass="errors"/>

            <td>
                <form:label path="date_created">
                    <spring:message text="Date_Created"/>
                </form:label>
            </td>
            <td>
                <form:input path="date_created" />
            </td>
            <td><form:errors path="date_created" cssClass="errors"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address" />
            </td>
            <td><form:errors path="address" cssClass="errors"/>

            <td>
                <form:label path="email">
                    <spring:message text="Email"/>
                </form:label>
            </td>
            <td>
                <form:input path="email" />
            </td>
            <td><form:errors path="email" cssClass="errors"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="country">
                    <spring:message text="Country"/>
                </form:label>
            </td>
            <td>
                <form:select path="country" id="country_id" name="country_id">
                    <c:choose>
                        <c:when test="${!empty hotel.country}">
                            <c:forEach items="${countryList}" var="country">
                                <c:if test="${hotel.country == country.country_code}">
                                    <form:option value="${country.country_id}" >${hotel.country}:${country.country_name}</form:option>
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <form:option value="">Select Country</form:option>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach items="${countryList}" var="country">
                        <form:option value="${country.country_id}">${country.country_code} : ${country.country_name}</form:option>
                    </c:forEach>
                </form:select>
            </td>
            <td><form:errors path="country" cssClass="errors"/></td>

            <td>
                <form:label path="currency">
                    <spring:message text="Currency"/>
                </form:label>
            </td>
            <td>
                <form:select path="currency" id="currency_code" name="currency_code">
                    <form:option value="">Select Currency</form:option>
                    <c:forEach items="${currencyList}" var="currency">
                        <form:option   value="${currency.currency_code}"  >${currency.currency_code} : ${currency.currency_name} </form:option>
                    </c:forEach>
                </form:select>
            </td>
            <td><form:errors path="currency" cssClass="errors"/></td>
        </tr>
        <tr>
            <td>
                <form:label path="state">
                    <spring:message text="State"/>
                </form:label>
            </td>
            <td>
                <form:select path="state" id="state_id" >
                    <c:choose>
                        <c:when test="${!empty hotel.state}">
                            <c:forEach items="${stateList}" var = "state">
                                <c:if test="${state.state_name == hotel.state}">
                                    <option value="${state.state_id}">${state.state_name}</option>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${stateList}" var = "state">
                                <option value="${state.state_id}">${state.state_name}</option>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <form:option value="">Select State</form:option>
                        </c:otherwise>
                    </c:choose>
                </form:select>
            </td>
            <td><form:errors path="state" cssClass="errors"/></td>

            <td>
                <form:label path="lat">
                    <spring:message text="Lat"/>
                </form:label>
            </td>
            <td>
                <form:input path="lat" />
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="city">
                    <spring:message text="City"/>
                </form:label>
            </td>
            <td>
                <form:select path = "city" id="city_id">
                    <c:choose>
                        <c:when test="${!empty hotel.city}">
                            <c:forEach items="${cityList}" var = "city">
                                <c:if test="${city.city_name == hotel.city}">
                                    <form:option value="${city.city_id}">${city.city_name} </form:option>
                                </c:if>
                            </c:forEach>
                            <c:forEach items="${cityList}" var = "city">
                                <form:option value="${city.city_id}">${city.city_name} </form:option>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <form:option value="">Select City</form:option>
                        </c:otherwise>
                    </c:choose>
                </form:select>
            </td>
            <td><form:errors path="city" cssClass="errors"/></td>

            <td>
                <form:label path="longitude">
                    <spring:message text="Long"/>
                </form:label>
            </td>
            <td>
                <form:input path="longitude" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="pincode">
                    <spring:message text="Pincode"/>
                </form:label>
            </td>
            <td>
                <form:input path="pincode" />
            </td>
            <td><form:errors path="pincode" cssClass="errors"/></td>
            <td>
                <form:label path="locality">
                    <spring:message text="Locality"/>
                </form:label>
            </td>
            <td>
                <form:input path="locality" />
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty hotel.hotel_id}">
                    <input type="submit" name="edit"
                           value="<spring:message text="Edit Hotel"/>" />
                </c:if>
                <c:if test="${empty hotel.hotel_id}">
                    <input type="button" name="add" onclick="validation()"
                           value="<spring:message text="Add Hotel"/>" >
                </c:if>
            </td>
        </tr>

    </table>
</form:form>

</body>
</html>
