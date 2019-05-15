package dev.nuer.gl.file;

import dev.nuer.gl.GraceLite;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Class that handles creating or loading a plugin file from the resources folder
 */
public class PluginFile {
    //YAML configuration for the file
    private YamlConfiguration yamlFile;
    //File to be created
    private File file;
    //Store the name of the file
    private String fileName;

    /**
     * Creates the provided yml file, the filename must be that of a file in the resources folder
     *
     * @param fileName String, the name of the file to load
     */
    public PluginFile(String fileName) {
        this.fileName = fileName;
        this.file = new File(GraceLite.instance.getDataFolder(), fileName);
        if (!file.exists()) {
            GraceLite.instance.saveResource(fileName, false);
        }
        yamlFile = new YamlConfiguration();
        try {
            yamlFile.load(file);
        } catch (InvalidConfigurationException e) {
            GraceLite.LOGGER.severe("[GraceLite] The supplied file " + fileName +
                    " is not in the correct format, please check your YAML syntax.");
        } catch (FileNotFoundException e) {
            GraceLite.LOGGER.severe("[GraceLite] The supplied file " + fileName +
                    " was not found, please contact the developer. Disabling the plugin.");
            GraceLite.instance.getServer().getPluginManager().disablePlugin(GraceLite.instance);
        } catch (IOException e) {
            GraceLite.LOGGER.severe("[GraceLite] The supplied file " + fileName +
                    " could not be loaded, please contact the developer. Disabling the plugin.");
            GraceLite.instance.getServer().getPluginManager().disablePlugin(GraceLite.instance);
        }
    }

    /**
     * Saves the file, this is used for setting variables in a method
     */
    public void save() {
        try {
            yamlFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reloads the file, updates the values
     */
    public void reload() {
        try {
            yamlFile.load(file);
        } catch (InvalidConfigurationException e) {
            GraceLite.LOGGER.severe("[GraceLite] The supplied file " + fileName +
                    " is not in the correct format, please check your YAML syntax.");
        } catch (FileNotFoundException e) {
            GraceLite.LOGGER.severe("[GraceLite] The supplied file " + fileName +
                    " was not found, please contact the developer. Disabling the plugin.");
            GraceLite.instance.getServer().getPluginManager().disablePlugin(GraceLite.instance);
        } catch (IOException e) {
            GraceLite.LOGGER.severe("[GraceLite] The supplied file " + fileName +
                    " could not be loaded, please contact the developer. Disabling the plugin.");
            GraceLite.instance.getServer().getPluginManager().disablePlugin(GraceLite.instance);
        }
    }

    /**
     * Gets the file configuration for this file
     *
     * @return FileConfiguration
     */
    public YamlConfiguration get() {
        return yamlFile;
    }
}