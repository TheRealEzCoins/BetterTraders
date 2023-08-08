package ezcoins.bettertraders.trades;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ezcoins.bettertraders.BetterTraders;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class MerchantInstance {
    private final NamespacedKey recipesKey = new NamespacedKey(BetterTraders.plugin, "merchant-recipes");
    public MerchantInstance() {

    }
    public void saveMerchantRecipes(WanderingTrader trader, List<MerchantRecipe> recipes) {
        String serialized = serializeMerchantRecipes(recipes);
        PersistentDataContainer dataContainer = trader.getPersistentDataContainer();
        dataContainer.set(recipesKey, PersistentDataType.STRING, serialized);
    }

    public List<MerchantRecipe> getMerchantRecipes(WanderingTrader trader) {
        PersistentDataContainer dataContainer = trader.getPersistentDataContainer();
        String serialized = dataContainer.get(recipesKey, PersistentDataType.STRING);

        if (serialized != null) {
            return deserializeMerchantRecipes(serialized);
        }

        return null;
    }

    private String serializeMerchantRecipes(List<MerchantRecipe> recipes) {
        Gson gson = new Gson();
        return gson.toJson(recipes);
    }


    private List<MerchantRecipe> deserializeMerchantRecipes(String serialized) {
        Gson gson = new Gson();
        TypeToken<List<MerchantRecipe>> token = new TypeToken<List<MerchantRecipe>>() {};
        return gson.fromJson(serialized, token.getType());
    }

    public Merchant createMerchantWithRecipes(List<MerchantRecipe> recipes) {
        Merchant merchant = Bukkit.createMerchant("Wandering Trader");
        merchant.setRecipes(recipes);
        return merchant;
    }
}
