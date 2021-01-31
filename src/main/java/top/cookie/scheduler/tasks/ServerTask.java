package top.cookie.scheduler.tasks;

public abstract class ServerTask {
    protected Runnable task;
    protected boolean cancel = false;
    protected Runnable taskOnCompletion;
    public ServerTask(Runnable task){
        this.task = task;
    }

    public abstract void run();

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel() {
        this.cancel = true;
        if (this.taskOnCompletion != null)
            this.taskOnCompletion.run();
    }

    public Runnable getTask() {
        return task;
    }

    public void setCompletionTask(Runnable runnable){
        this.taskOnCompletion = runnable;
    }
}
