
package net.pntriassic.world.biome.triassic;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockAridHorsetail;
import net.lepidodendron.block.BlockSandWhite;
import net.lepidodendron.block.BlockSandWhiteWavy;
import net.lepidodendron.util.EnumBiomeTypeTriassic;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.lepidodendron.world.gen.*;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeTriassicOceanClamBeds extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:triassic_ocean_clam_beds")
	public static final BiomeGenCustom biome = null;
	public BiomeTriassicOceanClamBeds(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WATER);
	}

	static class BiomeGenCustom extends BiomeTriassic {
		public BiomeGenCustom() {
			super(new BiomeProperties("Triassic Clam Beds").setRainfall(0.5F).setBaseHeight(-0.425F).setHeightVariation(0.00F));
			setRegistryName("lepidodendron:triassic_ocean_clam_beds");

			topBlock = BlockSandWhiteWavy.block.getDefaultState();
			fillerBlock = Blocks.SAND.getStateFromMeta(1);
			decorator.treesPerChunk = -999;
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

		protected static final WorldGenCordaites CORDAITES = new WorldGenCordaites(false);
		protected static final WorldGenPrehistoricGroundCoverSandy SANDY_GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverSandy();
		protected static final WorldGenPrehistoricGroundCoverPangaean PANGAEAN_GROUNDCOVER_GENERATOR = new WorldGenPrehistoricGroundCoverPangaean();
		protected static final WorldGenSinglePlantOptionalWater PLANT_GENERATOR = new WorldGenSinglePlantOptionalWater();

		private final WorldGenClamRocks CLAM_ROCKS = new WorldGenClamRocks();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	    	return CORDAITES;
	    }

		//public Biome.TempCategory getTempCategory()
	    //{
	    //    return Biome.TempCategory.OCEAN;
	   // }

		@Override
		public void decorate(World worldIn, Random rand, BlockPos pos)
		{

			if (net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ICE))
				for (int i = 0; i < 3; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					if (rand.nextInt(3) == 0) {
						this.CLAM_ROCKS.generate(worldIn, rand, worldIn.getHeight(pos.add(j, 0, k)));
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PLANT_GENERATOR.generate(BlockAridHorsetail.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 0, 255, true);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 11; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					PANGAEAN_GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 11; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					SANDY_GROUNDCOVER_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			super.decorate(worldIn, rand, pos);
		}

		@Override
		public EnumBiomeTypeTriassic getBiomeType() {
			return EnumBiomeTypeTriassic.Ocean;
		}

	}
}
