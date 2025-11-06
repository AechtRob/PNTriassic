
package net.pntriassic.world.biome.triassic;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeTriassic;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.lepidodendron.world.gen.*;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeTriassicCreekFloodedForest extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:triassic_creek_flooded_forest")
	public static final BiomeGenCustom biome = null;
	public BiomeTriassicCreekFloodedForest(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SWAMP);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.JUNGLE);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.LUSH);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.HOT);
	}

	static class BiomeGenCustom extends BiomeTriassic {
		public BiomeGenCustom() {
			super(new BiomeProperties("Triassic Southern Flooded Forest Creek").setRainfall(0.5F).setBaseHeight(-0.525F).setHeightVariation(0.0F).setTemperature(2.00F).setRainfall(1.5F).setWaterColor(3906905));
			setRegistryName("lepidodendron:triassic_creek_flooded_forest");
			topBlock = BlockPrehistoricGroundLush.block.getDefaultState();
			fillerBlock = Blocks.DIRT.getStateFromMeta(1);
			decorator.treesPerChunk = 7;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 20;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			decorator.clayPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int getFoliageColorAtPos(BlockPos pos)
		{
			return -15424749;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int getGrassColorAtPos(BlockPos pos)
		{
			return -15424749;
		}

		@Override
		public int getModdedBiomeGrassColor(int original)
		{
			return -15424749;
		}

		@Override
		public int getModdedBiomeFoliageColor(int original)
		{
			return -15424749;
		}

		protected static final WorldGenPodozamitesTreeWaterDeep PODOZAMITES_TREE = new WorldGenPodozamitesTreeWaterDeep(false);
		protected static final WorldGenTelemachusTreeWaterDeep TELEMACHUS_TREE = new WorldGenTelemachusTreeWaterDeep(false);
		protected static final WorldGenAraucarioxylonTreeWaterDeep ARAUCARIOXYLON_TREE = new WorldGenAraucarioxylonTreeWaterDeep(false);
		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);
		protected static final WorldGenDicroidiumOTree DICROIDIUM_O_TREE = new WorldGenDicroidiumOTree(false);
		protected static final WorldGenBrachyphyllumTree BRACHYPHYLLUM_TREE = new WorldGenBrachyphyllumTree(false);

		protected static final WorldGenTreeRottenLog ROTTEN_LOG_GENERATOR = new WorldGenTreeRottenLog();
		protected static final WorldGenTreeLog TELEMACHUS_LOG_GENERATOR = new WorldGenTreeLog(BlockTelemachusLog.block);
		protected static final WorldGenTreeLogWater TELEMACHUS_LOG_WATER_GENERATOR = new WorldGenTreeLogWater(BlockTelemachusLog.block);
		protected static final WorldGenSlimyAlgae SLIMY_GENERATOR = new WorldGenSlimyAlgae();

		protected static final WorldGenAnomozamites ANOMOZAMITES_GENERATOR = new WorldGenAnomozamites();
		protected static final WorldGenDicroidiumE DICROIDIUM_E_GENERATOR = new WorldGenDicroidiumE();
		protected static final WorldGenPleuromeia PLEUROMEIA_GENERATOR = new WorldGenPleuromeia();
		protected static final WorldGenPhoenicopsis PHOENICOPSIS_GENERATOR = new WorldGenPhoenicopsis();
		protected static final WorldGenCtenis CTENIS_GENERATOR = new WorldGenCtenis();
		protected static final WorldGenStiffCycad CYCAD_GENERATOR = new WorldGenStiffCycad();
		protected static final WorldGenCzekanowskia CZEKANOWSKIA_GENERATOR = new WorldGenCzekanowskia();
		protected static final WorldGenPterophyllum PTEROPHYLLUM_GENERATOR = new WorldGenPterophyllum();
		protected static final WorldGenNilssonia NILSSONIA_GENERATOR = new WorldGenNilssonia();

		protected static final WorldGenWaterHorsetail WATER_HORSETAIL_GENERATOR = new WorldGenWaterHorsetail();
		protected static final WorldGenSelaginella SELAGINELLA_GENERATOR = new WorldGenSelaginella();
		protected static final WorldGenSwampHorsetail SWAMP_HORSETAIL_GENERATOR = new WorldGenSwampHorsetail();
		protected static final WorldGenEquisetites EQUISETITES_GENERATOR = new WorldGenEquisetites();


		protected static final WorldGenAncientMoss ANCIENT_MOSS_GENERATOR = new WorldGenAncientMoss();
		protected static final WorldGenAncientMossGround ANCIENT_MOSS_GROUND_GENERATOR = new WorldGenAncientMossGround();
		protected static final WorldGenFern FERN_GENERATOR = new WorldGenFern();
		public static final PropertyEnum<BlockDoublePlant.EnumPlantType> VARIANT = PropertyEnum.<BlockDoublePlant.EnumPlantType>create("variant", BlockDoublePlant.EnumPlantType.class);
		protected static final WorldGenLeafblock LEAFBLOCK_GENERATOR = new WorldGenLeafblock();


		protected static final WorldGenPrehistoricGroundCoverLush GROUNDCOVER_LUSH_GENERATOR = new WorldGenPrehistoricGroundCoverLush();
		protected static final WorldGenPrehistoricGroundCover GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCover();
		protected static final WorldGenWaterSideRedPrehistoricGround WATERSIDE_DIRT_GENERATOR = new WorldGenWaterSideRedPrehistoricGround();
		protected static final WorldGenWaterSideLushPrehistoricGround WATERSIDE_LUSH_GENERATOR = new WorldGenWaterSideLushPrehistoricGround();
		protected static final WorldGenWatersideMud WATERSIDE_MUD_GENERATOR = new WorldGenWatersideMud();
		protected static final WorldGenSand PANGAEAN_SAND_GENERATOR = new WorldGenSand(BlockSandPangaean.block, 7);
		protected static final WorldGenPuddles PUDDLES_GENERATOR = new WorldGenPuddles();
		protected static final WorldGenPodzol PODZOL_GENERATOR = new WorldGenPodzol();
		protected static final WorldGenPangeanDirt DIRT_GENERATOR = new WorldGenPangeanDirt();
		protected static final WorldGenMossStone MOSSY_STONE_GENERATOR = new WorldGenMossStone();
		protected static final WorldGenMud MUD_GENERATOR = new WorldGenMud();
		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();
		protected static final WorldGenSingleStaticInWaterUpwards STATIC_GENERATOR = new WorldGenSingleStaticInWaterUpwards();
		protected static final WorldGenSingleStaticInWaterRotational STATIC_ROTATIONAL_GENERATOR = new WorldGenSingleStaticInWaterRotational();
		protected static final WorldGenSingleStaticInWaterSideways STATIC_SIDEWAYS_GENERATOR = new WorldGenSingleStaticInWaterSideways();
		protected static final WorldGenSingleStaticInWaterColumn STATIC_COLUMN_GENERATOR = new WorldGenSingleStaticInWaterColumn();
		protected static final WorldGenSingleAnemoneSea ANEMONE_GENERATOR = new WorldGenSingleAnemoneSea();
		protected static final WorldGenSingleSponge SPONGE_GENERATOR = new WorldGenSingleSponge();
		protected static final WorldGenSingleSpongeSideways SPONGE_SIDEWAYS_GENERATOR = new WorldGenSingleSpongeSideways();
		protected static final WorldGenSingleFenestella FENESTELLA_GENERATOR = new WorldGenSingleFenestella();
		protected static final WorldGenSingleFenestellaSideways FENESTELLA_SIDEWAYS_GENERATOR = new WorldGenSingleFenestellaSideways();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
		{
			if (rand.nextInt(15) == 0) {
				return PODOZAMITES_TREE;
			}
			if (rand.nextInt(64) == 0)  {
				return ARAUCARIOXYLON_TREE;
			}
			if (rand.nextInt(10) == 0)  {
				return DICROIDIUM_O_TREE;
			}
			if (rand.nextInt(8) == 0)  {
				return BRACHYPHYLLUM_TREE;
			}
			if (rand.nextInt(3) != 0)  {
				return NULL_TREE;
			}
			return TELEMACHUS_TREE;
		}

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos)
		{

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 38; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					WATERSIDE_LUSH_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

//            if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//                for (int i = 0; i < 48; ++i)
//                {
//                    int j = rand.nextInt(16) + 8;
//                    int k = rand.nextInt(16) + 8;
//                    int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//                    PUDDLES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//                }

//            if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//                for (int i = 0; i < 18; ++i)
//                {
//                    int j = rand.nextInt(16) + 8;
//                    int k = rand.nextInt(16) + 8;
//                    int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//                    MUD_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), true);
//                }

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {
				int i = rand.nextInt(6);

				for (int j = 0; j < i; ++j) {
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					if (Math.random() > 0.5) {
						ROTTEN_LOG_GENERATOR.generate(worldIn, rand, blockpos);
					}
				}

				i = rand.nextInt(6);

				for (int j = 0; j < i; ++j) {
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					if (Math.random() > 0.5) {
						TELEMACHUS_LOG_GENERATOR.generate(worldIn, rand, blockpos);
					}
				}

			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS)) {

				int i = rand.nextInt(5);

				for (int j = 0; j < i; ++j)
				{
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(16) + 8;
					BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
					TELEMACHUS_LOG_WATER_GENERATOR.generate(worldIn, rand, blockpos);
				}
			}

//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 3; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					ANOMOZAMITES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 60, 255);
//				}
//
//			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
//				for (int i = 0; i < 4; ++i)
//				{
//					int j = rand.nextInt(16) + 8;
//					int k = rand.nextInt(16) + 8;
//					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
//					PTEROPHYLLUM_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
//				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 3; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					NILSSONIA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 4; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					CTENIS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			DOUBLE_PLANT_GENERATOR.setPlantType(BlockDoublePlant.EnumPlantType.FERN);
			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i1 = 0; i1 < 25; ++i1)
				{
					int j1 = rand.nextInt(16) + 8;
					int k1 = rand.nextInt(16) + 8;
					int l1 = rand.nextInt(worldIn.getHeight(pos.add(j1, 0, k1)).getY() + 32);
					DOUBLE_PLANT_GENERATOR.generate(worldIn, rand, pos.add(j1, l1, k1));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 38; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					FERN_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 128; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					WATERSIDE_MUD_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 3; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					CZEKANOWSKIA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), true);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 22; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockLepidopteris.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 56; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockWoodHorsetail.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 14; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockMarattia.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 46; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockCladophlebis.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 1; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockBaiera.block.getDefaultState(), worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 8; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					DICROIDIUM_E_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), 60, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 156; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 5; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					EQUISETITES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), false);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 80; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					WATER_HORSETAIL_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 28; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					SWAMP_HORSETAIL_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 80; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					SLIMY_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}


			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeTriassic getBiomeType() {
			return EnumBiomeTypeTriassic.SouthAmericaAusAnt;
		}

	}
}
