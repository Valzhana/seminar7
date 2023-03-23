package notes.loggers;

import notes.models.*;

public class RepositoryFileAbleFactory implements IRepositoryFileAbleFactory {
    public Repository create(FileOperation fileOperation, Mapper mapper) {
        return new RepositoryFile(fileOperation, mapper);
    }
}

