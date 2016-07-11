package bloodasp.GalacticGreg;

import gregapi.GT_API;
import gregapi.block.IBlockPlacable;
import gregapi.code.ArrayListNoNulls;
import gregapi.code.ItemStackContainer;
import gregapi.config.Config;
import gregapi.data.CS;
import gregapi.data.CS.BlocksGT;
import gregapi.worldgen.WorldgenObject;
import gregapi.worldgen.Worldgen_GT_Ore_Layer;
import gregapi.oredict.OreDictMaterial;
import gregapi.block.prefixblock.PrefixBlock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.planets.mars.blocks.MarsBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;

public class GT_Worldgen_GT_Ore_Layer_Space 
{
	public final boolean mMoon;
	public final boolean mMars;
	public final boolean mAsteroid;
	public final boolean mEndAsteroid;
	public static ArrayList<GT_Worldgen_GT_Ore_Layer_Space> sList = new ArrayListNoNulls();
	public static int sWeight = 0;
	public final short mMinY;
	public final short mMaxY;
	public final short mWeight;
	public final short mDensity;
	public final short mSize;
	public final short mPrimaryMeta;
	public final short mSecondaryMeta;
	public final short mBetweenMeta;
	public final short mSporadicMeta;
	  public final String mWorldGenName2;
		public static final Map<String, Boolean> mAsteriodAllowed = new HashMap<String, Boolean>();
		public static final Map<String, Boolean> mEndAllowed = new HashMap<String, Boolean>();

	public GT_Worldgen_GT_Ore_Layer_Space(String aName, boolean aDefault, int aMinY, int aMaxY, int aWeight, int aDensity, int aSize, boolean aMoon,
			boolean aMars, boolean aEnd, boolean aAsteroids,  OreDictMaterial aPrimary,  OreDictMaterial aSecondary,  OreDictMaterial aBetween,  OreDictMaterial aSporadic) {
		this.mWorldGenName2 = aName;
		this.mMinY = ((short) CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "MinHeight", (long)aMinY));
		this.mMaxY = ((short) Math.max(this.mMinY + 5, CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "MaxHeight", (long)aMaxY)));
		this.mWeight = ((short) CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "RandomWeight", (long)aWeight));
		this.mDensity = ((short) CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "Density", (long)aDensity));
		this.mSize = ((short) Math.max(1, CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "Size", (long)aSize)));
	    this.mPrimaryMeta = OreDictMaterial.get(CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "OrePrimaryLayer", aPrimary.mNameInternal)).mID;
	    this.mSecondaryMeta = OreDictMaterial.get(CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "OreSecondaryLayer", aSecondary.mNameInternal)).mID;
	    this.mBetweenMeta = OreDictMaterial.get(CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "OreSporadiclyInbetween", aBetween.mNameInternal)).mID;
	    this.mSporadicMeta = OreDictMaterial.get(CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "OreSporaticlyAround", aSporadic.mNameInternal)).mID;
	    
	    
		this.mMoon = CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "Moon", aMoon);
		this.mMars = CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "Mars", aMars);
		this.mAsteroid=CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "Asteroid", aAsteroids);
		this.mEndAsteroid=CS.ConfigsGT.WORLDGEN.get("worldgen." + this.mWorldGenName2, "EndAsteroid", aEnd);
		mAsteriodAllowed.put(this.mWorldGenName2, this.mAsteroid);
		mEndAllowed.put(this.mWorldGenName2, this.mEndAsteroid);
		
		
		for (Worldgen_GT_Ore_Layer tWorldGen : Worldgen_GT_Ore_Layer.sList){
			if(tWorldGen.mWorldGenName.equals(aName)){
				tWorldGen.isGenerationAllowed("moon.moon", -27, this.mMoon ? -27: -50);
				tWorldGen.isGenerationAllowed("planet.mars", -28, this.mMars ? -28: -50);
				tWorldGen.isGenerationAllowed("planet.asteroids", -29, -50);
			}
		}
	}
}
