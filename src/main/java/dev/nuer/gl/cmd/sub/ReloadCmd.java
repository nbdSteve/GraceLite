package dev.nuer.gl.cmd.sub;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.method.PlayerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCmd {

    public static void reload(CommandSender sender) {
        if (sender.hasPermission("grace.admin")) {
            GraceLite.files.reload();
            GraceLite.updateCountdown();
            if (sender instanceof Player) {
                new PlayerMessage("reload", (Player) sender);
            } else {
                GraceLite.LOGGER.info("[GraceLite] You have reloaded all of the configuration files.");
            }
        } else {
            new PlayerMessage("no-permission", (Player) sender);
        }
    }
}
