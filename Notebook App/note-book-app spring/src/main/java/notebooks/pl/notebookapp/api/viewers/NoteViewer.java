package notebooks.pl.notebookapp.api.viewers;

public class NoteViewer {

    private Long id;
    private String title;
    private String text;
    private Long notebookID;

    public NoteViewer(Long id, String title, String text, Long notebookID) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.notebookID = notebookID;
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

    public void setText(String text) {
        this.text = text;
    }

    public Long getNotebookID() {
        return notebookID;
    }

    public void setNotebookID(Long notebookID) {
        this.notebookID = notebookID;
    }
}
