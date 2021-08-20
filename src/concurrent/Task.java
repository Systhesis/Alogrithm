package concurrent;

public class Task {
    private String id;
    private long putInTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getPutInTime() {
        return putInTime;
    }

    public void setPutInTime(long putInTime) {
        this.putInTime = putInTime;
    }

    public Task(String id, long putInTime) {
        this.id = id;
        this.putInTime = putInTime;
    }
}
