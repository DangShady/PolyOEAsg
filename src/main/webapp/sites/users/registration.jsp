<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-6 offset-3">
	<form action="" method="post">
		${Routes.SITE_REGISTRATION_SHOW }
		<div class="card mt-5">
			<div class="card-header text-center">
				<h2>Registration</h2>
			</div>
			<div class="card-body">
			
			<jsp:include page="/common/inform.jsp"></jsp:include>				
			
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="username"><b>Username</b></label> <input type="text"
								class="form-control" name="username" id="username"
								aria-describedby="usernameHid" placeholder="Username"
								value="${user.username }" required> 
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
								placeholder="Password"required>
						</div>

						<div class="form-group">
							<label for="email"><b>Email</b></label> <input type="email"
								class="form-control" name="email" id="email"
								aria-describedby="emailHid" placeholder="Email"
								value="${user.email }"required> 
						</div>
						
						
					</div>

				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Sign up</button>
			</div>
		</div>
	</form>
</div>