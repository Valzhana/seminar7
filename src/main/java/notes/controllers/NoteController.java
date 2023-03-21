package notes.controllers;

import notes.models.Note;
import notes.models.Repository;
import notes.models.ValidateNote;

import java.util.List;

public class NoteController {
    private final Repository repository;

    private final ValidateNote validator = new ValidateNote();

    public NoteController(Repository repository) {
        this.repository = repository;
    }

    public void saveNote(Note note) throws Exception {
        validator.check(note);
        repository.createNote(note);
    }

    public Note readNote(String noteId) throws Exception {
        List<Note> notes = repository.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("Контакт не найден");
    }

    public List<Note> readNotes() {
        List<Note> notes = repository.getAllNotes();
        return notes;
    }

    public void deleteNote(String noteId) {
        repository.deleteNote(noteId);
    }
    public void updateNoteTitle(String noteId) {
        repository.updateNoteTitle(noteId);
    }
    public void updateNoteText(String noteId) {
        repository.updateNoteText(noteId);
    }
    public void updateNoteDate(String noteId) {
        repository.updateNoteDate(noteId);
    }
}
