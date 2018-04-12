package com.meession.tm.dao; 
 
import java.sql.Date;
import java.util.List;

import com.meession.tm.entity.Ticket; 
 
public interface TicketDAO { 
    /** 
     * 表示创建订单的操作 
     *  
     * @param Ticket 
     * @return 
     * @throws Exception 
     */ 
    public boolean doCreateTicket(Ticket Ticket) throws Exception; 
 
    /** 
     * 更新订单 
     *  
     * @param Ticket 
     * @return 
     * @throws Exception 
     */ 
    public boolean doUpdateTicket(Ticket Ticket) throws Exception; 
 
    /** 
     * 删除订单 
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */ 
    public boolean doDeleteTicket(Long id) throws Exception; 
    
    
    /** 
     * 通过名字查询车票 
     *  
     * @param name
     * @return 
     * @throws Exception 
     */ 
    public List<Ticket> findByName(String name) throws Exception; 
    
    /**
     * 通过时间区间查询车票
     * @param oneTime
     * @param twoTime
     * @return
     * @throws Exception
     */
    public List<Ticket> findByTime(Date departureTime) throws Exception;
    
    /**
     * 通过车次名查询车票
     * @param route
     * @return
     * @throws Exception
     */
    public List<Ticket> findByRoute(String from,String to) throws Exception ;
    /** 
     * 表示查询所有订单 
     *  
     * @param keyWord 
     * @return 
     * @throws Exception 
     */ 
    public List<Ticket> findAllTicket() throws Exception; 
    
    /**
     * 通过票的ID查票
     * @param id
     * @return
     * @throws Exception
     */
    public Ticket findTicketById(Long id) throws Exception;
    
//    public Ticket findByNameTime(String route,Date departureTime) throws Exception;
    
   
} 
