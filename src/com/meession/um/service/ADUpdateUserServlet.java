package com.meession.um.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.meession.common.DAOFactory;
import com.meession.um.dao.UserDAO;
import com.meession.um.entity.User;

/**
 * Servlet implementation class ChangePasswordServlet
 */
public class ADUpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADUpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String phoneNumber = request.getParameter("phoneNumber");
		String username = request.getParameter("username");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");
		String idCard = request.getParameter("idCard");
		System.out.println(idCard); 
		String idType = request.getParameter("idType");
		String birthday = request.getParameter("birthday");
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ); 
		String balance = request.getParameter("balance");
		Integer Balance = Integer.parseInt(balance);
		java.util.Date timeDate = null; 
		try { 
		timeDate = sdf.parse(birthday); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		}
		java.sql.Date Birthday = new java.sql.Date(timeDate.getTime());
		HttpSession session = request.getSession(); 
		String admin = (String) session.getAttribute("admin");
		
		if(admin == null )
			System.out.println("请先登录");
		else{
		System.out.println(username);
		
		UserDAO userDao = DAOFactory.getIUserDAOInstance();
		
		User user = new User();
		try {
			user = userDao.findById(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(user);
			user.setPhoneNumber(phoneNumber);
			user.setMail(mail);
			user.setName(name);
			user.setIdCard(idCard);
			user.setIdType(idType);
			user.setBirthday(Birthday);
			user.setBalance(Balance);
			System.out.println(user);
			try {
				UserDAO userDao1 = DAOFactory.getIUserDAOInstance();
				if(userDao1.doUpdate(user))
				{
				System.out.println("修改成功");
				request.getRequestDispatcher("adUser.jsp").forward(request, response);
				UserDAO userDao2 = DAOFactory.getIUserDAOInstance();
				
				User user1 = new User();
				
					user1 = userDao2.findById(username);
					System.out.println(user1);
					session.setAttribute("User", user1);
				}
				else 
					System.out.println("修改失败");
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
