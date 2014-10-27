package me.DJBiokinetix;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin implements Listener{
	
	String prefix = (ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Hub" + ChatColor.DARK_GRAY + "]" + " ");
	
	final HashMap<Long, Long> Timer = new HashMap<Long, Long>();
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	
	@Override
	public void onEnable(){
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
    }
	
	@Override
	public void onDisable(){
		saveDefaultConfig();
	}
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	  Player jugador = (Player)sender;

      int cdt = Integer.parseInt(getConfig().getString("Time"));
      String launch = getConfig().getString("Firework message");
      String notallowed = getConfig().getString("No permission");
      String wait = getConfig().getString("Wait message");
	  
	  String leave = getConfig().getString("S Fake").replaceAll("&", "§").replaceAll("%user%", jugador.getPlayer().getName());
	  String entry = getConfig().getString("E Fake").replaceAll("&", "§").replaceAll("%user%", jugador.getPlayer().getName());
	  	  	  
	  	  if(cmd.getName().equalsIgnoreCase("hub")){
	  		if (args.length == 0) {
	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "====== [" + ChatColor.GOLD + "Hub" + ChatColor.DARK_GRAY + "] ======");
	  		  jugador.sendMessage(ChatColor.GRAY + "Plugin by: " + ChatColor.RED + "DJBiokinetix");
	  		  jugador.sendMessage(ChatColor.GRAY + "Version: " + ChatColor.AQUA + "4.1");
	  		  jugador.sendMessage(ChatColor.GRAY + "For more info:" + ChatColor.RED + " " + "/hub help");
	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "==================");
	  		} else if (args.length == 1) {
		        if (args[0].equalsIgnoreCase("reload")) {
		        	if(jugador.hasPermission("hub.reload")){
		        		saveDefaultConfig();
		        		reloadConfig();
		        		jugador.sendMessage(ChatColor.GREEN + "Configuration reloaded");
		        	}
		         } else if (args.length == 1){
		    		  if(args[0].equalsIgnoreCase("music")){
		    	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "======================= [" + ChatColor.GOLD + "Music" + ChatColor.DARK_GRAY + "] =======================");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub 13 - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "13");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub cat - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "cat");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub blocks - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "blocks");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub chirp - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "chirp");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub far - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "far");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub mall - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "mall");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub mellohi - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "mellohi");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub stal - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "stal");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub strad - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "strad");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub ward - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "ward");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub 11 - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "11");
		    	  		  jugador.sendMessage(ChatColor.RED + "/hub wait - " + " " + ChatColor.AQUA + "Play record:" + " " + ChatColor.GOLD + "wait");
		    	  		  jugador.sendMessage(ChatColor.DARK_GRAY + "=====================================================");
		    		  } else if (args.length == 1){
		    	    		if (args[0].equalsIgnoreCase("help")) {
		    	    	    	  jugador.sendMessage(ChatColor.DARK_GRAY + "=========================================");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/fw -" + " " + ChatColor.GRAY + "Launch fireworks!");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/fw help -" + " " + ChatColor.GRAY + "Help about fireworks");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/fake -" + " " + ChatColor.GRAY + "Fake message 'leave'");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/entry -" + " " + ChatColor.GRAY + "Fake message 'join'");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/hub -" + " " + ChatColor.GRAY + "Hub version and author!");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/hub reload -" + " " + ChatColor.GRAY + "Reload the config files!");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/hub music -" + " " + ChatColor.GRAY + "menu of the disco mode...");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/hub music stop" + " " + ChatColor.GRAY + "Stop the music!");
		    	    	          jugador.sendMessage(ChatColor.GREEN + "Command:" + " " + ChatColor.AQUA + "/hub help -" + " " + ChatColor.GRAY + "display this menu");
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
	  		}
	  	  
	  	  if(cmd.getName().equalsIgnoreCase("fake")){
			  if(jugador.getPlayer().hasPermission("fake.hub")){
			  jugador.getServer().broadcastMessage(leave);
			  }}
	  	   	  
	  	  if(cmd.getName().equalsIgnoreCase("entry")){
			  if(jugador.getPlayer().hasPermission("fake.hub")){
			  jugador.getServer().broadcastMessage(entry);
			  FireworkTypes.shootFireworkRandom(jugador);
			  }}
	  	
	  	  if(cmd.getName().equalsIgnoreCase("rconfig")){
			  if(jugador.getPlayer().hasPermission("hub.reload")){
			  saveDefaultConfig();
			  reloadConfig();
			  jugador.sendMessage(ChatColor.GREEN + "Configuration reloaded!");
			  }}
		
	      if ((cmd.getName().equalsIgnoreCase("fw")) ||	(cmd.getName().equalsIgnoreCase("firework"))){
	    	  if(args.length == 0){
	    		  if (jugador.hasPermission("firework.hub")) {
	    			  if (jugador.hasPermission("firework.admin")) {
	    				  FireworkTypes.shootFireworkRandom(jugador);
	    	        	  jugador.sendMessage(formatVariables(launch, jugador));
	    	          } else {
	    	        	  int cooldownTime = cdt;
	    	            if (this.cooldowns.containsKey(sender.getName())) {
	    	            	long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
	    	              if (secondsLeft > 0L) {
	    	            	  sender.sendMessage(formatVariables(wait, jugador));
	    	                return true;
	    	              }
	    	            } this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
	    	            FireworkTypes.shootFireworkRandom(jugador);
	    	            jugador.sendMessage(formatVariables(launch, jugador));
	    	          }
	    	        } else {
	    	        	jugador.sendMessage(formatVariables(notallowed, jugador));
	    	        }
	    	  } else if (args.length == 1){
	    		  if(args[0].equalsIgnoreCase("help")) {
	    			  jugador.sendMessage(ChatColor.DARK_GRAY + "====================================");
	    			  jugador.sendMessage(ChatColor.GREEN + "Firework:" + ChatColor.AQUA + " " + "/fw -" + " " + ChatColor.GRAY + "Launch random firework!");
	    			  jugador.sendMessage(ChatColor.GREEN + "Firework:" + ChatColor.AQUA + " " + "/fw red -" + " " + ChatColor.GRAY + "Launch firework red!");
	    			  jugador.sendMessage(ChatColor.GREEN + "Firework:" + ChatColor.AQUA + " " + "/fw blue -" + " " + ChatColor.GRAY + "Launch firework blue!");
	    			  jugador.sendMessage(ChatColor.GREEN + "Firework:" + ChatColor.AQUA + " " + "/fw purple -" + " " + ChatColor.GRAY + "Launch firework purple!");
	    			  jugador.sendMessage(ChatColor.GREEN + "Firework:" + ChatColor.AQUA + " " + "/fw white -" + " " + ChatColor.GRAY + "Launch firework white!");
	    			  jugador.sendMessage(ChatColor.GREEN + "Firework:" + ChatColor.AQUA + " " + "/fw yellow -" + " " + ChatColor.GRAY + "Launch firework yellow!");
	    			  jugador.sendMessage(ChatColor.GREEN + "Firework:" + ChatColor.AQUA + " " + "/fw lime -" + " " + ChatColor.GRAY + "Launch firework lime!");
	    			  jugador.sendMessage(ChatColor.GREEN + "Firework:" + ChatColor.AQUA + " " + "/fw multi -" + " " + ChatColor.GRAY + "Launch firework multicolor!");
	    			  jugador.sendMessage(ChatColor.DARK_GRAY + "====================================");
	    		  } else if (args.length == 1){
	    			  if(args[0].equalsIgnoreCase("red")){
	    				  if (jugador.hasPermission("firework.red")) {
	    	    			  if (jugador.hasPermission("firework.admin")) {
	    	    				  FireworkTypes.shootFireworkRed(jugador);
	    	    	        	  jugador.sendMessage(formatVariables(launch, jugador));
	    	    	          } else {
	    	    	        	  int cooldownTime = cdt;
	    	    	            if (this.cooldowns.containsKey(sender.getName())) {
	    	    	            	long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
	    	    	              if (secondsLeft > 0L) {
	    	    	            	  sender.sendMessage(formatVariables(wait, jugador));
	    	    	                return true;
	    	    	              }
	    	    	            } this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
	    	    	            FireworkTypes.shootFireworkRed(jugador);
	    	    	            jugador.sendMessage(formatVariables(launch, jugador));
	    	    	          }
	    	    	        } else {
	    	    	        	jugador.sendMessage(formatVariables(notallowed, jugador));
	    	    	        }
	    			  } else if (args.length == 1){
	    				  if(args[0].equalsIgnoreCase("lime")){
		    				  if (jugador.hasPermission("firework.lime")) {
		    	    			  if (jugador.hasPermission("firework.admin")) {
		    	    				  FireworkTypes.shootFireworkLime(jugador);
		    	    	        	  jugador.sendMessage(formatVariables(launch, jugador));
		    	    	          } else {
		    	    	        	  int cooldownTime = cdt;
		    	    	            if (this.cooldowns.containsKey(sender.getName())) {
		    	    	            	long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
		    	    	              if (secondsLeft > 0L) {
		    	    	            	  sender.sendMessage(formatVariables(wait, jugador));
		    	    	                return true;
		    	    	              }
		    	    	            } this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
		    	    	            FireworkTypes.shootFireworkLime(jugador);
		    	    	            jugador.sendMessage(formatVariables(launch, jugador));
		    	    	          }
		    	    	        } else {
		    	    	        	jugador.sendMessage(formatVariables(notallowed, jugador));
		    	    	        }
		    			  } else if (args.length == 1){
		    				  if(args[0].equalsIgnoreCase("purple")){
			    				  if (jugador.hasPermission("firework.purple")) {
			    	    			  if (jugador.hasPermission("firework.admin")) {
			    	    				  FireworkTypes.shootFireworkPurple(jugador);
			    	    	        	  jugador.sendMessage(formatVariables(launch, jugador));
			    	    	          } else {
			    	    	        	  int cooldownTime = cdt;
			    	    	            if (this.cooldowns.containsKey(sender.getName())) {
			    	    	            	long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
			    	    	              if (secondsLeft > 0L) {
			    	    	            	  sender.sendMessage(formatVariables(wait, jugador));
			    	    	                return true;
			    	    	              }
			    	    	            } this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
			    	    	            FireworkTypes.shootFireworkPurple(jugador);
			    	    	            jugador.sendMessage(formatVariables(launch, jugador));
			    	    	          }
			    	    	        } else {
			    	    	        	jugador.sendMessage(formatVariables(notallowed, jugador));
			    	    	        }
			    			  } else if (args.length == 1){
			    				  if(args[0].equalsIgnoreCase("white")){
				    				  if (jugador.hasPermission("firework.white")) {
				    	    			  if (jugador.hasPermission("firework.admin")) {
				    	    				  FireworkTypes.shootFireworkWhite(jugador);
				    	    	        	  jugador.sendMessage(formatVariables(launch, jugador));
				    	    	          } else {
				    	    	        	  int cooldownTime = cdt;
				    	    	            if (this.cooldowns.containsKey(sender.getName())) {
				    	    	            	long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
				    	    	              if (secondsLeft > 0L) {
				    	    	            	  sender.sendMessage(formatVariables(wait, jugador));
				    	    	                return true;
				    	    	              }
				    	    	            } this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
				    	    	            FireworkTypes.shootFireworkWhite(jugador);
				    	    	            jugador.sendMessage(formatVariables(launch, jugador));
				    	    	          }
				    	    	        } else {
				    	    	        	jugador.sendMessage(formatVariables(notallowed, jugador));
				    	    	        }
				    			  } else if (args.length == 1){
				    				  if(args[0].equalsIgnoreCase("yellow")){
					    				  if (jugador.hasPermission("firework.yellow")) {
					    	    			  if (jugador.hasPermission("firework.admin")) {
					    	    				  FireworkTypes.shootFireworkYellow(jugador);
					    	    	        	  jugador.sendMessage(formatVariables(launch, jugador));
					    	    	          } else {
					    	    	        	  int cooldownTime = cdt;
					    	    	            if (this.cooldowns.containsKey(sender.getName())) {
					    	    	            	long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
					    	    	              if (secondsLeft > 0L) {
					    	    	            	  sender.sendMessage(formatVariables(wait, jugador));
					    	    	                return true;
					    	    	              }
					    	    	            } this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
					    	    	            FireworkTypes.shootFireworkYellow(jugador);
					    	    	            jugador.sendMessage(formatVariables(launch, jugador));
					    	    	          }
					    	    	        } else {
					    	    	        	jugador.sendMessage(formatVariables(notallowed, jugador));
					    	    	        }
					    			  } else if (args.length == 1){
					    				  if(args[0].equalsIgnoreCase("multi")){
						    				  if (jugador.hasPermission("firework.multi")) {
						    	    			  if (jugador.hasPermission("firework.admin")) {
						    	    				  FireworkTypes.shootFireworkNormal(jugador);
						    	    	        	  jugador.sendMessage(formatVariables(launch, jugador));
						    	    	          } else {
						    	    	        	  int cooldownTime = cdt;
						    	    	            if (this.cooldowns.containsKey(sender.getName())) {
						    	    	            	long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
						    	    	              if (secondsLeft > 0L) {
						    	    	            	  sender.sendMessage(formatVariables(wait, jugador));
						    	    	                return true;
						    	    	              }
						    	    	            } this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
						    	    	            FireworkTypes.shootFireworkNormal(jugador);
						    	    	            jugador.sendMessage(formatVariables(launch, jugador));
						    	    	          }
						    	    	        } else {
						    	    	        	jugador.sendMessage(formatVariables(notallowed, jugador));
						    	    	        }
						    			  } else if (args.length == 1){
						    				  if(args[0].equalsIgnoreCase("blue")){
							    				  if (jugador.hasPermission("firework.blue")) {
							    	    			  if (jugador.hasPermission("firework.admin")) {
							    	    				  FireworkTypes.shootFireworkBlue(jugador);
							    	    	        	  jugador.sendMessage(formatVariables(launch, jugador));
							    	    	          } else {
							    	    	        	  int cooldownTime = cdt;
							    	    	            if (this.cooldowns.containsKey(sender.getName())) {
							    	    	            	long secondsLeft = ((Long)this.cooldowns.get(sender.getName())).longValue() / 1000L + cooldownTime - System.currentTimeMillis() / 1000L;
							    	    	              if (secondsLeft > 0L) {
							    	    	            	  sender.sendMessage(formatVariables(wait, jugador));
							    	    	                return true;
							    	    	              }
							    	    	            } this.cooldowns.put(sender.getName(), Long.valueOf(System.currentTimeMillis()));
							    	    	            FireworkTypes.shootFireworkBlue(jugador);
							    	    	            jugador.sendMessage(formatVariables(launch, jugador));
							    	    	          }
							    	    	        } else {
							    	    	        	jugador.sendMessage(formatVariables(notallowed, jugador));
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Join(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		Location loc = e.getPlayer().getLocation();
		
		if (p.hasPermission("join.hub")) {
			e.setJoinMessage(getConfig().getString("Join").replaceAll("&", "§").replaceAll("%user%", e.getPlayer().getName()));
			FireworkTypes.shootFireworkRandom(e.getPlayer());
	        return;
	      } else if(p.getName().contains("DJBiokinetix")) {
	    	  p.sendMessage(ChatColor.AQUA + "========================================");
	    	  p.sendMessage(prefix + ChatColor.RED + ChatColor.BOLD + " " + "¡Este servidor usa tu plugin!" + " " + prefix);
	    	  p.sendMessage(ChatColor.AQUA + "========================================");
	    	  p.playEffect(loc, Effect.RECORD_PLAY, 2259);
	    	  for (Player players : Bukkit.getOnlinePlayers()){
	    		  players.playSound(loc, Sound.FIREWORK_LAUNCH, 10F, 0.1F);
	    	  }
	      } else if(p.getName().contains("Cazmon")){
	  		  p.sendMessage(ChatColor.DARK_GRAY + "====== [" + ChatColor.GOLD + "Hub" + ChatColor.DARK_GRAY + "] ======");
	  		  p.sendMessage(ChatColor.GRAY + "Plugin by: " + ChatColor.RED + "DJBiokinetix");
	  		  p.sendMessage(ChatColor.GRAY + "Version: " + ChatColor.AQUA + "4.1");
	  		  p.sendMessage(ChatColor.GRAY + "For more info:" + ChatColor.RED + " " + "/hub help");
	  		  p.sendMessage(ChatColor.DARK_GRAY + "==================");
	      }
		e.setJoinMessage(null);
	}
	
	@EventHandler
	public void Leave(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		Location loc = e.getPlayer().getLocation();
		
		if (p.hasPermission("leave.hub")){
			e.setQuitMessage(getConfig().getString("Leave").replaceAll("&", "§").replaceAll("%user%", e.getPlayer().getName()));
			return;
		} else if (p.getPlayerListName().equalsIgnoreCase("DJBiokinetix")){
			for (Player players : Bukkit.getOnlinePlayers()){
				players.playSound(loc, Sound.NOTE_BASS, 1F, 1F);
			}
		}
		e.setQuitMessage(null);
	}
	
	@EventHandler
	public void Kick(PlayerKickEvent e){
		e.setLeaveMessage(null);
	}
	
	public String formatVariables(String string, Player player){
		int cdt = Integer.parseInt(getConfig().getString("Time"));
		return ChatColor.translateAlternateColorCodes("&".charAt(0), string).replace("%time", String.valueOf(cdt));
	}
}