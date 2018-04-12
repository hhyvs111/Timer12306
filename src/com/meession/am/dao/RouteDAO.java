package com.meession.am.dao;



import java.sql.Date;
import java.util.List;

import com.meession.am.entity.Route; 
 
/**
 * @author me
 *
 */
/**
 * @author me
 *
 */
public interface RouteDAO { 
    /** 
     * 表示车次的增加操作 
     *  
     * @param Route 
     * @return 
     * @throws Exception 
     */ 
    public boolean doCreateRoute(Route route) throws Exception; 
 
    /** 
     * 表示车次的修改操作 
     *  
     * @param Route 
     * @return 
     * @throws Exception 
     */ 
    public boolean doUpdateRoute(Route route) throws Exception; 
 
    /** 
     * 表示根据站点和出发时间删除车次 
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */ 
    public boolean doDeleteRoute(Long routeId) throws Exception; 
    
    
    /** 
     *  
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */
    //
    /**
     * 表示查询所有的车次
     * @return
     * @throws Exception
     */
    public List<Route> findRoute(String fromStation,String toStation,Date departureTime) throws Exception;
    
    public List<Route> findAllRoute() throws Exception; 
 
    /** 
     * 表示通过发车站和目的站以及时间查询车次 
     *  
     * @param keyWord 
     * @return 
     * @throws Exception 
     */ 
    public List<Route> findByfromStation(String routeName,Date departureTime) throws Exception; 
    //
    /**
     * 表示通过发车时间查询车次
     * @param departureTime
     * @return
     * @throws Exception
     */
    public List<Route> findBydepartureTime(Date departureTime) throws Exception;
    
    /**
     * 通过 出发以及时间查询车次
     * @param Type
     * @return
     * @throws Exception
     */
    public Route findOnlyRoute(Long routeid) throws Exception;

    
} 
