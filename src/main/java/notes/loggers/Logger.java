package notes.loggers;

import java.io.FileWriter;
import java.io.IOException;

public class Logger implements Logable {
    private String fileName;

    public Logger(String fileName) {
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void writeLog(String log) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(log);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
