package notes.controllers;

import notes.models.Note;

import java.util.List;

public interface IController {

    public void saveNote(Note note) throws Exception;

    public Note readNote(String noteId) throws Exception;

    public List<Note> readNotes();

    public void deleteNote(String noteId);
    public void updateNoteTitle(String noteId);
    public void updateNoteText(String noteId);
    public void updateNoteDate(String noteId);
}


