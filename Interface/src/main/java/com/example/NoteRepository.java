package com.example;

import com.example.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Integer> {

    @Override
    List<Note> findAll();

    List<Note> findByName(String name);
}
