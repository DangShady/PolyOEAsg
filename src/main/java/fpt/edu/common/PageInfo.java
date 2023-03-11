package fpt.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInfo {
	public static Map<PageType, PageInfo> pageRoute = new HashMap();
		
	static {
		pageRoute.put(PageType.USER_MANAGERMENT_PAGE, new PageInfo("User Managerment", "/admin/users/users.jsp", null));
		pageRoute.put(PageType.REPORT_MANAGERMENT_PAGE, new PageInfo("Reports", "/admin/reports/reports.jsp", null));
		pageRoute.put(PageType.VIDEO_MANAGERMENT_PAGE, new PageInfo("Video Managerment", "/admin/videos/videos.jsp", null));
		
		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("Home", "/sites/home/home.jsp", null));
		pageRoute.put(PageType.SITE_LOGIN_PAGE, new PageInfo("Login", "/sites/users/login.jsp", null));
		pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("Registration", "/sites/users/registration.jsp", null));
		
		pageRoute.put(PageType.SITE_CHANGEPASSWORD_PAGE, new PageInfo("Change Password", "/sites/users/changePassword.jsp", null));
		pageRoute.put(PageType.SITE_FORGOTPASSWORD_PAGE, new PageInfo("Forgot Password", "/sites/users/forgotPassword.jsp", null));
		pageRoute.put(PageType.SITE_EDITPROFILE_PAGE, new PageInfo("Edit Profile", "/sites/users/editProfile.jsp", null));
		
		pageRoute.put(PageType.SITE_VIDEO_DETAIL_PAGE, new PageInfo("Video Detail", "/sites/videos/detail.jsp", null));
		pageRoute.put(PageType.SITE_VIDEO_FAVORITE_PAGE, new PageInfo("Favorite", "/sites/videos/favorite.jsp", null));
		pageRoute.put(PageType.SITE_VIDEO_SHARE_PAGE, new PageInfo("Share", "/sites/videos/share.jsp", null));
		
		pageRoute.put(PageType.SITE_VIDEO_SEARCH_PAGE, new PageInfo("Search", "/sites/videos/searchVideo.jsp", null));
	}
	
	public static void prepareForward(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
	}
	
	public static void prepareForwardSite(HttpServletRequest request, HttpServletResponse response, PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		
		request.setAttribute("page", page);
		request.getRequestDispatcher("/sites/layout.jsp").forward(request, response);
	}
	private String title;
	private String contentUrl;
	private String scriptUrl;
	
	public PageInfo(String title, String contentUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contentUrl = contentUrl;
		this.scriptUrl = scriptUrl;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContentUrl() {
		return contentUrl;
	}
	public void setContentUrl(String contentUrl) {
		this.contentUrl = contentUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
	
	
	
}
