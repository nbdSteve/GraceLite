package dev.nuer.gl;

import dev.nuer.gl.cmd.GraceCmd;
import dev.nuer.gl.file.LoadFiles;
import dev.nuer.gl.listener.WorldListener;
import dev.nuer.gl.method.VersionChecker;
import dev.nuer.gl.timer.CountdownTimer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Main class for the GraceLite plugin
 */
public final class GraceLite extends JavaPlugin {
    //Store the main plugin instance
    public static GraceLite instance;
    //Store the plugin files
    public static LoadFiles files;
    //Instance of the plugins logger
    public static Logger LOGGER = Bukkit.getLogger();
    //if the plugin is counting down
    public static boolean doCountdown;
    //Store the instance of the countdown timer runnable
    public static CountdownTimer timer;

    /**
     * Method called on plugin start up
     */
    @Override
    public void onEnable() {
        LOGGER.info("[GraceLite] Thank you for choosing to use GraceLite!");
        LOGGER.info("[GraceLite] If you find any bugs please contact nbdSteve#0583 on Discord.");
        //Set the instance variable
        instance = this;
        //Create a new instance of plugin files
        files = new LoadFiles();
        //Get if the plugin should count down
        updateCountdown();
        //Create a new instance of the timer runnable
        timer = new CountdownTimer();
        //Register the base plugin command
        getCommand("grace").setExecutor(new GraceCmd());
        //Register plugin events
        getServer().getPluginManager().registerEvents(new WorldListener(), this);
        //Setup the version checker
        VersionChecker.checkVersion(null);
        getServer().getPluginManager().registerEvents(new VersionChecker(), this);
    }

    /**
     * Method called on plugin shutdown
     */
    @Override
    public void onDisable() {
        LOGGER.info("[GraceLite] Thank you for choosing to use GraceLite!");
        LOGGER.info("[GraceLite] If you find any bugs please contact nbdSteve#0583 on Discord.");
    }

    /**
     * Updates the instance countdown boolean
     */
    public static void updateCountdown() {
        doCountdown = GraceLite.files.get("config").getBoolean("countdown-enabled");
    }
}