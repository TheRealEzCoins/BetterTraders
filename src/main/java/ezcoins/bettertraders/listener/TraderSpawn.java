package ezcoins.bettertraders.listener;

import ezcoins.bettertraders.gui.VillagerUI;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class TraderSpawn implements Listener {

    @EventHandler
    private void onTraderInteract(final PlayerInteractEntityEvent event) {
        if(event.getRightClicked() instanceof WanderingTrader) {
            event.setCancelled(true);
            Player player = event.getPlayer();
            WanderingTrader wanderingTrader = (WanderingTrader) event.getRightClicked();
            VillagerUI villagerUI = new VillagerUI(wanderingTrader);
            villagerUI.populateUIFromEntity();
            villagerUI.openInventory(player);
        }
    }

    @EventHandler
    private void onTraderSpawn(final EntitySpawnEvent event) {
        if(event.getEntity() instanceof WanderingTrader) {
            WanderingTrader wanderingTrader = (WanderingTrader) event.getEntity();
            new VillagerUI(wanderingTrader).saveToEntity();
        }
    }
}
