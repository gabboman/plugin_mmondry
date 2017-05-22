package es.titaniumsystem.gabamagar.andryvision09_plugin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Monster;
import org.bukkit.plugin.java.JavaPlugin;

public class ChetosMobs extends JavaPlugin {

	public Map<String, Map<String, Double>> ajustes;
	public Set<String> mobs;
	

	public void onEnable() {
		ajustes = new HashMap<String, Map<String, Double>>();
		// Registramos comandos:
		this.getCommand("chetosmobsupdate").setExecutor(new chetosmobsupdate());
		mobs=new HashSet<String>();
		//mobs.add("zombie");
		getLogger().info("Crashyvisioner69 ENABLED");
	}

	public void onDisable() {
		getLogger().info("PUEDES CORRER PERO NO PODRÁS ESCAPAR");
	}

	public void updateHealthMultiplier(double k, Monster p, String action) {
		p.setHealth(p.getHealth() * k);

	}

	// Vamos por partes, vamos a hacer los comandos, no?

	public class chetosmobsupdate implements CommandExecutor {

		// This method is called, when somebody uses our command
		// /chetosmobsupdate zombie salud 5
		public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
			if (true) {//revisar que los argumentos son correctos. de momento no lo hacemos
				if (ajustes.containsKey(arg3[0])) {
					ajustes.get(arg3[0]).put(arg3[1], Double.parseDouble(arg3[2]));

				} else {
					ajustes.put(arg3[0], new HashMap<String, Double>());
					ajustes.get(arg3[0]).put(arg3[1], Double.parseDouble(arg3[2]));
				}
				
				
				
			}else{
				return false;
			}
			return true;
		}

	}

}
