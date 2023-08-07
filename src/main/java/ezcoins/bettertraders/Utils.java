package ezcoins.bettertraders;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.material.Dye;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    public static ItemStack createDyeItem(DyeColor dyeColor, int stackSize) {
        Dye dye = new Dye();
        dye.setColor(dyeColor);
        ItemStack dyeItem = dye.toItemStack(stackSize);

        return dyeItem;
    }

    public static List<MerchantRecipe> selectRandomTrades(List<MerchantRecipe> originalList, int numberOfItems) {
        List<MerchantRecipe> selectedItems = new ArrayList<>();
        Random random = new Random();

        while (selectedItems.size() < numberOfItems) {
            int randomIndex = random.nextInt(originalList.size());
            MerchantRecipe selectedItem = originalList.get(randomIndex);
            if (!selectedItems.contains(selectedItem)) {
                selectedItems.add(selectedItem);
            }
        }

        return selectedItems;
    }
}
