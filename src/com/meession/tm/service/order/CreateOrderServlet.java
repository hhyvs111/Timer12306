package com.meession.tm.service.order;

import java.io.IOException;
import java.sql.Date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.am.entity.Route;
import com.meession.common.DAOFactory;
import com.meession.tm.dao.OrderDAO;
import com.meession.tm.entity.Order;
import com.meession.um.dao.UserDAO;
import com.meession.um.entity.User;

/**
 * Servlet implementation class CreateOrderServlet
 */
public class CreateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(); 
		String username = (String) session.getAttribute("user");
	    System.out.println(username);
		if(username == null )
			System.out.println("请先登录");
		else{
			
			//String routeId = request.getParameter("routeId");
			String seatType = request.getParameter("seatType");
			String password = request.getParameter("password");
		    Route route = (Route) session.getAttribute("route");
		    User user = (User) session.getAttribute("User");
//		    System.out.println(departureTime);
		    System.out.println(seatType + " "+password+ " ");
		    System.out.println(user.getPassword());
		    System.out.println(user.getName());
		    if(user.getPassword().equals(password))
		    {
//		    	Date now = new Date();
//			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//			java.util.Date timeDate = null; 
//			try { 
//			timeDate = sdf.format(now); 
//			} catch (ParseException e) { 
//			e.printStackTrace(); 
//			}
			//java.sql.Date departureTime = new java.sql.Date(timeDate.getTime());
			
			String status = "待付款";
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			
			java.sql.Timestamp createDate= new java.sql.Timestamp(System.currentTimeMillis());
			//System.out.println(sdf.parse(sdf.format(createDate)));
//			System.out.println(departureTime);
			int userId = user.getId();
			Long userid =(long)userId;
			System.out.println(user.getId());
			OrderDAO  orderDao = DAOFactory.getIOrderDAOInstance();
			Order order = new Order();
			order.setStatus(status);
			order.setCreateDate(createDate);
			order.setLastUpdateDate(createDate);
			order.setUserId(userid);
			order.setRouteId(route.getId());
			
			try {
				orderDao.doCreateOrder(order);
				OrderDAO  orderDao1 = DAOFactory.getIOrderDAOInstance();
				order = orderDao1.findByMaxOrderId();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			session.setAttribute("orderId",order.getId() ); //可能获取空的ID
//			session.setAttribute("routeName", routeName);
//			session.setAttribute("trainType", trainType);
			session.setAttribute("seatType", seatType);
//			session.setAttribute("price", price);
//			session.setAttribute("departureTime", departureTime);
//			request.setAttribute("a","aaa132");
			RequestDispatcher rd = request.getRequestDispatcher("CreateTicketServlet");
			rd.forward(request, response);
		}
		    else{
				System.out.println("密码错误");
				response.sendRedirect("errorpass.jsp");
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
