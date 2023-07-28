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

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		VideoDAO dao = new VideoDAO();

		String username = SessionUtils.getLoginedUsername(request);
		request.setAttribute("name", username);

		fillVideoDetail(request, response);

		try {


			String indexPage = request.getParameter("index");
			if(indexPage == null) {
				indexPage = "1" ;
			}
			int index = Integer.parseInt(indexPage);
			
			long count = dao.countVideo();
			
			long endPage = count/8;
			if(count % 8 !=0) {
				endPage++;
			}
			List<Video> list = dao.fillVideoInPage(index);
			
			request.setAttribute("videos", list);
			
			request.setAttribute("endPage", endPage);

		} catch (Exception e) {
			e.printStackTrace();

			request.setAttribute("error", e.getMessage());
		}
		PageInfo.prepareForwardSite(request, response, PageType.SITE_HOME_PAGE);
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
}
