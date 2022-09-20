package com.sshmanager.ssh.common.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// �α��ε� ��ä�� �ƴϸ� �α��� modalâ�� ���
		HttpSession session = request.getSession(true);
		Object userSession = session.getAttribute("userSession");

		if (userSession == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter printwriter = response.getWriter();
			printwriter.print("<script>$('#loginModal').modal({ keyboard: false, backdrop: 'static' });</script>");
			printwriter.flush();
			printwriter.close();
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

}
