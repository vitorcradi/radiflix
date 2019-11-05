package br.com.radiflix.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class MovieDTO {

    @JsonProperty("name")
    public String name;

    @JsonProperty("genre")
    public String genre;

    @JsonInclude(Include.NON_EMPTY)
    @JsonProperty("genre_id")
    public int genreId;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("detail")
    public String detail;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("to_watch")
    public boolean toWatch;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("watched")
    public int watched;

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

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public boolean isToWatch() {
        return toWatch;
    }

    public void setToWatch(boolean toWatch) {
        this.toWatch = toWatch;
    }

    public int getWatched() {
        return watched;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

}
