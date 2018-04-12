package com.meession.tm.dao.proxy; 
 
import java.sql.Date;
import java.util.List;

import com.meession.common.DBConnection;
import com.meession.tm.dao.OrderDAO;
import com.meession.tm.dao.impl.OrderImpl;
import com.meession.tm.entity.Order;

public class IOrderDAOProxy implements OrderDAO { 
    private DBConnection dbc = null; 
    private OrderDAO dao = null; 
 
    public IOrderDAOProxy() { 
        this.dbc = new DBConnection(); 
        this.dao = new OrderImpl(this.dbc.getConnection()); 
    } 
 

    public boolean doCreateOrder(Order Order) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doCreateOrder(Order); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
 
    public boolean doUpdateOrder(Order Order) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doUpdateOrder(Order); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
 
    public boolean doDeleteOrder(Long id) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doDeleteOrder(id); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
 

    public List<Order> findByUserId(Long userId) throws Exception { 
        List<Order> all = null; 
        try { 
            all = this.dao.findByUserId(userId); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }

 
    public List<Order> findByStatus(String Status) throws Exception { 
        List<Order> all = null; 
        try { 
            all = this.dao.findByStatus(Status); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }
    
 
    public List<Order> findByUserName(String username) throws Exception { 
        List<Order> all = null; 
        try { 
            all = this.dao.findByUserName(username); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }

 
    public List<Order> findAllOrder() throws Exception { 
        List<Order> all = null; 
        try { 
            all = this.dao.findAllOrder(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }
    
 
    public Order findByOrderId(Long id) throws Exception { 
        Order order = null;
        try { 
            order = this.dao.findByOrderId(id); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return order; 
    }
 
    public Order findByCreateTime(Date createTime ) throws Exception { 
        Order order = null;
        try { 
            order = this.dao.findByCreateTime(createTime); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return order; 
    }
 
    public Order findByMaxOrderId() throws Exception { 
        Order order = null;
        try { 
            order = this.dao.findByMaxOrderId(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return order; 
    }

} 
