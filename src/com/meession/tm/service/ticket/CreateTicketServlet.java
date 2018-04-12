package com.meession.tm.service.ticket;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.am.dao.RouteDAO;
import com.meession.am.entity.Route;
import com.meession.common.DAOFactory;
import com.meession.tm.dao.OrderDAO;
import com.meession.tm.dao.TicketDAO;
import com.meession.tm.entity.Ticket;
import com.meession.um.entity.User;

/**
 * Servlet implementation class CreateTicketServlet
 */
public class CreateTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTicketServlet() {
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
		User user = (User)session.getAttribute("User");
		Long orderId = (Long)session.getAttribute("orderId"); //可能获取空的ID
		System.out.println(orderId);
//		Long routeId = (Long)session.getAttribute("routeId");  //获取车次ID
//		String routeName = (String)session.getAttribute("routeName");
//		String trainType = (String)session.getAttribute("trainType");
		Route route = (Route) session.getAttribute("route");
		String seatType = (String)session.getAttribute("seatType");
		//Integer price = (Integer)session.getAttribute("price");
		//Date departureTime =  (Date)session.getAttribute("departureTime");
		
		//TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();//
		System.out.println("      "+route.getDepartureTime());
		System.out.println(route);
		Ticket ticket = new Ticket();
		ticket.setName(user.getName());
		ticket.setRoute(route.getName());
		ticket.setRouteType(route.getType());
		ticket.setDepartureTime((Timestamp) route.getDepartureTime());
		ticket.setOrderId(orderId);
//		TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();
//		try {
//			if(ticketDao.doCreateTicket(ticket))
//				System.out.println("购票成功");
//			else
//				System.out.println("购票失败");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String from = route.getFromStation();
		String to = route.getToStation();
		ticket.setFrom(from);
		ticket.setTo(to);
		ticket.setRouteId(route.getId());
//		RouteDAO RouteDao = DAOFactory.getIRouteDAOInstance();
//		Route route = null;
//		try {
//			route = RouteDao.findOnlyRoute(routeId);
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		if(seatType.equals("商务座")&&route.getBusinessSeatCount()>0)
		{
			ticket.setSeatType(seatType);
			Integer bS = route.getBusinessSeatCount();
			Integer price = route.getbPrice();
			String seatnum = bS.toString()+"号";
			ticket.setSeatNum(seatnum);
			ticket.setPrice(price);
			RouteDAO RouteDao1 = DAOFactory.getIRouteDAOInstance();
			int bS1 = bS - 1;
			System.out.println(bS1);
			route.setBusinessSeatCount(bS1);
			try {
				RouteDao1.doUpdateRoute(route);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();
			try {
				if(ticketDao.doCreateTicket(ticket))
					System.out.println("购买成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("PayOrderServlet");
		}
		else if(seatType.equals("特等座")&&route.getSpecialSeatCount()>0)
		{
			ticket.setSeatType(seatType);
			Integer bS = route.getSpecialSeatCount();
			Integer price = route.getSpPrice();
			String seatnum = bS.toString()+"号";
			ticket.setSeatNum(seatnum);
			ticket.setPrice(price);
			RouteDAO RouteDao1 = DAOFactory.getIRouteDAOInstance();
			Integer bS1 = bS - 1;
			System.out.println(bS1);
			route.setSpecialSeatCount(bS1);
			try {
				RouteDao1.doUpdateRoute(route);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();
			try {
				ticketDao.doCreateTicket(ticket);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("PayOrderServlet");
		}
		else if(seatType.equals("软座")&&route.getSoftSeatCount()>0)
		{
			ticket.setSeatType(seatType);
			Integer bS = route.getSoftSeatCount();
			Integer price = route.getSfPrice();
			String seatnum = bS.toString()+"号";
			ticket.setSeatNum(seatnum);
			ticket.setPrice(price);
			RouteDAO RouteDao1 = DAOFactory.getIRouteDAOInstance();
			Integer bS1 = bS - 1;
			route.setSoftSeatCount(bS1);
			try {
				RouteDao1.doUpdateRoute(route);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();
			try {
				ticketDao.doCreateTicket(ticket);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("PayOrderServlet");
		}
		else if(seatType.equals("硬座")&&route.getHardSeatCount()>0)
		{
			ticket.setSeatType(seatType);
			Integer bS = route.getHardSeatCount();
			Integer price = route.gethPrice();
			String seatnum = bS.toString()+"号";
			ticket.setSeatNum(seatnum);
			ticket.setPrice(price);
			RouteDAO RouteDao1 = DAOFactory.getIRouteDAOInstance();
			Integer bS1 = bS - 1;
			route.setHardSeatCount(bS1);
			try {
				RouteDao1.doUpdateRoute(route);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();
			try {
				ticketDao.doCreateTicket(ticket);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("PayOrderServlet");
		}
		else if(seatType.equals("无座")&&route.getNoSeatCount()>0)
		{
			ticket.setSeatType(seatType);
			Integer bS = route.getHardSeatCount();
			Integer price = route.getnPrice();
			String seatnum = bS.toString()+"号";
			ticket.setSeatNum(seatnum);
			ticket.setPrice(price);
			RouteDAO RouteDao1 = DAOFactory.getIRouteDAOInstance();
			Integer bS1 = bS - 1;
			route.setNoSeatCount(bS1);
			try {
				RouteDao1.doUpdateRoute(route);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();
			try {
				ticketDao.doCreateTicket(ticket);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("PayOrderServlet");
		}
		else
		{
			System.out.println("购票失败");
		}
		
//		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
//		java.util.Date timeDate = null; 
//		try { 
//		timeDate = sdf.parse(aa); 
//		} catch (ParseException e) { 
//		e.printStackTrace(); 
//		}
//		java.sql.Date departureTime = new java.sql.Date(timeDate.getTime());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
