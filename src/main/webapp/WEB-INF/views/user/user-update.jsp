<%@page import="cybersoft.javabackend.java14.crm.util.UrlConst"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
	<meta charset="UTF-8">
	<title>UPDATE USER</title>
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
	                            Update User
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">Update User</h1>
	            </div>
	        </div>
	    </div>
	</div>
	
	<div class="container page__container">
	    <div class="card card-form">
            <div class="row no-gutters">
                        <div class="col-lg-4 card-body">
                            <p><strong class="headings-color">Update User</strong></p>
                            <p class="text-muted">Stack supports all of Bootstrap's default form styling in addition to a handful of new input types and features. Please <a href="https://getbootstrap.com/docs/4.1/components/forms/" target="_blank">read the official documentation</a>                                for a full list of options from Bootstrap's core library.</p>
                        </div>
                        <div class="col-lg-8 card-form__body card-body">
                            <form method="post">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Name:</label>
                                    <input name="name" class="form-control" id="exampleInputEmail1" placeholder="Enter name ...">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Email:</label>
                                    <input name="email" class="form-control" id="exampleInputPassword1" placeholder="Enter email ...">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Phone:</label>
                                    <input name="phone" class="form-control" id="exampleInputPassword1" placeholder="Enter phone ...">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Address:</label>
                                    <input name="address" class="form-control" id="exampleInputPassword1" placeholder="Enter password ...">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Role:</label>
                                    <select name="role" class="form-control">
									    <option>ROLE_ADMIN</option>
									    <option>ROLE_LEADER</option>
									    <option>ROLE_MEMBER</option>
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