package com.ideabobo.model;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields
    private Integer id;
    private String title;
	private Integer uid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	
   
}