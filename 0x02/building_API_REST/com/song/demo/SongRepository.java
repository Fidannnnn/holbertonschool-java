package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class SongRepository {

    private final List<Song> list = new ArrayList<>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        if (id == null) return null;
        for (Song s : list) {
            if (id.equals(s.getId())) {
                return s;
            }
        }
        return null;
    }

    public void addSong(Song s) {
        if (s == null) return;
        // if same id exists, replace it; otherwise append
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() != null && list.get(i).getId().equals(s.getId())) {
                list.set(i, s);
                return;
            }
        }
        list.add(s);
    }

    public void updateSong(Song s) {
        if (s == null || s.getId() == null) return;
        for (int i = 0; i < list.size(); i++) {
            if (s.getId().equals(list.get(i).getId())) {
                list.set(i, s);
                return;
            }
        }
        // if not found, add as new (simple behavior for this assignment)
        list.add(s);
    }

    public void removeSong(Song s) {
        if (s == null || s.getId() == null) return;
        Integer targetId = s.getId();
        Iterator<Song> it = list.iterator();
        while (it.hasNext()) {
            if (targetId.equals(it.next().getId())) {
                it.remove();
                return;
            }
        }
    }
}
