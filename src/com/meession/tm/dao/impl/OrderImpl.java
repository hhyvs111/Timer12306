package com.meession.tm.dao.impl;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList; 
import java.util.List;

import com.meession.tm.dao.OrderDAO;
import com.meession.tm.entity.Order; 
 
public class OrderImpl implements OrderDAO { 
    private Connection conn = null; 
 
    public OrderImpl(Connection conn) { 
        this.conn = conn; 
    } 
 

    public boolean doCreateOrder(Order Order) throws Exception {   // 注册信息
        boolean flag = false; 
        String sql = "INSERT INTO orderinfo(status,createDate,lastUpdateDate,userId,routeId,price) VALUES (?, ?, ?, ?, ?, ?)"; 
        PreparedStatement pstmt = null; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, Order.getStatus());
            pstmt.setTimestamp(2, new java.sql.Timestamp(Order.getCreateDate().getTime()));
//            pstmt.setDate(3, new java.sql.Date(Order.getPayTime().getTime()));
            pstmt.setTimestamp(3, new java.sql.Timestamp(Order.getLastUpdateDate().getTime()));
            pstmt.setLong(4, Order.getUserId());
            pstmt.setLong(5, Order.getRouteId());
            pstmt.setInt(6, Order.getPrice());
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
 
 
    public boolean doUpdateOrder(Order Order) throws Exception { //订单
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "UPDATE orderinfo SET status = ?, createDate = ?, payTime = ?, lastUpdateDate = ?, price = ? WHERE id = ? "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, Order.getStatus());
            pstmt.setTimestamp(2, new java.sql.Timestamp(Order.getCreateDate().getTime()));
            pstmt.setTimestamp(3, new java.sql.Timestamp(Order.getPayTime().getTime()));
            pstmt.setTimestamp(4, new java.sql.Timestamp(Order.getLastUpdateDate().getTime()));
            pstmt.setInt(5, Order.getPrice());
            pstmt.setLong(6,Order.getId());
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
     

    public boolean doDeleteOrder(Long id) throws Exception { 
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "DELETE FROM orderinfo WHERE id = ?"; 
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
 
 
    public List<Order> findByUserId(Long userId) throws Exception { 
    	List<Order> all = new ArrayList<Order>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM orderinfo WHERE userId = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setLong(1, userId);
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                Order Order= new Order(); 
                Order.setId(rs.getLong(1));
                Order.setStatus(rs.getString(2)); 
                Order.setCreateDate(rs.getTimestamp(3));
                Order.setPayTime(rs.getTimestamp(4));
                Order.setLastUpdateDate(rs.getTimestamp(5));
                Order.setUserId(rs.getLong(6));
                Order.setRouteId(rs.getLong(7));
                Order.setPrice(rs.getInt(8));
                all.add(Order);
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
 
 
    public List<Order> findByStatus(String Status) throws Exception { 
    	List<Order> all = new ArrayList<Order>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM orderinfo WHERE Status = ? "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, Status); 
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                Order Order = new Order(); 
                Order.setId(rs.getLong(1));
                Order.setStatus(rs.getString(2)); 
                Order.setCreateDate(rs.getTimestamp(3));
                Order.setPayTime(rs.getTimestamp(4));
                Order.setLastUpdateDate(rs.getTimestamp(5));
                Order.setUserId(rs.getLong(6));
                Order.setRouteId(rs.getLong(7));
                Order.setPrice(rs.getInt(8));
                all.add(Order);
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
    

    public List<Order> findByUserName(String username) throws Exception { 
    	List<Order> all = new ArrayList<Order>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM orderinfo WHERE userId = (select id from user where username = ?) "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, username); 
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                Order Order = new Order(); 
                Order.setId(rs.getLong(1));
                Order.setStatus(rs.getString(2)); 
                Order.setCreateDate(rs.getTimestamp(3));
                Order.setPayTime(rs.getTimestamp(4));
                Order.setLastUpdateDate(rs.getTimestamp(5));
                Order.setPrice(rs.getInt(6));
                Order.setUserId(rs.getLong(7));
                Order.setRouteId(rs.getLong(8));
         
                all.add(Order);
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



public List<Order> findAllOrder() throws Exception { 
	List<Order> all = new ArrayList<Order>(); 
    PreparedStatement pstmt = null; 
    String sql = "SELECT * FROM orderinfo "; 
    try { 
        pstmt = this.conn.prepareStatement(sql); 
         
        ResultSet rs = pstmt.executeQuery(); 
        while (rs.next()) { 
            Order Order = new Order(); 
            Order.setId(rs.getLong(1));
            Order.setStatus(rs.getString(2)); 
            Order.setCreateDate(rs.getTimestamp(3));
            Order.setPayTime(rs.getTimestamp(4));
            Order.setLastUpdateDate(rs.getTimestamp(5));
            Order.setUserId(rs.getLong(6));
            Order.setRouteId(rs.getLong(7));
            Order.setPrice(rs.getInt(8));
            all.add(Order);
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

 
public Order findByOrderId(Long id) throws Exception { 
	Order Order = new Order(); 
	PreparedStatement pstmt = null; 
    String sql = "SELECT * FROM orderinfo  where id = ?"; 
    try { 
        pstmt = this.conn.prepareStatement(sql); 
        pstmt.setLong(1, id);
        ResultSet rs = pstmt.executeQuery(); 
        while (rs.next()) { 
            
        	Order.setId(rs.getLong(1));
            Order.setStatus(rs.getString(2)); 
            Order.setCreateDate(rs.getTimestamp(3));
            Order.setPayTime(rs.getTimestamp(4));
            Order.setLastUpdateDate(rs.getTimestamp(5));
            Order.setPrice(rs.getInt(6));
            Order.setUserId(rs.getLong(7));
            Order.setRouteId(rs.getLong(8));
            
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
    return Order; 
} 
 
public Order findByCreateTime(Date createTime) throws Exception { 
	Order Order = new Order(); 
	PreparedStatement pstmt = null; 
    String sql = "SELECT * FROM orderinfo  where createDate = ?"; 
    try { 
        pstmt = this.conn.prepareStatement(sql); 
        pstmt.setDate(1, createTime);
        ResultSet rs = pstmt.executeQuery(); 
        while (rs.next()) { 
            
        	Order.setId(rs.getLong(1));
            Order.setStatus(rs.getString(2)); 
            Order.setCreateDate(rs.getTimestamp(3));
            Order.setPayTime(rs.getTimestamp(4));
            Order.setLastUpdateDate(rs.getTimestamp(5));
            Order.setUserId(rs.getLong(6));
            Order.setRouteId(rs.getLong(7));
            Order.setPrice(rs.getInt(8));
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
    return Order; 
}

public Order findByMaxOrderId() throws Exception { 
	Order Order = new Order(); 
	PreparedStatement pstmt = null; 
    String sql = "SELECT * FROM orderinfo  where id = (select max(id) from orderinfo order by id desc)"; 
    try { 
        pstmt = this.conn.prepareStatement(sql); 
        ResultSet rs = pstmt.executeQuery(); 
        while (rs.next()) { 
            
        	Order.setId(rs.getLong(1));
            Order.setStatus(rs.getString(2)); 
            Order.setCreateDate(rs.getTimestamp(3));
            Order.setPayTime(rs.getTimestamp(4));
            Order.setLastUpdateDate(rs.getTimestamp(5));
            Order.setUserId(rs.getLong(6));
            Order.setRouteId(rs.getLong(7));
            Order.setPrice(rs.getInt(8));
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
    return Order; 
} 
}