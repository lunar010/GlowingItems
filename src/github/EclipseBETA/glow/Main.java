package github.EclipseBETA.glow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;


public class Main extends JavaPlugin implements Listener {

	public Scoreboard scoreboard;
	
	@Override
	public void onEnable() {
		System.out.println("by EclipseBETA");
		getServer().getPluginManager().registerEvents(this, this);
		scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
			initializeTeam("red", ChatColor.RED.toString());
			initializeTeam("white", ChatColor.WHITE.toString());
			initializeTeam("green", ChatColor.GREEN.toString());
			initializeTeam("gold", ChatColor.GOLD.toString());
			initializeTeam("yellow", ChatColor.YELLOW.toString());
			initializeTeam("purple", ChatColor.DARK_PURPLE.toString());
	}
	
	private void initializeTeam(String teamName, String prefix) {
        if (scoreboard.getTeam(teamName) == null) {
            scoreboard.registerNewTeam(teamName).setPrefix(prefix);
        }
    }
	
	@EventHandler
	public void onDrop(ItemSpawnEvent e) {
        ItemStack item = e.getEntity().getItemStack();
        if (item.getItemMeta().hasLore()) {
			for (String lore : item.getItemMeta().getLore()) {
				if (lore.contains("일반")) {
					e.getEntity().setGlowing(true);
					scoreboard.getTeam("white").addEntry(e.getEntity().getUniqueId().toString());
				} else if(lore.contains("희귀")) {
					e.getEntity().setGlowing(true);
					scoreboard.getTeam("green").addEntry(e.getEntity().getUniqueId().toString());
				} else if(lore.contains("에픽")) {
					e.getEntity().setGlowing(true);
					scoreboard.getTeam("purple").addEntry(e.getEntity().getUniqueId().toString());
				} else if(lore.contains("전설")) {
					e.getEntity().setGlowing(true);
					scoreboard.getTeam("gold").addEntry(e.getEntity().getUniqueId().toString());
				} else if(lore.contains("신화")) {
					e.getEntity().setGlowing(true);
					scoreboard.getTeam("red").addEntry(e.getEntity().getUniqueId().toString());
				} else if(lore.contains("캐시")) {
					e.getEntity().setGlowing(true);
					scoreboard.getTeam("yellow").addEntry(e.getEntity().getUniqueId().toString());
				}
	        }
        }
	}
	
}