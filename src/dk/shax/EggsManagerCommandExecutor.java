package dk.shax;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class EggsManagerCommandExecutor implements CommandExecutor {
	
	private EggsManager plugin;
	
	public EggsManagerCommandExecutor(EggsManager instance){
		
		this.plugin = instance;
	}

    public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
    	
    	if (command.getName().equals("eggsmanager")){
    		if (args.length != 0){
		    	if (args[0].equals("reset")){
		    	
					if (args.length < 2){
						return false;
					}
					
					if (Boolean.parseBoolean(args[1]) == true){
					
					FileConfiguration config = plugin.getConfig();
			
					config.set("eggsAllowed.skeleton", false);
					config.set("eggsAllowed.creeper", false);
					config.set("eggsAllowed.slime", false);
					config.set("eggsAllowed.zombie", false);
					config.set("eggsAllowed.spider", false);
					config.set("eggsAllowed.chicken", false);
					config.set("eggsAllowed.cavespider", false);
					config.set("eggsAllowed.cow", false);
					config.set("eggsAllowed.enderman", false);
					config.set("eggsAllowed.wolf", false);
					config.set("eggsAllowed.pigzombie", false);
					config.set("eggsAllowed.squid", false);
					config.set("eggsAllowed.magmacube", false);
					config.set("eggsAllowed.sheep", false);
					config.set("eggsAllowed.blaze", false);
					config.set("eggsAllowed.villager", false);
					config.set("eggsAllowed.silverfish", false);
					config.set("eggsAllowed.pig", false);
					config.set("eggsAllowed.ghast", false);
					config.set("eggsAllowed.mooshroom", false);
				
					config.set("messages.touser", true);
					config.set("messages.usermessage", "You cannot place this egg!");
				
					plugin.saveConfig();
					
					sender.sendMessage("EggsManager Config Reset.");
				
					return true;
				
					}
		    	} else if (args[0].equals("reload")){
		    		
					if (args.length < 2){
						return false;
					}
					
					if (Boolean.parseBoolean(args[1]) == true){
						
						plugin.reloadConfig();
		    		
						plugin.getConf();
		    		
		    		sender.sendMessage("EggsManager Reloaded.");
		    		
		    		return true;
					}
		    		
		    		return false;
		    	}
    		}
    	}
        
        return false;
    }

}
