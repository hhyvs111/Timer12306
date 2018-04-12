package com.meession.am.dao.impl;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List;

import com.meession.am.dao.RouteDAO;
import com.meession.am.entity.Route; 
 
public class RouteImpl implements RouteDAO { 
    private Connection conn = null; 
 
    public RouteImpl(Connection conn) { 
        this.conn = conn; 
    } 
 
    public boolean doCreateRoute(Route route) throws Exception {   // 车次信息
        boolean flag = false; 
        String sql = "INSERT INTO Route(name,trainType,fromStation,toStation,departureTime,arrivalTime,businessSeatCount,bPrice,specialSeatCount,spPrice,softSeatCount,sfPrice,hardSeatCount,hPrice,noSeatCount,nPrice,remark,fromStationId,toStationId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? , ? , ? , ? , ? , ? , ?,(select id from Station where name = ?),(select id from Station where name = ? ))"; 
        PreparedStatement pstmt = null; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, route.getName());
            pstmt.setString(2, route.getType());
            pstmt.setString(3, route.getFromStation());
            pstmt.setString(4, route.getToStation());
            pstmt.setTimestamp(5, new java.sql.Timestamp(route.getDepartureTime().getTime())); 
            pstmt.setTimestamp(6, new java.sql.Timestamp(route.getArrivalTime().getTime()));
            pstmt.setInt(7, route.getBusinessSeatCount());
            pstmt.setInt(8, route.getbPrice());
            pstmt.setInt(9,route.getSpecialSeatCount());
            pstmt.setInt(10, route.getSpPrice());
            pstmt.setInt(11, route.getSoftSeatCount());
            pstmt.setInt(12, route.getSfPrice());
            pstmt.setInt(13, route.getHardSeatCount());
            pstmt.setInt(14, route.gethPrice());
            pstmt.setInt(15, route.getNoSeatCount());
            pstmt.setInt(16, route.getnPrice());
            pstmt.setString(17, route.getRemark());
            pstmt.setString(18, route.getFromStation());
            pstmt.setString(19, route.getToStation());
            if (pstmt.executeUpdate() > 0) { 
                flag = true; 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            if (pstmt != null) { 
                try { 
                    pstmt.close(); 
                } catch (Exception e2) { 
                    e2.printStackTrace(); 
                } 
            } 
        } 
        return flag; 
    } 
 
    public boolean doUpdateRoute(Route route) throws Exception { //更新车次
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "UPDATE Route SET name = ?, trainType = ?, fromStation = ?, toStation = ?, departureTime = ?, arrivalTime = ?, businessSeatCount = ?, bPrice = ?, specialSeatCount = ?, spPrice = ?, softSeatCount = ?,sfPrice = ?,hardSeatCount = ?,hPrice = ?,noSeatCount = ?,nPrice = ? ,remark = ?   WHERE id = ?"; 
        try { 
        	pstmt = this.conn.prepareStatement(sql); 
        	pstmt.setString(1, route.getName());
            pstmt.setString(2, route.getType());
            pstmt.setString(3, route.getFromStation());
            pstmt.setString(4, route.getToStation());
            pstmt.setTimestamp(5, new java.sql.Timestamp(route.getDepartureTime().getTime())); 
            pstmt.setTimestamp(6, new java.sql.Timestamp(route.getArrivalTime().getTime()));
            pstmt.setInt(7, route.getBusinessSeatCount());
            pstmt.setInt(8, route.getbPrice());
            pstmt.setInt(9,route.getSpecialSeatCount());
            pstmt.setInt(10, route.getSpPrice());
            pstmt.setInt(11, route.getSoftSeatCount());
            pstmt.setInt(12, route.getSfPrice());
            pstmt.setInt(13, route.getHardSeatCount());
            pstmt.setInt(14, route.gethPrice());
            pstmt.setInt(15, route.getNoSeatCount());
            pstmt.setInt(16, route.getnPrice());
            pstmt.setString(17, route.getRemark());
            pstmt.setLong(18, route.getId());
            if (pstmt.executeUpdate() > 0) { 
                flag = true; 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            if (pstmt != null) { 
                try { 
                    pstmt.close(); 
                } catch (Exception e2) { 
                    e2.printStackTrace(); 
                } 
            } 
        } 
        return flag; 
    } 
     
    public boolean doDeleteRoute(Long routeid) throws Exception { 
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "DELETE FROM Route WHERE id = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setLong(1, routeid);

            if (pstmt.executeUpdate() > 0) { 
                flag = true; 
            } 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            if (pstmt != null) { 
                try { 
                    pstmt.close(); 
                } catch (Exception e2) { 
                    e2.printStackTrace(); 
                } 
            } 
        } 
        return flag; 
    } 
    
    public List<Route> findRoute(String fromStation,String toStation,Date departureTime) throws Exception {   //查询车次
    	List<Route> all = new ArrayList<Route>();	
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM route WHERE fromStation = ? and toStation = ? and departureTime LIKE  ?  "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, fromStation);
            pstmt.setString(2, toStation);
            pstmt.setString(3, departureTime+"%");
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
            Route route = new Route();
            route.setId(rs.getLong(1));
            route.setName(rs.getString(2));
            route.setType(rs.getString(3));
            route.setFromStation(rs.getString(4));
            route.setToStation(rs.getString(5));
            route.setDepartureTime(rs.getTimestamp(6)); 
            route.setArrivalTime(rs.getTimestamp(7));
            route.setBusinessSeatCount(rs.getInt(8));
            route.setbPirce(rs.getInt(9));
            route.setSpecialSeatCount(rs.getInt(10));
            route.setSpPrice(rs.getInt(11));
            route.setSoftSeatCount(rs.getInt(12));
            route.setSfPrice(rs.getInt(13));
            route.setHardSeatCount(rs.getInt(14));
            route.sethPrice(rs.getInt(15));
            route.setNoSeatCount(rs.getInt(16));
            route.setnPrice(rs.getInt(17));
            route.setRemark(rs.getString(18));
            route.setFromStationId(rs.getLong(19));
            route.setToStationId(rs.getLong(20));  
            all.add(route);
            } 
            rs.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            if (pstmt != null) { 
                try { 
                    pstmt.close(); 
                } catch (Exception e2) { 
                    e2.printStackTrace(); 
                } 
            } 
        } 
        return all; 
    }
    
    public List<Route> findAllRoute() throws Exception {   //查询车次
         List<Route> all = new ArrayList<Route>();
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM route "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
            Route route = new Route();
            route.setId(rs.getLong(1));
            route.setName(rs.getString(2));
            route.setType(rs.getString(3));
            route.setFromStation(rs.getString(4));
            route.setToStation(rs.getString(5));
            route.setDepartureTime(rs.getTimestamp(6)); 
            route.setArrivalTime(rs.getDate(7));
            route.setBusinessSeatCount(rs.getInt(8));
            route.setbPirce(rs.getInt(9));
            route.setSpecialSeatCount(rs.getInt(10));
            route.setSpPrice(rs.getInt(11));
            route.setSoftSeatCount(rs.getInt(12));
            route.setSfPrice(rs.getInt(13));
            route.setHardSeatCount(rs.getInt(14));
            route.sethPrice(rs.getInt(15));
            route.setNoSeatCount(rs.getInt(16));
            route.setnPrice(rs.getInt(17));
            route.setRemark(rs.getString(18));
            route.setFromStationId(rs.getLong(19));
            route.setToStationId(rs.getLong(20));   
            all.add(route);
            } 
            rs.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            if (pstmt != null) { 
                try { 
                    pstmt.close(); 
                } catch (Exception e2) { 
                    e2.printStackTrace(); 
                } 
            } 
        } 
        return all; 
    } 
 
    public List<Route> findByfromStation(String routeName , Date departureTime) throws Exception { 
        List<Route> all = new ArrayList<Route>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM Route WHERE routeName = ? and departureTime >= ? "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1,routeName); 
            pstmt.setDate(3, departureTime);
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                Route route  = new Route(); 
                route.setId(rs.getLong(1));
                route.setName(rs.getString(2));
                route.setType(rs.getString(3));
                route.setFromStation(rs.getString(4));
                route.setToStation(rs.getString(5));
                route.setDepartureTime(rs.getTimestamp(6)); 
                route.setArrivalTime(rs.getDate(7));
                route.setBusinessSeatCount(rs.getInt(8));
                route.setbPirce(rs.getInt(9));
                route.setSpecialSeatCount(rs.getInt(10));
                route.setSpPrice(rs.getInt(11));
                route.setSoftSeatCount(rs.getInt(12));
                route.setSfPrice(rs.getInt(13));
                route.setHardSeatCount(rs.getInt(14));
                route.sethPrice(rs.getInt(15));
                route.setNoSeatCount(rs.getInt(16));
                route.setnPrice(rs.getInt(17));
                route.setRemark(rs.getString(18));
                route.setFromStationId(rs.getLong(19));
                route.setToStationId(rs.getLong(20));  
                all.add(route); 
            } 
            rs.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            if (pstmt != null) { 
                try { 
                    pstmt.close(); 
                } catch (Exception e2) { 
                    e2.printStackTrace(); 
                } 
            } 
        } 
        return all; 
    }
    
    public List<Route> findBydepartureTime(Date departureTime) throws Exception { 
        List<Route> all = new ArrayList<Route>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM Route WHERE departureTime= ? "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setDate(1,departureTime); 
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                Route route  = new Route(); 
                route.setId(rs.getLong(1));
                route.setName(rs.getString(2));
                route.setType(rs.getString(3));
                route.setFromStation(rs.getString(4));
                route.setToStation(rs.getString(5));
                route.setDepartureTime(rs.getTimestamp(6)); 
                route.setArrivalTime(rs.getDate(7));
                route.setBusinessSeatCount(rs.getInt(8));
                route.setbPirce(rs.getInt(9));
                route.setSpecialSeatCount(rs.getInt(10));
                route.setSpPrice(rs.getInt(11));
                route.setSoftSeatCount(rs.getInt(12));
                route.setSfPrice(rs.getInt(13));
                route.setHardSeatCount(rs.getInt(14));
                route.sethPrice(rs.getInt(15));
                route.setNoSeatCount(rs.getInt(16));
                route.setnPrice(rs.getInt(17));
                route.setRemark(rs.getString(18));
                route.setFromStationId(rs.getLong(19));
                route.setToStationId(rs.getLong(20));  
                all.add(route); 
            } 
            rs.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            if (pstmt != null) { 
                try { 
                    pstmt.close(); 
                } catch (Exception e2) { 
                    e2.printStackTrace(); 
                } 
            } 
        } 
        return all; 
    } 
    
    public Route findOnlyRoute(Long routeid) throws Exception { 
    	Route route = null;
    	PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM Route WHERE id = ? "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setLong(1,routeid); 
          //  pstmt.setString(2, toStation);
          //  pstmt.setDate(2, departureTime);
            ResultSet rs = pstmt.executeQuery(); 
           if (rs.next()) { 
                route  = new Route(); 
                route.setId(rs.getLong(1));
                route.setName(rs.getString(2));
                route.setType(rs.getString(3));
                route.setFromStation(rs.getString(4));
                route.setToStation(rs.getString(5));
                route.setDepartureTime(rs.getTimestamp(6)); 
                route.setArrivalTime(rs.getTimestamp(7));
                route.setBusinessSeatCount(rs.getInt(8));
                route.setbPirce(rs.getInt(9));
                route.setSpecialSeatCount(rs.getInt(10));
                route.setSpPrice(rs.getInt(11));
                route.setSoftSeatCount(rs.getInt(12));
                route.setSfPrice(rs.getInt(13));
                route.setHardSeatCount(rs.getInt(14));
                route.sethPrice(rs.getInt(15));
                route.setNoSeatCount(rs.getInt(16));
                route.setnPrice(rs.getInt(17));
                route.setRemark(rs.getString(18));
                route.setFromStationId(rs.getLong(19));
                route.setToStationId(rs.getLong(20));  
//                all.add(route); 
            }
            rs.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            if (pstmt != null) { 
                try { 
                    pstmt.close(); 
                } catch (Exception e2) { 
                    e2.printStackTrace(); 
                } 
            } 
        } 
        return route; 
    }

} 

