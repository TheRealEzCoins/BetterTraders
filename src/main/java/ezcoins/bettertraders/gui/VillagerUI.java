package ezcoins.bettertraders.gui;

import ezcoins.bettertraders.Utils;
import ezcoins.bettertraders.configs.DefaultConfig;
import ezcoins.bettertraders.configs.TraderConfig;
import ezcoins.bettertraders.enums.TradeType;
import ezcoins.bettertraders.trades.DefaultTrade;
import ezcoins.bettertraders.trades.MerchantInstance;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class VillagerUI {

    private Merchant inventory = Bukkit.createMerchant("Wandering Trader");
    private MerchantInstance merchantInstance;
    private WanderingTrader wanderingTrader;
    public VillagerUI(WanderingTrader wanderingTrader) {
        this.wanderingTrader = wanderingTrader;
        populateDefaultItems();
    }

    private void populateDefaultItems() {
        List<MerchantRecipe> defaultItems = Utils.selectRandomTrades(DefaultTrade.defaultItems(), DefaultConfig.getTradeAmount(TradeType.Default));
        List<MerchantRecipe> rareItems = Utils.selectRandomTrades(DefaultTrade.rareTrades(), DefaultConfig.getTradeAmount(TradeType.Rare));
        List<MerchantRecipe> customItems = Utils.selectRandomTrades(TraderConfig.createTradeRecipeFromConfig(), DefaultConfig.getTradeAmount(TradeType.Custom));

        List<MerchantRecipe> selectedItems = new ArrayList<>();
        selectedItems.addAll(customItems);
        selectedItems.addAll(defaultItems);
        selectedItems.addAll(rareItems);

        this.merchantInstance = new MerchantInstance();
        merchantInstance.saveMerchantRecipes(wanderingTrader, selectedItems);


        inventory.setRecipes(selectedItems);
    }



    public void openInventory(Player player) {
        player.openMerchant(inventory, true);
    }

    public MerchantInstance getMerchantInstance() {
        return merchantInstance;
    }
}
