package top.cookie.scheduler;

import top.cookie.Server;
import top.cookie.scheduler.tasks.ServerTask;
import top.cookie.scheduler.timer.Timer;

import java.util.concurrent.CopyOnWriteArrayList;

public class Scheduler {
    private Thread mainThread;
    private Thread asyncThread;
    private CopyOnWriteArrayList<ServerTask> mainThreadTasks = new CopyOnWriteArrayList<>();
    private CopyOnWriteArrayList<ServerTask> asyncTasks = new CopyOnWriteArrayList<>();
    private Timer timer = new Timer(Server.getInstance().getServerTick());
    private int serverTPS = 20;

    public Timer getTimer() {
        return timer;
    }

    public CopyOnWriteArrayList<ServerTask> getMainThreadTask() {
        return mainThreadTasks;
    }

    public CopyOnWriteArrayList<ServerTask> getAsyncTask() {
        return asyncTasks;
    }

    public void registerTask(ServerTask task){
        this.registerTask(task,false);
    }

    public void registerTask(ServerTask task,boolean async){
        if (async)
            this.asyncTasks.add(task);
        else if(!async)
            this.mainThreadTasks.add(task);
    }

    public int getServerTPS() {
        return serverTPS;
    }

    public void start(){
        this.timer.startTiming();
        this.mainThread = new Thread(new MainThreadRunnable());
        this.mainThread.start();
        this.asyncThread = new Thread(new AsyncTaskRunnable());
        this.asyncThread.start();
    }

    private class MainThreadRunnable implements Runnable{
        @Override
        public void run() {
            long latestTick = 0;
            while(!mainThread.isInterrupted()){
                long l2 = timer.getRunTicks();
                if (latestTick != l2) {
                    for (ServerTask task : Scheduler.this.mainThreadTasks) {
                        task.run();
                        if (task.isCancel())
                            Scheduler.this.mainThreadTasks.remove(task);
                    }
                    if ((l2 - latestTick) > 1){
                        serverTPS = 20 - ((int)(l2 - latestTick) - 1);
                    }
                    latestTick = l2;
                }
            }
            while(mainThreadTasks.size() != 0){
                long l2 = timer.getRunTicks();
                if (latestTick != l2) {
                    Scheduler.this.mainThreadTasks.stream().parallel().forEach((t) -> { t.run();
                        if (t.isCancel())Scheduler.this.mainThreadTasks.remove(t);});
                }
            }
        }
    }

    private class AsyncTaskRunnable implements Runnable{
        @Override
        public void run() {
            long latestTick = 0;
            while(!asyncThread.isInterrupted()){
                long l2 = timer.getRunTicks();
                if (latestTick != l2) {
                    Scheduler.this.asyncTasks.stream().parallel().forEach((t) -> { t.run();
                        if (t.isCancel())Scheduler.this.asyncTasks.remove(t);});
                }
            }
            while(asyncTasks.size() != 0){
                long l2 = timer.getRunTicks();
                if (latestTick != l2) {
                    Scheduler.this.asyncTasks.stream().parallel().forEach((t) -> { t.run();
                        if (t.isCancel())Scheduler.this.asyncTasks.remove(t);});
                }
            }
        }
    }

    public void close(){
        this.asyncThread.interrupt();
        this.mainThread.interrupt();
        if (this.asyncThread.isInterrupted() && this.mainThread.isInterrupted())
            this.timer.close();
    }
}
