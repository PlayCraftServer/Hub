package me.DJBiokinetix;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHub implements CommandExecutor {
	
	public Hub plugin;
	
	public CommandHub(Hub plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	  
	  String websrc = ("http://www.spigotmc.org/resources/hub.1095");
	  Player jugador = (Player)sender;
	  	  
	  if (args.length == 0) {
		  jugador.sendMessage(ChatColor.DARK_GRAY + "====== [" + ChatColor.GOLD + "Hub" + ChatColor.DARK_GRAY + "] ======");
		  jugador.sendMessage(ChatColor.GRAY + "Plugin by: " + ChatColor.RED + "DJBiokinetix");
		  jugador.sendMessage(ChatColor.GRAY + "Version: " + ChatColor.AQUA + this.plugin.getDescription().getVersion());
		  jugador.sendMessage(ChatColor.GRAY + "For more info:" + ChatColor.RED + " " + "//hub help");
		  jugador.sendMessage(ChatColor.DARK_GRAY + "==================");
	  } else if (args.length == 1) {
		  if (args[0].equalsIgnoreCase("reload")) {
			  if(jugador.hasPermission("hub.reload")){
				  this.plugin.reloadConfig();
				  this.plugin.saveConfig();
				  jugador.sendMessage(ChatColor.GREEN + "Configuration reloaded");
			  }
		  } else if (args.length == 1){
			  if(args[0].equalsIgnoreCase("music")){
				  jugador.sendMessage(ChatColor.DARK_GRAY + "======================= [" + ChatColor.GOLD + "Music" + ChatColor.DARK_GRAY + "] =======================");
				  jugador.sendMessage(ChatColor.RED + "//hub 13 - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "13");
				  jugador.sendMessage(ChatColor.RED + "//hub cat - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "cat");
				  jugador.sendMessage(ChatColor.RED + "//hub blocks - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "blocks");
				  jugador.sendMessage(ChatColor.RED + "//hub chirp - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "chirp");
				  jugador.sendMessage(ChatColor.RED + "//hub far - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "far");
				  jugador.sendMessage(ChatColor.RED + "//hub mall - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "mall");
				  jugador.sendMessage(ChatColor.RED + "//hub mellohi - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "mellohi");
				  jugador.sendMessage(ChatColor.RED + "//hub stal - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "stal");
				  jugador.sendMessage(ChatColor.RED + "//hub strad - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "strad");
				  jugador.sendMessage(ChatColor.RED + "//hub ward - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "ward");
				  jugador.sendMessage(ChatColor.RED + "//hub 11 - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "11");
				  jugador.sendMessage(ChatColor.RED + "//hub wait - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "wait");
				  jugador.sendMessage(ChatColor.DARK_GRAY + "=====================================================");
			  } else if (args.length == 1) {
				  if (args[0].equalsIgnoreCase("help")) {
					  jugador.sendMessage(ChatColor.DARK_GRAY + "=========================================");
					  jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/fw -" + " " + ChatColor.GRAY + "Launch fireworks!");
					  jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/fw help -" + " " + ChatColor.GRAY + "Help about fireworks");
					  jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/fake -" + " " + ChatColor.GRAY + "Fake message 'leave'");
					  jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/entry -" + " " + ChatColor.GRAY + "Fake message 'join'");
					  jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "//hub -" + " " + ChatColor.GRAY + "Hub version and author!");
					  jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "//hub reload -" + " " + ChatColor.GRAY + "Reload the config files!");
					  jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "//hub music -" + " " + ChatColor.GRAY + "menu of the disco mode...");
					  jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "//hub music stop" + " " + ChatColor.GRAY + "Stop the music!");
					  jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "//hub help -" + " " + ChatColor.GRAY + "display this menu");
					  jugador.sendMessage("");
					  jugador.sendMessage(ChatColor.GRAY + "Web:" + " " + ChatColor.GOLD + websrc);
					  jugador.sendMessage("");
					  jugador.sendMessage(ChatColor.DARK_GRAY + "=========================================");
				  } else if (args.length == 1) {
					  if(args[0].equalsIgnoreCase("13")){
						  if(jugador.hasPermission("13.hub")){
							  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2256);
							  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - 13");
						  }
					  } else if (args.length == 1) {
						  if(args[0].equalsIgnoreCase("cat")){
							  if(jugador.hasPermission("cat.hub")){
								  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2257);
								  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Cat");
							  }
						  } else if (args.length == 1) {
							  if(args[0].equalsIgnoreCase("blocks")){
								  if(jugador.hasPermission("blocks.hub")){
									  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2258);
									  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Blocks");
								  }
							  } else if (args.length == 1) {
								  if(args[0].equalsIgnoreCase("chirp")){
									  if(jugador.hasPermission("chirp.hub")){
										  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2259);
										  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Chirp");
									  }
								  } else if (args.length == 1) {
									  if(args[0].equalsIgnoreCase("far")){
										  if(jugador.hasPermission("far.hub")){
											  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2260);
											  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Far");
										  }
									  } else if (args.length == 1) {
										  if(args[0].equalsIgnoreCase("mall")){
											  if(jugador.hasPermission("mall.hub")){
												  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2261);
												  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Mall");
											  }
										  } else if (args.length == 1) {
											  if(args[0].equalsIgnoreCase("mellohi")){
												  if(jugador.hasPermission("mellohi.hub")){
													  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2262);
													  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Mellohi");
												  }
											  } else if (args.length == 1) {
												  if(args[0].equalsIgnoreCase("stal")){
													  if(jugador.hasPermission("stal.hub")){
														  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2263);
														  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Stal");
													  }
												  } else if (args.length == 1) {
													  if(args[0].equalsIgnoreCase("strad")){
														  if(jugador.hasPermission("stard.hub")){
															  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2264);
															  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Strad");
														  }
													  } else if (args.length == 1) {
														  if(args[0].equalsIgnoreCase("ward")){
															  if(jugador.hasPermission("ward.hub")){
																  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2265);
																  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Ward");
															  }
														  } else if (args.length == 1) {
															  if(args[0].equalsIgnoreCase("11")){
																  if(jugador.hasPermission("11.hub")){
																	  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2266);
																	  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - 11");
																  }
															  } else if (args.length == 1) {
																  if(args[0].equalsIgnoreCase("wait")){
																	  if(jugador.hasPermission("wait.hub")){
																		  jugador.playEffect(jugador.getLocation(), Effect.RECORD_PLAY, 2267);
																		  jugador.sendMessage(ChatColor.GREEN + "Now playing: Record - Wait");
																	  }
																  }
															  }
														  }
													  }
												  }
											  }
										  }
									  }
								  }
							  }
						  } 
					  }
				  }
			  }
		  }
	  }
	  return false;
	}
}
