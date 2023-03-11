<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="offset-4 col-4">
	<form action="" method="post" name="formLogin">
		<div class="card mt-5">
			<div class="card-header text-center">
				<h2>Login</h2>
			</div>

			<jsp:include page="/common/inform.jsp"></jsp:include>
			
			<div class="card-body">
				<div class="form-group">
					<label for=""> <b>Username</b></label>  <input type="text" class="form-control"
						name="username" id="username" aria-describedby="usernameHid"
						placeholder="Username" required>

				</div>
				<div class="form-group">
					<label for=""><b>Password</b></label> <input type="password"
						class="form-control" name="password" id="password"
						aria-describedby="passwordHid" placeholder="Password" required>

				</div>
				<div class="form-check form-check-inline">
					<label style="color: blue"><input type="checkbox" class="form-check-input"
						name="remember">Remember me ?</label>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Login</button>
			</div>
		</div>
	</form>
</div>