package dev.nuer.gl.cmd.sub;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.file.FileManager;
import dev.nuer.gl.method.PlayerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class that handles the /grace reload sub command
 */
public class ReloadCmd {

    /**
     * Method for the reload sub command
     *
     * @param sender CommandSender, the person sending the command
     */
    public static void reload(CommandSender sender) {
        if (sender.hasPermission("grace.admin")) {
            FileManager.reload();
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