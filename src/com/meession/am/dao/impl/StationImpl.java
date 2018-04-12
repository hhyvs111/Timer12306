package com.meession.am.dao.impl;



import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List;

import com.meession.am.dao.StationDAO;
import com.meession.am.entity.Station; 
 
public class StationImpl implements StationDAO { 
    private Connection conn = null; 
 
    public StationImpl(Connection conn) { 
        this.conn = conn; 
    } 
 
    public boolean doCreateStation(Station Station) throws Exception {   // 车次信息
        boolean flag = false; 
        String sql = "INSERT INTO Station(name,level,desb) VALUES (?, ?, ?)"; 
        PreparedStatement pstmt = null; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, Station.getName());
            pstmt.setString(2, Station.getLevel());
            pstmt.setString(3, Station.getDescribe());
            
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
 
    public boolean doUpdateStation(Station Station) throws Exception { //更新车次
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql1 = "UPDATE Station SET name = ?,level = ?,describe = ?  WHERE name = ? "; 
        try { 
        	pstmt = this.conn.prepareStatement(sql1); 
        	pstmt.setString(1, Station.getName());
            pstmt.setString(2, Station.getLevel());
            pstmt.setString(3, Station.getDescribe());     
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
     
    public boolean doDeleteStation(String name) throws Exception { 
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "DELETE FROM Station WHERE name = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, name); 
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
 
    public List<Station> findStation(String name) throws Exception {   //查询车次
    	 List<Station> all = new ArrayList<Station>();
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM Station WHERE name = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
            	Station station  = new Station(); 
            	station.setId(rs.getLong(1));
                station.setName(rs.getString(2));
                station.setLevel(rs.getString(3));
                station.setDescribe(rs.getString(4));
                all.add(station); 
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
 
    public List<Station> findALLStation() throws Exception { 
        List<Station> all = new ArrayList<Station>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM Station  "; 
        try { 
            pstmt = this.conn.prepareStatement(sql);  
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                Station station  = new Station(); 
                station.setId(rs.getLong(1));
                station.setName(rs.getString(2));
                station.setLevel(rs.getString(3));
                station.setDescribe(rs.getString(4));
                all.add(station); 
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

