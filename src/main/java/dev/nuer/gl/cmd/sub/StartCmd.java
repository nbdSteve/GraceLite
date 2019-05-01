package dev.nuer.gl.cmd.sub;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.method.PlayerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCmd {

    public static void startCountdown(CommandSender sender) {
        if (sender.hasPermission("grace.admin")) {
            GraceLite.files.get("config").set("countdown-enabled", true);
            GraceLite.files.save("config");
            GraceLite.updateCountdown();
            if (sender instanceof Player) {
                new PlayerMessage("grace-start", (Player) sender);
            } else {
                GraceLite.LOGGER.info("[GraceLite] You have started the grace period.");
            }
        } else {
            new PlayerMessage("no-permission", (Player) sender);
        }
    }
}
