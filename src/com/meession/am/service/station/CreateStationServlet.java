package com.meession.am.service.station;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.am.dao.StationDAO;
import com.meession.am.entity.Station;
import com.meession.common.DAOFactory;
import com.meession.um.dao.UserDAO;

/**
 * Servlet implementation class CreateStationServlet
 */
public class CreateStationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateStationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stationName = request.getParameter("stationName");
		System.out.println(stationName);
		String level = request.getParameter("level");
		String describe = request.getParameter("describe");
		HttpSession session = request.getSession();
		String admin = (String) session.getAttribute("admin");
		if(admin == null)
			System.out.println("请以管理员登陆");
		else{
		StationDAO stationDao = DAOFactory.getIStationDAOInstance();
		
		 try {
			if(stationDao.findStation(stationName).size()==0)
			{
				Station station = new Station();
				station.setName(stationName);
				station.setLevel(level);
				station.setDescribe(describe);
				StationDAO stationDao1 = DAOFactory.getIStationDAOInstance();
				stationDao1.doCreateStation(station);
				System.out.println("添加成功");
				 request.getRequestDispatcher("adSite.jsp").forward(request, response);
				 request.setAttribute("msg", true);
			}
			else
			{
				System.out.println("该站点已存在");
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
