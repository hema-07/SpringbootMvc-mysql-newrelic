package com.wipro.movie.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="film")
public class Film {
	
	@Id
	@Column(name="filmid")
	private String filmid;
	
	@Column(name="filmname")
	private String filmname;
	
	@Column(name="language")
	private String language;
	
	@Column(name="budget")
	private int budget;
	
	
	
	
	public String getFilmid() {
		return filmid;
	}
	public void setFilmid(String filmid) {
		this.filmid = filmid;
	}
	public String getFilmname() {
		return filmname;
	}
	public void setFilmname(String filmname) {
		this.filmname = filmname;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	
	
	public Film() {}
	
}
