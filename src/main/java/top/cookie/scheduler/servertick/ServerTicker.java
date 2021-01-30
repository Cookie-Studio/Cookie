package top.cookie.scheduler.servertick;

import top.cookie.Server;
import java.util.concurrent.TimeUnit;

public class ServerTicker implements Runnable{
    @Override
    public void run() {
        while(!Thread.interrupted()){
            SchedulerActions.callAllAction();
            try {
                TimeUnit.MILLISECONDS.sleep(1000 * (1 / Server.getInstance().getServerTick()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
