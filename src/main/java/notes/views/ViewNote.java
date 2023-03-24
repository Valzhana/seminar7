package notes.views;


import notes.controllers.NoteController;
import notes.models.Note;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;


public class ViewNote implements IViewNote {
    private IViewOperations viewOperations;

    public ViewNote(IViewOperations viewOperations) {
        this.viewOperations = viewOperations;
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = viewOperations.prompt("Введите команду: ");
                com = Commands.valueOf(command.toUpperCase());
                if (com == Commands.EXIT) return;
                switch (com) {
                    case CREATE:
                        viewOperations.caseCreate();
                        break;
                    case READ:
                        viewOperations.caseRead();
                        break;
                    case LIST:
                        viewOperations.caseList();
                        break;
                    case DELETE:
                        viewOperations.caseDeleted();
                        break;
                    case UPDATE:
                        viewOperations.caseUpdate();
                        break;

                }
            } catch (Exception ee) {
                System.out.printf("Error: %s\n ", ee.getMessage());
            }
        }
    }
}
