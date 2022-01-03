<%@page import="cybersoft.javabackend.java14.crm.util.UrlConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<meta charset="UTF-8">
	<title>ADD TASK</title>
</head>

<body>
	<div class="container page__heading-container">
	    <div class="page__heading">
	        <div class="d-flex align-items-center">
	            <div>
	                <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb mb-0">
	                        <li class="breadcrumb-item"><a href="<%= request.getContextPath() + UrlConst.DASHBOARD%>">Dashboard</a></li>
	                        <li class="breadcrumb-item"><a href="<%= request.getContextPath() + UrlConst.TASK_LIST%>">Task</a></li>
	                        <li class="breadcrumb-item active" aria-current="page">
	                            Add Task
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">Add Task</h1>
	            </div>
	        </div>
	    </div>
	</div>
	
	<div class="container page__container">
	    <div class="card card-form">
            <div class="row no-gutters">
                 <div class="col-lg-4 card-body">
                            <p><strong class="headings-color">Create User</strong></p>
                            <p class="text-muted">Please fill out all fields.</p>
                        </div>
                        <div class="col-lg-8 card-form__body card-body">
                            <form method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Name: </label>
                                    <input name="name" class="form-control" id="exampleInputEmail1" placeholder="Enter name ...">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Description:</label>
                                    <input name="description" class="form-control" id="exampleInputPassword1" placeholder="Enter description ...">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Start Date:</label>
                                    <input name="start_date" class="form-control" id="exampleInputPassword1" placeholder="Enter start date ...">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">End Date:</label>
                                    <input name="end_date" class="form-control" id="exampleInputPassword1" placeholder="Enter end date ...">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Project:</label>
                                    <select name="project" class="form-control">
                                    	<c:forEach var="project" items="${projects }">
									  		<option>${project.name }</option>
									  	</c:forEach>
									</select>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">User:</label>
                                    <select name="user" class="form-control">
                                    	<c:forEach var="user" items="${users }">
									  		<option>${user.name }</option>
									  	</c:forEach>
									</select>
                                </div>
                                 <div class="form-group">
                                    <label for="exampleInputPassword1">Status:</label>
                                    <select name="status" class="form-control">
                                    	<option>Completed</option>
                                    	<option>Processing</option>
                                    	<option>Uncomleted</option>
									</select>
                                </div>
                                <button type="submit" class="btn btn-primary">Submit</button>
                            </form>
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