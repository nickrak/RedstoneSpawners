package nickrak.RedstoneSpawners;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockRedstoneEvent;

public class RedstoneListener extends BlockListener
{
    @Override
    public void onBlockRedstoneChange(BlockRedstoneEvent event)
    {
        if (event.getOldCurrent() != 0 || event.getNewCurrent() == 0)
        {
            return;
        }
        
        final Block b = event.getBlock();
        final ArrayList<Block> sb = new ArrayList<Block>(6);
        sb.add(b.getRelative(0, 1, 0));
        sb.add(b.getRelative(0, -1, 0));
        sb.add(b.getRelative(0, 0, 1));
        sb.add(b.getRelative(0, 0, -1));
        sb.add(b.getRelative(1, 0, 0));
        sb.add(b.getRelative(-1, 0, 0));
        
        for (final Block tb : sb)
        {
            spawnerAct(tb);
        }
        
        /*final CreatureSpawner cs = (CreatureSpawner) b.getState();
        final CreatureType ct = cs.getCreatureType();
        final World w = b.getWorld();
        final Location l = b.getLocation().add(0, 1, 0);

        w.spawnCreature(l, ct);*/
    }
    
    private final void spawnerAct(final Block b)
    {
        if (b.getType().getId() == Material.MOB_SPAWNER.getId())
        {
            CreatureSpawner cs = (CreatureSpawner) b.getState();
            b.getWorld().spawnCreature(b.getLocation().add(0, 1, 0), cs.getCreatureType());
        }        
    }
}
