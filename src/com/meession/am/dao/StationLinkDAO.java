package com.meession.am.dao;



import java.util.List;

import com.meession.am.entity.StationLink; 
 
public interface StationLinkDAO { 
    /** 
     * 表示数据库的增加操作 
     *  
     * @param Route 
     * @return 
     * @throws Exception 
     */ 
    public boolean doCreateSL(StationLink stationLink) throws Exception; 
 
    /** 
     * 表示数据库的修改操作 
     *  
     * @param Route 
     * @return 
     * @throws Exception 
     */ 
    public boolean doUpdateSL(StationLink stationLink) throws Exception; 
 
    /** 
     * 表示数据库的删除操作， 按 ID 查找 
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */ 
    public boolean doDeleteSL(StationLink stationLink) throws Exception; 
   
    
    /** 
     * 表示数据库的查询操作 
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */ 
    public StationLink findSL(StationLink stationLink) throws Exception; 
 
    /** 
     * 表示查询的时候返回所有站点 
     *  
     * @param keyWord 
     * @return 
     * @throws Exception 
     */ 
    public List<StationLink> findALLSL(Long stationOneId) throws Exception; 
    
} 
