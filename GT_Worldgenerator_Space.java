package bloodasp.GalacticGreg;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import gregapi.block.IBlockPlacable;
import gregapi.code.ArrayListNoNulls;
import gregapi.code.ItemStackContainer;
import gregapi.data.CS;
import gregapi.log.GT_Log;
import gregapi.worldgen.WorldgenObject;
import gregapi.worldgen.Worldgen_GT_Ore_Layer;
import gregapi.worldgen.Worldgenerator;
import gregapi.old.GregTech_API;
import gregapi.block.prefixblock.PrefixBlock;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.google.common.eventbus.Subscribe;

import micdoodle8.mods.galacticraft.api.event.wgen.GCCoreEventPopulate;
import micdoodle8.mods.galacticraft.core.world.gen.ChunkProviderMoon;
import micdoodle8.mods.galacticraft.planets.asteroids.blocks.AsteroidBlocks;
import micdoodle8.mods.galacticraft.planets.asteroids.world.gen.ChunkProviderAsteroids;
import micdoodle8.mods.galacticraft.planets.mars.world.gen.ChunkProviderMars;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderEnd;
import net.minecraft.world.gen.ChunkProviderHell;
import net.minecraftforge.common.MinecraftForge;

public class GT_Worldgenerator_Space extends Worldgenerator {
	public static boolean sAsteroids = true;
	private final EventBus eventBus = new EventBus();
	private World worldObj;
	private Random randomGenerator;
	private final Map<String, Boolean> mDimensionMap = new HashMap<String, Boolean>();

	private int chunkX;
	private int chunkZ;
	private int mAsteroidProbability = 50;
	private int mEndAsteroidProbability = 300;
	private int mSize = 100;
	private int endMinSize = 50;
	private int endMaxSize = 200;
	private int minSize = 100;
	private int maxSize = 400;
	private boolean endAsteroids = true;
	private boolean gcAsteroids = true;

	public GT_Worldgenerator_Space() {
		endAsteroids = GregTech_API.sWorldgenFile.get("galacticgreg", "GenerateAsteroidsInEnd", true);
		gcAsteroids = GregTech_API.sWorldgenFile.get("galacticgreg", "GenerateAsteroidsInGC", true);
		endMinSize = GregTech_API.sWorldgenFile.get("galacticgreg", "EndAsteroidMinSize", 50L);
		endMaxSize = GregTech_API.sWorldgenFile.get("galacticgreg", "EndAsteroidMaxSize", 200L);
		minSize = GregTech_API.sWorldgenFile.get("galacticgreg", "AsteroidMinSize", 100L);
		maxSize = GregTech_API.sWorldgenFile.get("galacticgreg", "AsteroidMaxSize", 400L);
		mAsteroidProbability = GregTech_API.sWorldgenFile.get("galacticgreg", "AsteroidProbability", 50L);
		mEndAsteroidProbability = GregTech_API.sWorldgenFile.get("galacticgreg", "EndAsteroidProbability", 300L);
		GameRegistry.registerWorldGenerator(this, 1073741923);
	}

