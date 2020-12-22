package com.exam.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@Column
	String jobtitle;
	@Column
	String jobdescription;
	@Column
	String skills;
	@Column
	String jobtduration;
	@Column
	String joblength;
	@Column
	String budget;
	@Column
	String jobtype;
	@Column
	String experiance;
	public job() {
		super();
	}
	public job(long id, String jobtitle, String jobdescription, String skills, String jobtduration, String joblength,
			String budget, String jobtype, String experiance) {
		super();
		this.id = id;
		this.jobtitle = jobtitle;
		this.jobdescription = jobdescription;
		this.skills = skills;
		this.jobtduration = jobtduration;
		this.joblength = joblength;
		this.budget = budget;
		this.jobtype = jobtype;
		this.experiance = experiance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getJobtduration() {
		return jobtduration;
	}
	public void setJobtduration(String jobtduration) {
		this.jobtduration = jobtduration;
	}
	public String getJoblength() {
		return joblength;
	}
	public void setJoblength(String joblength) {
		this.joblength = joblength;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getJobtype() {
		return jobtype;
	}
	public void setJobtype(String jobtype) {
		this.jobtype = jobtype;
	}
	public String getExperiance() {
		return experiance;
	}
	public void setExperiance(String experiance) {
		this.experiance = experiance;
	}
}
