package com.meession.am.entity;

/**
 * 车站与车站的关联信息
 * 
 *
 */
public class StationLink {

	private Long id;
	/**
	 * 距离(单位:千米)
	 */
	private Double distance;
	
	/**
	 * �?边车站的id
	 */
	private Long stationOneId;
	
	/**
	 * 另一边车站的id
	 */
	private Long stationTwoId;
	
	/**
	 * 备注
	 */
	private String remark;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getStationOneId() {
		return stationOneId;
	}

	public void setStationOneId(Long stationOneId) {
		this.stationOneId = stationOneId;
	}

	public Long getStationTwoId() {
		return stationTwoId;
	}

	public void setStationTwoId(Long stationTwoId) {
		this.stationTwoId = stationTwoId;
	}

}
