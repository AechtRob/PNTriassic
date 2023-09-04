
package net.pntriassic.world.biome.triassic;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeTriassic;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.lepidodendron.world.gen.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeTriassicDesertPleuromeiaBeds extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:triassic_desert_pleuromeia_beds")
	public static final BiomeGenCustom biome = null;
	public BiomeTriassicDesertPleuromeiaBeds(ElementsLepidodendronMod instance) {
		super(instance, 1589);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.DRY);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.SANDY);
	}

	static class BiomeGenCustom extends BiomeTriassic {
		public BiomeGenCustom() {
			//super(new BiomeProperties("Permian Desert").setRainfall(0.0F).setBaseHeight(0.18F).setHeightVariation(0.17F).setTemperature(2.2F).setRainDisabled().setWaterColor(10990706));
			super(new BiomeProperties("Triassic Desert Pleuromeia Beds").setRainfall(0.0F).setBaseHeight(-0.02F).setHeightVariation(0.000F).setTemperature(2.5F).setRainDisabled().setWaterColor(16767282));
			setRegistryName("lepidodendron:triassic_desert_pleuromeia_beds");
			topBlock = BlockSandRedWavy.block.getDefaultState();
			fillerBlock = Blocks.SAND.getStateFromMeta(1);
			decorator.treesPerChunk = 1;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 10;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenDicroidiumHTree DICROIDIUM_H_TREE = new WorldGenDicroidiumHTree(false);
		protected static final WorldGenWaterSideDriedMud DRIED_MUD_GENERATOR = new WorldGenWaterSideDriedMud();

		protected static final WorldGenWaterSideRedPrehistoricGround WATERSIDE_DIRT_GENERATOR = new WorldGenWaterSideRedPrehistoricGround();
		protected static final WorldGenPangeanDirt DIRT_GENERATOR = new WorldGenPangeanDirt();
		protected static final WorldGenAridHorsetail ARID_HORSETAIL_GENERATOR = new WorldGenAridHorsetail();
		protected static final WorldGenDeadBush DEAD_BUSH_GENERATOR = new WorldGenDeadBush();
		protected static final net.lepidodendron.world.gen.WorldGenDeadBush DEAD_BUSH_PF_GENERATOR = new net.lepidodendron.world.gen.WorldGenDeadBush();
		protected static final WorldGenPrehistoricGroundCoverPangaean GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverPangaean();
		protected static final WorldGenSchizoneura SCHIZONEURA_GENERATOR = new WorldGenSchizoneura();
		protected static final WorldGenLepidopteris LEPIDOPTERIS_GENERATOR = new WorldGenLepidopteris();
		protected static final WorldGenPleuromeia PLEUROMEIA_GENERATOR = new WorldGenPleuromeia();
		protected static final WorldGenIsoetes ISOETES_GENERATOR = new WorldGenIsoetes();
		//protected static final WorldGenSahnioxylon SAHNIOXYLON_GENERATOR = new WorldGenSahnioxylon();
		protected static final WorldGenPuddles PUDDLES_GENERATOR = new WorldGenPuddles();
		protected static final WorldGenBacterialCrust CRUST_GENERATOR = new WorldGenBacterialCrust();



		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
			return DICROIDIUM_H_TREE;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 92; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					WATERSIDE_DIRT_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 92; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY());
					PUDDLES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 92; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					DRIED_MUD_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 4096; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY());
					PLEUROMEIA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), true);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 10; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					CRUST_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 64; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					ARID_HORSETAIL_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					SCHIZONEURA_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), true);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 48; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					ISOETES_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			//This one is aggressive so leave til last to fill gaps:
			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 148; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					LEPIDOPTERIS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), true);
				}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				for (int i = 0; i < 1; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					DEAD_BUSH_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK)) {
				if (rand.nextInt(4) == 0) {
					for (int i = 0; i < 1; ++i) {
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
						DEAD_BUSH_PF_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), BlockDeadConifer.block.getDefaultState());
					}
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				if (rand.nextInt(4) == 0) {
					for (int i = 0; i < 1; ++i)
					{
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
						DEAD_BUSH_PF_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), BlockDeadLycopod.block.getDefaultState());
					}
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				if (rand.nextInt(4) == 0) {
					for (int i = 0; i < 1; ++i) {
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
						DEAD_BUSH_PF_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), BlockDeadPlant.block.getDefaultState());
					}
				}
			}

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
			{
				if (rand.nextInt(4) == 0) {
					for (int i = 0; i < 1; ++i) {
						int j = rand.nextInt(16) + 8;
						int k = rand.nextInt(16) + 8;
						int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
						DEAD_BUSH_PF_GENERATOR.generate(worldIn, rand, pos.add(j, l, k), BlockDeadPlantBleached.block.getDefaultState());
					}
				}
			}

	        super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeTriassic getBiomeType() {
			return EnumBiomeTypeTriassic.Desert;
		}

	}
}
