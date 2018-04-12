package com.meession.tm.service.ticket;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meession.am.dao.RouteDAO;
import com.meession.am.entity.Route;
import com.meession.common.DAOFactory;
import com.meession.tm.dao.TicketDAO;
import com.meession.tm.entity.Ticket;

/**
 * Servlet implementation class ADQueryTicketServlet
 */
public class ADQueryTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADQueryTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String routeType = request.getParameter("routeType");
		String departureTime = request.getParameter("departureTime");
		System.out.println(departureTime+ " " + routeType );

			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" ); 
			java.util.Date timeDate = null; 
			try { 
			timeDate = sdf.parse(departureTime); 
			} catch (ParseException e) { 
			e.printStackTrace(); 
			}
			java.sql.Date currentDate = new java.sql.Date(timeDate.getTime());
			
			List<Ticket> list = new ArrayList<Ticket>();
			TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();
			try {
				list = ticketDao.findByTime(currentDate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			System.out.println(list.size());
			for(int i = 0 ;i < list.size();i++)
				System.out.println(list.get(i));
			request.setAttribute("list", list);
			 request.getRequestDispatcher("adTicket.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
