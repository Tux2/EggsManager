package dk.shax;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerListener;

public class EggsManagerPlayerInteract extends PlayerListener {
	
	private EggsManager plugin;
	
	public EggsManagerPlayerInteract(EggsManager instance){
		
		this.plugin = instance;
	}
	
	public void onPlayerInteract(PlayerInteractEvent event){
		if (event.isCancelled()) return;
		
		Player player = event.getPlayer();
		
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
		
			if (event.useItemInHand() != null){
				if (player.getItemInHand().getTypeId() == 383){
					if (!player.hasPermission("eggsmanager.spawn.skeleton") && player.getItemInHand().getData().getData() == 51){
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.creeper") && player.getItemInHand().getData().getData() == 50) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.slime") && player.getItemInHand().getData().getData() == 55) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.zombie") && player.getItemInHand().getData().getData() == 54) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.spider") && player.getItemInHand().getData().getData() == 52) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.chicken") && player.getItemInHand().getData().getData() == 93) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.cavespider") && player.getItemInHand().getData().getData() == 59) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.cow") && player.getItemInHand().getData().getData() == 92) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.enderman") && player.getItemInHand().getData().getData() == 58) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.wolf") && player.getItemInHand().getData().getData() == 95) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.pigzombie") && player.getItemInHand().getData().getData() == 57) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.squid") && player.getItemInHand().getData().getData() == 94) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.magmacube") && player.getItemInHand().getData().getData() == 62) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.sheep") && player.getItemInHand().getData().getData() == 91) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.blaze") && player.getItemInHand().getData().getData() == 61) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.villager") && player.getItemInHand().getData().getData() == 120) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.silverfish") && player.getItemInHand().getData().getData() == 60) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.pig") && player.getItemInHand().getData().getData() == 90) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.ghast") && player.getItemInHand().getData().getData() == 56) {
						not_allowed(player);
						event.setCancelled(true);
					} else if (!player.hasPermission("eggsmanager.spawn.mooshroom") && player.getItemInHand().getData().getData() == 96) {
						not_allowed(player);
						event.setCancelled(true);
					}
				}
			}
		}		
	}
	
	public void not_allowed(Player player){
		if (plugin.toUser){
		player.sendMessage(plugin.userMessage);
		}
	}
}
