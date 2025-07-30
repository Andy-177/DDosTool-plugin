package paper.plugin.ddostool;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class DDosTool extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginCommand("dos").setExecutor(new DosCommand());
        Bukkit.getPluginCommand("ddos").setExecutor(new DDosCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
