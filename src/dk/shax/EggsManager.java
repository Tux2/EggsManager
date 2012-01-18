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
