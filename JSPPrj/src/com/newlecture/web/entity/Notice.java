/**
 * 
 */
package com.newlecture.web.entity;

import java.util.Date;
//유저에서 입력받은 저장소
public class Notice {
	private int id;
	private String title;
	private String writerId;
	private String content;
	private Date regDate;
	private int hit;
	private String files;
	
	public Notice() {

	}

	public Notice(int id, String title, String writerId, String content, Date regDate, int hit, String files) {
		super();
		this.id = id;
		this.title = title;
		this.writerId = writerId;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
		this.files = files;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "{\"id\":" + id + ", \"title\":\"" + title + "\", \"writerId\":\"" + writerId + "\", \"content\":\"" + content
				+ "\", \"regDate\":\"" + regDate + "\", \"hit\":" + hit + ", \"files\":\"" + files + "\"}";
	}
	
}
