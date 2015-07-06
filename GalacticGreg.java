package bloodasp.GalacticGreg;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import gregapi.code.ArrayListNoNulls;
import gregapi.code.ItemStackContainer;
import gregapi.data.CS;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.worldgen.WorldgenObject;
import gregapi.old.GregTech_API;
import gregapi.recipes.GT_ModHandler;
import gregapi.render.BlockTextureCopied;
import gregapi.block.prefixblock.PrefixBlock;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GalacticGreg.MODID, version = GalacticGreg.VERSION, dependencies = "required-after:GalacticraftCore; required-after:gregapi; required-after:gregtech; required-after:GalacticraftMars;", acceptableRemoteVersions="*")
public class GalacticGreg {
	public static final String MODID = "galacticgreg";
	public static final String VERSION = "1.6";
	public static final List<WorldgenObject> sWorldgenList = new ArrayListNoNulls();
	public Block GCMoonBlock;
	public Block GCMarsBlock;
	public Block GCAsteroidBlock;
	
	@Mod.EventHandler
	public void onPreLoad(FMLPreInitializationEvent aEvent){
		GCMoonBlock = GCBlocks.blockMoon;
		GCMarsBlock = MarsBlocks.marsBlock;
		GCAsteroidBlock = AsteroidBlocks.blockBasic;
		PrefixBlock broken;
		if(GCMoonBlock!=null){
			broken = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.broken.moon", OP.ore, null, null, null, new BlockTextureCopied(GCMoonBlock, 6, 4), Material.rock, Block.soundTypeStone, "pickaxe", 0.5F, 0.5F, -1, 0, 999, true, false, false, false, true, true, false, false,true,true,true,false,false,false);
			PrefixBlock tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.normal.gc.stone." + 0, OP.ore, null, null, new PrefixBlock.Drops(broken), new BlockTextureCopied(GCMoonBlock, 6, 4), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCMoonBlock, 1L, 4), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCMoonBlock, 1L, 4), broken);
			tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.small.gc.stone." + 0, OP.oreSmall, null, null, new PrefixBlock.Drops_Small_Ore(MT.Stone), new BlockTextureCopied(GCMoonBlock, 6, 4), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCMoonBlock, 1L, 4), tmp);//moonrock meta4
		
			broken = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.broken.moon2", OP.ore, null, null, null, new BlockTextureCopied(GCMoonBlock, 6, 3), Material.rock, Block.soundTypeStone, "pickaxe", 0.5F, 0.5F, -1, 0, 999, true, false, false, false, true, true, false, false,true,true,true,false,false,false);
			tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.normal.gc.stone2." + 0, OP.ore, null, null, new PrefixBlock.Drops(broken), new BlockTextureCopied(GCMoonBlock, 6, 3), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCMoonBlock, 1L, 3), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCMoonBlock, 1L, 3), broken);
			tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.small.gc.stone2." + 0, OP.oreSmall, null, null, new PrefixBlock.Drops_Small_Ore(MT.Stone), new BlockTextureCopied(GCMoonBlock, 6, 3), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCMoonBlock, 1L, 3), tmp);//moonrock meta4
		
		}
		
		    if(GCMarsBlock!=null){
			broken = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.broken.mars", OP.ore, null, null, null, new BlockTextureCopied(GCMarsBlock, 6, 9), Material.rock, Block.soundTypeStone, "pickaxe", 0.5F, 0.5F, -1, 0, 999, true, false, false, false, true, true, false, false,true,true,true,false,false,false);
			PrefixBlock tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.normal.gc.stone." + 1, OP.ore, null, null, new PrefixBlock.Drops(broken), new BlockTextureCopied(GCMarsBlock, 6, 9), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCMarsBlock, 1L, 9), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCMarsBlock, 1L, 9), broken);
			tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.small.gc.stone." + 1, OP.oreSmall, null, null, new PrefixBlock.Drops_Small_Ore(MT.Stone), new BlockTextureCopied(GCMarsBlock, 6, 9), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCMarsBlock, 1L, 9), tmp);//marsstone meta9
		
			broken = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.broken.mars2", OP.ore, null, null, null, new BlockTextureCopied(GCMarsBlock, 6, 6), Material.rock, Block.soundTypeStone, "pickaxe", 0.5F, 0.5F, -1, 0, 999, true, false, false, false, true, true, false, false,true,true,true,false,false,false);
			tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.normal.gc.stone2." + 1, OP.ore, null, null, new PrefixBlock.Drops(broken), new BlockTextureCopied(GCMarsBlock, 6, 6), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCMarsBlock, 1L, 6), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCMarsBlock, 1L, 6), broken);
			tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.small.gc.stone2." + 1, OP.oreSmall, null, null, new PrefixBlock.Drops_Small_Ore(MT.Stone), new BlockTextureCopied(GCMarsBlock, 6, 6), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCMarsBlock, 1L, 6), tmp);//marsstone meta9
		
		    }
		if(GCAsteroidBlock!=null){
			broken = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.broken.asteroid", OP.ore, null, null, null, new BlockTextureCopied(GCAsteroidBlock, 6, 2), Material.rock, Block.soundTypeStone, "pickaxe", 0.5F, 0.5F, -1, 0, 999, true, false, false, false, true, true, false, false,true,true,true,false,false,false);
			PrefixBlock tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.normal.gc.stone." + 2, OP.ore, null, null, new PrefixBlock.Drops(broken), new BlockTextureCopied(GCAsteroidBlock, 6, 2), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCAsteroidBlock, 1L, 2), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCAsteroidBlock, 1L, 2), broken);
			tmp = new PrefixBlock("gregtech", "gregtech", "gg.meta.ore.small.gc.stone." + 2, OP.oreSmall, null, null, new PrefixBlock.Drops_Small_Ore(MT.Stone), new BlockTextureCopied(GCAsteroidBlock, 6, 2), Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCAsteroidBlock, 1L, 2), tmp);//asteroid meta2
		}
	}

	@Mod.EventHandler
	public void onPostLoad(FMLPostInitializationEvent aEvent) {
		new WorldGenGaGT().run();
	}
}
