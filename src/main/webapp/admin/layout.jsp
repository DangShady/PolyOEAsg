<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>

<!doctype html>
<html lang="en">

<head>
<title>${page.title }</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<base href="/PolyOEAsg/" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

</head>

<body>
	<main class="container-fluid">
		<header class="row pt-5 pb-2">
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
			</div>
		</header>
		<nav class="row" style="font-size: 18px">
			<nav class="col navbar navbar-expand-sm navbar-light bg-light">
				<a class="navbar-brand" href="HomeAdmin"> <img
					src="/PolyOEAsg/images/aaa.png" class="mr-4" width="200px"
					height="100px">
				</a>
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link"
							href="HomeAdmin"><i class="fa fa-home" aria-hidden="true"></i>
								Home <span class="sr-only">(current)</span> </a></li>
						<li class="nav-item"><a class="nav-link"
							href="VideoManagerment"> <i class="fa fa-video "
								aria-hidden="true"></i> Videos
						</a></li>

						<li class="nav-item"><a href="UsersManagerment"
							class="nav-link"> <i class="fa fa-user" aria-hidden="true"></i>
								Users
						</a></li>

						<li class="nav-item"><a href="ReportsManagermentServlet"
							class="nav-link"><i class="fa fa-file" aria-hidden="true"></i>
								Report</a></li>


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


		<div>
			<div id="carouselExampleIndicators" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExampleIndicators" data-slide-to="0"
						class="active"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
					<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="/PolyOEAsg/images/nen7.jpg" class="d-block w-100" width="100%" height="100%" alt="...">
					</div>
					<div class="carousel-item">
						<img src="/PolyOEAsg/images/nen2.jpg" class="d-block w-100" width="100%" height="100%"  alt="...">
					</div>
					<div class="carousel-item">
						<img src="/PolyOEAsg/images/nen3.jpg" class="d-block w-100" width="100%" height="100%"  alt="...">
					</div>
				</div>
				<a class="carousel-control-prev" type="button"
					data-target="#carouselExampleIndicators" data-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="carousel-control-next" type="button"
					data-target="#carouselExampleIndicators" data-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>


	</main>


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
	<script>
		$('#myTab a').on('click', function(event) {
			event.preventDefault()
			$(this).tab('show')
		})
	</script>
</body>

</html>