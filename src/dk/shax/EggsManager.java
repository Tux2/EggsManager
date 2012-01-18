package dk.shax;

import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class EggsManager extends JavaPlugin {
	
	private Logger log = Logger.getLogger("Minecraft");
	public boolean isAllowedSkeleton, isAllowedCreeper, isAllowedSlime, isAllowedZombie, isAllowedSpider, isAllowedChicken, isAllowedCaveSpider;
	public boolean isAllowedCow, isAllowedEnderman, isAllowedWolf, isAllowedPigZombie, isAllowedSquid, isAllowedMagmaCube, isAllowedSheep;
	public boolean isAllowedBlaze, isAllowedVillager, isAllowedSilverfish, isAllowedPig, isAllowedGhast, isAllowedMooshroom;
	public boolean toUser;
	public String userMessage;
	private EggsManagerCommandExecutor executor;
	private FileConfiguration config;
	
	public void onEnable() {

		this.getConf();
		
		this.logMessage("Enabled.");
	}
	
	public void getConf(){
		
		config = null;
		config = getConfig();
		
		isAllowedSkeleton = config.getBoolean("eggsAllowed.skeleton", false);
		isAllowedCreeper = config.getBoolean("eggsAllowed.creeper", false);
		isAllowedSlime = config.getBoolean("eggsAllowed.slime", false);
		isAllowedZombie = config.getBoolean("eggsAllowed.zombie", false);
		isAllowedSpider = config.getBoolean("eggsAllowed.spider", false);
		isAllowedChicken = config.getBoolean("eggsAllowed.chicken", false);
		isAllowedCaveSpider = config.getBoolean("eggsAllowed.cavespider", false);
		isAllowedCow = config.getBoolean("eggsAllowed.cow", false);
		isAllowedEnderman = config.getBoolean("eggsAllowed.enderman", false);
		isAllowedWolf = config.getBoolean("eggsAllowed.wolf", false);
		isAllowedPigZombie = config.getBoolean("eggsAllowed.pigzombie", false);
		isAllowedSquid = config.getBoolean("eggsAllowed.squid", false);
		isAllowedMagmaCube = config.getBoolean("eggsAllowed.magmacube", false);
		isAllowedSheep = config.getBoolean("eggsAllowed.sheep", false);
		isAllowedBlaze = config.getBoolean("eggsAllowed.blaze", false);
		isAllowedVillager = config.getBoolean("eggsAllowed.villager", false);
		isAllowedSilverfish = config.getBoolean("eggsAllowed.silverfish", false);
		isAllowedPig = config.getBoolean("eggsAllowed.pig", false);
		isAllowedGhast = config.getBoolean("eggsAllowed.ghast", false);
		isAllowedMooshroom = config.getBoolean("eggsAllowed.mooshroom", false);
		
		toUser = config.getBoolean("messages.touser", true);
		userMessage = config.getString("messages.usermessage", "You cannot place this egg!");

		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_INTERACT, new EggsManagerPlayerInteract(this), Priority.Highest, this);
		
		this.executor = new EggsManagerCommandExecutor(this);
		this.getCommand("eggsmanager").setExecutor(this.executor);
	}

	public void onDisable() {
		
		
		this.logMessage("Disabled.");
	}
	
	protected void logMessage(String msg){
		// Log NAME + VERSION : MESSAGE
		PluginDescriptionFile pdFile = this.getDescription();
		this.log.info(pdFile.getName() + " " + pdFile.getVersion() + ": " + msg);
	}
	



}
