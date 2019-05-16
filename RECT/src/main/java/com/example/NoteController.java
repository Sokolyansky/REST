package com.example;

import com.example.Note;
import com.example.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class NoteController {
    private NoteService service;

    @Autowired
    public void setNoteService(NoteService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<Note> phonebook = service.findAll();
        return model.addAttribute("notes", phonebook).toString();
    }

    @GetMapping("/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Note note = service.getNoteById(id);
        return model.addAttribute("note", note).toString();
    }

    @PutMapping("{id}")
    public String saveNote(@PathVariable Integer id, @RequestBody Map<String, String> message) {
        service.updateNote(id, message.get("name"), message.get("phone"));
        Note note = service.getNoteById(id);
        return note.toString();
    }


    @PostMapping
    public void updateNote(@RequestBody Map<String, String> message) {
        service.saveNote(new Note(message.get("name"), message.get("phone")));

    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteNote(id);

    }


}
