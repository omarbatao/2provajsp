<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${errore == ''}">
    <div class="alert alert-success" role="alert">...</div>
</c:if>

<c:if test="${errore == ''}">
    <div class="alert alert-info" role="alert">...</div>
</c:if>

<c:if test="${errore == ''}">
    <div class="alert alert-warning" role="alert">...</div>
</c:if>

<c:if test="${errore == ''}">
    <div class="alert alert-danger" role="alert">...</div>
</c:if>