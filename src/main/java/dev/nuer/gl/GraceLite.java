package dev.nuer.gl;

import dev.nuer.gl.file.LoadFiles;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class GraceLite extends JavaPlugin {
    //Store the main plugin instance
    public static GraceLite instance;
    //Store the plugin files
    public static LoadFiles files;
    //Instance of the plugins logger
    public static Logger LOGGER = Bukkit.getLogger();

    @Override
    public void onEnable() {
        instance = this;
        files = new LoadFiles();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}