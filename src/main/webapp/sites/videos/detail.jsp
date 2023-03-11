<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-7">
	<div class="card text-center mt-3">

		
			<div class="card-header">
				<iframe width="800" height="600"
					src="${videos.description }"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
			<div class="card-body">

				<div class="row p-2">
					<b>${videos.title }</b>
				</div>
				<div class="row p-2">
					<b></b>
				</div>
			</div>
			<div class="card-footer text-right">
				<a href="LikeVideo?videoId=${videos.videoId }" class="btn btn-success">Like</a>
				<a href="ShareVideo?videoId=${videos.videoId }" class="btn btn-info">Share</a>
			</div>
		

	</div>
</div>
<div class="col-5">
	<c:forEach var="item" items="${videoDetail }">
		<div class="row border mt-3 mb-3" style="border-radius: 8px">
			<div class="col-3 mt-2 mb-2">
				<a href="Detail?videoId=${item.videoId }"><img
					src="${item.poster }" alt="" class="" width="120" height="100"
					style="border-radius: 10px"></a>
			</div>
			<div class="col-9 border-left">

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