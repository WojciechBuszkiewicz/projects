package notebooks.pl.notebookapp.manager;

import notebooks.pl.notebookapp.api.viewers.NoteViewer;
import notebooks.pl.notebookapp.dao.NoteBookRepository;
import notebooks.pl.notebookapp.dao.NoteRepository;
import notebooks.pl.notebookapp.dao.entity.Note;
import notebooks.pl.notebookapp.dao.entity.NoteBook;
import org.springframework.stereotype.Service;

@Service
public class NoteManager {
    private NoteRepository notes;
    private NoteBookRepository notebooks;

    public NoteManager(NoteRepository notes, NoteBookRepository notebooks) {
        this.notes = notes;
        this.notebooks = notebooks;
    }

    public Iterable<Note> getAll(){
        return notes.findAll();
    }

    public Note addNote(NoteViewer note, Long id){
        NoteBook notebook = notebooks.findById(id).get();
        Note newNote = new Note(note.getTitle(),note.getText(),notebook);
        return notes.save(newNote);
    }

    public Note findById(Long id){
        return notes.findById(id).get();
    }

    public Note uppdateNote(Note note){
        return notes.save(note);
    }

    public void deleteNoteById(Long id){
        notes.deleteById(id);
    }

}
