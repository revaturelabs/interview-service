package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An object representation of our Skill model.
 * 
 * @author Davin Merry
 */
@Entity
@Table(name="skills")
public class Skill {
	
	@Id
	@Column(name="skill_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="skill_title")
	private String title;
	
	public Skill() {
		super();
	}
	
	public Skill(int id, String title) {
		super();
		this.id = id;
		this.title = title;
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

	@Override
	public String toString() {
		return "Skill [id=" + id + ", title=" + title + "]";
	}
}
