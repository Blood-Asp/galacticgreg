package bloodasp.GalacticGreg;

import gregapi.block.IBlockPlacable;
import gregapi.code.ItemStackContainer;
import gregapi.config.Config;
import gregapi.data.CS;
import gregapi.data.CS.BlocksGT;
import gregapi.worldgen.WorldgenObject;
import gregapi.worldgen.Worldgen_GT_Ore_Layer;
import gregapi.worldgen.Worldgen_GT_Ore_SmallPieces;
import gregapi.worldgen.Worldgenerator;
import gregapi.oredict.OreDictMaterial;
import gregapi.block.prefixblock.PrefixBlock;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class GT_Worldgen_GT_Ore_SmallPieces_Space 
{
	public final short mMinY;
	public final short mMaxY;
	public final short mAmount;
	public final short mMeta;
	public final boolean mMoon;
	public final boolean mMars;
	public final String mWorldGenName;

	public GT_Worldgen_GT_Ore_SmallPieces_Space(String aName, boolean aDefault, int aMinY, int aMaxY, int aAmount, boolean aMoon, boolean aMars, boolean aEnd, OreDictMaterial aPrimary) {
		this.mWorldGenName = aName;
		this.mMinY = ((short) CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName, "MinHeight",(long) aMinY));
		this.mMaxY = ((short) Math.max(this.mMinY + 1, CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName, "MaxHeight",(long) aMaxY)));
		this.mAmount = ((short) Math.max(1, CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName, "Amount", (long)aAmount)));
	    this.mMeta = OreDictMaterial.get(CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName, "Ore", aPrimary.mNameInternal)).mID;
	    
	    
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
