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
        createStrawberryRecipe();
        createMintRecipe();
        createMangoRecipe();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void createGrapeIceRecipe() {
        // Create the Grape Ice IGET Bar item
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "IGET Bar");
        meta.setLore(List.of(ChatColor.DARK_PURPLE + "Grape Ice Flavor"));
        igetBar.setItemMeta(meta);

        // Define the crafting recipe
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_grape"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.SWEET_BERRIES);

        // Add the recipe to the server
        Bukkit.addRecipe(recipe);
    }

    private void createStrawberryRecipe() {
        // Create the Strawberry IGET Bar item
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "IGET Bar");
        meta.setLore(List.of(ChatColor.DARK_RED + "Strawberry Flavor"));
        igetBar.setItemMeta(meta);

        // Define the crafting recipe
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_strawberry"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.APPLE);

        // Add the recipe to the server
        Bukkit.addRecipe(recipe);
    }

    private void createMintRecipe() {
        // Create the Mint IGET Bar item
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "IGET Bar");
        meta.setLore(List.of(ChatColor.DARK_GREEN + "Mint Flavor"));
        igetBar.setItemMeta(meta);

        // Define the crafting recipe
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_mint"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.KELP);

        // Add the recipe to the server
        Bukkit.addRecipe(recipe);
    }

    private void createMangoRecipe() {
        // Create the Mango IGET Bar item
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "IGET Bar");
        meta.setLore(List.of(ChatColor.YELLOW + "Mango Flavor"));
        igetBar.setItemMeta(meta);

        // Define the crafting recipe
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar_mango"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.GLOW_BERRIES);

        // Add the recipe to the server
        Bukkit.addRecipe(recipe);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Check if the player right-clicked with an IGET Bar
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();

            if (item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasLore() && !meta.getLore().isEmpty()) {
                    String lore = meta.getLore().get(0);
                    
                    // Apply effects based on flavor
                    if (lore.equals(ChatColor.DARK_PURPLE + "Grape Ice Flavor")) {
                        // Nausea and Slowness for Grape Ice
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 200, 1));
                        event.setCancelled(true);
                    } else if (lore.equals(ChatColor.DARK_RED + "Strawberry Flavor")) {
                        // Speed and Jump Boost for Strawberry
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP_BOOST, 200, 1));
                        event.setCancelled(true);
                    } else if (lore.equals(ChatColor.DARK_GREEN + "Mint Flavor")) {
                        // Regeneration and Resistance for Mint
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 200, 1));
                        event.setCancelled(true);
                    } else if (lore.equals(ChatColor.YELLOW + "Mango Flavor")) {
                        // Haste and Night Vision for Mango
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HASTE, 200, 1));
                        event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 200, 1));
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
