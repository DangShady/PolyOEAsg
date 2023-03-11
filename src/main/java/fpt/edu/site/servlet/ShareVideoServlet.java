package fpt.edu.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.edu.common.EmailUtils;
import fpt.edu.common.PageInfo;
import fpt.edu.common.PageType;
import fpt.edu.common.SessionUtils;
import fpt.edu.dao.ShareDAO;
import fpt.edu.domain.Email;
import fpt.edu.model.Share;
import fpt.edu.model.User;
import fpt.edu.model.Video;

@WebServlet("/ShareVideo")
public class ShareVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtils.getLoginedUsername(request);
		request.setAttribute("name", username);

		if (!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}

		String videoId = request.getParameter("videoId");

		if (videoId == null) {
			response.sendRedirect("Home");
			return;
		}
		request.setAttribute("videoId", videoId);
		PageInfo.prepareForwardSite(request, response, PageType.SITE_VIDEO_SHARE_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String videoId = request.getParameter("videoId");

			if (videoId == null) {
				request.setAttribute("error", "VideoID is null!!");

			} else {
				Email email = new Email();
				email.setFrom("truongpvpd05497@fpt.edu.vn");
				email.setFromPassword("10042001");
				email.setTo(emailAddress);
				email.setSubject("Share Favorite Video");

				StringBuilder sb = new StringBuilder();
				sb.append("Dear ");

				sb.append("The video is more interesting and i want to share with you");
				sb.append("Please click the link ").append(String.format("a href=''>View Video</a>", videoId));
				sb.append("Regards");
				sb.append("Administrator");

				email.setContent(sb.toString());
				EmailUtils.send(email);

				ShareDAO dao = new ShareDAO();
				Share share = new Share();
				share.setEmails(emailAddress);
				share.setSharedDate(new Date());

				String username = SessionUtils.getLoginedUsername(request);
				User user = new User();
				user.setUsername(username);
				share.setUser(user);
				Video video = new Video();

				video.setVideoId(videoId);

				share.setVideo(video);
				System.out.println(username);
				System.out.println(videoId);
				dao.insert(share);
				request.setAttribute("message", "video link has been sent");
				
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		PageInfo.prepareForwardSite(request, response, PageType.SITE_VIDEO_SHARE_PAGE);

	}

}
