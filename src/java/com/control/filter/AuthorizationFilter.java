/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.control.filter;

/**
 *
 * @author padagoal
 */
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "/*" })
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			/*String reqURI = reqt.getRequestURI();
			if (reqURI.indexOf("/index.jsp") >= 0
					|| reqURI.indexOf("/IS2/ValidarServlet") >= 0
                              ||   (ses != null && ses.getAttribute("usuario") != null))*/
				chain.doFilter(request, response);
			/*else
				  request.getRequestDispatcher("ErrorServlet").forward(request, response);*/
		} catch (Exception e) {
			System.out.println(e.getMessage());
                          request.getRequestDispatcher("ErrorServlet").forward(request, response);
		}
	}

	@Override
	public void destroy() {

	}
}
