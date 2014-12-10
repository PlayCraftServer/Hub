package me.DJBiokinetix;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin {

	public static final Logger l = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable(){
		l.info("Hub Plugin enabled!");
		getCommand("/hub").setExecutor(new CommandHub(this));
		getCommand("fake").setExecutor(new CommandFake(this));
		getCommand("entry").setExecutor(new CommandEntry(this));
		getCommand("fw").setExecutor(new CommandFw(this));
		getCommand("firework").setExecutor(new CommandFw(this));
		getServer().getPluginManager().registerEvents(new EventsHub(this), this);
	    getConfig().addDefault("config.Join", String.valueOf("&e%user%&8» &7ha entrado al servidor!"));
	    getConfig().addDefault("config.Leave", String.valueOf("&e%user%&8» &7ha salido del servidor!"));
	    getConfig().addDefault("config.WelcomeMessage", String.valueOf("&7Bienvenido &e%user% &7al servidor!"));
	    getConfig().addDefault("config.Prefix", String.valueOf("&8[&6Hub&8]&7 "));
	    getConfig().addDefault("config.E-Fake", String.valueOf("&e%user%&8» &7ha entrado al servidor!"));
	    getConfig().addDefault("config.S-Fake", String.valueOf("&e%user%&8» &7ha salido del servidor!"));
	    getConfig().addDefault("config.FireworkMessage", String.valueOf("&7Lanzando cohetes!"));
	    getConfig().addDefault("config.NoPermission", String.valueOf("&cTu no tienes permiso para esto!"));
	    getConfig().addDefault("config.WaitMessage", String.valueOf("&7Espera &c%time &7segundos para lanzar otro cohete!"));
	    getConfig().addDefault("Time", Integer.valueOf("15"));
	    getConfig().options().copyDefaults(true);
	    saveConfig();
    }
	
	@Override
	public void onDisable(){
		l.info("Hub Plugin enabled!");
		saveConfig();
	}
	
}