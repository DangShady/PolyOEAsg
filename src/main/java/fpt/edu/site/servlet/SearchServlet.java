package fpt.edu.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.edu.common.PageInfo;
import fpt.edu.common.PageType;
import fpt.edu.common.SessionUtils;
import fpt.edu.dao.JpaUtils;
import fpt.edu.dao.VideoDAO;


import fpt.edu.model.Video;



@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private EntityManager em = JpaUtils.getEntityManager();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = SessionUtils.getLoginedUsername(request);
		request.setAttribute("name",username);
		try {
			String keyword = request.getParameter("keyword");
			
			VideoDAO dao = new VideoDAO();
			List<Video> list = dao.findAllVideoByTitle(keyword);
			
			request.setAttribute("videos", list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PageInfo.prepareForwardSite(request, response, PageType.SITE_VIDEO_SEARCH_PAGE);
	}

	
	
}
