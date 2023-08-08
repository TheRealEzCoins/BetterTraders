package ezcoins.bettertraders.gui;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ezcoins.bettertraders.Utils;
import ezcoins.bettertraders.configs.DefaultConfig;
import ezcoins.bettertraders.configs.TraderConfig;
import ezcoins.bettertraders.enums.TradeType;
import ezcoins.bettertraders.trades.DefaultTrade;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

import static ezcoins.bettertraders.BetterTraders.plugin;

public class VillagerUI {

    private Merchant inventory = Bukkit.createMerchant("Wandering Trader");

    private WanderingTrader wanderingTrader;
    public VillagerUI(WanderingTrader wanderingTrader) {
        this.wanderingTrader = wanderingTrader;

    }

    private void populateDefaultItems() {
        List<MerchantRecipe> defaultItems = Utils.selectRandomTrades(DefaultTrade.defaultItems(), DefaultConfig.getTradeAmount(TradeType.Default));
        List<MerchantRecipe> rareItems = Utils.selectRandomTrades(DefaultTrade.rareTrades(), DefaultConfig.getTradeAmount(TradeType.Rare));
        List<MerchantRecipe> customItems = Utils.selectRandomTrades(TraderConfig.createTradeRecipeFromConfig(), DefaultConfig.getTradeAmount(TradeType.Custom));

        List<MerchantRecipe> selectedItems = new ArrayList<>();
        selectedItems.addAll(customItems);
        selectedItems.addAll(defaultItems);
        selectedItems.addAll(rareItems);



        inventory.setRecipes(selectedItems);
    }

    public void populateUIFromEntity() {
        NamespacedKey key = new NamespacedKey(plugin, "villager_ui");
        if (wanderingTrader.getPersistentDataContainer().has(key, PersistentDataType.STRING)) {
            String serializedData = wanderingTrader.getPersistentDataContainer().get(key, PersistentDataType.STRING);
            deserializeUI(serializedData);
        }
    }

    public void saveToEntity() {
        populateDefaultItems();
        NamespacedKey key = new NamespacedKey(plugin, "villager_ui");
        wanderingTrader.getPersistentDataContainer().set(key, PersistentDataType.STRING, serializeUI());
    }

    public String serializeUI() {
        JsonArray jsonArray = new JsonArray();

        for (MerchantRecipe recipe : inventory.getRecipes()) {
            JsonObject recipeJson = new JsonObject();
            recipeJson.addProperty("result", recipe.getResult().getType().toString());
            recipeJson.addProperty("amount", recipe.getResult().getAmount());

            JsonArray ingredientArray = new JsonArray();
            for (ItemStack ingredient : recipe.getIngredients()) {
                JsonObject ingredientJson = new JsonObject();
                ingredientJson.addProperty("type", ingredient.getType().toString());
                ingredientJson.addProperty("amount", ingredient.getAmount());
                ingredientArray.add(ingredientJson);
            }
            recipeJson.add("ingredients", ingredientArray);

            jsonArray.add(recipeJson);
        }

        return jsonArray.toString();
    }

    public void deserializeUI(String serializedData) {
        JsonArray jsonArray = JsonParser.parseString(serializedData).getAsJsonArray();

        List<MerchantRecipe> newRecipes = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject recipeJson = jsonArray.get(i).getAsJsonObject();
            Material resultType = Material.valueOf(recipeJson.get("result").getAsString());
            int resultAmount = recipeJson.get("amount").getAsInt();

            MerchantRecipe recipe = new MerchantRecipe(new ItemStack(resultType, resultAmount), Integer.MAX_VALUE);

            JsonArray ingredientArray = recipeJson.get("ingredients").getAsJsonArray();
            for (int j = 0; j < ingredientArray.size(); j++) {
                JsonObject ingredientJson = ingredientArray.get(j).getAsJsonObject();
                Material ingredientType = Material.valueOf(ingredientJson.get("type").getAsString());
                int ingredientAmount = ingredientJson.get("amount").getAsInt();
                ItemStack ingredient = new ItemStack(ingredientType, ingredientAmount);
                recipe.addIngredient(ingredient);
            }

            newRecipes.add(recipe);
        }

        inventory.setRecipes(newRecipes);
    }

    public void openInventory(Player player) {
        player.openMerchant(inventory, true);
    }

}
