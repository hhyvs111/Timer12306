package com.meession.am.entity;


/**
 * 车站
 * @author sam
 *
 */
public class Station {
     
	private Long id;
	/**
	 * 车站名称
	 */
	private String name;
	/**
	 * 车站等级:
	 * 特等�?,
	 * �?等站,
	 * 二等�?,
	 * 三等�?,
	 * 四等�?,
	 * 五等�?,
	 * 
	 */
	private String level;
	/**
	 * 车站描述
	 */
	private String describe;
	
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
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
}
