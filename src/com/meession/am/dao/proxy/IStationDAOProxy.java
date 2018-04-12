package com.meession.am.dao.proxy; 
 
import java.util.List;

import com.meession.common.DBConnection;
import com.meession.am.dao.StationDAO;
import com.meession.am.dao.impl.StationImpl;
import com.meession.am.entity.Station;

public class IStationDAOProxy implements StationDAO { 
    private DBConnection dbc = null; 
    private StationDAO dao = null; 
 
    public IStationDAOProxy() { 
        this.dbc = new DBConnection(); 
        this.dao = new StationImpl(this.dbc.getConnection()); 
    } 
 

    public boolean doCreateStation(Station station) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doCreateStation(station); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 

    public boolean doUpdateStation(Station station) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doUpdateStation(station); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
 
    public boolean doDeleteStation(String name) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doDeleteStation(name); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 

    public List<Station> findStation(String name) throws Exception { 
    	 List<Station> all = null; 
        try { 
             all = this.dao.findStation(name); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    } 
 

    public List<Station> findALLStation() throws Exception { 
        List<Station> all = null; 
        try { 
            all = this.dao.findALLStation(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }

} 
