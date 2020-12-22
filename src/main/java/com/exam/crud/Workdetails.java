package com.exam.crud;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Workdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	@Column
	String time;
	@Column
	String worktitle;
	@Column
	String date;
	@Column
	String clientname;
	public Workdetails() {
		super();
	}
	public Workdetails(long id, String time, String worktitle, String date, String clientname) {
		super();
		this.id = id;
		this.time = time;
		this.worktitle = worktitle;
		this.date = date;
		this.clientname = clientname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getWorktitle() {
		return worktitle;
	}
	public void setWorktitle(String worktitle) {
		this.worktitle = worktitle;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	@Override
	public String toString() {
		return "Workdetails [id=" + id + ", time=" + time + ", worktitle=" + worktitle + ", date=" + date
				+ ", clientname=" + clientname + "]";
	}
	
}
