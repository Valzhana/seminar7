package notes.models;

public interface Mapper {
    String map(Note note);

    Note map(String line);
}
