package me.DJBiokinetix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFake implements CommandExecutor {

	public Hub plugin;
	
	public CommandFake(Hub plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player jugador = (Player) sender;
		String leave = this.plugin.getConfig().getString("config.S-Fake").replaceAll("&", "§").replaceAll("%user%", jugador.getPlayer().getName());
		if(jugador.getPlayer().hasPermission("fake.hub")){
			  jugador.getServer().broadcastMessage(leave);
		}
		return false;
	}

}
