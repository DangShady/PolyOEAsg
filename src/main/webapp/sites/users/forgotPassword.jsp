<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
   <div class="offset-4 col-4">
                <form action="ForgotPassword" method="post">
                    <div class="card mt-5">
                        <div class="card-header text-center">
                            <h2>Forgot Password</h2>
                        </div>
                        <div class="card-body">
                        
                        	<jsp:include page="/common/inform.jsp"></jsp:include>
                        
                            <div class="form-group">
                                <label for="username"><b>Username</b></label>
                                <input type="text" class="form-control" name="username" id="username"
                                    aria-describedby="usernameHid" placeholder="Username"required>
                               
                            </div>
                            <div class="form-group">
                                <label for="email"><b>Email</b></label>
                                <input type="email" class="form-control" name="email" id="email"
                                    aria-describedby="emailHid" placeholder="Email" required>
                               
                            </div>
                        </div>
                        <div class="card-footer text-muted">
                            <button class="btn btn-success">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
