<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<style>
#wd{
	height: 2px !important; 
}
.wd1{
	height: 2px !important;
}

	</style>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue">
			<div>
				<a href="https://www.xadmin.net" class="navbar-brand"> Employee
					Management Application </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">

				  <!-- <a href="<%=request.getContextPath()%>/addEmployee" class="btn btn-success">Add -->
					<!-- New Employee</a>   --> 
                    <a href="./addEmployee" class="btn btn-success">Add
                        New Employee</a>
			</div>
			<br>
			<table class="table table-bordered wd1">
				<thead>
					<tr>
						<!-- <th>ID</th> -->
						<th>Employee Name</th>
						<th>Employee Email Id</th>
						<!-- <th>Date Of Birth</th> -->
						<!-- <th>Age</th> -->
                        <!-- <th>Salary</th> -->
                        <!-- <th>Status</th> -->
					</tr>
				</thead>
				<tbody >
				
					<c:forEach var="employee" items="${listOfEmployees}">

						<tr id="wd">
							<!-- <td><c:out value="${employee.employeeId}" /></td> -->
							<td><c:out value="${employee.employeeName}" /></td>
							<td><c:out value="${employee.employeeMailId}" /></td>
							<!-- <td><c:out value="${employee.employeeDob}" /></td>
                            <td><c:out value="${employee.employeeAge}" /></td> -->
                            <!-- <td><c:out value="${employee.employeeSalary}" /></td> -->
                            <!-- <td><c:out value="${employee.employeeStatus}" /></td> -->
							<td><a href="edit?id=<c:out value='${employee.employeeId}' />">Update</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${employee.employeeId}' />">Delete</a></td>
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>