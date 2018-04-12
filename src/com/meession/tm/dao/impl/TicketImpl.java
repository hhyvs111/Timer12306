package com.meession.tm.dao.impl;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List;

import com.meession.tm.dao.TicketDAO;
import com.meession.tm.entity.Ticket; 
 
public class TicketImpl implements TicketDAO { 
    private Connection conn = null; 
 
    public TicketImpl(Connection conn) { 
        this.conn = conn; 
    } 
 

    public boolean doCreateTicket(Ticket Ticket) throws Exception {   // 购票
        boolean flag = false; 
        String sql = "INSERT INTO Ticket(name,route,routeType,seatNum,seatType,departureTime,price,fromPlace,toPlace,remark,orderId,routeId,userId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, (select id from user where name = ?))"; 
        PreparedStatement pstmt = null; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, Ticket.getName());
            pstmt.setString(2, Ticket.getRoute());
            pstmt.setString(3, Ticket.getRouteType());
            pstmt.setString(4, Ticket.getSeatNum());
            pstmt.setString(5, Ticket.getSeatType());
            pstmt.setTimestamp(6, new java.sql.Timestamp(Ticket.getDepartureTime().getTime()));
            pstmt.setInt(7, Ticket.getPrice());
            pstmt.setString(8, Ticket.getFrom());
            pstmt.setString(9, Ticket.getTo());
            pstmt.setString(10, Ticket.getRemark());
            pstmt.setLong(11, Ticket.getOrderId());
            pstmt.setLong(12, Ticket.getRouteId());
            pstmt.setString(13, Ticket.getName());
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
 

