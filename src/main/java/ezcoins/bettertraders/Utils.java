package ezcoins.bettertraders;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.material.Dye;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

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

    public static <T> List<T> getInstancesOfInterface(List<Object> objects, Class<T> targetInterface) {
        List<T> instances = new ArrayList<>();
        for (Object obj : objects) {
            if (targetInterface.isInstance(obj)) {
                instances.add(targetInterface.cast(obj));
            }
        }
        return instances;
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
