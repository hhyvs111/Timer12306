package com.meession.am.service.route;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
public class QueryRouteAtoBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryRouteAtoBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.setContentType("text/html,charset=utf-8");
		//request.setCharacterEncoding("UTF-8");
		String fromStation = request.getParameter("fromStation");
		String toStation = request.getParameter("toStation");
		String departureTime = request.getParameter("departureTime");
		System.out.println(departureTime+ " " +fromStation+toStation 	);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd" ); 
		//String aa= request.getParameter("Date"); 
		java.util.Date timeDate = null; 
		try { 
		timeDate = sdf.parse(departureTime); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		}
		java.sql.Date currentDate = new java.sql.Date(timeDate.getTime());
		
		List<Route> list = null ;//new ArrayList<Route>();
		
		RouteDAO routeDao = DAOFactory.getIRouteDAOInstance();
		try {
			list = routeDao.findRoute(fromStation,toStation,currentDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		System.out.println(list.size());
		for(int i = 0 ;i < list.size();i++)
			System.out.println(list.get(i));
		request.setAttribute("list", list);
		request.getRequestDispatcher("QueryRoute.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	response.setContentType("text/html;charset=utf-8");
//		//PrintWriter out = response.getWriter();
//		this.doGet(request, response);
	}

}
