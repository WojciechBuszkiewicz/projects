package notebooks.pl.notebookapp.dao.entity;


import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private NoteBook noteBook;

    public Note() {
    }

    public Note(String title, String text, NoteBook noteBook) {
        this.title = title;
        this.text = text;
        this.noteBook = noteBook;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public NoteBook getNoteBook() {
        return noteBook;
    }

    public void setNoteBook(NoteBook noteBook) {
        this.noteBook = noteBook;
    }

    public void setText(String text) {
        this.text = text;
    }
}
