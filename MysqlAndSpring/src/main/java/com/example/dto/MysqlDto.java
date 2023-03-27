package com.example.dto;

import jakarta.persistence.Column;

public class MysqlDto {

	private long id;
	private String title;
	private String description;
	private String content;
	
	public MysqlDto(long id, String title, String description, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.content = content;
	}
	public MysqlDto() {
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "MysqlEntity [id=" + id + ", title=" + title + ", description=" + description + ", content=" + content
				+ "]";
	}
}
