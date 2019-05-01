package dev.nuer.gl.cmd.sub;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.method.PlayerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopCmd {

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