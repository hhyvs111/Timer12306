package com.meession.tm.service.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.common.DAOFactory;
import com.meession.tm.dao.OrderDAO;
import com.meession.tm.entity.Order;

/**
 * Servlet implementation class QueryOrderByUserServlet
 */
public class QueryOrderByUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryOrderByUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(); 
		String username = (String) session.getAttribute("user");
		String admin = (String) session.getAttribute("admin");
		System.out.println(username);
		if(username == null )
		{
			System.out.println("请先登录");
			response.sendRedirect("Login.jsp");
		}
		else{
			
			OrderDAO orderDao = DAOFactory.getIOrderDAOInstance();
			List<Order> list = new ArrayList<Order>();
			try {
				list = orderDao.findByUserName(username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(list.size());
			for(int i = 0 ;i < list.size();i++)
				System.out.println(list.get(i));
			request.setAttribute("list", list);
			request.getRequestDispatcher("UserOrder.jsp").forward(request, response);
			
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
