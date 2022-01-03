<%@page import="cybersoft.javabackend.java14.crm.util.UrlConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<meta charset="UTF-8">
	<title>LIST USER</title>
</head>

<body>
	<div class="container page__heading-container">
	    <div class="page__heading">
	        <div class="d-flex align-items-center">
	            <div>
	                <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb mb-0">
	                        <li class="breadcrumb-item"><a href="<%= request.getContextPath() + UrlConst.DASHBOARD%>">Dashboard</a></li>
	                        <li class="breadcrumb-item"><a href="<%= request.getContextPath() + UrlConst.USER_LIST%>">User</a></li>
	                        <li class="breadcrumb-item active" aria-current="page">
	                            List User
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">List User</h1>
	            </div>
	        </div>
	    </div>
	</div>
	
	<div class="container page__container">
	    <div class="card card-form">
            <div class="row no-gutters">
                 <div class="table-responsive border-bottom">
                     <table class="table mb-0 thead-border-top-0">
                         <thead>
                             <tr>
                             	 <th>ID</th>
                                 <th>Employee</th>
                                 <th>Role</th>
                                 <th>Email</th>
                                 <th>Phone</th>
                                 <th>Address</th>
                                 <th></th>
                                 <th></th>
                             </tr>
                         </thead>
                         <tbody class="list" id="staff">
                         	<c:forEach var="user" items="${users }">
                              <tr class="selected">
                             	  <td>${user.id }</td>
                                  <td>${user.name }</td>
                                  <td>${user.role.name }</td>
                                  <td>${user.email }</td>
                                  <td>${user.phone }</td>
                                  <td>${user.address }</td>
                                  <td>
                                  	<div class="ml-auto">
                            			<a href="<%= request.getContextPath() + UrlConst.USER_UPDATE%>?id=${user.id}" class="btn btn-light">
                            				<i class="material-icons icon-16pt text-muted mr-1">settings</i>
                            				Update
                						</a>
                       				 </div>
                                  </td>
                                  <td>
                                  	<div class="ml-auto">
                            			<a href="<%= request.getContextPath() + UrlConst.USER_DELETE%>?id=${user.id}" class="btn btn-light">
                            				<i class="material-icons icon-16pt text-muted mr-1">delete</i>
                            				Delete
                						</a>
                       				 </div>
                                  </td>
                              </tr>
                             </c:forEach>
                         </tbody>
                     </table>
                 </div>
            </div>
        </div>
	</div>
	
	<content tag="scripts">
		<!-- Chart.js -->
		<script src='<c:url value="assets/vendor/Chart.min.js" />'></script>
		
		<!-- App Charts JS -->
		<script src='<c:url value="assets/js/chartjs-rounded-bar.js" />'></script>
		<script src='<c:url value="assets/js/charts.js" />'></script>
		
		<!-- Chart Samples -->
		<script src='<c:url value="assets/js/page.dashboard.js" />'></script>
	</content>
</body>