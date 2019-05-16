package com.example;

import com.example.Note;

import java.util.List;

public interface NoteService {
    Note getNoteById(Integer id);

    void saveNote(Note note);

    void updateNote(Integer id, String name, String phoneNumber);

    void deleteNote(Integer id);

    List<Note> findAll();

}
