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
        createIGETBarRecipe();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void createIGETBarRecipe() {
        // Create the IGET Bar item
        ItemStack igetBar = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = igetBar.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "IGET Bar");
        meta.setLore(List.of(ChatColor.DARK_PURPLE + "Grape Ice Flavor"));
        igetBar.setItemMeta(meta);

        // Define the crafting recipe
        ShapedRecipe recipe = new ShapedRecipe(new NamespacedKey(this, "iget_bar"), igetBar);
        recipe.shape(" I ", "RNR", " R ");
        recipe.setIngredient('I', Material.IRON_INGOT);
        recipe.setIngredient('R', Material.REDSTONE);
        recipe.setIngredient('N', Material.SWEET_BERRIES);

        // Add the recipe to the server
        Bukkit.addRecipe(recipe);
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Check if the player right-clicked with the IGET Bar
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            ItemStack item = event.getItem();

            if (item != null && item.getType() == Material.AMETHYST_SHARD && item.hasItemMeta()) {
                ItemMeta meta = item.getItemMeta();
                if (meta.hasLore() && meta.getLore().contains(ChatColor.DARK_PURPLE + "Grape Ice Flavor")) {
                    // Apply the effects to the player
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NAUSEA, 200, 1)); // Nausea for 10 seconds
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 200, 1)); // Slowness for 10 seconds
                    event.setCancelled(true); // Prevent any placement action
                }
            }
        }
    }
}
