package notes.models;

import java.util.List;

public interface Repository {
    List<Note> getAllNotes();
    String createNote(Note note);
    void deleteNote(String noteId);
    void updateNoteTitle(String noteId);
    void updateNoteText(String userId);
    void updateNoteDate(String userId);

}
