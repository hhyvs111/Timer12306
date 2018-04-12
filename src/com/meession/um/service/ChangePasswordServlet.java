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
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ppassword = request.getParameter("ppassword");
		String npassword = request.getParameter("npassword");
		HttpSession session = request.getSession(); 
		String username = (String) session.getAttribute("user");
		System.out.println(username+ " "+ ppassword+ " "+ npassword);
		if(username == null)
		{
			System.out.println("请先登录");
			response.sendRedirect("userlogin.html");
		}
		else
		{
//		System.out.println(username);
		
		UserDAO userDao = DAOFactory.getIUserDAOInstance();
		
		User user = null;
		try {
			user = userDao.findById(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user.getPassword().equals(ppassword))  //�������ƥ�����޸�����
		{
			UserDAO userDao1 = DAOFactory.getIUserDAOInstance();
			user.setPassword(npassword);
			try {
				userDao1.doUpdate(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("密码修改成功"+user.getPassword());
			request.getRequestDispatcher("ChangePassSuccess.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("ChangePasswordError.jsp").forward(request, response);
			System.out.println("原始密码错误");
		}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
