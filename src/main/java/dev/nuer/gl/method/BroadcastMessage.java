package dev.nuer.gl.method;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.file.FileManager;
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
        for (String line : FileManager.get("config").getStringList(filePath)) {
            Bukkit.broadcastMessage(Chat.colorize(line));
        }
    }
}