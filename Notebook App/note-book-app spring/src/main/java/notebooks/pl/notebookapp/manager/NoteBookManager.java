package notebooks.pl.notebookapp.manager;

import notebooks.pl.notebookapp.api.viewers.NoteBookViewer;
import notebooks.pl.notebookapp.dao.NoteBookRepository;
import notebooks.pl.notebookapp.dao.entity.NoteBook;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteBookManager {
    private NoteBookRepository noteBooks;

    public NoteBookManager(NoteBookRepository noteBooks) {
        this.noteBooks = noteBooks;
    }

    public Iterable<NoteBook> getAll(){
    return noteBooks.findAll();
    }

    public NoteBook addNoteBook(NoteBook noteBook){
        return noteBooks.save(noteBook);
    }

    public void deleteNotebook(Long id){
        noteBooks.deleteById(id);
    }

    public NoteBook updateNotebook(NoteBookViewer notebook, Long id){
        NoteBook notebookToUpdate = noteBooks.findById(id).get();
        notebookToUpdate.setTitle(notebook.getTitle());
        noteBooks.save(notebookToUpdate);
        return notebookToUpdate;
    }

    public NoteBook findById(Long id){
        return this.noteBooks.findById(id).get();
    }

}
