<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="components/header.jsp" />

<body>

	<div class="container">
		<h1>All Users</h1>
	</div>
    
    <form:form action="register" method="post" modelAttribute="user">
        
        <spring:bind path="FIRST_NAME">
			<div class="form-group">
				<label class="col-sm-2 control-label">First Name</label>
				<div class="col-sm-10">
					<form:input path="FIRST_NAME" type="text" class="form-control " id="name" placeholder="Name" />
				</div>
			</div>
		</spring:bind>
        
        		<spring:bind path="email">
			<div class="form-group">
				<label class="col-sm-2 control-label">Email</label>
				<div class="col-sm-10">
					<form:input path="email" class="form-control" id="email" placeholder="Email" />
				</div>
			</div>
		</spring:bind>
        
        <div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn-lg btn-primary pull-right">Add</button>
			</div>
		</div>

    </form:form>

	<jsp:include page="components/footer.jsp" />

</body>
</html>