package ezcoins.bettertraders.listener;

import ezcoins.bettertraders.BetterTraders;
import ezcoins.bettertraders.gui.VillagerUI;
import ezcoins.bettertraders.trades.MerchantInstance;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.List;

public class TraderSpawn implements Listener {
    public static HashMap<Entity, VillagerUI> villagerUIHashMap = new HashMap<>();
    @EventHandler
    private void onTraderInteract(final PlayerInteractEntityEvent event) {
        if(event.getRightClicked() instanceof WanderingTrader) {
            if(villagerUIHashMap.containsKey(event.getRightClicked())) {
                event.setCancelled(true);
                Player player = event.getPlayer();
                WanderingTrader wanderingTrader = (WanderingTrader) event.getRightClicked();
                MerchantInstance merchantInstance = new MerchantInstance();
                List<MerchantRecipe> merchantRecipeList = merchantInstance.getMerchantRecipes(wanderingTrader);

                Merchant merchant = merchantInstance.createMerchantWithRecipes(merchantRecipeList);
                player.openMerchant(merchant, true);

            }
        }
    }

    @EventHandler
    private void onTraderSpawn(final EntitySpawnEvent event) {
        if(event.getEntity() instanceof WanderingTrader) {
            WanderingTrader wanderingTrader = (WanderingTrader) event.getEntity();
            new VillagerUI(wanderingTrader);
        }
    }
}
