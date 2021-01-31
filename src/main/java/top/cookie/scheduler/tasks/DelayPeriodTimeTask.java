package top.cookie.scheduler.tasks;

public class DelayPeriodTimeTask extends DelayPeriodTask{
    protected int periodTime;
    protected int hasPeriodTime;
    public DelayPeriodTimeTask(Runnable ruunbale, int delay, int period, int periodTime) {
        super(ruunbale, delay, period);
        this.periodTime = periodTime;
    }

    @Override
    public void run() {
        if (this.isCancel())
            return;
        this.runningTick++;
        if (this.runningTick == this.delay && this.hasPeriodTime < this.periodTime){
            this.task.run();
            this.hasPeriodTime++;
            this.runningTick++;
        }
        if (this.runningTick == (this.delay + period + 1) && this.hasPeriodTime < this.periodTime){
            this.task.run();
            this.hasPeriodTime++;
            this.runningTick = this.delay + 1;
        }
        if (this.hasPeriodTime == this.periodTime)
            this.setCancel();
    }
}
