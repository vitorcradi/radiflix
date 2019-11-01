package br.com.radiflix.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name= "filme")
public class FilmEntity {
	
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "ano_lancamento")
	private Date releaseYear;
	
	@Column(name = "titulo")
	private String name;
	
	@Column(name = "genero")
	private String genre;
	
	@Column(name = "detalhe")
	private String details;
	
	@Column(name = "assistido")
	private Integer watched;

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Integer getWatched() {
		return watched;
	}

	public void setWatched(Integer watched) {
		this.watched = watched;
	}
}