    public boolean doUpdateTicket(Ticket Ticket) throws Exception { //���¸�����Ϣ
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "UPDATE Ticket SET name = ?,route = ?, seatNum = ?, seatType = ? WHERE id = ? "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
        
            pstmt.setString(1, Ticket.getName());
            pstmt.setString(2, Ticket.getRoute());
            pstmt.setString(3, Ticket.getSeatNum());
            pstmt.setString(4, Ticket.getSeatType());
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
     
 
    public boolean doDeleteTicket(Long id) throws Exception { 
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "DELETE FROM Ticket WHERE id = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setLong(1, id); 
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
 
 
    public List<Ticket> findByName(String name) throws Exception { 
    	List<Ticket> all = new ArrayList<Ticket>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM Ticket WHERE name = ? "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                Ticket Ticket = new Ticket(); 
                Ticket.setId(rs.getLong(1));
                Ticket.setName(rs.getString(2));
                Ticket.setRoute(rs.getString(3));
                Ticket.setRouteType(rs.getString(4));
                Ticket.setSeatNum(rs.getString(5));
                Ticket.setSeatType(rs.getString(6));
                Ticket.setDepartureTime(rs.getTimestamp(7));
                Ticket.setPrice(rs.getInt(8));
                Ticket.setFrom(rs.getString(9));
                Ticket.setTo(rs.getString(10));
                Ticket.setRemark(rs.getString(11));
                Ticket.setOrderId(rs.getLong(12));
                Ticket.setRouteId(rs.getLong(13));
                Ticket.setUserId(rs.getLong(14));
                all.add(Ticket);
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
 
 
    public List<Ticket> findByTime(Date departureTime) throws Exception { 
    	List<Ticket> all = new ArrayList<Ticket>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM Ticket WHERE departureTime like ? "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, departureTime+"%");
            ResultSet rs = pstmt.executeQuery(); 
            while(rs.next()) { 
                Ticket Ticket = new Ticket(); 
                Ticket.setId(rs.getLong(1));
                Ticket.setName(rs.getString(2));
                Ticket.setRoute(rs.getString(3));
                Ticket.setRouteType(rs.getString(4));
                Ticket.setSeatNum(rs.getString(5));
                Ticket.setSeatType(rs.getString(6));
                Ticket.setDepartureTime(rs.getTimestamp(7));
                Ticket.setPrice(rs.getInt(8));
                Ticket.setFrom(rs.getString(9));
                Ticket.setTo(rs.getString(10));
                Ticket.setRemark(rs.getString(11));
                Ticket.setOrderId(rs.getLong(12));
                Ticket.setRouteId(rs.getLong(13));
                Ticket.setUserId(rs.getLong(14));
                all.add(Ticket);
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
    
 
    public List<Ticket> findByRoute(String from,String to) throws Exception { 
    	List<Ticket> all = new ArrayList<Ticket>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM Ticket WHERE fromPlace = ? and toPlace = ? "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, from); 
            pstmt.setString(2, to); 
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                Ticket Ticket = new Ticket(); 
                Ticket.setId(rs.getLong(1));
                Ticket.setName(rs.getString(2));
                Ticket.setRoute(rs.getString(3));
                Ticket.setRouteType(rs.getString(4));
                Ticket.setSeatNum(rs.getString(5));
                Ticket.setSeatType(rs.getString(6));
                Ticket.setDepartureTime(rs.getTimestamp(7));
                Ticket.setPrice(rs.getInt(8));
                Ticket.setFrom(rs.getString(9));
                Ticket.setTo(rs.getString(10));
                Ticket.setRemark(rs.getString(11));
                Ticket.setOrderId(rs.getLong(12));
                Ticket.setRouteId(rs.getLong(13));
                Ticket.setUserId(rs.getLong(14));
                all.add(Ticket);
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




public List<Ticket> findAllTicket() throws Exception { 
	List<Ticket> all = new ArrayList<Ticket>(); 
    PreparedStatement pstmt = null; 
    String sql = "SELECT * FROM Ticket "; 
    try { 
        pstmt = this.conn.prepareStatement(sql); 
         
        ResultSet rs = pstmt.executeQuery(); 
        if (rs.next()) { 
            Ticket Ticket = new Ticket(); 
            Ticket.setId(rs.getLong(1));
            Ticket.setName(rs.getString(2));
            Ticket.setRoute(rs.getString(3));
            Ticket.setRouteType(rs.getString(4));
            Ticket.setSeatNum(rs.getString(5));
            Ticket.setSeatType(rs.getString(6));
            Ticket.setDepartureTime(rs.getTimestamp(7));
            Ticket.setPrice(rs.getInt(8));
            Ticket.setFrom(rs.getString(9));
            Ticket.setTo(rs.getString(10));
            Ticket.setRemark(rs.getString(11));
            Ticket.setOrderId(rs.getLong(12));
            Ticket.setRouteId(rs.getLong(13));
            Ticket.setUserId(rs.getLong(14));
            all.add(Ticket);
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
 
public Ticket findTicketById(Long id) throws Exception { 
	List<Ticket> all = new ArrayList<Ticket>(); 
	Ticket Ticket = new Ticket();
    PreparedStatement pstmt = null; 
    String sql = "SELECT * FROM Ticket  where id = ?"; 
    try { 
        pstmt = this.conn.prepareStatement(sql); 
        pstmt.setLong(1,id);
        ResultSet rs = pstmt.executeQuery(); 
        
            //Ticket Ticket = new Ticket(); 
            Ticket.setId(rs.getLong(1));
            Ticket.setName(rs.getString(2));
            Ticket.setRoute(rs.getString(3));
            Ticket.setRouteType(rs.getString(4));
            Ticket.setSeatNum(rs.getString(5));
            Ticket.setSeatType(rs.getString(6));
            Ticket.setDepartureTime(rs.getTimestamp(7));
            Ticket.setPrice(rs.getInt(8));
            Ticket.setFrom(rs.getString(9));
            Ticket.setTo(rs.getString(10));
            Ticket.setRemark(rs.getString(11));
            Ticket.setOrderId(rs.getLong(12));
            Ticket.setRouteId(rs.getLong(13));
            Ticket.setUserId(rs.getLong(14));
            all.add(Ticket);
        
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
    return Ticket; 
}
}