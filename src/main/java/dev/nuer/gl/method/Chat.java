package dev.nuer.gl.method;

import org.bukkit.ChatColor;

/**
 * Class that handles applying color codes to chat messages
 */
public class Chat {

    /**
     * Will apply the Bukkit color codes to the specified message
     *
     * @param message String, the message to colorize
     * @return String
     */
    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}