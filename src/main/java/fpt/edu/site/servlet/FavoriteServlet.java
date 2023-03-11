package fpt.edu.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.edu.common.PageInfo;
import fpt.edu.common.PageType;
import fpt.edu.common.SessionUtils;
import fpt.edu.dao.FavoriteDAO;
import fpt.edu.domain.FavoriteReport;
import fpt.edu.domain.Myfavorites;

@WebServlet("/Favorite")
public class FavoriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String username = SessionUtils.getLoginedUsername(request);
		request.setAttribute("name",username);
		
		if(!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		
		fillFavoritesVideo(request, response);
		PageInfo.prepareForwardSite(request, response, PageType.SITE_VIDEO_FAVORITE_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void fillFavoritesVideo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String username = SessionUtils.getLoginedUsername(request);
			
			FavoriteDAO dao = new FavoriteDAO();
			
			List<Myfavorites> list = dao.MyfavoriteVideo(username);
			
			request.setAttribute("favList", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
}
