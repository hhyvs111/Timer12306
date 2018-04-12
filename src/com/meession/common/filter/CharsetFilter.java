package com.meession.common.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharsetFilter
 */
public class CharsetFilter implements Filter {

	private String charset;

	/**
	 * Default constructor.
	 */
	public CharsetFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse rsp,
			FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) rsp;
		String method = request.getMethod();
		//get方法
		if (method.equalsIgnoreCase("get")) {
			   request=new HttpServletRequestWrapper(request){
				   /**
					 * 增强getParameter
					 */
					@Override
					public String getParameter(String name) {
						String val = super.getParameter(name);
						try {
							if(null!=val){
							     val = new String(val.getBytes("ISO-8859-1"), charset);
							}
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
						return val;
					}
			   };
			   response.setCharacterEncoding(charset);
			}
		
        //post方法
		if (method.equalsIgnoreCase("post")) {
			request.setCharacterEncoding(charset);
			response.setCharacterEncoding(charset);
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		charset = fConfig.getInitParameter("charset");
		if (null == charset | "".equals(charset)) {
			charset = "utf-8";
		}
	}

}
