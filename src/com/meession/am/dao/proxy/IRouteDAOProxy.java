package com.meession.am.dao.proxy; 
 
import java.sql.Date;
import java.util.List;

import com.meession.common.DBConnection;
import com.meession.am.dao.RouteDAO;
import com.meession.am.dao.impl.RouteImpl;
import com.meession.am.entity.Route;

public class IRouteDAOProxy implements RouteDAO { 
    private DBConnection dbc = null; 
    private RouteDAO dao = null; 
 
    public IRouteDAOProxy() { 
        this.dbc = new DBConnection(); 
        this.dao = new RouteImpl(this.dbc.getConnection()); 
    } 
 
    public boolean doCreateRoute(Route route) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doCreateRoute(route); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
    public boolean doUpdateRoute(Route route) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doUpdateRoute(route); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
    public boolean doDeleteRoute(Long routeid ) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doDeleteRoute(routeid); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
    public List<Route> findRoute(String fromStation,String toStation,Date departureTime) throws Exception { 
        List<Route> all = null;
        try { 
            all = this.dao.findRoute(fromStation,toStation,departureTime); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    } 
    
 
    public List<Route> findAllRoute() throws Exception { 
        List<Route> all = null;
        try { 
            all = this.dao.findAllRoute(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    } 
 
 
    public List<Route> findByfromStation(String routeName, Date departureTime) throws Exception { 
        List<Route> all = null; 
        try { 
            all = this.dao.findByfromStation(routeName,departureTime); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }
    

    public List<Route> findBydepartureTime(Date departureTime) throws Exception { 
        List<Route> all = null; 
        try { 
            all = this.dao.findBydepartureTime(departureTime);
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }
    

    public Route findOnlyRoute(Long routeid) throws Exception { 
        Route route = null; 
        try { 
            route = this.dao.findOnlyRoute(routeid); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return route; 
    }

} 
