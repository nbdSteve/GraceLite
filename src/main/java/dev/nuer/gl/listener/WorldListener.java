package dev.nuer.gl.listener;

import dev.nuer.gl.GraceLite;
import dev.nuer.gl.method.PlayerMessage;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityCombustEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Class that handles blocking all of the explosive and potentially explosive events in the world
 */
public class WorldListener implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (!GraceLite.doCountdown) return;
        if (event.getPlayer().hasPermission("grace.bypass")) return;
        if (event.getBlockPlaced().getType().equals(Material.TNT)) {
            new PlayerMessage("event-deny", event.getPlayer());
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void interactTNTMinecart(PlayerInteractEvent event) {
        if (!GraceLite.doCountdown) return;
        if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if (event.getPlayer().hasPermission("grace.bypass")) return;
        if (event.getItem().getType().equals(Material.getMaterial("EXPLOSIVE_MINECART"))
                || event.getItem().getType().equals(Material.getMaterial("TNT_MINECART"))) {
            new PlayerMessage("event-deny", event.getPlayer());
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void explode(BlockExplodeEvent event) {
        if (!GraceLite.doCountdown) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void explosivePrime(ExplosionPrimeEvent event) {
        if (!GraceLite.doCountdown) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void entityExplode(EntityCombustEvent event) {
        if (!GraceLite.doCountdown) return;
        event.setCancelled(true);
    }

    @EventHandler
    public void createSpawn(CreatureSpawnEvent event) {
        if (GraceLite.files.get("config").getBoolean("disable-wither-spawning")) {
            if (event.getEntity().getType().equals(EntityType.WITHER)) {
                event.setCancelled(true);
            }
        }
        if (!GraceLite.doCountdown) return;
        if (event.getEntity().getType().equals(EntityType.CREEPER)) {
            event.setCancelled(true);
        }
    }
}