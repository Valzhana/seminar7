package notes.controllers;

import notes.models.Note;
import notes.models.Repository;

import java.util.List;

public class AdapterController extends NoteController implements IController {
    @Override
    public void saveNote(Note note) throws Exception {
        super.saveNote(note);
    }

    @Override
    public Note readNote(String noteId) throws Exception {
        return super.readNote(noteId);
    }

    @Override
    public List<Note> readNotes() {
        return super.readNotes();
    }

    @Override
    public void deleteNote(String noteId) {
        super.deleteNote(noteId);
    }

    @Override
    public void updateNoteTitle(String noteId) {
        super.updateNoteTitle(noteId);
    }

    @Override
    public void updateNoteText(String noteId) {
        super.updateNoteText(noteId);
    }

    @Override
    public void updateNoteDate(String noteId) {
        super.updateNoteDate(noteId);
    }

    public AdapterController(Repository repository) {
        super(repository);
    }
}
