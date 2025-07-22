package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypeTriassic;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.BiomeTriassicCreek;
import net.pntriassic.world.biome.triassic.BiomeTriassicDeltaFlats;
import net.pntriassic.world.biome.triassic.BiomeTriassicRiverbank;
import net.pntriassic.world.biome.triassic.BiomeTriassicRiverbankForest;

public class GenLayerTriassicRiverMixDeltaSpecial extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    //Creeks to use:
    public Biome TRIASSIC_CREEK_DELTA_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_delta_flats"));
    public int TRIASSIC_CREEK_DELTA_FLATS_ID = Biome.getIdForBiome(TRIASSIC_CREEK_DELTA_FLATS);
    public Biome TRIASSIC_DELTA_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_delta_flats"));
    public int TRIASSIC_DELTA_FLATS_ID = Biome.getIdForBiome(TRIASSIC_DELTA_FLATS);

    public Biome TRIASSIC_CREEK_CHINLE_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_chinle_flats"));
    public int TRIASSIC_CREEK_CHINLE_FLATS_ID = Biome.getIdForBiome(TRIASSIC_CREEK_CHINLE_FLATS);
    public Biome TRIASSIC_CHINLE_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_chinle_flats"));
    public int TRIASSIC_CHINLE_FLATS_ID = Biome.getIdForBiome(TRIASSIC_CHINLE_FLATS);

    public Biome TRIASSIC_CREEK_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_estuary"));
    public int TRIASSIC_CREEK_ESTUARY_ID = Biome.getIdForBiome(TRIASSIC_CREEK_ESTUARY);
    public Biome TRIASSIC_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_estuary"));
    public int TRIASSIC_ESTUARY_ID = Biome.getIdForBiome(TRIASSIC_ESTUARY);

    public GenLayerTriassicRiverMixDeltaSpecial(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {
                if (aint[i] == TRIASSIC_DELTA_FLATS_ID
                )
                {
                    aint2[i] = TRIASSIC_CREEK_DELTA_FLATS_ID;
                }
                else if (aint[i] == TRIASSIC_CHINLE_FLATS_ID
                )
                {
                    aint2[i] = TRIASSIC_CREEK_CHINLE_FLATS_ID;
                }
                else if (aint[i] == TRIASSIC_ESTUARY_ID
                )
                {
                    aint2[i] = TRIASSIC_CREEK_ESTUARY_ID;
                }
                else {
                    aint2[i] = aint[i];
                }
            }
            else
            {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }
}
