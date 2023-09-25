package com.example.music.service;

import com.example.music.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> showAll();
    boolean create(Song song);
    boolean update (Song song);
    Song findById(int id);

}
