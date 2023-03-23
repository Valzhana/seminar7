package notes.loggers;

import notes.models.FileOperation;
import notes.models.Mapper;
import notes.models.Repository;

public interface IRepositoryFileAbleFactory {
        Repository create(FileOperation fileOperation, Mapper mapper);
}
