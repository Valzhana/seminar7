package notes;

import notes.controllers.AdapterController;
import notes.controllers.IController;
import notes.controllers.NoteController;
import notes.loggers.Logable;
import notes.loggers.Logger;
import notes.models.*;
import notes.views.*;

public class Main {
    public static void main(String[] args) {
        Logable logger = new Logger("log.txt");
        FileOperation fileOperation = new FileOperationImpl("notes.txt");
        Repository repository = new RepositoryFile(fileOperation, new NoteMapper());
        IController controller = new AdapterController(repository);
        IViewOperations viewOperations = new ViewOperations(controller);
        IViewOperations viewLogOperations = new ViewLogOperations(viewOperations, logger);
        IViewNote view = new ViewNote(viewLogOperations);
        view.run();
    }
}
