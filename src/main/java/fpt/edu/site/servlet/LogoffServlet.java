package fpt.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fpt.edu.common.CookieUtils;
import fpt.edu.common.PageInfo;
import fpt.edu.common.PageType;
import fpt.edu.common.SessionUtils;


@WebServlet("/Logoff")
public class LogoffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CookieUtils.add("username", null, 0, response);
		
		request.setAttribute("isLogin", false);
		SessionUtils.invalidate(request);
		request.getRequestDispatcher("/Home").forward(request, response);
//		PageInfo.prepareForwardSite(request, response, PageType.SITE_HOME_PAGE);
	}

}
