package es.titaniumsystem.gabamagar.andryvision09_plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
/*
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Endermite;
import org.bukkit.entity.Evoker;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Guardian;
import org.bukkit.entity.Husk;
import org.bukkit.entity.Monster;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
*/
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;

public class ChetosMobs extends JavaPlugin {

	public Map<String, Map<String, Double>> ajustes;
	public Set<String> acciones;
	public Map<String, Class<?>> mobs2class;
	public List<World> mundos;

	public void onEnable() {
		ajustes = new HashMap<String, Map<String, Double>>();
		// Registramos comandos:
		this.getCommand("chetosmobsupdate").setExecutor(new chetosmobsupdate());
		// acciones:
		acciones = new HashSet<String>();
		acciones.add("salud");
		acciones.add("daño");
		// Convertimos las cadenas de los mobs a clases
		mobs2class = new HashMap<String, Class<?>>();
		mobs2class.put("blaze", Blaze.class);
		mobs2class.put("cavespider", CaveSpider.class);
		mobs2class.put("creeper", Creeper.class);
		mobs2class.put("elderguardian", ElderGuardian.class);
		mobs2class.put("enderman", Enderman.class);
		mobs2class.put("endermite", Endermite.class);
		mobs2class.put("evoker", Evoker.class);
		mobs2class.put("giant", Giant.class);
		mobs2class.put("guardian", Guardian.class);
		mobs2class.put("husk", Husk.class);
		// mobs2class.put("illager", Illager.class);
		// mobs2class.put("illusioner", Illusioner.class);
		mobs2class.put("pigzombie", PigZombie.class);
		mobs2class.put("silverfish", Silverfish.class);
		mobs2class.put("skeleton", Skeleton.class);
		// mobs2class.put("spellcaster", SpellCaster.class);
		mobs2class.put("spider", Spider.class);
		mobs2class.put("stray", Stray.class);
		mobs2class.put("vex", Vex.class);
		mobs2class.put("vindicator", Vindicator.class);
		mobs2class.put("witch", Witch.class);
		mobs2class.put("wither", Wither.class);
		mobs2class.put("witherskeleton", WitherSkeleton.class);
		mobs2class.put("zombie", Zombie.class);
		mobs2class.put("zombievillager", ZombieVillager.class);
		// Mundos en los que actuaremos. Podremos pasar por la lista mundos.
		World overworld = Bukkit.getServer().getWorld("world");
		World nether = Bukkit.getServer().getWorld("world_nether");
		World world_end = Bukkit.getServer().getWorld("world_the_end");
		mundos = new ArrayList<World>();
		mundos.add(overworld);
		mundos.add(nether);
		mundos.add(world_end);
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
			getLogger().info("ejecutando");
			if (mobs2class.keySet().contains(arg3[0].toLowerCase()) && acciones.contains(arg3[1].toLowerCase())) {// revisar
				// hacemos
				if (ajustes.containsKey(arg3[0])) {
					ajustes.get(arg3[0]).put(arg3[1], Double.parseDouble(arg3[2]));

				} else {
					ajustes.put(arg3[0], new HashMap<String, Double>());
					ajustes.get(arg3[0]).put(arg3[1], Double.parseDouble(arg3[2]));
				}
				
				if(arg3[1]=="salud"){
					for(World w : mundos){
						getLogger().info("Mundo "+w.getName());
						for(Entity e: w.getEntitiesByClasses(mobs2class.get(arg3[0]))){
							getLogger().info("Actualizando entidad...");
							Monster m= (Monster) e;
							m.setHealth(m.getHealth()*Double.parseDouble(arg3[2]));
						}
					}
				}

			} else {
				getLogger().info("WRONG: argumentos erroneos");
				return false;
				
			}
			return true;
		}

	}

}
