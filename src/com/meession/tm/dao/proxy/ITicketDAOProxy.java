package com.meession.tm.dao.proxy; 
 
import java.sql.Date;
import java.util.List;

import com.meession.common.DBConnection;
import com.meession.tm.dao.TicketDAO;
import com.meession.tm.dao.impl.TicketImpl;
import com.meession.tm.entity.Ticket;

public class ITicketDAOProxy implements TicketDAO { 
    private DBConnection dbc = null; 
    private TicketDAO dao = null; 
 
    public ITicketDAOProxy() { 
        this.dbc = new DBConnection(); 
        this.dao = new TicketImpl(this.dbc.getConnection()); 
    } 
 
 
    public boolean doCreateTicket(Ticket Ticket) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doCreateTicket(Ticket); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 

    public boolean doUpdateTicket(Ticket Ticket) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doUpdateTicket(Ticket); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 

    public boolean doDeleteTicket(Long id) throws Exception { 
        boolean flag = true; 
        try { 
            flag = this.dao.doDeleteTicket(id); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return flag; 
    } 
 
 

    public List<Ticket> findByName(String name) throws Exception { 
        List<Ticket> all = null; 
        try { 
            all = this.dao.findByName(name); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }

 
    public List<Ticket> findByTime(Date departureTime) throws Exception { 
        List<Ticket> all = null; 
        try { 
            all = this.dao.findByTime(departureTime); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }
    
 
    public List<Ticket> findByRoute(String from,String to) throws Exception { 
        List<Ticket> all = null; 
        try { 
            all = this.dao.findByRoute(from,to); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }
 
    public List<Ticket> findAllTicket() throws Exception { 
        List<Ticket> all = null; 
        try { 
            all = this.dao.findAllTicket(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return all; 
    }
 
    public Ticket findTicketById(Long id) throws Exception { 
        Ticket ticket = new Ticket();
        try { 
            ticket = this.dao.findTicketById(id); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } finally { 
            this.dbc.close(); 
        } 
        return ticket; 
    }
} 
