<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="shortenUrlApp">
    <jsp:include page="common/header.jsp"/>
<body>
    <div class="outerWrapper" ng-controller="mainController">
        
        
        <jsp:include page="urlSections/urlForm.jsp"/>
    <div class="col-xs-12" style="height:30px;"></div>
    <div class="col-xs-12">

        <jsp:include page="urlSections/urlTable.jsp"/>

</div>
</div><!-- End Inner -->

<jsp:include page="common/footer.jsp"/>
</body>
</html>