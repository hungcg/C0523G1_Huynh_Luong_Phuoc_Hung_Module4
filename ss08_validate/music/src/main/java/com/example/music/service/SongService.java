package com.example.music.service;

import com.example.music.model.Song;
import com.example.music.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository repository;

    @Override
    public List<Song> showAll() {
        return repository.findAll();
    }

    @Override
    public boolean create(Song song) {
        Song song1 = repository.save(song);
        return song1!=null;
    }

    @Override
    public boolean update( Song song) {
        Song song1 = repository.save(song);
        return song1!=null;
    }

    @Override
    public Song findById(int id) {
        return repository.findById(id).get();
    }
}
