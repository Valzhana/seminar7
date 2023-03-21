package notes;

import notes.controllers.NoteController;
import notes.models.*;
import notes.views.ViewNote;

public class Main {
    public static void main(String[] args) {
        saveFile();
    }

    private static void saveFile() {
        FileOperation fileOperation = new FileOperationImpl("notes.txt");
        Repository repository = new RepositoryFile(fileOperation, new NoteMapper());
        NoteController controller = new NoteController(repository);
        ViewNote view = new ViewNote(controller);
        view.run();
    }
}
