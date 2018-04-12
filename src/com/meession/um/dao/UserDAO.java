package com.meession.um.dao; 
 
import java.util.List;

import com.meession.um.entity.User; 
 
public interface UserDAO { 
    /** 
     * 表示数据库的增加操作 
     *  
     * @param user 
     * @return 
     * @throws Exception 
     */ 
    public boolean doCreate(User user) throws Exception; 
 
    /** 
     * 表示数据库的修改操作 
     *  
     * @param user 
     * @return 
     * @throws Exception 
     */ 
    public boolean doUpdate(User user) throws Exception; 
 
    /** 
     * 表示数据库的删除操作， 按 ID 查找 
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */ 
    public boolean doDelete(int id) throws Exception; 
    
    
    /** 
     * 表示数据库的查询操作 
     *  
     * @param id 
     * @return 
     * @throws Exception 
     */ 
    public User findById(String username) throws Exception; 
 
    /** 
     * 表示查询的时候返回一组对象 
     *  
     * @param keyWord 
     * @return 
     * @throws Exception 
     */ 
    public List<User> findAll() throws Exception; 
    
} 
