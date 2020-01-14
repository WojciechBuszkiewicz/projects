package notebooks.pl.notebookapp.dao.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class NoteBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy="noteBook", cascade = CascadeType.ALL)
    private List<Note> lists = new ArrayList<>();

    public NoteBook() {
    }

    public NoteBook(Long id, String title) {
        this.id = id;
        this.title = title;
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

    public List<Note> getLists() {
        return lists;
    }

    public void setLists(List<Note> lists) {
        this.lists = lists;
    }
}
