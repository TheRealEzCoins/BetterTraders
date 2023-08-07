package ezcoins.bettertraders;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.Collections;

public class TraderSpawn implements Listener {
    @EventHandler
    private void onTraderInteract(final PlayerInteractEntityEvent event) {
        if(event.getRightClicked() instanceof WanderingTrader) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            new VillagerUI().openInventory(player);
        }
    }
}
