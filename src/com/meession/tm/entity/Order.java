package com.meession.tm.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 订单
 * 
 * @author sam
 */
public class Order {

	private Long id;

	/**
	 * 订单状态: 已创建, 待付款, 已付款, 已完成, 已取消
	 */
	private String status;

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + ", createDate=" + createDate + ", payTime=" + payTime
				+ ", lastUpdateDate=" + lastUpdateDate + ", userId=" + userId + ", routeId=" + routeId + ", price="
				+ price + "]";
	}
	/**
	 * 订单创建日期
	 */
	private Timestamp createDate;

	/**
	 * 支付日期
	 */
	private Timestamp payTime;

	/**
	 * 最后一次更改日期
	 */
	private Timestamp lastUpdateDate;

	/**
	 * 订单所属的用户
	 */
	private Long userId;
	/**
	 * 车次ID
	 */
	private Long routeId;
	
	private int price;
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Date getPayTime() {
		return payTime;
	}
	public void setPayTime(Timestamp payTime) {
		this.payTime = payTime;
	}
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}
	public void setLastUpdateDate(Timestamp lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}


	
}
