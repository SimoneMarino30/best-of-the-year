package org.lessons.bestoftheyear;

public class Song {

    private int id;
    private String title;

    //CONSTRUCTOR

    public Song(int id, String title) {
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
