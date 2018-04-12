package com.meession.tm.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 车票
 * 
 * @author sam
 */
public class Ticket {

	private Long id;
	/**
	 * 乘客姓名
	 */
	private String name;
	/**
	 * 车次 (车次名)
	 */
	private String route;
	/**
	 * 车号车型
	 */
	private String routeType;
	/**
	 * 座位号
	 */
	private String seatNum;
	/**
	 * 座位类型 
	 * businessSeat(商务座), 
	 * specialSeat(特等座), 
	 * softSeat(软座), 
	 * hardSeat(硬座),
	 * noSeat(无座),
	 */
	private String seatType;

	/**
	 * 发车时间
	 */
	private Timestamp departureTime;

	
	/**
	 * 价格
	 */
	private int price;

	/**
	 * 出发地
	 */
	private String from;

	/**
	 * 目的地
	 */
	private String to;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 车次id
	 */
	private Long routeId;
	/**
	 * 用户id
	 */
	private Long userId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getRouteType() {
		return routeType;
	}
	public void setRouteType(String routeType) {
		this.routeType = routeType;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public String getSeatType() {
		return seatType;
	}
	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
