package com.revature.model;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * An object representation of our Comment model.
 * 
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
 * 
 * @author Davin Merry
 */
@Entity
@Table(name="comments")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Timestamp date;
	private String name;
	private String text;
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="interview_comments")
	private Interview interviewId;


	public Comment() {
	}

	public Comment(int id, Timestamp date, String name, String text, Interview interviewId) {
		this.id = id;
		this.date = date;
		this.name = name;
		this.text = text;
		this.interviewId = interviewId;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Interview getInterviewId() {
		return this.interviewId;
	}

	public void setInterviewId(Interview interviewId) {
		this.interviewId = interviewId;
	}

	public Comment id(int id) {
		this.id = id;
		return this;
	}

	public Comment date(Timestamp date) {
		this.date = date;
		return this;
	}

	public Comment name(String name) {
		this.name = name;
		return this;
	}

	public Comment text(String text) {
		this.text = text;
		return this;
	}

	public Comment interviewId(Interview interviewId) {
		this.interviewId = interviewId;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Comment)) {
			return false;
		}
		Comment comment = (Comment) o;
		return id == comment.id && Objects.equals(date, comment.date) && Objects.equals(name, comment.name) && Objects.equals(text, comment.text) && Objects.equals(interviewId, comment.interviewId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, date, name, text, interviewId);
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", date='" + getDate() + "'" +
			", name='" + getName() + "'" +
			", text='" + getText() + "'" +
			", interviewId='" + getInterviewId() + "'" +
			"}";
	}

	
}
