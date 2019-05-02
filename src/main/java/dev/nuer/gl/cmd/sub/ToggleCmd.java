package dev.nuer.gl.cmd.sub;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.method.PlayerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class that handles the /grace toggle sub command
 */
public class ToggleCmd {

    /**
     * Method for the toggle sub command
     *
     * @param sender CommandSender, the person sending the command
     */
    public static void toggleCountdown(CommandSender sender) {
        if (sender.hasPermission("grace.admin")) {
            boolean enabled = GraceLite.files.get("config").getBoolean("countdown-enabled");
            if (enabled) {
                GraceLite.files.get("config").set("countdown-enabled", false);
            } else {
                GraceLite.files.get("config").set("countdown-enabled", true);
            }
            GraceLite.files.save("config");
            GraceLite.updateCountdown();
            if (sender instanceof Player) {
                new PlayerMessage("grace-toggle", (Player) sender, "{state}", String.valueOf(!enabled));
            } else {
                GraceLite.LOGGER.info("[GraceLite] You have started the toggled the grace period to " + !enabled + ".");
            }
        } else {
            new PlayerMessage("no-permission", (Player) sender);
        }
    }
}