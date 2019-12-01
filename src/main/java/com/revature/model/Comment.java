package com.revature.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * An object representation of our Comment model.
 * 
 * @author Davin Merry
 */
@Entity
@Table(name="comments")
public class Comment {
	/*
	 * A side note to others:
	 * 
	 * Notice the lack of @Column annotations throughout this model.
	 * There is really no need to add this if there doesn't have to be.
	 * 
	 * For one, it just causes a bit more clutter and confusion.
	 * Second, they're really only useful for renaming the column on the backend, which
	 * this program has no real use for.
	 * 
	 * Unless absolutely necessary, do not add more clutter here (which, ironically, this comment does).
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Timestamp date;
	private String name;
	private String text;
	
	public Comment() {
		super();
	}
	
	public Comment(int id, Timestamp date, String name, String text) {
		super();
		this.id = id;
		this.date = date;
		this.name = name;
		this.text = text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (text == null) {
			if (other.text != null)
				return false;
		}
		else if (!text.equals(other.text))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		}
		else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", date=" + date + ", name=" + name + ", text=" + text + "]";
	}
}
