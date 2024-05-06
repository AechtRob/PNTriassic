package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypeJurassic;
import net.lepidodendron.util.EnumBiomeTypeTriassic;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.BiomeTriassicBlackBeach;
import net.pntriassic.world.biome.triassic.BiomeTriassicCreek;
import net.pntriassic.world.biome.triassic.BiomeTriassicRiverbank;
import net.pntriassic.world.biome.triassic.BiomeTriassicRiverbankForest;

public class GenLayerTriassicRiverMix extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    public Biome TRIASSIC_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_river"));
    public int TRIASSIC_RIVER_ID = Biome.getIdForBiome(TRIASSIC_RIVER);

    //Creeks to use:
    public Biome TRIASSIC_CREEK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek"));
    public int TRIASSIC_CREEK_ID = Biome.getIdForBiome(TRIASSIC_CREEK);
    public Biome TRIASSIC_CREEK_COASTAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_coastal"));
    public int TRIASSIC_CREEK_COASTAL_ID = Biome.getIdForBiome(TRIASSIC_CREEK_COASTAL);
    public Biome TRIASSIC_CREEK_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_desert"));
    public int TRIASSIC_CREEK_DESERT_ID = Biome.getIdForBiome(TRIASSIC_CREEK_DESERT);
    public Biome TRIASSIC_CREEK_FLOODED = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_flooded_forest"));
    public int TRIASSIC_CREEK_FLOODED_ID = Biome.getIdForBiome(TRIASSIC_CREEK_FLOODED);
    public Biome TRIASSIC_CREEK_GONDWANA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_gondwanan_forest"));
    public int TRIASSIC_CREEK_GONDWANA_ID = Biome.getIdForBiome(TRIASSIC_CREEK_GONDWANA);
    public Biome TRIASSIC_CREEK_LAKELAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_warm_lakeland"));
    public int TRIASSIC_CREEK_LAKELAND_ID = Biome.getIdForBiome(TRIASSIC_CREEK_LAKELAND);
    public Biome TRIASSIC_CREEK_XERIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_xeric"));
    public int TRIASSIC_CREEK_XERIC_ID = Biome.getIdForBiome(TRIASSIC_CREEK_XERIC);
    public Biome TRIASSIC_CREEK_WOODLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_woodland"));
    public int TRIASSIC_CREEK_WOODLAND_ID = Biome.getIdForBiome(TRIASSIC_CREEK_WOODLAND);

    //Biomes to exclude for rivers:
    public Biome TRIASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_shore"));
    public int TRIASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN_SHORE);
    public Biome TRIASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean"));
    public int TRIASSIC_OCEAN_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN);
    public Biome TRIASSIC_CLAM = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_clam_beds"));
    public int TRIASSIC_CLAM_ID =  Biome.getIdForBiome(TRIASSIC_CLAM);
    public Biome TRIASSIC_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_reef"));
    public int TRIASSIC_REEF_ID =  Biome.getIdForBiome(TRIASSIC_REEF);
    public Biome TRIASSIC_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_mountains"));
    public int TRIASSIC_MOUNTAINS_ID =  Biome.getIdForBiome(TRIASSIC_MOUNTAINS);
    public Biome TRIASSIC_VOLCANIC_ISLANDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_volcanic_islands"));
    public int TRIASSIC_VOLCANIC_ISLANDS_ID = Biome.getIdForBiome(TRIASSIC_VOLCANIC_ISLANDS);
    public Biome TRIASSIC_VOLCANIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach_black"));
    public int TRIASSIC_VOLCANIC_BEACH_ID = Biome.getIdForBiome(TRIASSIC_VOLCANIC_BEACH);
    public Biome TRIASSIC_POLJE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland_polje"));
    public int TRIASSIC_POLJE_ID =  Biome.getIdForBiome(TRIASSIC_POLJE);
    public Biome TRIASSIC_POLJE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland_polje_edge"));
    public int TRIASSIC_POLJE_EDGE_ID =  Biome.getIdForBiome(TRIASSIC_POLJE_EDGE);

    public GenLayerTriassicRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
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
                //Exclude rivers here:
                if (aint[i] == TRIASSIC_OCEAN_SHORE_ID
                        || aint[i] == TRIASSIC_OCEAN_ID
                        || aint[i] == TRIASSIC_CLAM_ID
                        || aint[i] == TRIASSIC_REEF_ID
                        || aint[i] == TRIASSIC_MOUNTAINS_ID
                        || aint[i] == TRIASSIC_VOLCANIC_ISLANDS_ID
                        || aint[i] == TRIASSIC_VOLCANIC_BEACH_ID
                        || aint[i] == TRIASSIC_POLJE_ID
                        || aint[i] == TRIASSIC_POLJE_EDGE_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    Biome biome = Biome.getBiome(aint[i]);
                    if (biome instanceof BiomeTriassic) {
                        BiomeTriassic biomeTriassic = (BiomeTriassic) biome;
                        if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Swamp) {
                            aint2[i] = TRIASSIC_CREEK_FLOODED_ID;
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Desert) {
                            aint2[i] = TRIASSIC_CREEK_DESERT_ID;
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Cool) {
                            aint2[i] = TRIASSIC_CREEK_GONDWANA_ID;
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Warm) {
                            aint2[i] = TRIASSIC_CREEK_LAKELAND_ID;
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Xeric) {
                            aint2[i] = TRIASSIC_CREEK_XERIC_ID;
                        }
                        else if (biome == BiomeTriassicRiverbank.biome
                                || biome == BiomeTriassicRiverbankForest.biome
                                || biome == BiomeTriassicCreek.biome) {
                            aint2[i] = TRIASSIC_CREEK_ID;
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Ocean) {
                            aint2[i] = TRIASSIC_CREEK_COASTAL_ID;
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Woodland) {
                            aint2[i] = TRIASSIC_CREEK_WOODLAND_ID;
                        }
                        else {
                            aint2[i] = TRIASSIC_RIVER_ID;
                        }
                    }
                    else {
                        aint2[i] = TRIASSIC_RIVER_ID;
                    }
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
