package notes.views;

import notes.loggers.Logable;

import java.time.LocalDateTime;

public class ViewLogOperations implements IViewOperations {
    private IViewOperations viewOperations;
    private Logable logable;

    public ViewLogOperations(IViewOperations viewOperations, Logable logable) {
        this.viewOperations = viewOperations;
        this.logable = logable;
    }

    private String logText(String method){
        return logText(LocalDateTime.now(), method);
    }

    private String logText(LocalDateTime dateTime, String method){
        String text = String.format("\ndate: %s, method: %s", dateTime.toString(), method);
        return text;
    }

    @Override
    public void caseRead() throws Exception {
        String log = logText("read");
        logable.writeLog(log);
        viewOperations.caseRead();
    }

    @Override
    public void caseDeleted() throws Exception {
        String log = logText("delete");
        logable.writeLog(log);
        viewOperations.caseDeleted();
    }

    @Override
    public void caseUpdate() throws Exception {
        String log = logText("update");
        logable.writeLog(log);
        viewOperations.caseUpdate();
    }

    @Override
    public void caseList() throws Exception {
        String log = logText("list");
        logable.writeLog(log);
        viewOperations.caseList();
    }

    @Override
    public void caseCreate() throws Exception {
        String log = logText("create");
        logable.writeLog(log);
        viewOperations.caseCreate();
    }
    @Override
    public String prompt(String message) throws Exception {
        return viewOperations.prompt(message);
    }
}
