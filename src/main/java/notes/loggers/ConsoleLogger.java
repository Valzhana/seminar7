package notes.loggers;

public class ConsoleLogger implements Logable {
    @Override
    public void writeLog(String log) {
        System.out.println(log);
    }
}
