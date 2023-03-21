package notes.models;

import java.util.regex.Pattern;

public class ValidateNote {
    private final Pattern patternName = Pattern.compile("^\\S*$");
    private final Pattern patternPhone = Pattern.compile("^\\d*$");


    public void check(Note note) throws Exception {
        if (!patternName.matcher(note.getTitle()).find()){
            throw new Exception("invalid title");
        }

        if (!patternName.matcher(note.getText()).find()){
            throw new Exception("invalid text");
        }

        if (!patternPhone.matcher(note.getDate()).find()){
            throw new Exception("invalid date");
        }
    }
}
