package com.ideabobo.model;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */

public class Type implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private String ownid;
	private String img;
	private String totalh;
	private String note;
	
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTotalh() {
		return totalh;
	}
	public void setTotalh(String totalh) {
		this.totalh = totalh;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
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
	public String getOwnid() {
		return ownid;
	}
	public void setOwnid(String ownid) {
		this.ownid = ownid;
	}

	

}