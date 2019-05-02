package dev.nuer.gl.cmd.sub;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.method.PlayerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class that handles the /grace stop sub command
 */
public class StopCmd {

    /**
     * Method for the stop sub command
     *
     * @param sender CommandSender, the person sending the command
     */
    public static void stopCountdown(CommandSender sender) {
        if (sender.hasPermission("grace.admin")) {
            GraceLite.files.get("config").set("countdown-enabled", false);
            GraceLite.files.save("config");
            GraceLite.updateCountdown();
            if (sender instanceof Player) {
                new PlayerMessage("grace-stop", (Player) sender);
            } else {
                GraceLite.LOGGER.info("[GraceLite] You have halted the grace period.");
            }
        } else {
            new PlayerMessage("no-permission", (Player) sender);
        }
    }
}