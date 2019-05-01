package dev.nuer.gl.method;

import dev.nuer.gl.GraceLite;
import org.bukkit.Bukkit;

public class BroadcastMessage {

    public BroadcastMessage(String filePath) {
        for (String line : GraceLite.files.get("config").getStringList(filePath)) {
            Bukkit.broadcastMessage(Chat.colorize(line));
        }
    }
}