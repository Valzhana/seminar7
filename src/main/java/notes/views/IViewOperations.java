package notes.views;

public interface IViewOperations {
    public void caseDeleted() throws Exception;
    public void caseCreate() throws Exception;
    public void caseRead() throws Exception;
    public void caseList() throws Exception;
    public String prompt(String message) throws Exception;
    public void caseUpdate() throws Exception;
}
