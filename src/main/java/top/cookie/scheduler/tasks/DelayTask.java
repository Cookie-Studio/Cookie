package top.cookie.scheduler.tasks;

public class DelayTask extends ServerTask{
    protected int delay;
    protected int runningTick = 0;

    public DelayTask(Runnable ruunbale, int delay){
        super(ruunbale);
        this.delay = delay;
    }

    public int getDelay() {
        return delay;
    }

    public int getRunningTick() {
        return runningTick;
    }

    @Override
    public void run() {
        if (this.isCancel())
            return;
        this.runningTick++;
        if (this.runningTick == this.delay){
            this.task.run();
            this.setCancel();
        }
    }
}
