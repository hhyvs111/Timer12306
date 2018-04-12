package com.meession.tm.service.ticket;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.common.DAOFactory;
import com.meession.tm.dao.OrderDAO;
import com.meession.tm.dao.TicketDAO;
import com.meession.tm.entity.Order;
import com.meession.tm.entity.Ticket;
import com.meession.um.dao.UserDAO;
import com.meession.um.entity.User;

/**
 * Servlet implementation class RefundTicketServlet
 */
public class RefundTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundTicketServlet() {
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
		User user = (User) session.getAttribute("User");
		if(username == null )
			System.out.println("请先登录");
		else{
			String ticketId = request.getParameter("ticketId");
			Long ticketid = Long.parseLong(ticketId);
			String orderId = request.getParameter("orderId");
			Long orderid = Long.parseLong(orderId);
			
			String price = request.getParameter("price");
			Integer Price = Integer.parseInt(price);
			System.out.println(ticketid+ "   " +  orderid+"   "+price);
			TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();
			try {
				if(ticketDao.doDeleteTicket(ticketid))
				{
					int balance = user.getBalance();
					int nbalance = balance + Price;
					user.setBalance(nbalance);
					UserDAO UserDao = DAOFactory.getIUserDAOInstance();
					if(UserDao.doUpdate(user))
					{
						System.out.println("余额返回");
						OrderDAO OrderDao = DAOFactory.getIOrderDAOInstance();
						Order order = new Order();
						order = OrderDao.findByOrderId(orderid);
						System.out.println(order);
						java.sql.Timestamp lastUpdateDate= new java.sql.Timestamp(System.currentTimeMillis());
						order.setLastUpdateDate(lastUpdateDate);
						order.setStatus("已取消");
						OrderDAO OrderDao1 = DAOFactory.getIOrderDAOInstance();
						if(OrderDao1.doUpdateOrder(order))
						{
							System.out.println("更新订单成功");
				            request.getRequestDispatcher("QueryTicketServlet").forward(request, response);
						}
						else
							System.out.println("更新订单失败");
					}
						
					else
						System.out.println("更新余额失败");
					
					
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
