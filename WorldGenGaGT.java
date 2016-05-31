package bloodasp.GalacticGreg;

import gregapi.config.Config;
import gregapi.config.ConfigCategories;
import gregapi.data.CS.BlocksGT;
import gregapi.data.CS;
import gregapi.data.MT;
import gregapi.data.MT.OREMATS;
import cpw.mods.fml.common.Loader;

public class WorldGenGaGT implements Runnable {

	@Override
	public void run() {
		new GT_Worldgenerator_Space();

		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.copper", true, 60, 120, 32, true, true, true, MT.Cu);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.chalcopyrite", true, 60, 120, 16, true, true, true, OREMATS.Chalcopyrite);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.cassiterite", true, 60, 120, 16, true, true, true, OREMATS.Cassiterite);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.tin", true, 60, 120, 32, true, true, true, MT.Sn);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.bismuth", true, 80, 120, 8, true, true, false, MT.Bi);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.coal", true, 60, 100, 24, false, false, false, MT.Coal);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.magnetite", true, 40, 80, 12, true, true, true, OREMATS.Magnetite);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.bandediron", true, 40, 80, 12, true, true, true, OREMATS.BandedIron);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.sphalerite", true, 30, 60, 8, true, true, true, OREMATS.Sphalerite);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.zinc", true, 30, 60, 12, true, true, true, MT.Zn);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.galena", true, 40, 80, 8, true, true, true, OREMATS.Galena);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.lead", true, 40, 80, 8, true, true, true, MT.Pb);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.gold", true, 20, 40, 8, true, true, true, MT.Au);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.silver", true, 20, 40, 8, true, true, true, MT.Ag);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.garnierite", true, 20, 40, 4, true, true, true, OREMATS.Garnierite);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.pentlandite", true, 20, 40, 4, true, true, true, OREMATS.Pentlandite);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.lapis", true, 20, 40, 4, true, false, false, MT.Lapis);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.graphite", true, 5, 10, 2, true, true, false, MT.Graphite);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.diamond", true, 5, 10, 2, true, true, false, MT.Diamond);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.emerald", true, 5, 250, 1, true, true, false, MT.Emerald);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.ruby", true, 5, 250, 1, true, true, false, MT.Ruby);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.sapphire", true, 5, 250, 1, true, true, false, MT.Sapphire);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.greensapphire", true, 5, 250, 1, true, true, false, MT.GreenSapphire);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.olivine", true, 5, 250, 1, true, true, false, MT.Olivine);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.craponite", true, 5, 250, 1, true, true, true, MT.Craponite);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.topaz", true, 5, 250, 1, true, true, false, MT.Topaz);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.tanzanite", true, 5, 250, 1, true, true, false, MT.Tanzanite);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.amethyst", true, 5, 250, 1, true, true, false, MT.Amethyst);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.opal", true, 5, 250, 1, true, true, false, MT.Opal);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.jasper", true, 5, 250, 1, true, true, false, MT.Jasper);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.bluetopaz", true, 5, 250, 1, true, true, false, MT.BlueTopaz);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.amber", true, 5, 250, 1, true, true, false, MT.Amber);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.foolsruby", true, 5, 250, 1, true, true, false, MT.FoolsRuby);
	    //new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.garnetred", true, 5, 250, 1, true, true, false, MT.GarnetRed);
	    //new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.garnetyellow", true, 5, 250, 1, true, true, false, MT.GarnetYellow);
	    new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.redstone", true, 5, 20, 8, true, true, false, MT.Redstone);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.platinum", true, 20, 40, 8, false, true, true, MT.Platinum);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.cooperite", true, 20, 40, 6, false, false, true, MT.Pt);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.iridium", true, 20, 40, 8, false, true, true, MT.Iridium);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.netherquartz", true, 30, 120, 64, false, false, false, MT.NetherQuartz);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.saltpeter", true, 10, 60, 8, false, false, false, MT.Saltpeter);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.sulfur_n", true, 10, 60, 32, false, false, false, MT.S);
		new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.sulfur_o", true, 5, 15, 8, false, false, false, MT.S);

				int f = 0;
		for (int j = CS.ConfigsGT.WORLDGEN.get("worldgen", "AmountOfCustomSmallOreSlots", 16L); f < j; f++) {
			new GT_Worldgen_GT_Ore_SmallPieces_Space("ore.small.custom." + (f < 10 ? "0" : "") + f, false, 0, 0, 0, false, false, false, MT.NULL);
		}
		
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.bauxite", true, 10000, true, true, OREMATS.Bauxite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.cassiterite", true, 10000, true, true, OREMATS.Cassiterite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.chalcopyrite", true, 10000, true, true, OREMATS.Chalcopyrite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.saltpeter", true, 15000, true, true, MT.Saltpeter);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.sphalerite", true, 15000, true, true, OREMATS.Sphalerite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.pentlandite", true, 15000, true, true, OREMATS.Pentlandite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.stibnite", true, 20000, true, true, OREMATS.Stibnite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.bandediron", true, 20000, true, true, OREMATS.BandedIron);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.graphite", true, 25000, true, true, MT.Graphite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.vanadiummagnetite", true, 30000, true, true, OREMATS.VanadiumMagnetite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.galena", true, 30000, true, true, OREMATS.Galena);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.redstone", true, 35000, true, true, MT.Redstone);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.tungstate", true, 60000, true, true, OREMATS.Tungstate);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.powellite", true, 70000, true, true, OREMATS.Powellite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.cooperite", true, 80000, true, true, OREMATS.Cooperite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.monazite", true, 80000, true, true, MT.Monazite);
	    new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.uraninite", true, 150000, true, true, OREMATS.Uraninite);
		
		int g = 0;
	    for (int j = CS.ConfigsGT.WORLDGEN.get("worldgen", "AmountOfCustomBedrockOreSlots", 16L); g < j; g++) {
	      new GT_Worldgen_GT_Ore_Bedrock("ore.bedrock.custom." + (g < 10 ? "0" : "") + g, false, 100000, false, false, MT.NULL);
	    }

		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.naquadah", false, 10, 60, 10, 5, 32, false, true, true, true, MT.Nq, MT.Nq, MT.Nq, MT.Nq_528);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.lignite", true, 50, 130, 160, 8, 32, false, false, false,false, MT.Lignite, MT.Lignite, MT.Lignite, MT.Coal);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.coal", true, 50, 80, 80, 6, 32, false, false, false, false, MT.Coal, MT.Coal, MT.Coal, MT.Lignite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.magnetite", true, 50, 120, 160, 3, 32, true, true, false, false, OREMATS.Magnetite, OREMATS.Magnetite, OREMATS.BandedIron, OREMATS.VanadiumMagnetite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.gold", true, 60, 80, 160, 3, 32, true, true, false, true, OREMATS.Magnetite, OREMATS.Magnetite, OREMATS.VanadiumMagnetite, MT.Au);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.iron", true, 10, 40, 120, 4, 24, true, true, false, false, OREMATS.BrownLimonite, OREMATS.YellowLimonite, OREMATS.BandedIron, OREMATS.Malachite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.cassiterite", true, 40, 120, 50, 5, 24, true, true, false,true, MT.Sn, MT.Sn, OREMATS.Cassiterite, MT.Sn);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.tetrahedrite", true, 80, 120, 70, 4, 24, true, true, false, true, OREMATS.Tetrahedrite, OREMATS.Tetrahedrite, MT.Cu, OREMATS.Stibnite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.netherquartz", true, 40, 80, 80, 5, 24, false, false, false,false, MT.NetherQuartz, MT.NetherQuartz, MT.NetherQuartz, MT.NetherQuartz);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.sulfur", true, 5, 20, 100, 5, 24, false, true, false, false, MT.S, MT.S, MT.Pyrite, OREMATS.Sphalerite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.copper", true, 10, 30, 80, 4, 24, true, true, false, false, OREMATS.Chalcopyrite, OREMATS.BandedIron, MT.Pyrite, MT.Cu);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.bauxite", true, 50, 90, 80, 4, 24, true, true, false, true, OREMATS.Bauxite, OREMATS.Bauxite, OREMATS.Bauxite, OREMATS.Ilmenite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.salts", true, 50, 60, 50, 3, 24, true, false, false, false, MT.RockSalt, MT.Salt, OREMATS.Lepidolite, OREMATS.Spodumene);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.redstone", true, 10, 40, 60, 3, 24, true, true, false, true, MT.Redstone, MT.Redstone, MT.Ruby, OREMATS.Cinnabar);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.soapstone", true, 10, 40, 40, 3, 16, true, true, false, false, MT.Soapstone, MT.Talc, OREMATS.Glauconite, OREMATS.Pentlandite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.nickel", true, 10, 40, 40, 3, 16, true, true, false, true, OREMATS.Garnierite, MT.Ni, OREMATS.Cobaltite, OREMATS.Pentlandite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.platinum", true, 40, 50, 5, 3, 16, false, true, true, true, OREMATS.Cooperite, MT.Pd, MT.Pt, MT.Ir);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.pitchblende", true, 10, 40, 40, 3, 16, true, true, true, true, OREMATS.Pitchblende, OREMATS.Pitchblende, MT.U_238, OREMATS.Uraninite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.plutonium", true, 20, 30, 10, 3, 16, true, true, true, true, OREMATS.Uraninite, OREMATS.Uraninite, MT.Pu, MT.U_238);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.monazite", true, 20, 40, 30, 3, 16, true, true, true, true, OREMATS.Bastnasite, OREMATS.Bastnasite, MT.Monazite, MT.Nd);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.molybdenum", true, 20, 50, 5, 3, 16, true, true, true, true, OREMATS.Wulfenite, OREMATS.Molybdenite, MT.Mo, OREMATS.Powellite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.tungstate", true, 20, 50, 10, 3, 16, true, true, true, true, OREMATS.Scheelite, OREMATS.Russellite, OREMATS.Tungstate, OREMATS.Pinalite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.sapphire", true, 10, 40, 60, 3, 16, true, true, false, true, MT.YellowSapphire, MT.OrangeSapphire, MT.BlueSapphire, MT.GreenSapphire);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.manganese", true, 20, 30, 20, 3, 16, true, false, true, true, MT.Grossular, MT.Spessartine, OREMATS.Pyrolusite, OREMATS.Tantalite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.quartz", true, 40, 80, 60, 3, 16, true, true, true, true, MT.Quartzite, OREMATS.Barite, MT.CertusQuartz, MT.CertusQuartz);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.diamond", true, 5, 20, 40, 2, 16, true, true, true, true, MT.Graphite, MT.Graphite, MT.Diamond, MT.Coal);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.olivine", true, 10, 40, 60, 3, 16, true, true, true, true, OREMATS.Bentonite, OREMATS.Magnesite, MT.Olivine, OREMATS.Glauconite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.apatite", true, 40, 60, 60, 3, 16, false, false, false, false, MT.Apatite, MT.Apatite, MT.Phosphorus, MT.Phosphate);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.galena", true, 30, 60, 40, 5, 16, true, true, false, true, OREMATS.Galena, OREMATS.Galena, MT.Ag, MT.Pb);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.lapis", true, 20, 50, 40, 5, 16, true, true, false, true, MT.Lazurite, MT.Sodalite, MT.Lapis, MT.Calcite);
		new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.beryllium", true, 5, 30, 30, 3, 16, true, true, true, true, MT.Be, MT.Be, MT.Emerald, MT.Th);

		int i = 0;
		for (int j = CS.ConfigsGT.WORLDGEN.get("worldgen", "AmountOfCustomLargeVeinSlots", 16L); i < j; i++) {
			new GT_Worldgen_GT_Ore_Layer_Space("ore.mix.custom." + (i < 10 ? "0" : "") + i, false, 0, 0, 0, 0, 0, false, false, false, false, MT.NULL, MT.NULL, MT.NULL, MT.NULL);
		}
	}

}
