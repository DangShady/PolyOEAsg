package fpt.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import fpt.edu.common.PageInfo;
import fpt.edu.common.PageType;
import fpt.edu.common.SessionUtils;
import fpt.edu.dao.UserDAO;
import fpt.edu.domain.ChangePasswordForm;

@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//lấy tên người dùng đăng nhập từ request
		String username = SessionUtils.getLoginedUsername(request);
		
		request.setAttribute("name",username);
		
		if (username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}

		request.setAttribute("username", username);
		PageInfo.prepareForwardSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = SessionUtils.getLoginedUsername(request);
			
			ChangePasswordForm form = new ChangePasswordForm();
			BeanUtils.populate(form, request.getParameterMap());
			
			request.setAttribute("username", username);
			
			if(!form.getConfirmPassword().equals(form.getPassword())) {
				request.setAttribute("error", "New password and new confirm password are not identical !");
			}else {
				UserDAO dao = new UserDAO();
				dao.changePassword(form.getUsername(), form.getCurrentPassword(), form.getPassword());
				request.setAttribute("message", "Password has been changed !");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareForwardSite(request, response, PageType.SITE_CHANGEPASSWORD_PAGE);
	}

}
