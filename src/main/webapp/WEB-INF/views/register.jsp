<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="components/header.jsp" />

    <body>
        <spring:url value="/register" var="userActionUrl" />
        
        <form:form class="form-horizontal" method="post" modelAttribute="user" action="${userActionUrl}">
            <spring:bind path="firstName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="col-sm-offset-2 col-sm-5">
                        <form:input path="firstName" type="text" class="form-control " id="firstName" placeholder="First Name" />
                        
                    </div>
                </div>
            </spring:bind>
            
            <spring:bind path="lastName">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="col-sm-offset-2 col-sm-5">
                        <form:input path="lastName" type="text" class="form-control " id="lastName" placeholder="Last Name" />
                        
                    </div>
                </div>
            </spring:bind>
            
                        <spring:bind path="email">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="col-sm-offset-2 col-sm-5">
                        <form:input path="email" type="text" class="form-control " id="email" placeholder="Email" />
                        
                    </div>
                </div>
            </spring:bind>
            
                        <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="col-sm-offset-2 col-sm-5">
                        <form:input path="password" type="text" class="form-control " id="password" placeholder="Password" />
                        
                    </div>
                </div>
            </spring:bind>
            
                        <spring:bind path="number">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <div class="col-sm-offset-2 col-sm-5">
                        <form:input path="number" type="text" class="form-control " id="number" placeholder="XXX-XXX-XXX" />
                        
                    </div>
                </div>
            </spring:bind>
            
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-5">
                    <button type="submit" class="btn-lg btn-primary pull-right">Submit</button>
                </div>
            </div>
            
            <div>
                <div>
                    <form:errors path="firstName" class="control-label" />
                </div>
                <div>
                    <form:errors path="lastName" class="control-label" />
                </div>
                <div>
                    <form:errors path="email" class="control-label" />
                </div>
                <div>
                    <form:errors path="password" class="control-label" />
                </div>
                <div>
                    <form:errors path="number" class="control-label" />
                </div>             
            </div>     
        </form:form>

        <jsp:include page="components/footer.jsp" />

    </body>
</html>