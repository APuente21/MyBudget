<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="components/header.jsp" />

    <body>
        <spring:url value="/" var="userActionUrl" />
        
        <form:form class="form-horizontal" method="post" modelAttribute="user" action="${userActionUrl}">
            <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="col-sm-offset-2 col-sm-5">
                        <form:input path="email" type="text" class="form-control " id="email" placeholder="Email" />
                        <form:errors path="email" class="control-label" />
                    </div>
                </div>
            </spring:bind>
            
            <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="col-sm-offset-2 col-sm-5">
                        <form:input path="password" type="text" class="form-control " id="password" placeholder="Password" />
                        <form:errors path="password" class="control-label" />
                    </div>
                </div>
            </spring:bind>
            
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                    <a href="register">Register</a>
                    <button type="submit" class="btn-lg btn-primary pull-right">Sign In</button>
                </div>
            </div>
            
        </form:form>

        <jsp:include page="components/footer.jsp" />

    </body>
</html>