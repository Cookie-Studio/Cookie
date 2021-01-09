package top.cookie.scheduler;

import java.util.ArrayList;
import java.util.List;

public class SchedulerActions {
    private static final List<SchedulerAction> actions = new ArrayList<>();
    public static void registerSchedulerAction(SchedulerAction action){
        actions.add(action);
    }
    public static List<SchedulerAction> getSchedulerActions(){
        return actions;
    }
    public static void callAllAction(){
        actions.forEach((a) -> a.action());
    }
}
