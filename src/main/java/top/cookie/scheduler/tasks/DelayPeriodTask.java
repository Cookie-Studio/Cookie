package top.cookie.scheduler.tasks;

public class DelayPeriodTask extends DelayTask{
    protected int period;
    protected int runningTick;
    public DelayPeriodTask(Runnable ruunbale, int delay, int period) {
        super(ruunbale, delay);
        this.period = period;
    }

    @Override
    public void run() {
        if (this.isCancel())
            return;
        this.runningTick++;
        if (this.runningTick == this.delay){
            this.task.run();
            this.runningTick++;
        }
        if (this.runningTick == (this.delay + period + 1)){
            this.task.run();
            this.runningTick = this.delay + 1;
        }
    }
}
