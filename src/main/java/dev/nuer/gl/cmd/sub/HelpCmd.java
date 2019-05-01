package dev.nuer.gl.cmd.sub;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.method.PlayerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCmd {

    public static void help(CommandSender sender) {
        if (sender.hasPermission("grace.help")) {
            if (sender instanceof Player) {
                new PlayerMessage("help", (Player) sender);
            } else {
                GraceLite.LOGGER.info("[GraceLite] Please see the GitHub wiki page for command help.");
            }
        } else {
            new PlayerMessage("no-permission", (Player) sender);
        }
    }
}
