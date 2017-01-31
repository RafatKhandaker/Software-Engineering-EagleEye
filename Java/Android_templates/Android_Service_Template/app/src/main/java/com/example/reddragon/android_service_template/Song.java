package com.example.reddragon.android_service_template;

/**
 * Created by RedDragon on 1/30/17.
 */

public class Song {

    private long id;
    private String title;
    private String artist;

    public Song(long id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public long getID(){return id;}
    public String getTitle(){return title;}
    public String getArtist(){return artist;}

}
