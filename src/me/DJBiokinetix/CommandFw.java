package me.DJBiokinetix;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFw implements CommandExecutor {

	final HashMap<Long, Long> Timer = new HashMap<Long, Long>();
	public HashMap<String, Long> cooldowns = new HashMap<String, Long>();
	
	public Hub plugin;
	
	public CommandFw(Hub plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		  Player jugador = (Player) sender;
		
	      int cdt = Integer.parseInt(this.plugin.getConfig().getString("Time"));
	      
	      String launch = this.plugin.getConfig().getString("config.FireworkMessage");
	      String notallowed = this.plugin.getConfig().getString("config.NoPermission");
	      String wait = this.plugin.getConfig().getString("config.WaitMessage");
		
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
	    			  jugador.sendMessage(ChatColor.GREEN + "Firework:" + ChatColor.AQUA + " " + "/fw help -" + " " + ChatColor.GRAY + "Display this menu!");
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
	
	public String formatVariables(String string, Player player){
		int cdt = Integer.parseInt(this.plugin.getConfig().getString("Time"));
		return ChatColor.translateAlternateColorCodes("&".charAt(0), string).replace("%time", String.valueOf(cdt));
	}

}
