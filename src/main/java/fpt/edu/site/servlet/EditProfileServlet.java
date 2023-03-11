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
import fpt.edu.model.User;

@WebServlet("/EditProfile")
public class EditProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		
		request.setAttribute("name",username);
		if(username == null) {
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		try {
			UserDAO dao = new UserDAO();
			User user = dao.findById(username);
			
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareForwardSite(request, response, PageType.SITE_EDITPROFILE_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			String username = SessionUtils.getLoginedUsername(request);
			UserDAO dao = new UserDAO();
			User oldUser = dao.findById(username);
			
			user.setAdmin(oldUser.getAdmin());
			dao.update(user);
			request.setAttribute("message", "User profile update!!");
			
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareForwardSite(request, response, PageType.SITE_EDITPROFILE_PAGE);
	}

}
