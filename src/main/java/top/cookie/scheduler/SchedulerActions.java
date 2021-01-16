package top.cookie.scheduler;

import java.util.ArrayList;
import java.util.List;

public class SchedulerActions {
    private static final List<Runnable> actions = new ArrayList<>();
    public static void registerSchedulerAction(Runnable action){
        actions.add(action);
    }
    public static List<Runnable> getSchedulerActions(){
        return actions;
    }
    public static void callAllAction(){
        actions.forEach((a) -> a.run());
    }
}
