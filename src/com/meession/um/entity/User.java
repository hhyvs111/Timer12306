package com.meession.um.entity;



import java.util.Date; 
 
public class User { 
    private int id; 
    private String username;
    private String password;
    private String mail; 
    private String name; 
    private Date birthday;
    private String phoneNumber;
    private String idCard;
    private String idType;
    private int balance;


	public int getId() { 
        return id; 
    } 
 
    public void setId(int id) { 
        this.id = id; 
    } 
    
    public String getUsername(){
    	return username;
    	
    }
    public void setUsername(String username) { 
        this.username = username; 
    } 
    
    public String getPassword(){
    	return password;
    	
    }
    public void setPassword(String password) { 
        this.password = password; 
    } 
    
    public String getMail(){
    	return mail;
    	
    }
    
    public void setMail(String mail) { 
        this.mail = mail; 
    } 
    
    
    public String getName() { 
        return name; 
    } 
 
    public void setName(String name) { 
        this.name = name; 
    } 
 
 
    public Date getBirthday() { 
        return birthday; 
    } 
 
    public void setBirthday(Date birthday) { 
        this.birthday = birthday; 
    } 
    
    public String getPhoneNumber(){
    	return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
    	this.phoneNumber = phoneNumber;
    }
    
    public String getIdCard(){
    	return idCard;
    }
    
    public void setIdCard(String idCard){
    	this.idCard = idCard;
    }
    
    public String getIdType(){
    	return idType;
    }
    
    public void setIdType(String idType){
    	this.idType = idType;
    }

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", mail=" + mail + ", name=" + name
				+ ", birthday=" + birthday + ", phoneNumber=" + phoneNumber
				+ ", idCard=" + idCard + ", idType=" + idType + ", balance="
				+ balance + "]";
	}
    
} 
