package com.devedu.screenmatch.domain.movie;

public class Movie {

    private String name;
    private Integer duration;
    private Integer year;
    private String genre;

    public Movie() {}

    public Movie(String name, Integer duration, Integer year, String genre) {
        this.name = name;
        this.duration = duration;
        this.year = year;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
