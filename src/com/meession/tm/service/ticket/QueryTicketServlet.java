package com.meession.tm.service.ticket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.common.DAOFactory;
import com.meession.tm.dao.TicketDAO;
import com.meession.tm.entity.Ticket;
import com.meession.um.entity.User;

/**
 * Servlet implementation class QueryTicketServlet
 */
public class QueryTicketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryTicketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(); 
		String username = (String) session.getAttribute("user");
		User user = (User) session.getAttribute("User");
		System.out.println(username);
		if(username == null)
		{
			System.out.println("请先登录");
			response.sendRedirect("Login.jsp");
		}
			
		else{
			System.out.println(user);
			TicketDAO ticketDao = DAOFactory.getITicketDAOInstance();
			List<Ticket> ticketList = new ArrayList<Ticket>();
			try {
				ticketList = ticketDao.findByName(user.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(ticketList.size());
//			for(int i = 0 ;i < ticketList.size();i++)
//				System.out.println(ticketList.get(i));
			request.setAttribute("list", ticketList);
			request.getRequestDispatcher("UserTicket.jsp").forward(request, response);
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
