package notebooks.pl.notebookapp.api;


import notebooks.pl.notebookapp.api.viewers.NoteBookViewer;
import notebooks.pl.notebookapp.dao.entity.NoteBook;
import notebooks.pl.notebookapp.manager.NoteBookManager;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/noteBooks")
@CrossOrigin(origins = "http://localhost:4200")
public class NoteBookApi {

    NoteBookManager noteBooks;

    public NoteBookApi(NoteBookManager noteBooks) {
        this.noteBooks = noteBooks;
    }


    @GetMapping("/all")
    public List<NoteBookViewer> getAll(){
        List<NoteBookViewer> notebooksList = new ArrayList<>();
        noteBooks.getAll().forEach(notebook -> notebooksList.
                add(new NoteBookViewer(notebook.getId(),notebook.getTitle())));

        return notebooksList;
    }

    @PostMapping
    public NoteBookViewer addNoteBook(@RequestBody NoteBookViewer noteBook){
        NoteBook newNotebook = noteBooks.addNoteBook(new NoteBook(noteBook.getId(),noteBook.getTitle()));
        return new NoteBookViewer(newNotebook.getId(),newNotebook.getTitle());
    }


    @DeleteMapping("/{id}")
    public void removeNotebook(@PathVariable Long id){
        noteBooks.deleteNotebook(id);
    }

    @PutMapping("/{id}")
    public NoteBook updateNotebook(@RequestBody NoteBookViewer notebook, @PathVariable Long id){
        return noteBooks.updateNotebook(notebook,id);
    }


}
