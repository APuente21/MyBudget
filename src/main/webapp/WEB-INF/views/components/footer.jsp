<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="http://andrespuente.us/" var="andres" />
    
<div class="container-fluid footer">
	<hr>
	<footer>
        <a class="navbar-brand"  href="${andres}">&copy; Andres Puente 2018</a>
	</footer>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />

<jsp:include page="js.jsp" />
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>


