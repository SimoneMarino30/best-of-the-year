package org.lessons.bestoftheyear;

public class Movie {
    private int id;
    private String title;

    // CONSTRUCTOR
    public Movie(int id, String title) {
        this.id = id;
        this.title = title;
    }

    // GETTERS
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
