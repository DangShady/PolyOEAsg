package fpt.edu.servlet;

import java.io.IOException;
import java.util.List;

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

import fpt.edu.model.User;

@WebServlet({ "/UsersManagerment", "/UsersManagerment/create", "/UsersManagerment/update", "/UsersManagerment/delete",
		"/UsersManagerment/edit", "/UsersManagerment/reset" })
public class UsersManagermentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = SessionUtils.getLoginedUsername(request);
		request.setAttribute("name",username);
		
		String url = request.getRequestURI().toString();

		if (url.contains("edit")) {
			edit(request, response);
			return;
		} else if (url.contains("delete")) {
			delete(request, response);
			return;
		} else if (url.contains("reset")) {
			reset(request, response);
			return;
		}

		User user = new User();
		request.setAttribute("user", user);
		findAll(request, response);
		PageInfo.prepareForward(request, response, PageType.USER_MANAGERMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURI().toString();

		if (url.contains("create")) {
			create(request, response);
			return;
		} else if (url.contains("delete")) {
			delete(request, response);
			return;
		} else if (url.contains("update")) {
			update(request, response);
			return;
		} else if (url.contains("reset")) {
			reset(request, response);
			return;
		}
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			UserDAO dao = new UserDAO();

			List<User> list = dao.findAll();

			request.setAttribute("users", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();

		request.setAttribute("user", user);
		findAll(request, response);

		PageInfo.prepareForward(request, response, PageType.USER_MANAGERMENT_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("username");

		if (id == null) {
			request.setAttribute("error", "User id is required!");
			PageInfo.prepareForward(request, response, PageType.USER_MANAGERMENT_PAGE);
			return;
		}

		try {
			UserDAO dao = new UserDAO();
			User user = dao.findById(id);

			if (user == null) {
				request.setAttribute("error", "User id not found!");
				PageInfo.prepareForward(request, response, PageType.USER_MANAGERMENT_PAGE);
				return;
			}

			dao.delete(id);
			request.setAttribute("message", "User is deleted!");
			request.setAttribute("user", new User());

			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareForward(request, response, PageType.USER_MANAGERMENT_PAGE);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");

		if (username == null) {
			request.setAttribute("error", "User id is required!");
			PageInfo.prepareForward(request, response, PageType.USER_MANAGERMENT_PAGE);
			return;
		}

		try {
			UserDAO dao = new UserDAO();
			User user = dao.findById(username);

			request.setAttribute("user", user);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}

		PageInfo.prepareForward(request, response, PageType.USER_MANAGERMENT_PAGE);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();

		try {
			BeanUtils.populate(user, request.getParameterMap());

			UserDAO dao = new UserDAO();
			
			//truy vấn đến csdl
			User oldUser = dao.findById(user.getUsername());

			dao.update(user);

			request.setAttribute("user", user);
			findAll(request, response);
			request.setAttribute("message", "User is updated!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareForward(request, response, PageType.USER_MANAGERMENT_PAGE);

	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();

		try {
			BeanUtils.populate(user, request.getParameterMap());

			UserDAO dao = new UserDAO();
			dao.insert(user);

			request.setAttribute("user", user);
			request.setAttribute("message", "User is inserted!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		findAll(request, response);
		PageInfo.prepareForward(request, response, PageType.USER_MANAGERMENT_PAGE);

	}

}
