package com.meession.am.dao;



import java.util.List;

import com.meession.am.entity.Station; 
 
/**
 * @author me
 *
 */
public interface StationDAO { 
    /** 
     * 增加车站 
     *  
     * @param Route 
     * @return 
     * @throws Exception 
     */ 
    public boolean doCreateStation(Station station) throws Exception; 
 
    /** 
     * 更新车站 
     *  
     * @param Route 
     * @return 
     * @throws Exception 
     */ 
    public boolean doUpdateStation(Station station) throws Exception; 
 
    /** 
     * 删除车站 
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */ 
    public boolean doDeleteStation(String name) throws Exception; 
   
    
    /** 
     * 根据车站名查询车站信息 
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */ 
    public List<Station> findStation(String name) throws Exception; 
 
    /** 
     * 查询所有站点 
     *  
     * @param keyWord 
     * @return 
     * @throws Exception 
     */ 
    public List<Station> findALLStation() throws Exception; 
    
} 
