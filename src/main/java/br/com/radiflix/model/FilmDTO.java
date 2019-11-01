package br.com.radiflix.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class FilmDTO {
	
	@JsonProperty("name")
	public String name;
	
	@JsonProperty("genre")
	public String genre;
	
	@JsonProperty("details")
	public String details;
	
	@JsonProperty("watched")
	public Integer watched;
	
	@JsonProperty("release-year")
	public Date releaseYear;

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

	public Date getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

}
