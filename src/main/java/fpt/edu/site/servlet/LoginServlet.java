package fpt.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import fpt.edu.common.CookieUtils;
import fpt.edu.common.PageInfo;
import fpt.edu.common.PageType;
import fpt.edu.common.SessionUtils;
import fpt.edu.dao.UserDAO;
import fpt.edu.domain.LoginForm;
import fpt.edu.model.User;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = CookieUtils.get("username", request);

		if (username == null) {
			PageInfo.prepareForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
			return;
		}
		SessionUtils.add(request, "username", username);


		request.getRequestDispatcher("/Login").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();

			BeanUtils.populate(form, request.getParameterMap());

			UserDAO dao = new UserDAO();
			User user = dao.findById(form.getUsername());

			if (user != null && user.getPassword().equals(form.getPassword())) {
				SessionUtils.add(request, "username", user.getUsername());

				if (form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, response);
				} else {
					CookieUtils.add("username", form.getUsername(), 0, response);
				}

				request.setAttribute("isLogin", true);
				
				
				
				if (user.getAdmin() == true) {
				
					response.sendRedirect("HomeAdmin");
				} else {
				
					response.sendRedirect("Home");
				}

				return;
			}

			request.setAttribute("error", "Invalid f or password");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareForwardSite(request, response, PageType.SITE_LOGIN_PAGE);
	}

}
