package dev.nuer.gl.timer;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.method.BroadcastMessage;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

public class CountdownTimer {
    //Store the task id
    private BukkitTask counterTaskId;

    public CountdownTimer() {
        //Check that the countdown is not finished
        if (GraceLite.files.get("timer").getBoolean("timer.countdown-finished")) return;
        //Do the runnable to countdown
        counterTaskId = Bukkit.getScheduler().runTaskTimer(GraceLite.instance, () -> {
            //Check if the plugin should count
            if (!GraceLite.doCountdown) return;
            //Store the time remaining
            int timeRemaining = GraceLite.files.get("timer").getInt("timer.time-remaining") - 1;
            //Check that the time remaining is greater than 0
            if (timeRemaining >= 0) {
                GraceLite.files.get("timer").set("timer.time-remaining", timeRemaining);
                GraceLite.files.save("timer");
            } else {
                GraceLite.files.get("timer").set("timer.countdown-finished", true);
                GraceLite.files.save("timer");
                //Broadcast the message the grace period is complete
                new BroadcastMessage("grace-complete-broadcast");
                counterTaskId.cancel();
            }
        }, 0L, 20L);
    }

    public BukkitTask getCounterTaskId() {
        return counterTaskId;
    }
}