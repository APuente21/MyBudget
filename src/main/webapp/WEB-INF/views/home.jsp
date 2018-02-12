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
        <div class="container-fluid logInForm wrapper ">
            <div class="row justify-content-md-center">
                <div class="col-12 col-md-7">
                    <form:form class="form-horizontal" method="post" modelAttribute="user" action="${userActionUrl}">
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

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-5">
                                <button type="submit" id="bttn" class="btn-lg btn pull-righ">Sign In</button>
                                <a href="register">Register</a>
                            </div>
                        </div>
                        
                        <spring:bind path="email">
                            <div class="form-group ${status.error ? 'has-error alert alert-danger' : ''}">
                                <div class="col-sm-offset-2 col-sm-5">
                                    <form:errors path="email" class="control-label" />
                                </div>
                            </div>
                        </spring:bind>
                        <spring:bind path="password">
                             <div class="form-group ${status.error ? 'has-error alert alert-danger' : ''}">
                                <div class="col-sm-offset-2 col-sm-5">
                                    <form:errors path="password" class="control-label" /> 
                                </div>
                            </div>
                        </spring:bind>  
                        <spring:bind path="number">
                             <div class="form-group ${status.error ? 'has-error alert alert-danger' : ''}">
                                <div class="col-sm-offset-2 col-sm-5">
                                    <form:errors path="number" class="control-label" />
                                </div>
                            </div>
                        </spring:bind>   
                            

                    </form:form>
                </div>
            </div>    
        </div>

        <jsp:include page="components/footer.jsp" />
    </body>
</html>