package com.meession.am.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 列车车次
 * 
 *
 */
public class Route {

	@Override
	public String toString() {
		return "Route [id=" + id + ", name=" + name + ", type=" + type + ", fromStation=" + fromStation + ", toStation="
				+ toStation + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ ", businessSeatCount=" + businessSeatCount + ", bPrice=" + bPrice + ", specialSeatCount="
				+ specialSeatCount + ", spPrice=" + spPrice + ", softSeatCount=" + softSeatCount + ", sfPrice="
				+ sfPrice + ", hardSeatCount=" + hardSeatCount + ", hPrice=" + hPrice + ", noSeatCount=" + noSeatCount
				+ ", nPrice=" + nPrice + ", remark=" + remark + ", fromStationId=" + fromStationId + ", toStationId="
				+ toStationId + "]";
	}

	private Long id;
	/**
	 * 车次�?
	 */
	private String name;

	/**
	 * 车次类型 
	 * 高�?�动�?(G) 
	 * 动车(D) 
	 * 直达特快列车 (Z) 
	 * 特别快车(T) 
	 * 快�?�列�? (K) 
	 * 临客(L) 
	 * 普�?�列�?(纯数字开�?)
	 */
	private String type;

	/**
	 * 始发站名�?
	 */
	private String fromStation;
	/**
	 * 终点站名�?
	 */
	private String toStation;

	/**
	 * 发车时间
	 */
	private Timestamp departureTime;
	/**
	 * 抵达时间
	 */
	private Date arrivalTime;

	/**
	 * 商务座数�?
	 */
	private Integer businessSeatCount;
	
	/**
	 *商务座价格 
	 */
	private Integer bPrice;
	
	/**
	 * 特等座数�?
	 */
	private Integer specialSeatCount;
	
	/**
	 * 特等座价格
	 */
	private Integer spPrice;
	/**
	 * 软卧数量
	 */
	private Integer softSeatCount;
	/**
	 * 软卧价格
	 */
	private Integer sfPrice;
	/**
	 * 硬座数量
	 */
	private Integer hardSeatCount;
	/**
	 * 硬座价格
	 */
	private Integer hPrice;
	/**
	 * 无座数量
	 */
	private Integer noSeatCount;
	/**
	 * 无座价格
	 */
	private Integer nPrice;

	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 出发�? id
	 */
	private Long fromStationId;

	/**
	 * 终点�? id
	 */
	private Long toStationId;


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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public String getToStation() {
		return toStation;
	}

	public void setToStation(String toStation) {
		this.toStation = toStation;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Timestamp departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Integer getBusinessSeatCount() {
		return businessSeatCount;
	}

	public void setBusinessSeatCount(Integer businessSeatCount) {
		this.businessSeatCount = businessSeatCount;
	}

	public Integer getbPrice() {
		return bPrice;
	}

	public void setbPirce(Integer bPrice) {
		this.bPrice = bPrice;
	}

	public Integer getSpecialSeatCount() {
		return specialSeatCount;
	}

	public void setSpecialSeatCount(Integer specialSeatCount) {
		this.specialSeatCount = specialSeatCount;
	}

	public Integer getSpPrice() {
		return spPrice;
	}

	public void setSpPrice(Integer spPrice) {
		this.spPrice = spPrice;
	}

	public Integer getSoftSeatCount() {
		return softSeatCount;
	}

	public void setSoftSeatCount(Integer softSeatCount) {
		this.softSeatCount = softSeatCount;
	}

	public Integer getSfPrice() {
		return sfPrice;
	}

	public void setSfPrice(Integer sfPrice) {
		this.sfPrice = sfPrice;
	}

	public Integer getHardSeatCount() {
		return hardSeatCount;
	}

	public void setHardSeatCount(Integer hardSeatCount) {
		this.hardSeatCount = hardSeatCount;
	}

	public Integer gethPrice() {
		return hPrice;
	}

	public void sethPrice(Integer hPrice) {
		this.hPrice = hPrice;
	}

	public Integer getNoSeatCount() {
		return noSeatCount;
	}

	public void setNoSeatCount(Integer noSeatCount) {
		this.noSeatCount = noSeatCount;
	}

	public Integer getnPrice() {
		return nPrice;
	}

	public void setnPrice(Integer nPrice) {
		this.nPrice = nPrice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getFromStationId() {
		return fromStationId;
	}

	public void setFromStationId(Long fromStationId) {
		this.fromStationId = fromStationId;
	}

	public Long getToStationId() {
		return toStationId;
	}

	public void setToStationId(Long toStationId) {
		this.toStationId = toStationId;
	}

	
	
}
