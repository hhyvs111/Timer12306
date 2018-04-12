package com.meession.am.service.station;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.am.dao.StationDAO;
import com.meession.am.entity.Station;
import com.meession.common.DAOFactory;

/**
 * Servlet implementation class QueryStationServlet
 */
public class ADQueryStationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADQueryStationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String stationName = request.getParameter("stationName");
		//String level = request.getParameter("level");
		//String describe = request.getParameter("describe");
		//HttpSession session = request.getSession();
		StationDAO stationDao = DAOFactory.getIStationDAOInstance();
		System.out.println(stationName);
		List<Station> list = new ArrayList<Station>();
		if(stationName.equals("所有站点"))
			try {
				list = stationDao.findALLStation();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				list = stationDao.findStation(stationName);
				System.out.println(list);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.setAttribute("list", list);
		
		 request.getRequestDispatcher("adSite.jsp").forward(request, response);
			
		}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
