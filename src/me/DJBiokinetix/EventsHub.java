package me.DJBiokinetix;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EventsHub implements Listener {
	
	public Hub plugin;
	
	public EventsHub(Hub plugin){
		this.plugin = plugin;
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Join(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		Location loc = p.getLocation();
		String prefixch = ChatColor.DARK_GRAY + "[" + ChatColor.GOLD + "Hub" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " ";
		String hasPlayedBefore = this.plugin.getConfig().getString("config.WelcomeMessage").replaceAll("&", "§").replaceAll("%user%", p.getName());
		String msg = this.plugin.getConfig().getString("config.Join").replaceAll("&", "§").replaceAll("%user%", p.getName());
		String prefix = this.plugin.getConfig().getString("config.Prefix").replaceAll("&", "§");
		String websrc = ("http://www.spigotmc.org/resources/hub.1095");
		
		if (p.isOp() && p.hasPermission("hub.update")){
			p.sendMessage(prefixch + "Check more updates in:" + " " + ChatColor.GOLD + websrc);
		}
		
		if (p.hasPermission("join.hub")) {
			e.setJoinMessage(prefix + msg);
			FireworkTypes.shootFireworkRandom(p);
	        return;
		} else if (p.hasPlayedBefore()){
			e.setJoinMessage(hasPlayedBefore);
		} else if(p.getName().contains("DJBiokinetix")) {
			p.getWorld().spawnEntity(loc, EntityType.FIREWORK);
			p.sendMessage(ChatColor.AQUA + "========================================");
			p.sendMessage(prefixch + ChatColor.RED + ChatColor.BOLD + " " + "¡Este servidor usa tu plugin!" + " " + prefixch);
			p.sendMessage(ChatColor.AQUA + "========================================");
			p.playEffect(loc, Effect.RECORD_PLAY, 2259);
		}
		e.setJoinMessage(null);
	}
	
	@EventHandler
	public void Leave(PlayerQuitEvent e){
		
		Player p = e.getPlayer();
		String msg = this.plugin.getConfig().getString("config.Leave").replaceAll("&", "§").replaceAll("%user%", p.getName());
		
		if (p.hasPermission("leave.hub")){
			e.setQuitMessage(msg);
			return;
		}
		e.setQuitMessage(null);
	}
	
	@EventHandler
	public void Kick(PlayerKickEvent e){
		e.setLeaveMessage(null);
	}
	
}
