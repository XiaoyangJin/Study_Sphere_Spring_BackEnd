package com.study_sphere.spring_backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //indicate that the database should automatically generate the ID.
	private int post_id;
	private String title;
	private String summary;
	private String main_content;
	public int getPost_id() {
		return post_id;
	}
	
	// No-argument constructor
    public Post() {
    }
    
    
	public Post(int post_id, String title, String summary, String main_content) {
		super();
		this.post_id = post_id;
		this.title = title;
		this.summary = summary;
		this.main_content = main_content;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getMain_content() {
		return main_content;
	}
	public void setMain_content(String main_content) {
		this.main_content = main_content;
	}
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", title=" + title + ", summary=" + summary + ", main_content="
				+ main_content + "]";
	}
	
	
}
