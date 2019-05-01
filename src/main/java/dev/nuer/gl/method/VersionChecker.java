package dev.nuer.gl.method;

import dev.nuer.gl.GraceLite;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Class that handles checking if the server is using the latest version of the plugin
 */
public class VersionChecker implements Listener {
    //Store the resource key from spigot
    private static String resourceKey = "56095";

    /**
     * Checks the latest version against the current version
     *
     * @param player Player, player to send the update message to
     */
    public static void checkVersion(Player player) {
        try {
            URLConnection urlConn = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + resourceKey).openConnection();
            String version = new BufferedReader(new InputStreamReader(urlConn.getInputStream())).readLine();
            if (!version.equalsIgnoreCase(GraceLite.files.get("config").getString("version"))) {
                GraceLite.LOGGER.severe("[GraceLite] There is a new version of GraceLite available for download, please update to the latest version.");
                if (player != null) {
                    new PlayerMessage("outdated-version", player, "{currentVersion}",
                            GraceLite.files.get("config").getString("version"), "{latestVersion}", version);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void join(PlayerJoinEvent event) {
        if (event.getPlayer().isOp()) {
            Bukkit.getScheduler().runTaskLater(GraceLite.instance, () -> {
                checkVersion(event.getPlayer());
            }, 5L);
        }
    }
}