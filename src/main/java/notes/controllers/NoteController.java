package notes.controllers;

import notes.models.Note;
import notes.models.Repository;
import notes.models.ValidateNote;

import java.util.List;

public class NoteController {

    private final Repository repositoryFileDecorator;

    private final ValidateNote validator = new ValidateNote();

    public NoteController(Repository repository) {
        this.repositoryFileDecorator = repository;
    }

    public void saveNote(Note note) throws Exception {
        validator.check(note);
        repositoryFileDecorator.createNote(note);
    }

    public Note readNote(String noteId) throws Exception {
        List<Note> notes = repositoryFileDecorator.getAllNotes();
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("Контакт не найден");
    }

    public List<Note> readNotes() {
        List<Note> notes = repositoryFileDecorator.getAllNotes();
        return notes;
    }

    public void deleteNote(String noteId) {
        repositoryFileDecorator.deleteNote(noteId);
    }
    public void updateNoteTitle(String noteId) {
        repositoryFileDecorator.updateNoteTitle(noteId);
    }
    public void updateNoteText(String noteId) {
        repositoryFileDecorator.updateNoteText(noteId);
    }
    public void updateNoteDate(String noteId) {
        repositoryFileDecorator.updateNoteDate(noteId);
    }
}
