package BT.BT03;

public class StopWatch {
    private long startTime, endTime;

    public void start() {
        startTime = System.currentTimeMillis();
    }
    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }
    public long getEndTime() {
        return endTime;
    }

    public long getRunTime() {
        return endTime - startTime;
    }
}
