package com.meession.am.service.route;

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

/**
 * Servlet implementation class QueryRouteServlet
 */
public class QueryRouteFromServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryRouteFromServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//String fromStation = request.getParameter("fromStation");
		//String toStation = request.getParameter("toStation");
		String routeName = request.getParameter("routeName");
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd " ); 
		String dTime= request.getParameter("departureTime"); 
		java.util.Date timeDate = null; 
		try { 
		timeDate = sdf.parse(dTime); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		}
		java.sql.Date dpTime = new java.sql.Date(timeDate.getTime());
		
		List<Route> list = new ArrayList<Route>();
		
		RouteDAO routeDao = DAOFactory.getIRouteDAOInstance();
		try {
			list = routeDao.findByfromStation(routeName, dpTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
