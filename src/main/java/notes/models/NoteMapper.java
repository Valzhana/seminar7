package notes.models;


public class NoteMapper implements Mapper {
    @Override
    public String map(Note note) {
        return String.format("%s,%s,%s,%s", note.getId(), note.getTitle(), note.getText(), note.getDate());
    }

    @Override
    public Note map(String line) {
        String[] lines = line.split(",");
        return new Note(lines[0], lines[1], lines[2], lines[3]);
    }
}
