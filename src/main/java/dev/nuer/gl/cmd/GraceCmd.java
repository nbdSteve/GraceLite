package dev.nuer.gl.cmd;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.cmd.sub.*;
import dev.nuer.gl.method.PlayerMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Class that handles the /grace command for the plugin
 */
public class GraceCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("grace")) {
            if (args.length == 0) {
                QueryCmd.queryCountdown(sender);
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("h")) {
                    HelpCmd.help(sender);
                }
                if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("r")) {
                    ReloadCmd.reload(sender);
                }
                if (args[0].equalsIgnoreCase("start")) {
                    StartCmd.startCountdown(sender);
                }
                if (args[0].equalsIgnoreCase("stop")) {
                    StopCmd.stopCountdown(sender);
                }
                if (args[0].equalsIgnoreCase("t") || args[0].equalsIgnoreCase("toggle")) {
                    ToggleCmd.toggleCountdown(sender);
                }
            } else {
                if (sender instanceof Player) {
                    new PlayerMessage("invalid-command", (Player) sender, "{reason}", "Incorrect arguments");
                } else {
                    GraceLite.LOGGER.info("[GraceLite] You did not enter a valid command.");
                }
            }
        }
        return true;
    }
}