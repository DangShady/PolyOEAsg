<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col mt-4">

	<jsp:include page="/common/inform.jsp"></jsp:include>

	<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="tab"
			role="tab" href="#videoEditing" role="tab"
			aria-controls="videoEditing" aria-selected="true">Video Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link "
			id="videoList-tab" data-toggle="tab" role="tab" href="#videoList"
			role="tab" aria-controls="videoList" aria-selected="false">Video
				List</a></li>
	</ul>
	<div class="tab-content " id="myTabContent">
		<div class="tab-pane fade show active mt-3" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post" enctype="multipart/form-data">
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class="col-3">
								<div class="border p-3">
									<img
										src="${video.poster != null?video.poster: 'images/poster.jpg' }"
										alt="" class="img-fluid">

									<div class="input-group mb-3 mt-3">
										<div class="input-group-prepend">
											<button class="btn btn-info">Upload</button>
										</div>
										<div class="custom-file">
											<input type="file" class="custom-file-input" id="cover"
												name="cover" /> <button for="cover" class="btn btn-info"><b>File</b></button>
										</div>
									</div>
								</div>
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="youtubeId"><b>Youtube ID</b></label> <input type="text"
										class="form-control" name="videoId" id="videoId"
										aria-describedby="youtubeIdHid" placeholder="Youtube ID"
										value="${video.videoId }" required> 
								</div>
								<div class="form-group">
									<label for="video"><b>Video title</b></label> <input type="text"
										class="form-control" name="title" id=""
										title""
										aria-describedby="videoHid"
										placeholder="Video title" value="${video.title }"required> 
								</div>
								<div class="form-group">
									<label for="views"><b>View count</b></label> <input type="text"
										class="form-control" name="views" id="views"
										aria-describedby="viewsHid" placeholder="View count"
										value="${video.views }"required> 
								</div>
								<div class="form-check form-check-inline">
									<label> <input type="radio"
										class="form-check-input m-2" name="active" value="true"
										id="status" ${video.active ? 'checked' : '' }>Active
									</label> <label> <input type="radio"
										class="form-check-input m-2" name="active" value="false"
										id="status" ${! video.active ? 'checked' : '' }>Inactive
									</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="description">Description</label>
								<textarea name="description" id="description" cols="30" rows="4"
									class="form-control" ${video.description }></textarea>
							</div>
						</div>
					</div>
					<div class="card-footer text-center">
						<button class="btn btn-primary"
							formaction="VideoManagerment/create">Create</button>
						<button class="btn btn-warning"
							formaction="VideoManagerment/update">Update</button>
						<button class="btn btn-danger"
							formaction="VideoManagerment/delete">Delete</button>
						<button class="btn btn-info" formaction="VideoManagerment/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<!-- VIDEO LIST -->
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<th>Youtube ID</th>
					<th>Video Title</th>
					<th>View Count</th>
					<th>Status</th>
					<th>&nbsp;</th>
				</tr>
				<c:forEach var="item" items="${videos }">
					<tr>
						<td>${item.videoId }</td>
						<td>${item.title }</td>
						<td>${item.views }</td>
						<td>${item.active ? 'Active' : 'Deactive' }</td>
						
						<td>	
							<a href="VideoManagerment/edit?videoId=${item.videoId }">
							<i class="fas fa-edit" aria-hidden="true"></i> Edit</a> 
							<a href="VideoManagerment/delete?videoId=${item.videoId }" class="ml-2">
							<i class="fa fa-trash" aria-hidden="true"></i> Delete</a>
								
						</td>
					</tr>
				</c:forEach>

			</table>

		</div>
	</div>
</div>