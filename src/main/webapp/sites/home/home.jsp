<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-9">
	<div class="row p-2">

		<c:forEach var="item" items="${videos }">
			<div class="col-3 mt-2">
				<div class="card ">
					<div class="card-header">
						<a href="Detail?videoId=${item.videoId }"><img
							src="${empty item.poster ? 'images/poster.jpg':item.poster }"
							width="210" alt="" style="border-radius: 8px"
							height="160"></a>

					</div>
					<div class="card-body">

						<b>${item.title }</b>

					</div>
					<div class="car-footer mb-2 text-center">
						<a href="LikeVideo?videoId=${item.videoId }"
							class="btn btn-success"><i class="fa fa-thumbs-up"
							aria-hidden="true"></i> Like</a> <a
							href="ShareVideo?videoId=${item.videoId }" class="btn btn-info"><i
							class="fas fa-share" aria-hidden="true"></i> Share</a>
					</div>
				</div>
			</div>
		</c:forEach>



	</div>

	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">

					<c:forEach var="item" begin="1" end="${endPage }">
						<a class="page-link"
							href="Home?index=${item }">${item }</a>
							
							

					</c:forEach>
				</ul>
			</nav>
		</div>
	</div>
</div>

<div class="col-3">
	<div class="row mt-3 mb-3">
		<div class="col">
			<div class="card">
				<div class="card-header">
					<i class="fa fa-thumbs-up" aria-hidden="true"></i> Favorites
				</div>
				<c:forEach var="item" items="${videoDetail }">
					<div class="row border-bottom ml-1 ">
						<div class="col-5  mt-4 mb-2">
							<a href="Detail?videoId=${item.videoId }"><img
								src="${item.poster }" alt="" class="" width="120" height="100"
								style="border-radius: 10px"></a>
						</div>
						<div class="col-7 border-left">

							<div class="card-body">
								<b>${item.title }</b>
							</div>

							<div class="card-footer">
								Views:<b style="color: blue"> ${item.views }</b>
							</div>
						</div>

					</div>
				</c:forEach>

			</div>
		</div>
	</div>
</div>