package com.meession.um.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.common.DAOFactory;
import com.meession.um.dao.UserDAO;
import com.meession.um.entity.User;

/**
 * Servlet implementation class ChangePasswordServlet
 */
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String phoneNumber = request.getParameter("phoneNumber");
		//String mail = request.getParameter("mail");
//		String name = request.getParameter("name");
		String npassword = request.getParameter("npassword");
		
		String username = request.getParameter("username");
		System.out.println(npassword+" "+phoneNumber+ " "+ username);
	
		
		UserDAO userDao = DAOFactory.getIUserDAOInstance();
		
		User user = null;
		try {
			user = userDao.findById(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(user.getPhoneNumber());
		if(user.getPhoneNumber().equals(phoneNumber))  
		{
			
			user.setPassword(npassword);
			try {
				UserDAO userDao1 = DAOFactory.getIUserDAOInstance();
				userDao1.doUpdate(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("修改成功"+user.getPassword());
		}
		else
			System.out.println("手机号错误");
			
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
