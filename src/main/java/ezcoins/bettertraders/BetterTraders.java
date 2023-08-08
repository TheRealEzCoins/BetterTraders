package ezcoins.bettertraders;

import ezcoins.bettertraders.listener.TraderSpawn;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class BetterTraders extends JavaPlugin {
    public static FileConfiguration tradeConfig;
    public static FileConfiguration config;
    public static BetterTraders plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new TraderSpawn(), this);
        File tradeRecipes = new File(getDataFolder(), "trade_recipes.yml");
        if (!tradeRecipes.exists()) {
            saveResource("trade_recipes.yml", false);
        }
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveResource("config.yml", false);
        }
        tradeConfig = YamlConfiguration.loadConfiguration(tradeRecipes);
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
