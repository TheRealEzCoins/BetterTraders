package ezcoins.bettertraders.trades;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

public class TradeRecipe extends MerchantRecipe {

    public TradeRecipe(ItemStack itemToBeSold, int maxAmount, int cost) {
        super(itemToBeSold, maxAmount);
        this.addIngredient(new ItemStack(Material.EMERALD, cost));
    }

    public TradeRecipe(Material itemToBeSold, int stacksize, int maxAmount, int cost) {
        this(new ItemStack(itemToBeSold, stacksize), maxAmount, cost);
    }
}
