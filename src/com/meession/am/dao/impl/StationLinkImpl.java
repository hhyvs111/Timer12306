package com.meession.am.dao.impl;



import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.util.ArrayList; 
import java.util.List;

import com.meession.am.dao.StationLinkDAO;
import com.meession.am.entity.StationLink; 
 
public class StationLinkImpl implements StationLinkDAO { 
    private Connection conn = null; 
 
    public StationLinkImpl(Connection conn) { 
        this.conn = conn; 
    } 
 
    public boolean doCreateSL(StationLink stationLink) throws Exception {   // 车次信息
        boolean flag = false; 
        String sql = "INSERT INTO StationLink(distance,stationOneId,stationTwoId,remark) VALUES (?, ?, ?, ?)"; 
        PreparedStatement pstmt = null; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setDouble(1, stationLink.getDistance());
            pstmt.setLong(2, stationLink.getStationOneId());
            pstmt.setLong(3, stationLink.getStationTwoId());
            pstmt.setString(4, stationLink.getRemark());
            
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
 
    public boolean doUpdateSL(StationLink stationLink) throws Exception { //更新车次
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql1 = "UPDATE StationLink SET distance = ? remark = ?  WHERE stationOneId = ? and stationTwoId = ? "; 
        try { 
        	pstmt = this.conn.prepareStatement(sql1); 
        	pstmt.setDouble(1, stationLink.getDistance());
            pstmt.setString(2, stationLink.getRemark());
            pstmt.setLong(3, stationLink.getStationOneId());     
            pstmt.setLong(4, stationLink.getStationTwoId());     
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
     
    public boolean doDeleteSL(StationLink stationLink) throws Exception { 
        boolean flag = false; 
        PreparedStatement pstmt = null; 
        String sql = "DELETE FROM StationLink WHERE stationOneId = ? and stationTwoId = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setLong(1,stationLink.getStationOneId());
            pstmt.setLong(2, stationLink.getStationTwoId());
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
 
    public StationLink findSL(StationLink stationLink) throws Exception {   //查询车次
         StationLink StationLink = null;
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM StationLink WHERE StationOneId = ? and StationTwoId = ?"; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setLong(1, stationLink.getStationOneId());
            pstmt.setLong(2, stationLink.getStationTwoId());
            ResultSet rs = pstmt.executeQuery(); 
            if (rs.next()) { 
            stationLink  = new StationLink();
            stationLink.setDistance(rs.getDouble(1));
            stationLink.setStationOneId(rs.getLong(2));
            stationLink.setStationTwoId(rs.getLong(3));
            stationLink.setRemark(rs.getString(4));
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
        return stationLink; 
    } 
 
    public List<StationLink> findALLSL(Long stationLinkOneId) throws Exception { 
        List<StationLink> all = new ArrayList<StationLink>(); 
        PreparedStatement pstmt = null; 
        String sql = "SELECT * FROM StationLink  where stationLinkOneId = ?  "; 
        try { 
            pstmt = this.conn.prepareStatement(sql); 
            pstmt.setLong(1, stationLinkOneId);
            ResultSet rs = pstmt.executeQuery(); 
            while (rs.next()) { 
                StationLink stationLink  = new StationLink(); 
                stationLink.setDistance(rs.getDouble(1));
                stationLink.setStationOneId(rs.getLong(2));
                stationLink.setStationTwoId(rs.getLong(3));
                stationLink.setRemark(rs.getString(4));
                  
                all.add(stationLink); 
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

