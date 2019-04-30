package dev.nuer.gl.file;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;
import java.util.HashMap;

public class LoadFiles {
    private HashMap<Files, CreateFile> files;

    public enum Files {
        CONFIG, MESSAGES, TIMER
    }

    public LoadFiles() {
        files = new HashMap<>();
        files.put(Files.CONFIG, new CreateFile("grace-lite.yml"));
        files.put(Files.MESSAGES, new CreateFile("messages.yml"));
        files.put(Files.TIMER, new CreateFile("data" + File.separator + "grace-timer.yml"));
    }

    public FileConfiguration get(String fileName) {
        if (files.containsKey(Files.valueOf(fileName.toUpperCase()))) {
            files.get(Files.valueOf(fileName.toUpperCase())).get();
        }
        return null;
    }

    public void save(String fileName) {
        if (files.containsKey(Files.valueOf(fileName.toUpperCase()))) {
            files.get(Files.valueOf(fileName.toUpperCase())).save();
        }
    }

    public void reload() {
        for (CreateFile file : files.values()) {
            file.reload();
        }
    }
}
