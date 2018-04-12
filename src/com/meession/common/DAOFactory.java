package com.meession.common;


import com.meession.am.dao.RouteDAO;
import com.meession.am.dao.StationDAO;
import com.meession.am.dao.StationLinkDAO;
import com.meession.am.dao.proxy.IRouteDAOProxy;
import com.meession.am.dao.proxy.IStationDAOProxy;
import com.meession.am.dao.proxy.IStationLinkDAOProxy;
import com.meession.tm.dao.OrderDAO;
import com.meession.tm.dao.TicketDAO;
import com.meession.tm.dao.proxy.IOrderDAOProxy;
import com.meession.tm.dao.proxy.ITicketDAOProxy;
import com.meession.um.dao.UserDAO;
import com.meession.um.dao.proxy.IUserDAOProxy;
 
public class DAOFactory { 
    public static UserDAO getIUserDAOInstance() { 
        return new IUserDAOProxy(); 
    } 
    public static RouteDAO getIRouteDAOInstance(){
    	return new IRouteDAOProxy();
    }
    public static StationDAO getIStationDAOInstance(){
    	return new IStationDAOProxy();
    	
    }public static StationLinkDAO getIStationLinkDAOInstance(){
    	return new IStationLinkDAOProxy();
    	
    }public static OrderDAO getIOrderDAOInstance(){
    	return new IOrderDAOProxy();
    	
    	
    }public static TicketDAO getITicketDAOInstance(){
    	return new ITicketDAOProxy();
    }
} 
