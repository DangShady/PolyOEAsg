<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!doctype html>
<html lang="en">

<head>
<title>${page.title }</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<base href="/PolyOEAsg/" />
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
</head>


<body>
	<main class="container-fluid">
		<header class="row pt-3 pb-2">
			<div class="col-9">

				<h1 class="ml-2"
					style="font-size: 50px; color: #2c2c2c; letter-spacing: .05em; text-shadow: 4px 4px 0px #d5d5d5, 7px 7px 0px rgba(0, 0, 0, 0.2)">FPT
					Play Box</h1>
			</div>
			<div class="col-3 text-right">
				<div class="mb-3 mr-5">
					<a href="https://www.facebook.com/" class="mr-3"><i class="fab fa-facebook-f"></i></a>
					<a href="https://www.google.com/" class="mr-3"><i class="fa-brands fa-google"></i></a>
					<a href="https://www.youtube.com/"><i class="fa-brands fa-youtube"></i></a>
				</div>

				<div>
					<form action="Search" method="post">
						<div class="input-group">


							<div class="form-outline">
								<input type="search" name="keyword" placeholder="Search"
									class="form-control" required />
							</div>

							<button class="btn btn-light">
								<i class="fas fa-search"></i> Search
							</button>
						</div>
					</form>
				</div>

			</div>
		</header>
		<nav class="row" style="font-size: 18px;">
			<nav class="col navbar navbar-expand-sm navbar-light bg-light">
				<a class="navbar-brand" href="Home"> <img
					src="/PolyOEAsg/images/fpt-play-box.png" class="mr-4" width="200px"
					height="70px">
				</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="Home">
								<i class="fa fa-home" aria-hidden="true"></i> Home<span
								class="sr-only">(current)</span>
						</a></li>

						<li class="nav-item"><a class="nav-link" href="Favorite">
								<i class="fa fa-comment" aria-hidden="true"></i> My Favorites
						</a></li>

						<li class="nav-item dropdown "><a
							class="nav-link dropdown-toggle" href="#" id="dropdownId"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fa fa-user" aria-hidden="true"></i> My Account
						</a>

							<div class="dropdown-menu" aria-labelledby="dropdownId">

								<c:if test="${!isLogin }">
									<a class="dropdown-item" href="Registration">Registration</a>
									<a class="dropdown-item" href="Login">Login</a>
									<a class="dropdown-item" href="ForgotPassword">Forgot
										Password</a>
								</c:if>
								<c:if test="${isLogin }">
									<a class="dropdown-item" href="Logoff">Logoff</a>
									<a class="dropdown-item" href="ChangePassword">Change
										Password</a>
									<a class="dropdown-item" href="EditProfile">Edit Profile</a>
								</c:if>



							</div></li>




					</ul>
					<ul class="navbar-nav mr-20 mt-2 mt-lg-0 float-right">
						<c:if test="${isLogin }">
							<li class="nav-item"><a class="nav-link"
								style="color: blue"><i class="fa fa-eye"
									aria-hidden="true"></i> Welcome ${name}</a></li>
						</c:if>
					</ul>

				</div>
			</nav>

		</nav>
		<section class="row">
			<jsp:include page="${page.contentUrl }"></jsp:include>
		</section>


	</main>

	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.9/angular.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<c:if test="${not empty page.scriptUrl }">
		<jsp:include page="${page.scriptUrl }"></jsp:include>
	</c:if>
</body>

</html>