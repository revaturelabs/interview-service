package com.revature.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * An object representation of our Profile model.
 * This model is considered our "Interviewee".
 * 
 * [TODO] If you are adding on to this or incorporating Spring Data, please add your name to the author list.
 * @author Davin Merry
 * @author 
 */
public class Profile {
	private int id;
	private String firstName;
	private String lastName;
	private List<Skill> skills;
	
	@OneToMany(mappedBy = "MyInterview", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Interview> MyInterview;
	private String description;
	
	public Profile() {
		super();
	}
	
	public Profile(int id, String firstName, String lastName, List<Skill> skills, Set<Interview> interviews,
			String description) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.skills = skills;
		this.MyInterview = interviews;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public Set<Interview> getInterviews() {
		return MyInterview;
	}

	public void setInterviews(Set<Interview> interviews) {
		this.MyInterview = interviews;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((MyInterview == null) ? 0 : MyInterview.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((skills == null) ? 0 : skills.hashCode());
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
		Profile other = (Profile) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id != other.id)
			return false;
		if (MyInterview == null) {
			if (other.MyInterview != null)
				return false;
		} else if (!MyInterview.equals(other.MyInterview))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (skills == null) {
			if (other.skills != null)
				return false;
		} else if (!skills.equals(other.skills))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", skills=" + skills
				+ ", interviews=" + MyInterview + ", description=" + description + "]";
	}
}
