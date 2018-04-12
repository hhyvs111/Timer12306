package com.meession.am.service.route;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.am.dao.RouteDAO;
import com.meession.am.entity.Route;
import com.meession.common.DAOFactory;

/**
 * Servlet implementation class UpdateRouteServlet
 */
public class UpdateRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRouteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String admin = (String) session.getAttribute("admin");
//		if(admin == null)
//			System.out.println("请以管理员登陆");
//		else{
		//String routeName = request.getParameter("routeName");
//		String routeType = request.getParameter("trainType");
		//String fromStation = request.getParameter("fromStation");
		//String toStation = request.getParameter("toStation");
		String routeId = request.getParameter("routeId");
		Long routeid = Long.parseLong(routeId);
		
		String routeName = request.getParameter("routeName");
		String routeType = request.getParameter("routeType");
		String fromStation = request.getParameter("fromStation");
		String toStation = request.getParameter("toStation");
		
		String departureTime= request.getParameter("departureTime"); 
		System.out.println(departureTime+ " " +fromStation+toStation );
		System.out.println(Timestamp.valueOf(departureTime));
		System.out.println(departureTime);

		String arrivalTime = request.getParameter("arrivalTime");
		RouteDAO routeDao = DAOFactory.getIRouteDAOInstance();
		
		Route route = new Route();
		
		try {
			route = routeDao.findOnlyRoute(routeid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		String businessSeatCount = request.getParameter("businessSeatCount");
		String bPrice = request.getParameter("bPrice");
		String specialSeatCount = request.getParameter("specialSeatCount");
		String spPrice = request.getParameter("spPrice");
		String softSeatCount = request.getParameter("softSeatCount");
		String sfPrice = request.getParameter("sfPrice");
		String hardSeatCount = request.getParameter("hardSeatCount");
		String hPrice = request.getParameter("hPrice");
		String noSeatCount = request.getParameter("noSeatCount");
		String nPrice = request.getParameter("nPrice");
		String remark = request.getParameter("remark");
//		String fromStationId = request.getParameter("fromStationId");
//		String toStationId = request.getParameter("toStationId" );
		Integer bS = Integer.parseInt(businessSeatCount);
		Integer spS = Integer.parseInt(specialSeatCount);
		Integer sfS = Integer.parseInt(softSeatCount);
		Integer hS = Integer.parseInt(hardSeatCount);
		Integer nS = Integer.parseInt(noSeatCount);
		Integer bP = Integer.parseInt(bPrice);
		Integer spP = Integer.parseInt(spPrice);
		Integer sfP = Integer.parseInt(sfPrice);
		Integer hP = Integer.parseInt(hPrice);
		Integer nP = Integer.parseInt(nPrice);
//		Long fSId = Long.parseLong(fromStationId);
//		Long tSId = Long.parseLong(toStationId);
		route.setName(routeName);
		route.setType(routeType);
		route.setFromStation(fromStation);
		route.setToStation(toStation);
		route.setDepartureTime(Timestamp.valueOf(departureTime));
		route.setArrivalTime(Timestamp.valueOf(arrivalTime));
		route.setBusinessSeatCount(bS);
		route.setSpecialSeatCount(spS);
		route.setSoftSeatCount(sfS);
		route.setHardSeatCount(hS);
		route.setNoSeatCount(nS);
		route.setbPirce(bP);
		route.setSpPrice(spP);
		route.setSfPrice(sfP);
		route.sethPrice(hP);
		route.setnPrice(nP);
		route.setRemark(remark);
		try {
			RouteDAO routeDao1 = DAOFactory.getIRouteDAOInstance();
			if(routeDao1.doUpdateRoute(route))
			{	System.out.println("更新车次成功");
			RequestDispatcher rd = request.getRequestDispatcher("adRoute.jsp");
			rd.forward(request, response);
			}
			else
				System.out.println("更新车次失败");
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
	}

}
