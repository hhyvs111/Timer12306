package com.meession.um.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meession.common.DAOFactory;
import com.meession.um.dao.UserDAO;
import com.meession.um.dao.impl.UserImpl;
import com.meession.um.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String name = request.getParameter("name");	
		String phoneNumber = request.getParameter("phoneNumber");
		String idCard = request.getParameter("idCard");
		String idType = request.getParameter("idType");
	
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" ); 
		String aa= request.getParameter("Date"); 
		java.util.Date timeDate = null; 
		try { 
		timeDate = sdf.parse(aa); 
		} catch (ParseException e) { 
		e.printStackTrace(); 
		}
		java.sql.Date currentDate = new java.sql.Date(timeDate.getTime());
		User user1 = null;
		 System.out.println(username + " "+ password+ " " +mail+" "+phoneNumber+ " "+idCard+" " + currentDate);
		UserDAO userDao = DAOFactory.getIUserDAOInstance();
		try {
			user1 = userDao.findById(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user1 != null)
		{
		if(user1.getUsername().equals(username))
			System.out.println("用户名重复，请更换");
		else if(user1.getMail().equals(mail))
			System.out.println("邮箱重复，请更换");
		else if(user1.getPhoneNumber().equals(phoneNumber))
			System.out.println("手机号重复，请更换");
		else if(user1.getIdCard().equals(idCard))
			System.out.println("身份证号重复，请更换");
		}
		else
		{
			UserDAO userDao1 = DAOFactory.getIUserDAOInstance();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setMail(mail);
		user.setName(name);
		user.setBirthday(currentDate);
		user.setIdCard(idCard);
		user.setPhoneNumber(phoneNumber);
		user.setIdType(idType);
		try {
			if(userDao1.doCreate(user))
			{
				System.out.println("注册成功");
				response.sendRedirect("RegisterSuccess.jsp");
			}
			else
			{
				System.out.println("注册失败");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
