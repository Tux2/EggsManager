package dk.shax;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class EggsManagerCommandExecutor implements CommandExecutor {
	
	private EggsManager plugin;
	
	public EggsManagerCommandExecutor(EggsManager instance){
		
		this.plugin = instance;
	}

    public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
    	Player player = null;
    	if(sender instanceof Player) {
    		player = (Player)sender;
    	}
    	if (command.getName().equals("eggsmanager")){
    		if (args.length != 0){
		    	if (args[0].equals("reset")){
		    		if(player != null && !player.hasPermission("eggsmanager.reset")) {
		    			//The player doesn't have permission, let's just return...
		    			return true;
		    		}
		    	
					if (args.length < 2){
						return false;
					}
					
					if (Boolean.parseBoolean(args[1]) == true){
					
					FileConfiguration config = plugin.getConfig();
				
					config.set("messages.touser", true);
					config.set("messages.usermessage", "You cannot place this egg!");
				
					plugin.saveConfig();
					
					sender.sendMessage("EggsManager Config Reset.");
				
					return true;
				
					}
		    	} else if (args[0].equals("reload")){
		    		if(player != null && !player.hasPermission("eggsmanager.reload")) {
		    			//The player doesn't have permission, let's just return...
		    			return true;
		    		}
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
