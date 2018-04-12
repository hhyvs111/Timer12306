package com.meession.tm.service.order;

import java.io.IOException;
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
 * Servlet implementation class PayOrderServlet
 */
public class PayOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayOrderServlet() {
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
		
		if(username == null )
			System.out.println("请先登录");
		else{
			Long orderId = (Long) session.getAttribute("orderId");
			UserDAO userDao = DAOFactory.getIUserDAOInstance();
			User user = null;
			try {
				user = userDao.findById(username);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//Integer price = (Integer)session.getAttribute("price");
			Route route = (Route) session.getAttribute("route");
			String seatType = (String) session.getAttribute("seatType");
			if(seatType.equals("商务座")&&user.getBalance()>=route.getbPrice())
			{
				OrderDAO orderDao = DAOFactory.getIOrderDAOInstance();
				
				Order order = new Order();
				 try {
					order = orderDao.findByOrderId(orderId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Timestamp lastUpdateDate = new java.sql.Timestamp(System.currentTimeMillis());
				java.sql.Timestamp payDate = new java.sql.Timestamp(System.currentTimeMillis());
				 order.setStatus("已付款");
				 order.setPayTime(payDate);
				 order.setLastUpdateDate(lastUpdateDate);
				 order.setPrice(route.getbPrice());
				 int balance =user.getBalance() - route.getbPrice();
				 System.out.println(balance);
				 user.setBalance(balance);
				 UserDAO userDao1 = DAOFactory.getIUserDAOInstance();
				 try {
					userDao1.doUpdate(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 OrderDAO orderDao1 = DAOFactory.getIOrderDAOInstance();
				 try {
					orderDao1.doUpdateOrder(order);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 session.removeAttribute("route");
				 session.removeAttribute("seatType");
				 request.getRequestDispatcher("BuySuccess.jsp").forward(request, response);
				
			}
			else if(seatType.equals("特等座")&&user.getBalance()>=route.getSpPrice())
			{
				OrderDAO orderDao = DAOFactory.getIOrderDAOInstance();
				
				Order order = new Order();
				 try {
					order = orderDao.findByOrderId(orderId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Timestamp lastUpdateDate = new java.sql.Timestamp(System.currentTimeMillis());
				java.sql.Timestamp payDate = new java.sql.Timestamp(System.currentTimeMillis());
				 order.setStatus("已付款");
				 order.setPayTime(payDate);
				 order.setLastUpdateDate(lastUpdateDate);
				 order.setPrice(route.getSpPrice());
				 int balance =user.getBalance() -route.getSpPrice();
				 user.setBalance(balance);
				 UserDAO userDao1 = DAOFactory.getIUserDAOInstance();
				 try {
					userDao1.doUpdate(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 OrderDAO orderDao1 = DAOFactory.getIOrderDAOInstance();
				 try {
					orderDao1.doUpdateOrder(order);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 session.removeAttribute("route");
				 session.removeAttribute("seatType");
				 request.getRequestDispatcher("BuySuccess.jsp").forward(request, response);
			}
			else if(seatType.equals("软座")&&user.getBalance()>=route.getSfPrice())
			{
				OrderDAO orderDao = DAOFactory.getIOrderDAOInstance();
				
				Order order = new Order();
				 try {
					order = orderDao.findByOrderId(orderId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Timestamp lastUpdateDate = new java.sql.Timestamp(System.currentTimeMillis());
				java.sql.Timestamp payDate = new java.sql.Timestamp(System.currentTimeMillis());
				 order.setStatus("已付款");
				 order.setPayTime(payDate);
				 order.setLastUpdateDate(lastUpdateDate);
				 order.setPrice(route.getSfPrice());
				 int balance =user.getBalance() -route.getSfPrice();
				 user.setBalance(balance);
				 UserDAO userDao1 = DAOFactory.getIUserDAOInstance();
				 try {
					userDao1.doUpdate(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 OrderDAO orderDao1 = DAOFactory.getIOrderDAOInstance();
				 try {
					orderDao1.doUpdateOrder(order);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				 session.removeAttribute("route");
				 session.removeAttribute("seatType");
				 request.getRequestDispatcher("BuySuccess.jsp").forward(request, response);
			}
			else if(seatType.equals("硬座")&&user.getBalance()>=route.gethPrice())
			{
				OrderDAO orderDao = DAOFactory.getIOrderDAOInstance();
				
				Order order = new Order();
				 try {
					order = orderDao.findByOrderId(orderId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Timestamp lastUpdateDate = new java.sql.Timestamp(System.currentTimeMillis());
				java.sql.Timestamp payDate = new java.sql.Timestamp(System.currentTimeMillis());
				 order.setStatus("已付款");
				 order.setPayTime(payDate);
				 order.setLastUpdateDate(lastUpdateDate);
				 order.setPrice(route.gethPrice());
				 int balance =user.getBalance() -route.gethPrice();
				 user.setBalance(balance);
				 UserDAO userDao1 = DAOFactory.getIUserDAOInstance();
				 try {
					userDao1.doUpdate(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 OrderDAO orderDao1 = DAOFactory.getIOrderDAOInstance();
				 try {
					orderDao1.doUpdateOrder(order);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				 session.removeAttribute("route");
				 session.removeAttribute("seatType");
				 request.getRequestDispatcher("BuySuccess.jsp").forward(request, response);
			}
			else if(seatType.equals("无座")&&user.getBalance()>=route.getnPrice())
			{
				OrderDAO orderDao = DAOFactory.getIOrderDAOInstance();
				
				Order order = new Order();
				 try {
					order = orderDao.findByOrderId(orderId);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				java.sql.Timestamp lastUpdateDate = new java.sql.Timestamp(System.currentTimeMillis());
				java.sql.Timestamp payDate = new java.sql.Timestamp(System.currentTimeMillis());
				 order.setStatus("已付款");
				 order.setPayTime(payDate);
				 order.setLastUpdateDate(lastUpdateDate);
				 order.setPrice(route.getnPrice());
				 int balance =user.getBalance() -route.getnPrice();
				 user.setBalance(balance);
				 UserDAO userDao1 = DAOFactory.getIUserDAOInstance();
				 try {
					userDao1.doUpdate(user);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 OrderDAO orderDao1 = DAOFactory.getIOrderDAOInstance();
				 try {
					orderDao1.doUpdateOrder(order);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				
				 session.removeAttribute("route");
				 session.removeAttribute("seatType");
				 request.getRequestDispatcher("BuySuccess.jsp").forward(request, response);
			}
			else
			{
				System.out.println("余额不足");
				request.getRequestDispatcher("BuyError.jsp").forward(request, response);
				
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
