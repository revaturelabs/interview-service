package com.revature.model;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * An object representation of our Comment model.
 * 
 * A side note to others:
 * 
 * Notice the lack of @Column annotations throughout this model. There is really
 * no need to add this if there doesn't have to be.
 * 
 * For one, it just causes a bit more clutter and confusion. Second, they're
 * really only useful for renaming the column on the backend, which this program
 * has no real use for.
 * 
 * Unless absolutely necessary, do not add more clutter here (which, ironically,
 * this comment does).
 * 
 * @author Davin Merry
 */

@Entity
@Table(name = "comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Calendar date;
	
	private String text;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "interview_interviewer")
	private InterviewInterviewer interviewInterviewer;
	
	public Comment() {
	}
	
	public Comment(int id, Calendar date, String text, InterviewInterviewer interviewInterviewer) {
		this.id = id;
		this.date = date;
		this.text = text;
		this.interviewInterviewer = interviewInterviewer;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Calendar getDate() {
		return this.date;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public Comment id(int id) {
		this.id = id;
		return this;
	}
	
	public Comment date(Calendar date) {
		this.date = date;
		return this;
	}
	
	public Comment text(String text) {
		this.text = text;
		return this;
	}

	public InterviewInterviewer getInterviewInterviewer() {
		return interviewInterviewer;
	}

	public void setInterviewInterviewer(InterviewInterviewer interviewInterviewer) {
		this.interviewInterviewer = interviewInterviewer;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, id, interviewInterviewer, text);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Comment)) {
			return false;
		}
		Comment other = (Comment) obj;
		return Objects.equals(date, other.date) && id == other.id
				&& Objects.equals(interviewInterviewer, other.interviewInterviewer) && Objects.equals(text, other.text);
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", date=" + date + ", text=" + text + ", interviewInterviewer="
				+ interviewInterviewer + "]";
	}
	
}