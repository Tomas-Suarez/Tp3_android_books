package com.tp.tp3_android_books;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

public class BookModel implements Serializable {

    private UUID id;
    private String title;
    private String author;
    private int pages;
    private int year;
    private List<String> genres;
    private String synopsis;
    private int imageId;

    public BookModel(UUID id, String title, String author, int pages, int year, List<String> genres, String synopsis, int imageId) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.year = year;
        this.genres = genres;
        this.synopsis = synopsis;
        this.imageId = imageId;
    }

    public BookModel() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
