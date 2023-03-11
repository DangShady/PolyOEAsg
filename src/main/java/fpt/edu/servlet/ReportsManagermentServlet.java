package fpt.edu.servlet;

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
import fpt.edu.dao.VideoDAO;
import fpt.edu.domain.FavoriteReport;
import fpt.edu.domain.FavoriteUserReport;
import fpt.edu.model.Video;

@WebServlet("/ReportsManagermentServlet")
public class ReportsManagermentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		request.setAttribute("name",username);
		
		reportFavoritesByVideos(request, response);
		reportFavoriteUsersByVideos(request, response);
		
		PageInfo.prepareForward(request, response, PageType.REPORT_MANAGERMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void reportFavoriteUsersByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String videoUserId = request.getParameter("videoUserId");
			
			VideoDAO videoDao = new VideoDAO();
			List<Video> videoList = videoDao.findAll();
			
			if(videoUserId == null && videoList.size() > 0) {
				videoUserId = videoList.get(0).getVideoId();
			}
			
			FavoriteDAO dao = new FavoriteDAO();
			List<FavoriteUserReport> list = dao.reportFavoriteUserByVideo(videoUserId);
			
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("videoList", videoList);
			request.setAttribute("favUsers", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
	
	protected void reportFavoritesByVideos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoriteDAO dao = new FavoriteDAO();
			List<FavoriteReport> list = dao.reportFavoritesByVideos();

			request.setAttribute("favList", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	protected void reportShareByUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			FavoriteDAO dao = new FavoriteDAO();
			List<FavoriteReport> list = dao.reportFavoritesByVideos();

			request.setAttribute("listShare", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}
	
}
