<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <spring:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" var="jQuery"/>
    <spring:url value="https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js" var="jQueryValidate"/>
    <spring:url value="/resources/css/style.css" var="style"/>
    <spring:url value="/resources/js/validation_form.js" var="jsValidate"/>
    <script src="${jQuery}"></script>
    <script src="${jQueryValidate}"></script>
    <link href="${style}" rel="stylesheet"/>
    <script src="${jsValidate}" type="text/javascript"></script>
</head>

<body>
<div id="contact">
    <h4>Registration</h4>

    <spring:url value="/user/registration" var="registration_form"/>
    <form:form id="registration_id" action="${registration_form}" method="post" modelAttribute="registration_bean">
        <form:input type="text" path="name" placeholder="Name..."/>
        <form:errors path="name" cssClass="error_spring"/>
        <form:input type="text" path="email" name="email" placeholder="Email id..."/>
        <form:errors path="email" cssClass="error_spring"/>
        <form:input type="text" path="password" name="password" id="password" placeholder="Password"/>
        <form:errors path="password" cssClass="error_spring"/>
        <form:input type="text" path="password_again" name="password_again" placeholder="Repeat password"/>
        <form:errors path="password_again" cssClass="error_spring"/>
        <form:button value="Submit"> Submit</form:button>
    </form:form>
</div>

</body>

</html>