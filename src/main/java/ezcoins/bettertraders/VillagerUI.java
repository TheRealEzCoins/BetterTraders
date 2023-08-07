package ezcoins.bettertraders;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class VillagerUI {

    private Merchant inventory = Bukkit.createMerchant("Wandering Trader");
    public VillagerUI() {

        populateDefaultItems();
    }

    private void populateDefaultItems() {
        List<MerchantRecipe> defaultItems = Utils.selectRandomTrades(DefaultTrade.defaultItems(), 5);
        List<MerchantRecipe> rareItems = Utils.selectRandomTrades(DefaultTrade.rareTrades(), 1);

        List<MerchantRecipe> selectedItems = new ArrayList<>();
        selectedItems.addAll(defaultItems);
        selectedItems.addAll(rareItems);


        inventory.setRecipes(selectedItems);
    }

    public void openInventory(Player player) {
        player.openMerchant(inventory, true);
    }
}
