package ezcoins.bettertraders.trades;

import ezcoins.bettertraders.Utils;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;

import java.util.ArrayList;
import java.util.List;

public class DefaultTrade {

    public static List<MerchantRecipe> defaultItems() {
        List<MerchantRecipe> merchantRecipes = new ArrayList<>();

        for(Material flower : Tag.FLOWERS.getValues()) {
            TradeRecipe tradeRecipe = new TradeRecipe(flower, 1, 12, 1);
            merchantRecipes.add(tradeRecipe);
        }

        for(DyeColor dyeColor : DyeColor.values()) {
            TradeRecipe tradeRecipe = new TradeRecipe(Utils.createDyeItem(dyeColor, 3), 64, 1);
            merchantRecipes.add(tradeRecipe);
        }

        for(Material saplings : Tag.SAPLINGS.getValues()) {
            TradeRecipe tradeRecipe = new TradeRecipe(saplings, 1, 64, 5);
            merchantRecipes.add(tradeRecipe);
        }

        for(Material fishes : Tag.ITEMS_FISHES.getValues()) {
            TradeRecipe tradeRecipe = new TradeRecipe(fishes, 1, 64, 3);
            merchantRecipes.add(tradeRecipe);
        }


        for(Material sand : Tag.SAND.getValues()) {
            TradeRecipe tradeRecipe = new TradeRecipe(sand, 4, 8, 1);
            merchantRecipes.add(tradeRecipe);
        }

        for(Material coral : Tag.CORAL_BLOCKS.getValues()) {
            TradeRecipe tradeRecipe = new TradeRecipe(coral, 1, 8, 3);
            merchantRecipes.add(tradeRecipe);
        }

        TradeRecipe red_mushroom = new TradeRecipe(new ItemStack(Material.RED_MUSHROOM, 1), 12, 1);
        merchantRecipes.add(red_mushroom);

        TradeRecipe brown_mushroom = new TradeRecipe(new ItemStack(Material.BROWN_MUSHROOM, 1), 12, 1);
        merchantRecipes.add(brown_mushroom);

        TradeRecipe vines = new TradeRecipe(new ItemStack(Material.VINE, 1), 12, 1);
        merchantRecipes.add(vines);

        TradeRecipe lily_pad = new TradeRecipe(new ItemStack(Material.LILY_PAD, 2), 5, 1);
        merchantRecipes.add(lily_pad);

        TradeRecipe moss_block = new TradeRecipe(new ItemStack(Material.MOSS_BLOCK, 2), 5, 1);
        merchantRecipes.add(moss_block);

        TradeRecipe pointed_dripstone = new TradeRecipe(new ItemStack(Material.POINTED_DRIPSTONE, 1), 5, 1);
        merchantRecipes.add(pointed_dripstone);

        TradeRecipe rooted_dirt = new TradeRecipe(new ItemStack(Material.ROOTED_DIRT, 2), 5, 1);
        merchantRecipes.add(rooted_dirt);

        TradeRecipe small_dripleaf = new TradeRecipe(new ItemStack(Material.SMALL_DRIPLEAF, 1), 5, 1);
        merchantRecipes.add(small_dripleaf);

        TradeRecipe glowstone = new TradeRecipe(new ItemStack(Material.GLOWSTONE, 1), 64, 2);
        merchantRecipes.add(glowstone);

        TradeRecipe sea_pickle = new TradeRecipe(new ItemStack(Material.SEA_PICKLE, 1), 5, 2);
        merchantRecipes.add(sea_pickle);

        TradeRecipe slimeball = new TradeRecipe(new ItemStack(Material.SLIME_BALL, 1), 5, 4);
        merchantRecipes.add(slimeball);

        TradeRecipe beetroot_seeds = new TradeRecipe(new ItemStack(Material.BEETROOT_SEEDS, 1), 12, 1);
        merchantRecipes.add(beetroot_seeds);

        TradeRecipe melon_seeds = new TradeRecipe(new ItemStack(Material.MELON_SEEDS, 1), 12, 1);
        merchantRecipes.add(melon_seeds);

        TradeRecipe pumpkin_seeds = new TradeRecipe(new ItemStack(Material.PUMPKIN_SEEDS, 1), 12, 1);
        merchantRecipes.add(pumpkin_seeds);

        TradeRecipe wheat_seeds = new TradeRecipe(new ItemStack(Material.WHEAT_SEEDS, 1), 12, 1);
        merchantRecipes.add(wheat_seeds);

        TradeRecipe pumpkin = new TradeRecipe(new ItemStack(Material.PUMPKIN, 1), 4, 1);
        merchantRecipes.add(pumpkin);

        TradeRecipe sugar_cane = new TradeRecipe(new ItemStack(Material.SUGAR_CANE, 1), 8, 1);
        merchantRecipes.add(sugar_cane);

        return merchantRecipes;
    }

    public static List<MerchantRecipe> rareTrades() {
        List<MerchantRecipe> merchantRecipes = new ArrayList<>();

        TradeRecipe gunpowder = new TradeRecipe(new ItemStack(Material.GUNPOWDER, 1), 8, 1);
        merchantRecipes.add(gunpowder);

        TradeRecipe podzol = new TradeRecipe(new ItemStack(Material.PODZOL, 3), 6, 3);
        merchantRecipes.add(podzol);

        TradeRecipe packed_ice = new TradeRecipe(new ItemStack(Material.PACKED_ICE, 1), 6, 3);
        merchantRecipes.add(packed_ice);

        TradeRecipe bucket_of_pufferfish = new TradeRecipe(new ItemStack(Material.PUFFERFISH_BUCKET, 1), 4, 5);
        merchantRecipes.add(bucket_of_pufferfish);

        TradeRecipe bucket_of_tropical_fish = new TradeRecipe(new ItemStack(Material.TROPICAL_FISH_BUCKET, 1), 4, 5);
        merchantRecipes.add(bucket_of_tropical_fish);

        TradeRecipe blue_ice = new TradeRecipe(new ItemStack(Material.BLUE_ICE, 1), 6, 6);
        merchantRecipes.add(blue_ice);

        return merchantRecipes;
    }
}
