package notes.views;


import notes.controllers.NoteController;
import notes.models.Note;


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
                }
            }
            catch  (Exception ee){
                System.out.printf("%s something wrong \n ", ee.getMessage());
            }
        }
    }

    private void caseDeleted() {
        String id = prompt("Идентификатор записи: ");
        noteController.deleteNote(id);
        System.out.println("note deleted");
    }

    private void caseCreate() throws Exception {
        String title = prompt("Заголовок: ");
        String text = prompt("Текст: ");
        String date = prompt("Дата: ");
        Note note = new Note(id, title, text, date);
        noteController.saveNote(note);
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
}
