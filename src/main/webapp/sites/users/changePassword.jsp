<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
     <div class="offset-3 col-6">
                <form action="ChangePassword" method="post">
                    <div class="card">
                        <div class="card-header text-center">
                            <h2>Change Password</h2>
                        </div>
                        <div class="card-body">
                        
                        <jsp:include page="/common/inform.jsp"></jsp:include>
                        
                            <div class="row">
                                <div class="col">
                                    <div class="form-group">
                                        <label for="username"><b>Username</b></label>
                                        <input type="text" class="form-control" name="username" id="username"
                                            aria-describedby="usernameHid" placeholder="Username" required value="${username }">
                                        
                                    </div>
                                    <div class="form-group">
                                        <label for="currentPassword"><b>Current Password</b></label>
                                        <input type="password" class="form-control" name="currentPassword"
                                            id="currentPassword" placeholder="Current Password" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="password"><b>Password</b></label>
                                        <input type="password" class="form-control" name="password" id="password"
                                            placeholder="Password" required>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label for="confirmPassword"><b>Confirm Password</b></label>
                                        <input type="password" class="form-control" name="confirmPassword"
                                            id="confirmPassword" placeholder="Confirm Password" required>
                                    </div>
                                </div>

                            </div>
                        </div>
                        <div class="card-footer text-muted">
                            <button class="btn btn-success">Change Password</button>
                        </div>
                    </div>
                </form>
            </div>