package com.meession.um.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.common.DAOFactory;
import com.meession.um.dao.UserDAO;
import com.meession.um.dao.impl.UserImpl;
import com.meession.um.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("user");
//		String admin = (String) session.getAttribute("admin");
		//session.invalidate();
		if(userName== username)   //重复登陆
		{
			System.out.println("您已登陆，请勿重复登陆");
			response.sendRedirect("UserMain.jsp");
		}
		
		else
		{
		
		System.out.println(username+ "   "+password);
		UserDAO userDao = DAOFactory.getIUserDAOInstance();
		User user = new User();
		
	    System.out.println(username + " "+password);
		try {
			user = userDao.findById(username);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
			if(user == null)
				request.getRequestDispatcher("loginError.jsp").forward(request, response);
		//System.out.println(user.getUsername()+ " "+ user.getPassword());
			else if(username.equals(user.getUsername())&&password.equals(user.getPassword()))
            {
            	if(username.equals("admin")){
            		session.setAttribute("admin", username);
            		response.sendRedirect("admin.jsp");
            		//跳转到管理员界面
            	}// 如果是管理员登陆则存储到session
            	else
            		{
            		 session.setAttribute("user",username);
            		 session.setAttribute("userId", user.getId());
            		 session.setAttribute("User", user);
            		 // 如果是用户则存储用户名到session
            		 response.sendRedirect("My12306.jsp");
            		}
            	
            
            }
            else
            	{request.setAttribute("message", "失败");
            request.getRequestDispatcher("loginError.jsp").forward(request, response);
            	}
		}
	}

		// TODO Auto-generated method stub
		//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
			}

}
