package dev.nuer.gl.timer;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.file.FileManager;
import dev.nuer.gl.method.BroadcastMessage;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;

/**
 * Class that handles decrementing the grace timer
 */
public class CountdownTimer {
    //Store the task id
    private BukkitTask counterTaskId;

    /**
     * Constructor to initialize the countdown timer
     */
    public CountdownTimer() {
        //Check that the countdown is not finished
        if (FileManager.get("timer").getBoolean("timer.countdown-finished")) return;
        //Do the runnable to countdown
        counterTaskId = Bukkit.getScheduler().runTaskTimer(GraceLite.instance, () -> {
            //Check if the plugin should count
            if (!GraceLite.doCountdown) return;
            //Store the time remaining
            int timeRemaining = FileManager.get("timer").getInt("timer.time-remaining") - 1;
            //Check that the time remaining is greater than 0
            if (timeRemaining >= 0) {
                FileManager.get("timer").set("timer.time-remaining", timeRemaining);
                FileManager.save("timer");
            } else {
                FileManager.get("timer").set("timer.countdown-finished", true);
                FileManager.save("timer");
                //Broadcast the message the grace period is complete
                new BroadcastMessage("grace-complete-broadcast");
                counterTaskId.cancel();
            }
        }, 0L, 20L);
    }

    /**
     * Getter for the countdown timer task id
     *
     * @return BukkitTask
     */
    public BukkitTask getCounterTaskId() {
        return counterTaskId;
    }
}