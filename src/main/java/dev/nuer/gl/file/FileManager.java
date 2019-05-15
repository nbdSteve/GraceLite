package dev.nuer.gl.file;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;

/**
 * Class that handles loading files for the plugin
 */
public class FileManager {
    //HashMap of the plugin files from the resource folder
    private static HashMap<Files, PluginFile> files;

    /**
     * Enum to store each file, this is public so we can call methods on these variables
     */
    public enum Files {
        CONFIG, MESSAGES, TIMER
    }

    /**
     * Generate all of the files in the enum
     */
    public static void load() {
        //Initialize the HashMap
        files = new HashMap<>();
        //Load the plugins files
        files.put(Files.CONFIG, new PluginFile("grace-lite.yml"));
        files.put(Files.MESSAGES, new PluginFile("messages.yml"));
        files.put(Files.TIMER, new PluginFile("data" + File.separator + "grace-timer.yml"));
    }

    /**
     * Gets the specified yaml configuration
     *
     * @param fileName String, the file to get the configuration for
     * @return YamlConfiguration
     */
    public static YamlConfiguration get(String fileName) {
        if (files.containsKey(Files.valueOf(fileName.toUpperCase()))) {
            return files.get(Files.valueOf(fileName.toUpperCase())).get();
        }
        return null;
    }

    /**
     * Saves the specified file
     *
     * @param fileName String, file to save
     */
    public static void save(String fileName) {
        if (files.containsKey(Files.valueOf(fileName.toUpperCase()))) {
            files.get(Files.valueOf(fileName.toUpperCase())).save();
        }
    }

    /**
     * Reloads all of the files in the enum
     */
    public static void reload() {
        for (PluginFile file : files.values()) {
            file.reload();
        }
    }
}