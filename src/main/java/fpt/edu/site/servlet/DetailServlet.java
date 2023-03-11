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
import fpt.edu.dao.VideoDAO;
import fpt.edu.model.Video;

@WebServlet("/Detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		fillVideoDetail(request, response);
		String username = SessionUtils.getLoginedUsername(request);
		request.setAttribute("name",username);
		
		
		String value = request.getParameter("videoId");
		
		VideoDAO dao = new VideoDAO();
		Video video = dao.findById(value);
		
		request.setAttribute("videos", video);
		
		PageInfo.prepareForwardSite(request, response, PageType.SITE_VIDEO_DETAIL_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void fillVideoDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			VideoDAO dao = new VideoDAO();
			List<Video> list = dao.findAll();
			
			request.setAttribute("videoDetail", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
