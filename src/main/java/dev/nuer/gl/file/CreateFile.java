package dev.nuer.gl.file;

import dev.nuer.gl.GraceLite;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CreateFile {
    private YamlConfiguration yamlFile;
    private File file;

    public CreateFile(String fileName) {
        this.file = new File(GraceLite.instance.getDataFolder(), fileName);
        if (!file.exists()) {
            GraceLite.instance.saveResource(fileName, false);
        }
        yamlFile = new YamlConfiguration();
        try {
            yamlFile.load(file);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {
        try {
            yamlFile.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            yamlFile.load(file);
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration get() {
        return yamlFile;
    }
}