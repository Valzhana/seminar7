package notes.views;


import notes.controllers.NoteController;
import notes.models.Note;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class ViewNote {
    private NoteController noteController;

    public ViewNote(NoteController noteController) {
        this.noteController = noteController;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        caseCreate();
                        break;
                    case READ:
                        caseRead();
                        break;
                    case LIST:
                        caseList();
                        break;
                    case DELETE:
                        caseDeleted();
                        break;
                    case UPDATE:
                        caseUpdate();
                        break;
                    }
            }
            catch  (Exception ee){
                System.out.printf("Error: %s\n ", ee.getMessage());
            }
        }
    }

    private void caseDeleted() {
        String id = prompt("Идентификатор записи: ");
        noteController.deleteNote(id);
        System.out.println("Данные удалены");
    }

    private void caseCreate() throws Exception {
        String title = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        String date = prompt("Дата: ");
        noteController.saveNote(new Note(title,text,date));
    }

    private void caseRead() {
        String id = prompt("Идентификатор записи: ");
        try {
            Note note = noteController.readNote(id);
            System.out.println(note);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void caseList() {
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
