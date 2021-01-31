package top.cookie.scheduler.tasks;

public class PeriodTimeTask extends PeriodTask{
    protected int periodTime;
    protected int hasPeriodTime;
    public PeriodTimeTask(Runnable runnable, int period,int periodTime) {
        super(runnable, period);
        this.periodTime = periodTime;
    }

    @Override
    public void run() {
        if (this.isCancel())
            return;
        if (this.runningTick == 0){
            this.task.run();
            this.hasPeriodTime++;
        }
        this.runningTick++;
        if (this.runningTick == (this.period + 1)){
            this.task.run();
            this.hasPeriodTime++;
            this.runningTick = 1;
        }
        if (this.hasPeriodTime == this.periodTime)
            this.setCancel();
    }
}
