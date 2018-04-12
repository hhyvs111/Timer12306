package com.meession.tm.dao; 
 
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.meession.tm.entity.Order; 
 
/**
 * @author me
 *
 */
public interface OrderDAO { 
    /** 
     * 表示创建订单的操作 
     *  
     * @param Order 
     * @return 
     * @throws Exception 
     */ 
    public boolean doCreateOrder(Order order) throws Exception; 
 
    /** 
     * 表示修改订单 
     *  
     * @param Order 
     * @return 
     * @throws Exception 
     */ 
    public boolean doUpdateOrder(Order order) throws Exception; 
 
    /** 
     * 表示删除订单 
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */ 
    public boolean doDeleteOrder(Long id) throws Exception; 
    
    
    /** 
     * 通过用户ID查询订单 
     *  
     * @param Userid 
     * @return 
     * @throws Exception 
     */ 
 public List<Order> findByUserId(Long userId  ) throws Exception; 
    
    /**
     * 通过订单状态查询订单
     * @param status
     * @return
     * @throws Exception
     */
    public List<Order> findByStatus(String status) throws Exception;
    /**
     * 通过用户名查询订单
     * @param username
     * @return
     * @throws Exception
     */
    public List<Order> findByUserName(String username) throws Exception;
    
    /** 
     * 表示查询所有订单 
     *  
     * @param keyWord 
     * @return 
     * @throws Exception 
     */ 
    public List<Order> findAllOrder() throws Exception; 
    
    /**
     * 通过订单ID查询订单
     * @param orderId
     * @return
     * @throws Exception
     */
    public Order findByOrderId(Long id) throws Exception;
    
    /**
     * 通过订单创建时间查询订单
     * @param createDate
     * @return
     * @throws Exception
     */
    public Order findByCreateTime(Date createDate) throws Exception ;
    
    public Order findByMaxOrderId() throws Exception;
    
    
} 
