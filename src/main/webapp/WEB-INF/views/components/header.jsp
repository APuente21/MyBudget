<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
    <title>Spring MVC Form Handling Example</title>
    <spring:url  value="/resources/css/css/hello.css" var="coreCss" />   
    <spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
    
    
    <link rel="stylesheet" type="text/css"  href="${bootstrapCss}" />
    <link rel="stylesheet" type="text/css"  href="${coreCss}" />

</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/users/add" var="urlAddUser" />

<nav class="navbar navbar-inverse">
	<div class="container-fluid myHeader">
		<div class="navbar-header" align="center">
			<h1><a class="navbar-brand" href="${urlHome}">My Budget</a></h1>
		</div>
	</div>
</nav>