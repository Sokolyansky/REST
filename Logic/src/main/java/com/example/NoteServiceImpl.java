package com.example;

import com.example.Note;
import com.example.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {


    private NoteRepository repository;

    @Autowired
    public void setProductRepository(NoteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Note getNoteById(Integer id) {
        return repository.findById(id).orElseGet(() -> new Note());
    }

    @Override
    public void saveNote(Note note) {
        repository.save(note);
    }

    @Override
    public void updateNote(Integer id, String name, String phoneNumber) {
        Note updated = repository.findById(id).orElseGet(() -> new Note());
        updated.setName(name);
        updated.setPhoneNumber(phoneNumber);
        repository.save(updated);
    }

    @Override
    public void deleteNote(Integer id) {
        repository.deleteById(id);
    }


    public List<Note> findAll() {
        return repository.findAll();


    }
}
