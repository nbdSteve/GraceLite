package dev.nuer.gl.method;

import org.bukkit.ChatColor;

public class Chat {

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}