package com.meession.um.dao.impl;



import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List;

import com.meession.um.dao.UserDAO;
import com.meession.um.entity.User; 
 
public class UserImpl implements UserDAO { 
    private Connection conn = null; 
 
    public UserImpl(Connection conn) { 
        this.conn = conn; 
    } 
 
    public boolean doCreate(User user) throws Exception {   // 注册信息
        boolean flag = false; 
        String sql = "INSERT INTO user(username,password,mail,name,birthday,phoneNumber,idCard,idType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; 
        PreparedStatement pstmt = null; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getMail());
            pstmt.setString(4, user.getName());
            pstmt.setDate(5, new java.sql.Date(user.getBirthday().getTime())); 
            pstmt.setString(6, user.getPhoneNumber());
            pstmt.setString(7,user.getIdCard());
            pstmt.setString(8, user.getIdType());
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
 
    public boolean doUpdate(User user) throws Exception { //���¸�����Ϣ
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "UPDATE user SET name = ?, password = ?, birthday = ?, phoneNumber = ?, idCard = ? ,idType= ?,balance = ? where username = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, user.getName()); 
            pstmt.setString(2, user.getPassword()); 
            pstmt.setDate(3, new java.sql.Date(user.getBirthday().getTime())); 
            pstmt.setString(4, user.getPhoneNumber());
            pstmt.setString(5, user.getIdCard());
            pstmt.setString(6, user.getIdType());
            pstmt.setInt(7, user.getBalance());
            pstmt.setString(8, user.getUsername()); 
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
     
    public boolean doDelete(int id) throws Exception { 
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "DELETE FROM user WHERE id = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setInt(1, id); 
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
 
    public User findById(String username) throws Exception { 
        User user = null; 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM user WHERE username = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, username); 
            ResultSet rs = pstmt.executeQuery(); 
            if (rs.next()) { 
                user = new User(); 
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2)); 
                user.setPassword(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setName(rs.getString(5));
                user.setBirthday(rs.getDate(6));
                user.setPhoneNumber(rs.getString(7));
                user.setIdCard(rs.getString(8));
                user.setIdType(rs.getString(9));
                user.setBalance(rs.getInt(10));
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
        return user; 
    } 
 
    public List<User> findAll() throws Exception { 
        List<User> all = new ArrayList<User>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM user"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
             
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                User user = new User(); 
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2)); 
                user.setPassword(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setName(rs.getString(5));
                user.setBirthday(rs.getDate(6));
                user.setPhoneNumber(rs.getString(7));
                user.setIdCard(rs.getString(8));
                user.setIdType(rs.getString(9)); 
                user.setBalance(rs.getInt(10));
                all.add(user); 
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
} 

