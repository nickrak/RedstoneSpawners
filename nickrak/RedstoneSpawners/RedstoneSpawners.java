package nickrak.RedstoneSpawners;

import java.util.logging.Logger;

import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class RedstoneSpawners extends JavaPlugin
{
    private final Logger l = Logger.getLogger("RedstoneSpawner");
    
    @Override
    public void onDisable()
    {
        this.l.info("[RedstoneSpawners] Stopped.");
    }

    @Override
    public void onEnable()
    {
        final PluginManager pm = this.getServer().getPluginManager();
        
        final RedstoneListener rl = new RedstoneListener();
        pm.registerEvent(Type.REDSTONE_CHANGE, rl, Priority.Monitor, this);
        
        this.l.info("[RedstoneSpawners] Started Version " + this.getDescription().getVersion() + ".");
    }

}
