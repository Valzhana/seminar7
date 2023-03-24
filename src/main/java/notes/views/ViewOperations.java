package notes.views;

import notes.controllers.IController;
import notes.models.Note;


import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class ViewOperations implements IViewOperations {
    private IController noteController;
    public ViewOperations(IController controller) {
        this.noteController = controller;
    }
    public void caseDeleted() {
        String id = prompt("Идентификатор записи: ");
        noteController.deleteNote(id);
        System.out.println("Данные удалены");
    }

    public void caseCreate() throws Exception {
        String title = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        String date = prompt("Дата: ");
        noteController.saveNote(new Note(title,text,date));
    }

    public void caseRead() {
        String id = prompt("Идентификатор записи: ");
        try {
            Note note = noteController.readNote(id);
            System.out.println(note);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void caseList() {
        List<Note> notesList = noteController.readNotes();
        for (Note note : notesList) {
            System.out.println(note);
        }
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
    public void caseUpdate() {
        String id = prompt("Идентификатор записи: ");
        String number = String.valueOf(parseInt(prompt("""
                1 - изменить заголовок
                2 - изменить текст
                3 - изменить дату
                """)));
        switch (number) {
            case "1" -> {
                noteController.updateNoteTitle(id);
            }
            case "2" -> {
                noteController.updateNoteText(id);
            }
            case "3" -> {
                noteController.updateNoteDate(id);
            }
        }
        System.out.println("Данные сохранены");
    }
}
