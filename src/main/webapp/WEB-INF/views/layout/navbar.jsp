<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cybersoft.javabackend.java14.crm.util.UrlConst" %>

<div class="page__header mb-0">
    <div class="container page__container">
        <div class="navbar navbar-secondary navbar-light navbar-expand-sm p-0">
            <button class="navbar-toggler navbar-toggler-right" data-toggle="collapse" data-target="#navbarsExample03" type="button">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="navbar-collapse collapse" id="navbarsExample03">
                <ul class="nav navbar-nav flex">
                    <li class="nav-item">
                        <a class="nav-link active" href="<%= request.getContextPath() + UrlConst.DASHBOARD%>">
                            Dashboard</a>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            Project
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<%= request.getContextPath() + UrlConst.PROJECT_LIST%>">
                                Manage Project
                            </a>
                            <a class="dropdown-item" href="<%= request.getContextPath() + UrlConst.PROJECT_ADD%>">
                                Create Project
                            </a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
                            User
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="<%= request.getContextPath() + UrlConst.USER_LIST %>">
                                List User
                            </a>
                            <a class="dropdown-item" href="<%= request.getContextPath() + UrlConst.USER_ADD %>">
                                Create User
                            </a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#">Task</a>
                        <div class="dropdown-menu">
                        <a class="dropdown-item" href="<%= request.getContextPath() + UrlConst.TASK_LIST %>">
                                List Task
                            </a>
                            <a class="dropdown-item" href="<%= request.getContextPath() + UrlConst.TASK_ADD %>">
                                Create Task
                            </a>
                        </div>
                    </li>
                    
                </ul>
            </div>
        </div>
    </div>
</div>