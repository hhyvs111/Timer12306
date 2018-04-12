package com.meession.am.service.route;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.am.dao.RouteDAO;
import com.meession.common.DAOFactory;

/**
 * Servlet implementation class DeleteRouteServlet
 */
public class DeleteRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRouteServlet() {
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
		String admin = (String) session.getAttribute("admin");
//		if(admin == null)
//			System.out.println("请以管理员登陆");
//		else{
			String routeId = request.getParameter("routeId");
			Long routeid = Long.parseLong(routeId);
			String fromStation = request.getParameter("fromStation");
			String toStation = request.getParameter("toStation");
//			SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH-mm-ss" ); 
			String departureTime= request.getParameter("departureTime"); 
//			java.util.Date dTime = null; 
//			try { 
//			dTime = sdf.parse(departureTime); 
//			} catch (ParseException e) { 
//			e.printStackTrace(); 
//			}
//			java.sql.Date dpTime = new java.sql.Date(dTime.getTime());
			RouteDAO routeDao = DAOFactory.getIRouteDAOInstance();
			try {
				if(routeDao.doDeleteRoute(routeid))
				{
					System.out.println("删除成功");
					RequestDispatcher rd = request.getRequestDispatcher("adRoute.jsp");
					rd.forward(request, response);
				}
				else
				{
					System.out.println("删除失败");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
	}

}
