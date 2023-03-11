<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col">
	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="favorites-tab" data-toggle="tab"
			role="tab" href="#favorites" role="tab" aria-controls="favorites"
			aria-selected="true"> Favorites </a></li>

		<li class="nav-item" role="presentation"><a class="nav-link "
			id="favoriteUsers-tab" data-toggle="tab" role="tab"
			href="#favoriteUsers" role="tab" aria-controls="favoriteUsers"
			aria-selected="false">Favorites users</a></li>

		<li class="nav-item" role="presentation"><a class="nav-link "
			id="shareFriends-tab" data-toggle="tab" role="tab"
			href="#shareFriends" role="tab" aria-controls="shareFriends"
			aria-selected="false">Share friends</a></li>
	</ul>
	<div class="tab-content " id="myTabContent">
		<!-- FAVORITES -->
		<div class="tab-pane fade show active mt-3" id="favorites"
			role="tabpanel" aria-labelledby="favorites-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<th>Video title</th>
					<th>Favorites count</th>
					<th>Lasted date</th>
					<th>Oldest date</th>
				</tr>

				<c:forEach var="item" items="${favList }">
					<tr>
						<td>${item.videoTitle }</td>
						<td>${item.favoriteCount }</td>
						<td>${item.newesDate }</td>
						<td>${item.oldesDate }</td>
					</tr>
				</c:forEach>

			</table>
		</div>
		<!-- USER LIST -->
		<div class="tab-pane fade" id="favoriteUsers" role="tabpanel"
			aria-labelledby="favoriteUsers-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
								<label for=""> <b>Video title</b> <select name="videoUserId"
									id="videoUserId" class="form-control ml-2">
										<c:forEach var="item" items="${videoList }">
											<option value="${item.videoId }"
												${item.videoId == videoUserId?'selected':'' }>${item.title }</option>
										</c:forEach>

								</select>
									<button class="btn btn-info ml-2">Report</button>
								</label>
							</div>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<th>Username</th>
								<th>Fullname</th>
								<th>Email</th>
								<th>Favorite date</th>
							</tr>
							<c:forEach var="item" items="${favUsers }">
								<tr>
									<td>${item.username }</td>
									<td>${item.fullname }</td>
									<td>${item.email }</td>
									<td>${item.likeDate }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>
		</div>
		<!-- SHARE FRIENDS -->
		<div class="tab-pane fade" id="shareFriends" role="tabpanel"
			aria-labelledby="shareFriends-tab">
			<form action="" method="">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
								<label for=""> <b>Video title</b>
								 <select name="videoUserId"
									id="videoUserId" class="form-control ml-2">
										<c:forEach var="item" items="${videoList }">
											<option value="${item.videoId }"
												${item.videoId == videoUserId?'selected':'' }>${item.title }</option>
										</c:forEach>
								</select>
									<button class="btn btn-info ml-2">Report</button>
								</label>
							</div>

						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<th>Sender name</th>
								<th>Sender email</th>
								<th>Receiver</th>
								<th>Sent date</th>
							</tr>
							<c:forEach var="item" items="${favUsers}">
								<tr>
									<td>${item.username }</td>
									<td>${item.fullname }</td>
									<td>${item.email }</td>
									<td>${item.likeDate }</td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>