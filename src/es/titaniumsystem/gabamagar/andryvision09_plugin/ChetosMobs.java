package es.titaniumsystem.gabamagar.andryvision09_plugin;

import org.bukkit.entity.Monster;
import org.bukkit.plugin.java.JavaPlugin;

public class ChetosMobs extends JavaPlugin {

	public void onEnable() {
		getLogger().info("Crashyvisioner69 ENABLED");
	}

	public void onDisable() {
		getLogger().info("PUEDES CORRER PERO NO PODRÁS ESCAPAR");
	}

	public void multiplyUpdater(int k, Monster p, String action) {
		if (action.toLowerCase().equals("salud")) {
			p.setHealth(p.getHealth() * k);
		}
		if (action.toLowerCase().equals("daño")) {
			//MIERDA XD
		}
		if( action.toLowerCase().equals("velocidad")){
			// OH SHIT DOS
		}
		

	}

}
