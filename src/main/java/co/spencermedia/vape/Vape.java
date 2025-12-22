package co.spencermedia.vape;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.ChatColor;
import java.util.List;

public final class Vape extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        createGrapeIceRecipe();
        createMangoIceRecipe();
        createBlueberryIceRecipe();
        createStrawberryKiwiIceRecipe();
        createWatermelonMintIceRecipe();
        createIceCreamRecipe();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void createGrapeIceRecipe() {
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "IGET Bar");
        meta.setLore(List.of(ChatColor.DARK_PURPLE + "Grape Ice"));
        igetBar.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_grape_ice"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.SWEET_BERRIES);
        Bukkit.addRecipe(recipe);
    }

    private void createMangoIceRecipe() {
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "IGET Bar");
        meta.setLore(List.of(ChatColor.YELLOW + "Mango Ice"));
        igetBar.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_mango_ice"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.GLOW_BERRIES);
        Bukkit.addRecipe(recipe);
    }

    private void createBlueberryIceRecipe() {
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "IGET Bar");
        meta.setLore(List.of(ChatColor.BLUE + "Blueberry Ice"));
        igetBar.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_blueberry_ice"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.BLUE_ORCHID);
        Bukkit.addRecipe(recipe);
    }

    private void createStrawberryKiwiIceRecipe() {
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "IGET Bar");
        meta.setLore(List.of(ChatColor.RED + "Strawberry Kiwi Ice"));
        igetBar.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_strawberry_kiwi_ice"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.BEETROOT);
        Bukkit.addRecipe(recipe);
    }

    private void createWatermelonMintIceRecipe() {
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "IGET Bar");
        meta.setLore(List.of(ChatColor.AQUA + "Watermelon Mint Ice"));
        igetBar.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_watermelon_mint_ice"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.SEA_PICKLE);
        Bukkit.addRecipe(recipe);
    }

    private void createIceCreamRecipe() {
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "IGET Bar");
        meta.setLore(List.of(ChatColor.WHITE + "Ice Cream"));
        igetBar.setItemMeta(meta);
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_ice_cream"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.SUGAR);
        Bukkit.addRecipe(recipe);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();

            if (item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasLore() && !meta.getLore().isEmpty()) {
                    String lore = meta.getLore().get(0);
                    
                    if (lore.equals(ChatColor.DARK_PURPLE + "Grape Ice")) {
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 200, 1));
                        event.setCancelled(true);
                    } else if (lore.equals(ChatColor.YELLOW + "Mango Ice")) {
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 200, 1));
                        event.setCancelled(true);
                    } else if (lore.equals(ChatColor.BLUE + "Blueberry Ice")) {
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 200, 1));
                        event.setCancelled(true);
                    } else if (lore.equals(ChatColor.RED + "Strawberry Kiwi Ice")) {
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 200, 1));
                        event.setCancelled(true);
                    } else if (lore.equals(ChatColor.AQUA + "Watermelon Mint Ice")) {
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 1));
                        event.setCancelled(true);
                    } else if (lore.equals(ChatColor.WHITE + "Ice Cream")) {
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 200, 1));
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
