package com.meession.um.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.common.DAOFactory;
import com.meession.um.dao.UserDAO;
import com.meession.um.entity.User;

/**
 * Servlet implementation class QueryUserInfoServlet
 */
public class QueryUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryUserInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		List<User> list = new ArrayList<User>();
		HttpSession session = request.getSession(); 
		String username = (String) session.getAttribute("user");
		String admin = (String) session.getAttribute("admin");
		if(username == null || admin == null)
			System.out.println("请先登录");
		else{
		UserDAO userDao = DAOFactory.getIUserDAOInstance();
		User user = new User();
		try {
			user= userDao.findById(username);
			//list = userDao.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for(int i=0;i<list.size();i++)
//			System.out.println(list.get(i));
//		request.setAttribute("List", list);
		request.setAttribute("user", user);
//		request.setAttribute("a","aaa132");
		RequestDispatcher rd = request.getRequestDispatcher("UserInfo.jsp");
		rd.forward(request, response);
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
