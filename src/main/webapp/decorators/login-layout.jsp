<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>
<!DOCTYPE html>
<html>
	<head>
		<title><dec:title/></title>
		<jsp:include page="/WEB-INF/views/layout/header.jsp" />
		<dec:head />
	</head>
	<body class="layout-login">
    	<dec:body/>
    
	    <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
	</body>
</html>