package bloodasp.galacticgreg;

import gregapi.block.prefixblock.PrefixBlock;
import gregapi.config.Config;
import gregapi.data.CS;
import gregapi.data.CS.BlocksGT;
import gregapi.old.GregTech_API;
import gregapi.oredict.OreDictMaterial;
import gregapi.worldgen.WorldgenObject;
import gregapi.worldgen.Worldgenerator;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class GT_Worldgen_GT_Ore_Bedrock
{
  public final int mProbability;
  public final OreDictMaterial mMaterial;
  public final boolean mMoon;
  public final boolean mMars;
  public final String mWorldGenName;
  
  public GT_Worldgen_GT_Ore_Bedrock(String aName, boolean aDefault, int aProbability, boolean aMoon, boolean aMars, OreDictMaterial aPrimary)
  {
	this.mWorldGenName = aName;
    this.mProbability = Math.max(1, CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName, "Probability", (long)aProbability));
    this.mMaterial = OreDictMaterial.get(CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName, "Ore", aPrimary.mNameInternal));
	
	
	
    this.mMoon = CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName, "Moon", aMoon);
    this.mMars = CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName, "Mars", aMars);
    
	for (WorldgenObject tWorldGen : Worldgenerator.sWorldgenList){
		if(tWorldGen.mWorldGenName.equals(aName)){
			tWorldGen.isGenerationAllowed("moon.moon", -27, this.mMoon ? -27: -50);
			tWorldGen.isGenerationAllowed("planet.mars", -28, this.mMars ? -28: -50);
		}
	}
    
  }
}