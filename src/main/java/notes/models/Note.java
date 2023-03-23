package notes.models;


import java.util.List;

public class Note implements Repository {
    private String id = "";
    private String title;
    private String text;
    private String date;

    public Note(String title, String text, String date) {
        this.title = title;
        this.text = text;
        this.date = date;
    }
    public Note(String id, String title, String text, String data) {
        this(title, text, data);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public List<Note> getAllNotes() {
        return null;
    }

    @Override
    public String createNote(Note note) {
        return null;
    }

    @Override
    public void deleteNote(String noteId) {

    }

    @Override
    public void updateNoteTitle(String noteId) {

    }

    @Override
    public void updateNoteText(String userId) {

    }

    @Override
    public void updateNoteDate(String userId) {

    }
}
