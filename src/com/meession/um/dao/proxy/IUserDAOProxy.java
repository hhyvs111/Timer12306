package com.meession.um.dao.proxy; 
 
import java.util.List;

import com.meession.common.DBConnection;
import com.meession.um.dao.UserDAO;
import com.meession.um.dao.impl.UserImpl;
import com.meession.um.entity.User;

public class IUserDAOProxy implements UserDAO { 
    private DBConnection dbc = null; 
    private UserDAO dao = null; 
 
    public IUserDAOProxy() { 
        this.dbc = new DBConnection(); 
        this.dao = new UserImpl(this.dbc.getConnection()); 
    } 
 

    public boolean doCreate(User user) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doCreate(user); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
 
    public boolean doUpdate(User user) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doUpdate(user); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
    public boolean doDelete(int id) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doDelete(id); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 

    public User findById(String username) throws Exception { 
        User user = null; 
        try { 
            user = this.dao.findById(username); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return user; 
    } 
 
    public List<User> findAll() throws Exception { 
        List<User> all = null; 
        try { 
            all = this.dao.findAll(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }

} 
