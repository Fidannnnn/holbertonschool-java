package com.song.demo;

import java.util.Objects;

public class Song {
    private Integer id;
    private String name;
    private String artist;
    private String album;
    private String releaseYear;

    public Song() {
    }

    public Song(Integer id, String name, String artist, String album, String releaseYear) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
    }

    // Getters
    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }
    public String getReleaseYear() { return releaseYear; }

    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setArtist(String artist) { this.artist = artist; }
    public void setAlbum(String album) { this.album = album; }
    public void setReleaseYear(String releaseYear) { this.releaseYear = releaseYear; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Song)) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
    }
}
