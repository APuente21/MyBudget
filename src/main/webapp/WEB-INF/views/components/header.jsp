<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<head>
    <title>Spring MVC Form Handling Example</title>  
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <spring:url value="/" var="home" />
    <!-- 
    <spring:url value="/resources/resources/core/css/hello.css" var="mainCss" />
	<spring:url value="/resources/resources/core/css/bootstrap.min.css" var="bootsrap" />
    <spring:url value="/" var="home" />
    <link href="${mainCss}" rel="stylesheet" type="text/css" />
    <link href="${bootsrap}" rel="stylesheet" type="text/css" />
    -->
    <jsp:include page="css.jsp" />
</head>
<div class="page-header myHeader">
    <div class="container-fluid">        
        <h1><a class="navbar-brand"  href="${home}">My Budget</a></h1>
    </div>
</div>
