package nickrak.RedstoneSpawners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.CreatureType;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class RedstoneListener extends BlockListener
{   
    @Override
    public void onBlockRedstoneChange(BlockRedstoneEvent event)
    {
        final Block b = event.getBlock();
        if (b.getType() == Material.MOB_SPAWNER && event.getNewCurrent() > 0 && event.getOldCurrent() == 0)
        {
            final CreatureSpawner cs = (CreatureSpawner) b.getState();
            final CreatureType ct = cs.getCreatureType();
            final World w = b.getWorld();
            final Location l = b.getLocation().add(0, 1, 0);
            
            w.spawnCreature(l, ct);
        }
    }
}
