package com.museum.entity;

import java.time.LocalDate;

public class Artical {
	private Integer id;
	private String name;
	private Category category;
	private LocalDate createDate;
	private String  creatorName;
	public Artical() {
		
	}
	public Artical(Integer id, String name, Category category, LocalDate createDate, String creatorName) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.createDate = createDate;
		this.creatorName = creatorName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public String getCreatorName() {
		return creatorName;
	}
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Artical [id=" + id + ", name=" + name + ", category=" + category + ", createDate=" + createDate
				+ ", creatorName=" + creatorName + "]";
	}
	

}
