package dev.nuer.gl.method;

import dev.nuer.gl.GraceLite;
import org.bukkit.Bukkit;

/**
 * Class that handles broadcasting messages
 */
public class BroadcastMessage {

    /**
     * Broadcasts the specified message to the server
     *
     * @param filePath String, the internal path for the broadcast message
     */
    public BroadcastMessage(String filePath) {
        for (String line : GraceLite.files.get("config").getStringList(filePath)) {
            Bukkit.broadcastMessage(Chat.colorize(line));
        }
    }
}