	public void generate(Random aRandom, int aX, int aZ, World aWorld, IChunkProvider aChunkGenerator, IChunkProvider aChunkProvider) {
		super.generate(aRandom, aX, aZ, aWorld, aChunkGenerator, aChunkProvider);
		aRandom = new Random(aRandom.nextInt());
		aX *= 16;
		aZ *= 16;
		String tBiome = aWorld.getBiomeGenForCoords(aX + 8, aZ + 8).biomeName;
		int tDimensionType = 0;
		if (tBiome == null) {
			tBiome = BiomeGenBase.plains.biomeName;
		} 
		if ((aWorld.provider.dimensionId == -30) || ((aChunkGenerator instanceof ChunkProviderAsteroids))) {
			tDimensionType = -30;
		} else if ((tBiome.equals(BiomeGenBase.sky.biomeName)) || (aWorld.provider.dimensionId == 1) || ((aChunkGenerator instanceof ChunkProviderEnd))) {
			tDimensionType = 1;
		}else {
			tDimensionType = 0;
		}
		// Asteroid Gen
		if (((tDimensionType == 1) && endAsteroids && ((this.mEndAsteroidProbability <= 1) || (aRandom.nextInt(this.mEndAsteroidProbability) == 0)))
				|| ((tDimensionType == -30) && gcAsteroids && ((this.mAsteroidProbability <= 1) || (aRandom.nextInt(this.mAsteroidProbability) == 0)))) {
			short primaryMeta = 0;
			short secondaryMeta = 0;
			short betweenMeta = 0;
			short sporadicMeta = 0;
			if ((Worldgen_GT_Ore_Layer.sWeight > 0) && (Worldgen_GT_Ore_Layer.sList.size() > 0)) {
				boolean temp = true;
				int tRandomWeight;
				for (int i = 0; (i < 256) && (temp); i++) {
					tRandomWeight = aRandom.nextInt(Worldgen_GT_Ore_Layer.sWeight);
					for (Worldgen_GT_Ore_Layer tWorldGen : Worldgen_GT_Ore_Layer.sList) {
						tRandomWeight -= ((Worldgen_GT_Ore_Layer) tWorldGen).mWeight;
						if (tRandomWeight <= 0) {
							try {
								if ((GT_Worldgen_GT_Ore_Layer_Space.mAsteriodAllowed.get(tWorldGen.mWorldGenName) && tDimensionType == -30) || ((GT_Worldgen_GT_Ore_Layer_Space.mEndAllowed.get(tWorldGen.mWorldGenName) && tDimensionType == 1))) {
									primaryMeta = tWorldGen.mPrimaryMeta;
									secondaryMeta = tWorldGen.mSecondaryMeta;
									betweenMeta = tWorldGen.mBetweenMeta;
									sporadicMeta = tWorldGen.mSporadicMeta;
									temp = false;
									break;
								}
							} catch (Throwable e) {
								e.printStackTrace(GT_Log.err);
							}
						}
					}
				}
			}
			int tX = aX + aRandom.nextInt(16);
			int tY = 50 + aRandom.nextInt(200 - 50);
			int tZ = aZ + aRandom.nextInt(16);
			if (tDimensionType == 1) {
				mSize = aRandom.nextInt((int) (endMaxSize - endMinSize));
			} else {
				mSize = aRandom.nextInt((int) (maxSize - minSize));
			}
			if ((aWorld.getBlock(tX, tY, tZ).isAir(aWorld, tX, tY, tZ))) {
				float var6 = aRandom.nextFloat() * 3.141593F;
				double var7 = tX + 8 + MathHelper.sin(var6) * this.mSize / 8.0F;
				double var9 = tX + 8 - MathHelper.sin(var6) * this.mSize / 8.0F;
				double var11 = tZ + 8 + MathHelper.cos(var6) * this.mSize / 8.0F;
				double var13 = tZ + 8 - MathHelper.cos(var6) * this.mSize / 8.0F;
				double var15 = tY + aRandom.nextInt(3) - 2;
				double var17 = tY + aRandom.nextInt(3) - 2;
				for (int var19 = 0; var19 <= this.mSize; var19++) {
					double var20 = var7 + (var9 - var7) * var19 / this.mSize;
					double var22 = var15 + (var17 - var15) * var19 / this.mSize;
					double var24 = var11 + (var13 - var11) * var19 / this.mSize;
					double var26 = aRandom.nextDouble() * this.mSize / 16.0D;
					double var28 = (MathHelper.sin(var19 * 3.141593F / this.mSize) + 1.0F) * var26 + 1.0D;
					double var30 = (MathHelper.sin(var19 * 3.141593F / this.mSize) + 1.0F) * var26 + 1.0D;
					int tMinX = MathHelper.floor_double(var20 - var28 / 2.0D);
					int tMinY = MathHelper.floor_double(var22 - var30 / 2.0D);
					int tMinZ = MathHelper.floor_double(var24 - var28 / 2.0D);
					int tMaxX = MathHelper.floor_double(var20 + var28 / 2.0D);
					int tMaxY = MathHelper.floor_double(var22 + var30 / 2.0D);
					int tMaxZ = MathHelper.floor_double(var24 + var28 / 2.0D);
					for (int eX = tMinX; eX <= tMaxX; eX++) {
						double var39 = (eX + 0.5D - var20) / (var28 / 2.0D);
						if (var39 * var39 < 1.0D) {
							for (int eY = tMinY; eY <= tMaxY; eY++) {
								double var42 = (eY + 0.5D - var22) / (var30 / 2.0D);
								if (var39 * var39 + var42 * var42 < 1.0D) {
									for (int eZ = tMinZ; eZ <= tMaxZ; eZ++) {
										double var45 = (eZ + 0.5D - var24) / (var28 / 2.0D);
										if ((var39 * var39 + var42 * var42 + var45 * var45 < 1.0D) && (aWorld.getBlock(tX, tY, tZ).isAir(aWorld, tX, tY, tZ))) {
											int ranOre = aRandom.nextInt(50);
											if (ranOre < 3) {
												setOreBlock(aWorld, eX, eY, eZ, primaryMeta, tDimensionType == 1);
											} else if (ranOre < 6) {
												setOreBlock(aWorld, eX, eY, eZ, secondaryMeta, tDimensionType == 1);
											} else if (ranOre < 8) {
												setOreBlock(aWorld, eX, eY, eZ, betweenMeta, tDimensionType == 1);
											} else if (ranOre < 10) {
												setOreBlock(aWorld, eX, eY, eZ, sporadicMeta, tDimensionType == 1);
											} else {
												if (tDimensionType == -30) {
													aWorld.setBlock(eX, eY, eZ, AsteroidBlocks.blockBasic, 2, 0);
												} else {
													aWorld.setBlock(eX, eY, eZ, Blocks.end_stone, 0, 0);
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		// Save Chunk
		Chunk tChunk = aWorld.getChunkFromBlockCoords(aX, aZ);
		if (tChunk != null) {
			tChunk.isModified = true;
		}
	}
	
	public boolean isGenerationAllowed(World aWorld, int aDimensionType, int aAllowedDimensionType, String mWorldGenName) {
		String aDimName = aWorld.provider.getDimensionName();
		Boolean tAllowed = mDimensionMap.get(aDimName);
		if (tAllowed == null) {
			boolean tValue = GregTech_API.sWorldgenFile.get("worldgen.dimensions."+mWorldGenName, aDimName.replaceAll(" ", "_"), aDimensionType == aAllowedDimensionType);
			mDimensionMap.put(aDimName, tValue);
			return tValue;
		}
		return tAllowed;
	}

	private static void setOreBlock(World aWorld, int aX, int aY, int aZ, short aID, boolean end) {
		if (end) {
			CS.BlocksGT.oreEndstone.placeBlock(aWorld, aX, aY, aZ, (byte) 6, aID, null, false, true);
		} else {
			IBlockPlacable tBlock = (IBlockPlacable) CS.BlocksGT.stoneToNormalOres.get(new ItemStackContainer(AsteroidBlocks.blockBasic, 1L, 2));
			if (tBlock != null) {
				tBlock.placeBlock(aWorld, aX, aY, aZ, (byte) 6, aID, null, false, true);
			}
		}
	}
}
