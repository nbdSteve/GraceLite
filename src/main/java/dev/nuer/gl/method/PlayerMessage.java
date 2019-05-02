package dev.nuer.gl.method;

import dev.nuer.gl.GraceLite;
import org.bukkit.entity.Player;

/**
 * Class that handles sending a message to a player
 */
public class PlayerMessage {

    /**
     * Send a default message to the player
     *
     * @param filePath String, the internal path for the message
     * @param player   Player, the player to send the message to
     */
    public PlayerMessage(String filePath, Player player) {
        for (String line : GraceLite.files.get("messages").getStringList(filePath)) {
            player.sendMessage(Chat.colorize(line));
        }
    }

    /**
     * Sends a message to the specified player, replaces the specified placeholders with their
     * respective replacement string
     *
     * @param filePath    String, the internal path for the message
     * @param player      Player, the player to send the message to
     * @param placeholder String, the first placeholder
     * @param replacement String, the replacement for the first placeholder
     */
    public PlayerMessage(String filePath, Player player,
                         String placeholder, String replacement) {
        for (String line : GraceLite.files.get("messages").getStringList(filePath)) {
            player.sendMessage(Chat.colorize(line).replace(placeholder, replacement));
        }
    }

    /**
     * Sends a message to the specified player, replaces the specified placeholders with their
     * respective replacement string
     *
     * @param filePath     String, the internal path for the message
     * @param player       Player, the player to send the message to
     * @param placeholder  String, the first placeholder
     * @param replacement  String, the replacement for the first placeholder
     * @param placeholder2 String, the second placeholder
     * @param replacement2 String, the replacement for the second placeholder
     */
    public PlayerMessage(String filePath, Player player,
                         String placeholder, String replacement,
                         String placeholder2, String replacement2) {
        for (String line : GraceLite.files.get("messages").getStringList(filePath)) {
            player.sendMessage(Chat.colorize(line)
                    .replace(placeholder, replacement)
                    .replace(placeholder2, replacement2));
        }
    }

    /**
     * Sends a message to the specified player, replaces the specified placeholders with their
     * respective replacement string
     *
     * @param filePath     String, the internal path for the message
     * @param player       Player, the player to send the message to
     * @param placeholder  String, the first placeholder
     * @param replacement  String, the replacement for the first placeholder
     * @param placeholder2 String, the second placeholder
     * @param replacement2 String, the replacement for the second placeholder
     * @param placeholder3 String, the third placeholder
     * @param replacement3 String, the replacement for the third placeholder
     * @param placeholder4 String, the fourth placeholder
     * @param replacement4 String, the replacement for the fourth placeholder
     */
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