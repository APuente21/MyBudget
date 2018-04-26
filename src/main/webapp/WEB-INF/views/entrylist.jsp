<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

    <jsp:include page="components/header.jsp" />

    <body>

        <div class="container">
            <h1>This months details</h1>
        

        <table class="table" width="50%">
            <thead class="thead-dark">
                <tr>
                    <th>Date</th>
                    <th>Category</th>
                    <th>Description</th>
                    <th>Amount</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${entries}" var="entry">
                    <tr>
                        <td>${entry.date}</td>
                        <td>${entry.category.name}</td>
                        <td>${entry.description}</td>
                        <td>${entry.amount}</td>
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>	
        </div>

        <jsp:include page="components/footer.jsp" />
        
    </body>
</html>