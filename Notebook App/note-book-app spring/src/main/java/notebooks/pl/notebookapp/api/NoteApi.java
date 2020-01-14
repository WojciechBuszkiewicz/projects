package notebooks.pl.notebookapp.api;


import notebooks.pl.notebookapp.api.viewers.NoteViewer;
import notebooks.pl.notebookapp.dao.NoteRepository;
import notebooks.pl.notebookapp.dao.entity.Note;
import notebooks.pl.notebookapp.dao.entity.NoteBook;
import notebooks.pl.notebookapp.manager.NoteBookManager;
import notebooks.pl.notebookapp.manager.NoteManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/notes")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteApi {
    NoteManager notes;
    NoteBookManager notebooks;

    public NoteApi(NoteManager notes, NoteBookManager notebooks) {
        this.notes = notes;
        this.notebooks = notebooks;
    }

    @GetMapping("/{id}")
    public List<NoteViewer> getNotesFromNotebook(@PathVariable Long id){
        NoteBook notebook = notebooks.findById(id);

        return notebook.getLists().stream().map(el -> new NoteViewer(el.getId(),el.getTitle(),el.getText(),notebook.getId()))
                .collect(Collectors.toList());
    }

    @PostMapping("/{id}")
    public NoteViewer addNote(@RequestBody NoteViewer note, @PathVariable Long id){
        Note newNote = notes.addNote(note,id);
        return new NoteViewer(newNote.getId(),newNote.getTitle(),newNote.getText(), newNote.getNoteBook().getId());
    }

    @PutMapping("/{id}")
    public NoteViewer updateNote(@RequestBody NoteViewer note,@PathVariable Long id){
        Note noteToUpdate = this.notes.findById(id);
        noteToUpdate.setText(note.getText());
        noteToUpdate.setTitle(note.getTitle());
        notes.uppdateNote(noteToUpdate);
        return new NoteViewer(noteToUpdate.getId(),noteToUpdate.getTitle(),noteToUpdate.getText(),noteToUpdate.getNoteBook().getId());
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id){
        notes.deleteNoteById(id);
    }

}
