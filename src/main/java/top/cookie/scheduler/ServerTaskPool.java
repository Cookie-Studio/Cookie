package top.cookie.scheduler;

import top.cookie.Server;
import top.cookie.scheduler.tasks.ServerTask;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ServerTaskPool implements ServerThread{
    private Thread mainThread = new Thread(this.new Scheduler());
    private ArrayList<ServerTask> taskPool = new ArrayList<>();

    private class Scheduler implements Runnable{
        @Override
        public void run() {
            while(!mainThread.isInterrupted()) {
                ServerTaskPool.this.taskPool.stream().parallel().forEach((task) -> {
                    task.run();
                    if (task.isCancel())
                        ServerTaskPool.this.taskPool.remove(task);
                });
                try {
                    TimeUnit.MILLISECONDS.sleep(1000 * (1 / Server.getInstance().getServerTick()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public ServerTaskPool(){
        this.mainThread.start();
    }

    @Override
    public void close(){
        this.mainThread.interrupt();
    }

    public void registerTask(ServerTask task){
        this.taskPool.add(task);
    }
}
