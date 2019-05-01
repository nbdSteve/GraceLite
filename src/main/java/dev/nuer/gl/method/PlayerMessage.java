package dev.nuer.gl.method;

import dev.nuer.gl.GraceLite;
import org.bukkit.entity.Player;

public class PlayerMessage {

    /**
     * Send a default message to the player
     *
     * @param filePath String, internal message path
     * @param player   Player, the player to send to
     */
    public PlayerMessage(String filePath, Player player) {
        for (String line : GraceLite.files.get("messages").getStringList(filePath)) {
            player.sendMessage(Chat.colorize(line));
        }
    }

    public PlayerMessage(String filePath, Player player,
                         String placeholder, String replacement) {
        for (String line : GraceLite.files.get("messages").getStringList(filePath)) {
            player.sendMessage(Chat.colorize(line).replace(placeholder, replacement));
        }
    }

    public PlayerMessage(String filePath, Player player,
                         String placeholder, String replacement,
                         String placeholder2, String replacement2) {
        for (String line : GraceLite.files.get("messages").getStringList(filePath)) {
            player.sendMessage(Chat.colorize(line)
                    .replace(placeholder, replacement)
                    .replace(placeholder2, replacement2));
        }
    }

    public PlayerMessage(String filePath, Player player,
                         String placeholder, String replacement,
                         String placeholder2, String replacement2,
                         String placeholder3, String replacement3,
                         String placeholder4, String replacement4) {
        for (String line : GraceLite.files.get("messages").getStringList(filePath)) {
            player.sendMessage(Chat.colorize(line)
                    .replace(placeholder, replacement)
                    .replace(placeholder2, replacement2)
                    .replace(placeholder3, replacement3)
                    .replace(placeholder4, replacement4));
        }
    }
}