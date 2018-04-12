package com.meession.am.dao.proxy; 
 
import java.util.List;

import com.meession.common.DBConnection;
import com.meession.am.dao.StationLinkDAO;
import com.meession.am.dao.impl.StationLinkImpl;
import com.meession.am.entity.StationLink;

public class IStationLinkDAOProxy implements StationLinkDAO { 
    private DBConnection dbc = null; 
    private StationLinkDAO dao = null; 
 
    public IStationLinkDAOProxy() { 
        this.dbc = new DBConnection(); 
        this.dao = new StationLinkImpl(this.dbc.getConnection()); 
    } 
 

    public boolean doCreateSL(StationLink stationLink) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doCreateSL(stationLink); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 

    public boolean doUpdateSL(StationLink stationLink) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doUpdateSL(stationLink); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 

    public boolean doDeleteSL(StationLink stationLink) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doDeleteSL(stationLink); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
 
    public StationLink findSL(StationLink stationLink) throws Exception { 
         StationLink StationLink = null;
        try { 
             StationLink = this.dao.findSL(stationLink); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return stationLink; 
    } 
 
 
    public List<StationLink> findALLSL(Long stationLinkOneId) throws Exception { 
        List<StationLink> all = null; 
        try { 
            all = this.dao.findALLSL(stationLinkOneId); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }

} 
