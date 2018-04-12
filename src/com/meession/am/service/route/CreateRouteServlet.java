package com.meession.am.service.route;

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

/**
 * Servlet implementation class CreateRoute
 */
public class CreateRouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRouteServlet() {
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
		String admin = (String) session.getAttribute("admin");
//		if(admin == null)
//			System.out.println("请以管理员登陆");
//		else{
		String routeName = request.getParameter("routeName");
		String routeType = request.getParameter("routeType");
		String fromStation = request.getParameter("fromStation");
		String toStation = request.getParameter("toStation");
		
		String departureTime= request.getParameter("departureTime"); 
		System.out.println(Timestamp.valueOf(departureTime));
		System.out.println(departureTime);

		String arrivalTime = request.getParameter("arrivalTime");
		
		
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
		//String fromStationId = request.getParameter("fromStationId");
		//String toStationId = request.getParameter("toStationId" );
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
		//Long fSId = Long.parseLong(fromStationId);
		//Long tSId = Long.parseLong(toStationId);
		
		Route route = new Route();
		
		RouteDAO routeDao = DAOFactory.getIRouteDAOInstance();
		
		route.setName(routeName);
		route.setType(routeType);
		route.setFromStation(fromStation);
		route.setToStation(toStation);
		route.setDepartureTime(Timestamp.valueOf(departureTime));
		route.setArrivalTime(Timestamp.valueOf(arrivalTime));
		route.setBusinessSeatCount(bS);
		route.setbPirce(bP);
		route.setSpecialSeatCount(spS);
		route.setSpPrice(spP);
		route.setSoftSeatCount(sfS);
		route.setSfPrice(sfP);
		route.setHardSeatCount(hS);
		route.sethPrice(hP);
		route.setNoSeatCount(nS);
		route.setnPrice(nP);
		route.setRemark(remark);
		System.out.println("route   "+ route.getDepartureTime());
		//route.setFromStationId(fSId);
		//route.setToStationId(tSId);
		try {
			if(routeDao.doCreateRoute(route))
			{
				System.out.println(" 添加成功");
				 request.getRequestDispatcher("adRoute.jsp").forward(request, response);
			}
			else 
				
				{
				System.out.println("添加失败");
				 request.getRequestDispatcher("adRoute.jsp").forward(request, response);
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
	}

}
