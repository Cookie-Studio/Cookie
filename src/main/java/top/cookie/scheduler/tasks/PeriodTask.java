package top.cookie.scheduler.tasks;

public class PeriodTask extends ServerTask{
    protected int period;
    protected int runningTick;
    public PeriodTask(Runnable runnable, int period){
        super(runnable);
        this.period = period;
    }
    @Override
    public void run() {
        if (this.isCancel())
            return;
        if (this.runningTick == 0){
            this.task.run();
        }
        this.runningTick++;
        if (this.runningTick == (this.period + 1)){
            this.task.run();
            this.runningTick = 1;
        }
    }
}
