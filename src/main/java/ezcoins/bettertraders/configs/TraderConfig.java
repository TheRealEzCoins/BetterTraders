package ezcoins.bettertraders.configs;

import ezcoins.bettertraders.trades.TradeRecipe;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

import static ezcoins.bettertraders.BetterTraders.tradeConfig;

public class TraderConfig {

    public static List<MerchantRecipe> createTradeRecipeFromConfig() {
        List<MerchantRecipe> list = new ArrayList<>();
        ConfigurationSection tradeSection = tradeConfig.getConfigurationSection("");
        if (tradeSection != null) {
            for (String tradeKey : tradeSection.getKeys(false)) {
                Material itemToBeSold = Material.valueOf(tradeConfig.getString(tradeKey + ".itemToBeSold"));
                int stackSize = tradeConfig.getInt(tradeKey + ".stackSize");
                int maxAmount = tradeConfig.getInt(tradeKey + ".maxAmount");
                int cost = tradeConfig.getInt(tradeKey + ".cost");

                TradeRecipe tradeRecipe = new TradeRecipe(itemToBeSold, stackSize, maxAmount, cost);
                list.add(tradeRecipe);
            }
        }
        return list;
    }
}
