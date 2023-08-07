package ezcoins.bettertraders;

import org.bukkit.plugin.java.JavaPlugin;

public final class BetterTraders extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new TraderSpawn(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
