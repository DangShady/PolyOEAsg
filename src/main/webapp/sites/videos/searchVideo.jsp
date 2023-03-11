<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col">
	<div class="row p-2">

		<c:forEach var="item" items="${videos }">
			<div class="col-3 mt-3">
				<div class="card">
					<div class="card-header">
						<a href="Detail?videoId=${item.videoId }"><img src="${item.poster }" alt="" class=""
							width="300" height="250" style="border-radius:8px"></a>

					</div>
					<div class="card-body">


						<b>${item.title }</b>

					</div>
					<div class="card-footer text-muted">
						<a href="UnlikeVideo" class="btn btn-primary">Unlike</a> <a href="ShareVideo?videoId=${item.videoId }"
							class="btn btn-info">Share</a>
					</div>
				</div>
			</div>
		</c:forEach>



	</div>
	<div class="row">
		<div class="col">
			<nav aria-label="Page navigation">
				<ul class="pagination justify-content-center">
					<li class="page-item disabled"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
							<span class="sr-only">Previous</span>
					</a></li>
					<li class="page-item active"><a class="page-link" href="#">&lt;</a></li>
					<li class="page-item"><a class="page-link" href="#">&gt;</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>