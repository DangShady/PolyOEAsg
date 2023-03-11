<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<div class="col">

	<jsp:include page="/common/inform.jsp"></jsp:include>

	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="userEditing-tab" data-toggle="tab"
			role="tab" href="#userEditing" role="tab" aria-controls="userEditing"
			aria-selected="true"> User Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link "
			id="userList-tab" data-toggle="tab" role="tab" href="#userList"
			role="tab" aria-controls="userList" aria-selected="false">User
				List</a></li>
	</ul>
	<div class="tab-content " id="myTabContent">
		<div class="tab-pane fade show active mt-3" id="userEditing"
			role="tabpanel" aria-labelledby="userEditing-tab">
			<form action="" method="post">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-5 mx-auto">
								<div class="form-group">
									<label for="username"><b>Username</b></label> <input type="text"
										class="form-control" name="username" id="username"
										aria-describedby="usernameHid" placeholder="Username"
										value="${user.username }"required> 
								</div>
								<div class="form-group">
									<label for="fullname"><b>Fullname</b></label> <input type="text"
										class="form-control" name="fullname" id="fullname"
										aria-describedby="fullnameHid" placeholder="Fullname"
										value="${user.fullname }"required> 
								</div>
								<div class="form-group">
									<label for="password"><b>Password</b></label> <input type="password"
										class="form-control" name="password" id="password"
										aria-describedby="passwordHid" placeholder="Password"
										value="${user.password }"required> 
								</div>
								<div class="form-group">
									<label for="email"><b>Email</b></label> <input type="email"
										class="form-control" name="email" id="email"
										aria-describedby="emailHid" placeholder="Email"
										value="${user.email }" required> 
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-center">
						<button class="btn btn-success"
							formaction="UsersManagerment/create">Create</button>
						<button class="btn btn-warning"
							formaction="UsersManagerment/update">Update</button>
						<button class="btn btn-danger"
							formaction="UsersManagerment/delete">Delete</button>
						<button class="btn btn-info" formaction="UsersManagerment/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<!-- USER LIST -->
		<div class="tab-pane fade" id="userList" role="tabpanel"
			aria-labelledby="userList-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<th>Username</th>
					<th>Fullname</th>
					<th>Email</th>
					<th>Role</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="item" items="${users }">
					<tr>
						<td>${item.username }</td>
						<td>${item.fullname }</td>
						<td>${item.email }</td>
						<td>${item.admin ? 'Admin' : 'User' }</td>
						<td>
								<a href="UsersManagerment/edit?username=${item.username }"><i class="fa fa-edit" aria-hidden="true"></i>
								Edit</a> 
								<a href="UsersManagerment/delete?username=${item.username }" class="ml-2"><i class="fa fa-trash"
								aria-hidden="true"></i> Delete</a>
								
								</td>
					</tr>
				</c:forEach>

			</table>

		</div>
	</div>
</div>