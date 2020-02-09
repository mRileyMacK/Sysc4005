public abstract class Workstation{
    protected String workTimesFilePath;
    protected Buffer<Component1> c1Buffer;
    public String getWorkTimesFilePath() {
        return workTimesFilePath;
    }
    public Workstation(String workTimesFile){
        this.workTimesFilePath = workTimesFile;
        c1Buffer = new Buffer<Component1>();
    }
    public void setWorkTimesFilePath(String workTimesFilePath) {
        this.workTimesFilePath = workTimesFilePath;
    }

    public Buffer<Component1> getc1Buffer(){
        return c1Buffer;
    }
}