package fpt.edu.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.edu.common.PageInfo;
import fpt.edu.common.PageType;
import fpt.edu.common.SessionUtils;
import fpt.edu.dao.FavoriteDAO;
import fpt.edu.model.Favorite;
import fpt.edu.model.User;
import fpt.edu.model.Video;


@WebServlet("/LikeVideo")
public class LikeVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		
		//lấy giá trị các tham số đc truyền vào từ request
		String page = request.getParameter("page");
		String videoId = request.getParameter("videoId");
	
		if(videoId == null) {
			response.sendRedirect("Home");
			return;
		}
		
		try {
			FavoriteDAO dao = new FavoriteDAO();
			Favorite favorite = new Favorite();
			Video video = new Video();
			video.setVideoId(videoId);
			favorite.setVideo(video);
			
			//thiết lập tt ngườu dùng và ngày vào favorite
			String username = SessionUtils.getLoginedUsername(request);
			User user = new User();
			user.setUsername(username);
			favorite.setUser(user);
			
			favorite.setLikedDate(new Date());
			
			dao.insert(favorite);
			
			request.setAttribute("message", "Video is added to favorite");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		if(page == null) {
			page = "Home";
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
