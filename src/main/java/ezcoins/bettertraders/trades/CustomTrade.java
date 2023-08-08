package ezcoins.bettertraders.trades;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.SmithingRecipe;

import java.util.ArrayList;
import java.util.List;

public class CustomTrade {
    public static List<MerchantRecipe> customTrades() {
        List<MerchantRecipe> merchantRecipes = new ArrayList<>();
        for (Recipe recipe : Bukkit.getRecipesFor(new ItemStack(Material.SMITHING_TABLE))) {
            if (recipe instanceof SmithingRecipe) {
                SmithingRecipe smithingRecipe = (SmithingRecipe) recipe;

                TradeRecipe template = new TradeRecipe(smithingRecipe.getAddition().getItemStack(), 8, 1);
                merchantRecipes.add(template);
            }
        }


        return  merchantRecipes;
    }
}
