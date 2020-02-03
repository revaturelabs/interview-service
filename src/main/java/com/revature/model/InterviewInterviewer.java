package com.revature.model;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "interview_interviewer")
public class InterviewInterviewer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="interview_interviewer_id")
	private int id;
	
	private String text;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="fk_interview")
	private Interview interview;
	
<<<<<<< HEAD
	// This column will hold the interviewer's username
=======
	// This column will utilize the Interviewer's username.
>>>>>>> 9c66410cfb28f9dc4de0b1a0eddfc28c458d241d
	private String interviewer;
	
	public InterviewInterviewer() {
		super();
	}
	
	public InterviewInterviewer(int id, String text, Interview interview, String interviewer) {
		super();
		this.id = id;
		this.text = text;
		this.interview = interview;
		this.interviewer = interviewer;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Interview getInterview() {
		return interview;
	}
	
	public void setInterview(Interview interview) {
		this.interview = interview;
	}
	
	public String getInterviewer() {
		return interviewer;
	}
	
	public void setInterviewer(String interviewer) {
		this.interviewer = interviewer;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, interview, interviewer, text);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof InterviewInterviewer)) {
			return false;
		}
		InterviewInterviewer other = (InterviewInterviewer) obj;
		return id == other.id && Objects.equals(interview, other.interview)
				&& Objects.equals(interviewer, other.interviewer) && Objects.equals(text, other.text);
	}
	
	@Override
	public String toString() {
		return "InterviewJoin [id=" + id + ", text=" + text + ", interview=" + interview + ", interviewer="
				+ interviewer + "]";
	}
}