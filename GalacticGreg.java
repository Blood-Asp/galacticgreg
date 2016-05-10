package bloodasp.GalacticGreg;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import gregapi.code.ArrayListNoNulls;
import gregapi.code.ItemStackContainer;
import gregapi.data.CS;
import gregapi.data.MT;
import gregapi.data.OP;
import gregapi.worldgen.WorldgenObject;
import gregapi.oredict.OreDictManager;
import gregapi.oredict.OreDictMaterial;
import gregapi.oredict.OreDictPrefix;
import gregapi.recipes.GT_ModHandler;
import gregapi.render.BlockTextureCopied;
import gregapi.render.ITexture;
import gregapi.block.prefixblock.PrefixBlock;
import gregapi.block.behaviors.Drops;
import gregapi.block.behaviors.Drops_SmallOre;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLLoadEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GalacticGreg.MODID, version = GalacticGreg.VERSION, dependencies = "required-after:GalacticraftCore; required-after:gregapi; required-after:gregtech; required-after:GalacticraftMars;")
public class GalacticGreg {
	public static final String MODID = "galacticgreg";
	public static final String VERSION = "1.9";
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
			broken = doCreatePBlock("gg.meta.ore.broken.moon", OP.ore,  null, new BlockTextureCopied(GCMoonBlock, 6, 4));
			PrefixBlock tmp = doCreatePBlock("gg.meta.ore.normal.gc.stone." + 0, OP.ore, new Drops(broken), new BlockTextureCopied(GCMoonBlock, 6, 4));
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCMoonBlock, 1L, 4), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCMoonBlock, 1L, 4), broken);
			tmp = doCreatePBlock("gg.meta.ore.small.gc.stone." + 0, OP.oreSmall,  new Drops_SmallOre(MT.Stone), new BlockTextureCopied(GCMoonBlock, 6, 4));
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCMoonBlock, 1L, 4), tmp);//moonrock meta4
		
			broken = doCreatePBlock("gg.meta.ore.broken.moon2", OP.ore,  null, new BlockTextureCopied(GCMoonBlock, 6, 3));
			tmp = doCreatePBlock("gg.meta.ore.normal.gc.stone2." + 0, OP.ore,  new Drops(broken), new BlockTextureCopied(GCMoonBlock, 6, 3));
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCMoonBlock, 1L, 3), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCMoonBlock, 1L, 3), broken);
			tmp = doCreatePBlock("gg.meta.ore.small.gc.stone2." + 0, OP.oreSmall,  new Drops_SmallOre(MT.Stone), new BlockTextureCopied(GCMoonBlock, 6, 3));
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCMoonBlock, 1L, 3), tmp);//moonrock meta3
		
		}
		
		    if(GCMarsBlock!=null){
			broken = doCreatePBlock("gg.meta.ore.broken.mars", OP.ore,  null, new BlockTextureCopied(GCMarsBlock, 6, 9));
			PrefixBlock tmp = doCreatePBlock("gg.meta.ore.normal.gc.stone." + 1, OP.ore,  new Drops(broken), new BlockTextureCopied(GCMarsBlock, 6, 9));
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCMarsBlock, 1L, 9), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCMarsBlock, 1L, 9), broken);
			tmp = doCreatePBlock("gg.meta.ore.small.gc.stone." + 1, OP.oreSmall,  new Drops_SmallOre(MT.Stone), new BlockTextureCopied(GCMarsBlock, 6, 9));
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCMarsBlock, 1L, 9), tmp);//marsstone meta9
		
			broken = doCreatePBlock("gg.meta.ore.broken.mars2", OP.ore,  null, new BlockTextureCopied(GCMarsBlock, 6, 6));
			tmp = doCreatePBlock("gg.meta.ore.normal.gc.stone2." + 1, OP.ore,  new Drops(broken), new BlockTextureCopied(GCMarsBlock, 6, 6));
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCMarsBlock, 1L, 6), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCMarsBlock, 1L, 6), broken);
			tmp = doCreatePBlock("gg.meta.ore.small.gc.stone2." + 1, OP.oreSmall,  new Drops_SmallOre(MT.Stone), new BlockTextureCopied(GCMarsBlock, 6, 6));
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCMarsBlock, 1L, 6), tmp);//marsstone meta6
		
		    }
		if(GCAsteroidBlock!=null){
			broken = doCreatePBlock("gg.meta.ore.broken.asteroid", OP.ore,  null, new BlockTextureCopied(GCAsteroidBlock, 6, 2));
			PrefixBlock tmp = doCreatePBlock("gg.meta.ore.normal.gc.stone." + 2, OP.ore,  new Drops(broken), new BlockTextureCopied(GCAsteroidBlock, 6, 2));
			CS.BlocksGT.stoneToNormalOres.put(new ItemStackContainer(GCAsteroidBlock, 1L, 2), tmp);
			CS.BlocksGT.stoneToBrokenOres.put(new ItemStackContainer(GCAsteroidBlock, 1L, 2), broken);
			tmp = doCreatePBlock("gg.meta.ore.small.gc.stone." + 2, OP.oreSmall,  new Drops_SmallOre(MT.Stone), new BlockTextureCopied(GCAsteroidBlock, 6, 2));
			CS.BlocksGT.stoneToSmallOres.put(new ItemStackContainer(GCAsteroidBlock, 1L, 2), tmp);//asteroid meta2
		}
	}
	
	public PrefixBlock doCreatePBlock(String aName,OreDictPrefix aPrefix, Drops aDrops,ITexture aTexture){
		return new PrefixBlock("gregtech", "gregtech", aName, aPrefix, null, null, aDrops, aTexture, Material.rock, Block.soundTypeStone, "pickaxe", 1.0F, 1.0F, 0, 0, 999, false, false, false, false, true, true, false, false,true,true,true,false,false,false);
	}

	@Mod.EventHandler
	public void onPostLoad(FMLPostInitializationEvent aEvent) {
		new WorldGenGaGT().run();

//		GT_Values.RA.addCentrifugeRecipe(new ItemStack(GCBlocks.blockMoon, 1, 5), null, null, 
//				MT.Helium3.getGas(33, false), 
//				new ItemStack(Blocks.sand,1), 
//				OreDictMaterial.get(MT.Aluminium)GT_OreDictUnificator.get(OreDictPrefix.sPrefixes.get("dust"), MT.Aluminium, 1), 
//				GT_OreDictUnificator.get(OreDictPrefix.sPrefixes.get("dust"),, MT.Calcite, 1), 
//				GT_OreDictUnificator.get(OreDictPrefix.sPrefixes.get("dust"),, MT.Iron, 1), 
//				GT_OreDictUnificator.get(OreDictPrefix.sPrefixes.get("dust"),, MT.Magnesium, 1), 
//				GT_OreDictUnificator.get(OreDictPrefix.sPrefixes.get("dust"),, MT.Titanium, 1), new int[]{5000,400,400,100,100,50}, 400, 8);
//		
//		GT_Values.RA.addPulveriserRecipe(new ItemStack(GCBlocks.blockMoon, 1, 4), new ItemStack[]{new ItemStack(GCBlocks.blockMoon, 1, 5)}, null, 400, 2);
//		
//		GT_Values.RA.addFluidExtractionRecipe(new ItemStack(MarsBlocks.marsBlock, 1, 9), new ItemStack(Blocks.stone, 1), new FluidStack(MT.Iron.mLiquid,50), 10000, 250, 16);
	
		
	}
}
