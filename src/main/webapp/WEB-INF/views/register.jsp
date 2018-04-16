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
        <div class="container logInForm wrapper ">
            <div class="justify-content-md-center">
                    <form:form class="form-horizontal" method="post" modelAttribute="user" action="${userActionUrl}">
                        <div class="row">
                            <div class="col-lg-3">
                                <spring:bind path="firstName">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input path="firstName" type="text" class="form-control " id="firstName" placeholder="First Name" />
                                        <form:errors path="firstName" class="control-label" />                                        
                                    </div>
                                </spring:bind>
                            </div>
                            <div class="col-lg-3">
                                <spring:bind path="lastName">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input path="lastName" type="text" class="form-control " id="lastName" placeholder="Last Name" />
                                        <form:errors path="lastName" class="control-label" />    
                                    </div>
                                </spring:bind>
                            </div>
                        </div>
                        
                       
                       <div class="row">
                            <div class="col-lg-6">
                                <spring:bind path="email">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input path="email" type="text" class="form-control " id="email" placeholder="Email" />
                                        <form:errors path="email" class="control-label" />    
                                    </div>
                                </spring:bind>
                           </div>
                        </div>

                       <div class="row">
                            <div class="col-lg-6">
                                <spring:bind path="password">
                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                        <form:input path="password" type="text" class="form-control " id="password" placeholder="Password" />
                                        <form:errors path="password" class="control-label" />    
                                    </div>
                                </spring:bind>
                           </div>
                        </div>

                        <div class="row">
                            <div class="col-md-2">Country Code</div>
                            <div class="col-md-2">Area Code</div>
                            <div class="col-md-2">Number</div>
                        </div>
                        <div class="row form-group">
                            <div class="col-lg-2">
                                <form:input path="countryCode" type="text" class="form-control " id="countryCode" placeholder="+1" />
                                <form:errors path="countryCode" class="control-label" /> 
                            </div>
                            <div class=" col-lg-2">
                                <form:input path="areaCode" type="text" class="form-control " id="areaCode" placeholder="123" />
                                <form:errors path="areaCode" class="control-label" /> 
                            </div>
                            <div class=" col-lg-2">
                                <form:input path="number" type="text" class="form-control " id="number" placeholder="456-6789" />
                                <form:errors path="number" class="control-label" /> 
                            </div>  
                        </div>

                        <div class="form-group">
                            <button type="submit" class="btn-lg btn pull-right">Submit</button>
                        </div>                      
                        
                    </form:form>

            </div>
        </div>
        <jsp:include page="components/footer.jsp" />

    </body>
</html>