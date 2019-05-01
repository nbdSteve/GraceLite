package dev.nuer.gl.cmd.sub;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.method.PlayerMessage;
import dev.nuer.gl.method.TimeManipulation;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QueryCmd {

    public static void queryCountdown(CommandSender sender) {
        if (sender.hasPermission("gracelite.use")) {
            if (GraceLite.files.get("timer").getBoolean("timer.countdown-finished")) {
                if (sender instanceof Player) {
                    new PlayerMessage("grace-complete", (Player) sender);
                } else {
                    GraceLite.LOGGER.info("[GraceLite] The grace period is complete.");
                }
            } else {
                if (sender instanceof Player) {
                    TimeManipulation tm = new TimeManipulation(GraceLite.files.get("timer").getInt("timer.time-remaining"));
                    new PlayerMessage("grace-countdown-query", (Player) sender, "{days}", tm.getDays(),
                            "{hours}", tm.getHours(), "{minutes}", tm.getMinutes(), "{seconds}", tm.getSeconds());
                } else {
                    GraceLite.LOGGER.info("[GraceLite] For detailed grace time information, please use this command in game.");
                }
            }
        } else {
            new PlayerMessage("no-permission", (Player) sender);
        }
    }
}
