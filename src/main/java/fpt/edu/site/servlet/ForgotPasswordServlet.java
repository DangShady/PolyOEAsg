package fpt.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.edu.common.EmailUtils;
import fpt.edu.common.PageInfo;
import fpt.edu.common.PageType;
import fpt.edu.dao.UserDAO;
import fpt.edu.domain.Email;
import fpt.edu.model.User;

@WebServlet("/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PageInfo.prepareForwardSite(request, response, PageType.SITE_FORGOTPASSWORD_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String username = request.getParameter("username");
			
			UserDAO dao = new UserDAO();
			User user = dao.findByUsernameAndEmail(username, emailAddress);
			
			if(user == null) {
				request.setAttribute("error", "Username or email are incorrect");
			}else {
				Email email = new Email();
				email.setFrom("truongpvpd05497@fpt.edu.vn");
				email.setFromPassword("10042001");
				email.setTo(emailAddress);
				email.setSubject("Forgot Password Funtion");
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append("<br>");
				
				
				sb.append("You are used the forgot password funtion <br> ");
				sb.append("Your password is <b> ").append(user.getPassword()).append("</b>");
				sb.append("Regards <br>");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				request.setAttribute("message", "Email sent to the email Address. Please check and get your password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareForwardSite(request, response, PageType.SITE_FORGOTPASSWORD_PAGE);
	}

}
