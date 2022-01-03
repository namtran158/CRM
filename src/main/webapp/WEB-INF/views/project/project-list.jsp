<%@page import="cybersoft.javabackend.java14.crm.util.UrlConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<meta charset="UTF-8">
	<title>MANAGE PROJECT</title>
</head>

<body>
	<div class="container page__heading-container">
	    <div class="page__heading">
	        <div class="d-flex align-items-center">
	            <div>
	                <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb mb-0">
	                        <li class="breadcrumb-item"><a href="<%= request.getContextPath() + UrlConst.DASHBOARD%>">Dashboard</a></li>
	                        <li class="breadcrumb-item"><a href="<%= request.getContextPath() + UrlConst.PROJECT_LIST%>">Project</a></li>
	                        <li class="breadcrumb-item active" aria-current="page">
	                            Manage Project
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">Manage Project</h1>
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
                                 <th>Project</th>
                                 <th>Description</th>
                                 <th>Start Date</th>
                                 <th>End Date</th>
                                 <th>Leader</th>
                                 <th></th>
                                 <th></th>
                             </tr>
                         </thead>
                         <tbody class="list" id="staff">
                         	<c:forEach var="project" items="${projects }">
                              <tr class="selected">
                             	  <td>${project.id }</td>
                                  <td>${project.name }</td>
                                  <td>${project.description }</td>
                                  <td>${project.start_date }</td>
                                  <td>${project.end_date }</td>
                                  <td>${project.user.name }</td>
                                  <td>
                                  	<div class="ml-auto">
                            			<a href="<%= request.getContextPath() + UrlConst.PROJECT_UPDATE%>?id=${project.id}" class="btn btn-light">
                            				<i class="material-icons icon-16pt text-muted mr-1">settings</i>
                            				Update
                						</a>
                       				 </div>
                                  </td>
                                  <td>
                                  	<div class="ml-auto">
                            			<a href="<%= request.getContextPath() + UrlConst.PROJECT_DELETE%>?id=${project.id}" class="btn btn-light">
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