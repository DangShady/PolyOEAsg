package fpt.edu.servlet;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import fpt.edu.common.PageInfo;
import fpt.edu.common.PageType;
import fpt.edu.common.SessionUtils;
import fpt.edu.common.UploadUtils;
import fpt.edu.dao.VideoDAO;
import fpt.edu.model.Video;

@MultipartConfig
@WebServlet({ "/VideoManagerment", "/VideoManagerment/create", "/VideoManagerment/update", "/VideoManagerment/delete",
		"/VideoManagerment/edit", "/VideoManagerment/reset" })
public class VideoManagermentServlet extends HttpServlet {
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

		Video video = new Video();
		video.setPoster("images/logovideo.jpg");

		findAll(request, response);
		request.setAttribute("video", video);
		
		PageInfo.prepareForward(request, response, PageType.VIDEO_MANAGERMENT_PAGE);
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

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("videoId");

		if (id == null) {
			request.setAttribute("error", "Video id is required!");
			PageInfo.prepareForward(request, response, PageType.VIDEO_MANAGERMENT_PAGE);
			return;
		}

		try {
			VideoDAO dao = new VideoDAO();
			Video video = dao.findById(id);

			request.setAttribute("video", video);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}

		PageInfo.prepareForward(request, response, PageType.VIDEO_MANAGERMENT_PAGE);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Video video = new Video();

		try {
			BeanUtils.populate(video, request.getParameterMap());

			VideoDAO dao = new VideoDAO();
			Video oldVideo = dao.findById(video.getVideoId());

			if (request.getPart("cover").getSize() == 0) {
				video.setPoster(oldVideo.getPoster());
			} else {
				video.setPoster(
						"uploads/" + UploadUtils.procesUploadField("cover", request, "/uploads", video.getVideoId()));
			}

			dao.update(video);

			request.setAttribute("video", video);
			findAll(request, response);
			request.setAttribute("message", "Video is updated!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareForward(request, response, PageType.VIDEO_MANAGERMENT_PAGE);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {

		try {
			VideoDAO dao = new VideoDAO();

			List<Video> list = dao.findAll();

			request.setAttribute("videos", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Video video = new Video();

		try {
			BeanUtils.populate(video, request.getParameterMap());

			video.setPoster(
					"uploads/" + UploadUtils.procesUploadField("cover", request, "/uploads", video.getVideoId()));

			VideoDAO dao = new VideoDAO();
			dao.insert(video);

			request.setAttribute("video", video);
			request.setAttribute("message", "Video is inserted!!!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		findAll(request, response);
		PageInfo.prepareForward(request, response, PageType.VIDEO_MANAGERMENT_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("videoId");

		if (id == null) {
			request.setAttribute("error", "Video id is required!");
			PageInfo.prepareForward(request, response, PageType.VIDEO_MANAGERMENT_PAGE);
			return;
		}
		
		try {
			VideoDAO dao = new VideoDAO();
			Video video = dao.findById(id);

			if (video == null) {
				request.setAttribute("error", "Video id not found!");
				PageInfo.prepareForward(request, response, PageType.VIDEO_MANAGERMENT_PAGE);
				return;
			}

			dao.delete(id);
			request.setAttribute("message", "Video is deleted!");
			request.setAttribute("video", new Video());

			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Error: " + e.getMessage());
		}
		PageInfo.prepareForward(request, response, PageType.VIDEO_MANAGERMENT_PAGE);
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		video.setPoster("images/poster.jpg");
		video.setActive(true);
		request.setAttribute("video", video);
		findAll(request, response);
		
		PageInfo.prepareForward(request, response, PageType.VIDEO_MANAGERMENT_PAGE);
	}

}
