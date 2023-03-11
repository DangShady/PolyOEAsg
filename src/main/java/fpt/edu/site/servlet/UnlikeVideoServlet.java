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
import fpt.edu.dao.FavoriteDAO;
import fpt.edu.model.Favorite;


@WebServlet("/UnlikeVideo")
public class UnlikeVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int favoriteId = Integer.parseInt(request.getParameter("favoriteId")); 
		System.out.println(favoriteId);

		
		try {
			
			
			FavoriteDAO dao = new FavoriteDAO();
			
			
			dao.delete(favoriteId);
			
			response.sendRedirect("Favorite");
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo.prepareForwardSite(request, response, PageType.SITE_VIDEO_FAVORITE_PAGE);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
