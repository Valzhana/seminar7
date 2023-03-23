package notes.loggers;

import notes.models.*;

public abstract class RepositoryFileDecoratorFactory implements IRepositoryFileAbleFactory {
    private final Logable log;
    public RepositoryFileDecoratorFactory(Logable log) {
        this.log = log;
    }
    public Repository create(FileOperation fileOperation, Mapper mapper) {
        return new RepositoryFileDecorator( new RepositoryFile(fileOperation, mapper), log);
    }
}