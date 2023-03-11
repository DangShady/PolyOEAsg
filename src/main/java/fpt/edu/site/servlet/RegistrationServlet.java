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
import fpt.edu.dao.UserDAO;
import fpt.edu.model.User;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PageInfo.prepareForwardSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());;
			
			UserDAO dao = new UserDAO();
			dao.insert(user);
				
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.setAttribute("user", user);
		PageInfo.prepareForwardSite(request, response, PageType.SITE_REGISTRATION_PAGE);
	}

}
