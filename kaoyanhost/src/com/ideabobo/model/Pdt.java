package com.ideabobo.model;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class Pdt implements java.io.Serializable {

	// Fields
    private Integer id;
    private String title;
    private String daan;
    private Integer type;
    private String img;
    private Integer leixing;
    private Integer typeid;
    
    
    
    
    
    
   	public Integer getTypeid() {
		return typeid;
	}
	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}
	public Integer getLeixing() {
		return leixing;
	}
	public void setLeixing(Integer leixing) {
		this.leixing = leixing;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Integer getType() {
   		return type;
   	}
   	public void setType(Integer type) {
   		this.type = type;
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
	public String getDaan() {
		return daan;
	}
	public void setDaan(String daan) {
		this.daan = daan;
	}
	
    
}