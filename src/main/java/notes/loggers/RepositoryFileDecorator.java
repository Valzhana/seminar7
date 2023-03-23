package notes.loggers;

import notes.models.FileOperation;
import notes.models.Mapper;
import notes.models.Note;
import notes.models.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepositoryFileDecorator implements Repository {
    private final Repository repository;
    private final Logable logable;


    public RepositoryFileDecorator(Repository repository, Logable logable) {
        this.repository = repository;
        this.logable = logable;
    }
    private Mapper mapper;
    private FileOperation fileOperation;
    public void RepositoryFile(FileOperation fileOperation, Mapper mapper) {
        this.fileOperation = fileOperation;
        this.mapper = mapper;
    }

    @Override
    public List<Note> getAllNotes() {
        List<String> lines = fileOperation.readAllLines();
        List<Note> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(mapper.map(line));
        }
        return notes;
    }

    @Override
    public String createNote(Note note) {

        List<Note> notes = getAllNotes();
        int max = 0;
        for (Note item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        saveRepository(notes);
        return id;
    }

    private void saveRepository(List<Note> notes) {
        List<String> lines = new ArrayList<>();
        for (Note item : notes) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);
    }

    @Override
    public void deleteNote(String noteId) {
        List<Note> notes = getAllNotes();

        Note foundNote = null;
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                foundNote = note;
            }
        }
        if (foundNote != null) {
            notes.remove(foundNote);
        }
        saveRepository(notes);
    }

    @Override
    public void updateNoteTitle(String userId) {
        List<Note> notes = getAllNotes();
        Note foundNote = null;
        for (Note note : notes) {
            if (note.getId().equals(userId)) {
                foundNote = note;
            }
        }
        if (foundNote != null) {
            String title = prompt("Введите заголовок:\n ");
            foundNote.setTitle(title);
        }
        saveRepository(notes);
    }

    @Override
    public void updateNoteText(String noteId) {
        List<Note> notes = getAllNotes();
        Note foundNote = null;
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                foundNote = note;
            }
        }
        if (foundNote != null) {
            String text = prompt("Введите текст :\n ");
            foundNote.setText(text);
        }
        saveRepository(notes);
    }

    @Override
    public void updateNoteDate(String noteId) {
        List<Note> notes = getAllNotes();
        Note foundNote = null;
        for (Note note : notes) {
            if (note.getId().equals(noteId)) {
                foundNote = note;
            }
        }
        if (foundNote != null) {
            String date = prompt("Введите дату:\n");
            foundNote.setDate(date);
        }
        saveRepository(notes);
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}