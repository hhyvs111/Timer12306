package com.meession.am.entity;

import java.sql.Time;
import java.util.Date;

/**
 * 车次和站点的关联信息
 * @author sam
 *
 */
public class RouteStation {

	private Long id;
	/**
	 * 车站位于车次的第几个站点, �?1�?始计�?.
	 */
	private Integer postion;
	
	/**
	 * 到站时间
	 */
	private Time arrivalTime;
	/**
	 * 离站时间
	 */
	private Time leftTime;
	
	/**
	 * 车次id
	 */
	private Long routeId;
	/**
	 * 站点id
	 */
	private Long stationId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getPostion() {
		return postion;
	}
	public void setPostion(Integer postion) {
		this.postion = postion;
	}
	
	public Date getArrivalTime() {
		return arrivalTime;
	}
	
	public Time getLeftTime() {
		return leftTime;
	}
	public void setLeftTime(Time leftTime) {
		this.leftTime = leftTime;
	}
	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Long getRouteId() {
		return routeId;
	}
	public void setRouteId(Long routeId) {
		this.routeId = routeId;
	}
	public Long getStationId() {
		return stationId;
	}
	public void setStationId(Long stationId) {
		this.stationId = stationId;
	}
	
	
	
}
