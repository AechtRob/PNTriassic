package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypeTriassic;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.*;

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
    public Biome TRIASSIC_CREEK_LAKELAND_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_warm_volcanic_hills"));
    public int TRIASSIC_CREEK_LAKELAND_HILLS_ID = Biome.getIdForBiome(TRIASSIC_CREEK_LAKELAND_HILLS);
    public Biome TRIASSIC_CREEK_LAKELAND_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_warm_volcanic_hills_valley"));
    public int TRIASSIC_CREEK_LAKELAND_SWAMP_ID = Biome.getIdForBiome(TRIASSIC_CREEK_LAKELAND_SWAMP);
    public Biome TRIASSIC_CREEK_XERIC = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_xeric"));
    public int TRIASSIC_CREEK_XERIC_ID = Biome.getIdForBiome(TRIASSIC_CREEK_XERIC);
    public Biome TRIASSIC_CREEK_WOODLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_woodland"));
    public int TRIASSIC_CREEK_WOODLAND_ID = Biome.getIdForBiome(TRIASSIC_CREEK_WOODLAND);
    public Biome TRIASSIC_CREEK_WOODLAND_FIELD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_woodland_field"));
    public int TRIASSIC_CREEK_WOODLAND_FIELD_ID = Biome.getIdForBiome(TRIASSIC_CREEK_WOODLAND_FIELD);
    public Biome TRIASSIC_CREEK_GONDWANA_MOSSY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_gondwanan_plain"));
    public int TRIASSIC_CREEK_GONDWANA_MOSSY_ID = Biome.getIdForBiome(TRIASSIC_CREEK_GONDWANA_MOSSY);
    public Biome TRIASSIC_CREEK_DELTA_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_delta_flats"));
    public int TRIASSIC_CREEK_DELTA_FLATS_ID = Biome.getIdForBiome(TRIASSIC_CREEK_DELTA_FLATS);
    public Biome TRIASSIC_CREEK_CHINLE_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_chinle_flats"));
    public int TRIASSIC_CREEK_CHINLE_FLATS_ID = Biome.getIdForBiome(TRIASSIC_CREEK_CHINLE_FLATS);
    public Biome TRIASSIC_CREEK_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_estuary"));
    public int TRIASSIC_CREEK_ESTUARY_ID = Biome.getIdForBiome(TRIASSIC_CREEK_ESTUARY);
    public Biome TRIASSIC_CREEK_SOUTHERN_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_karoo_forest"));
    public int TRIASSIC_CREEK_SOUTHERN_FOREST_ID = Biome.getIdForBiome(TRIASSIC_CREEK_SOUTHERN_FOREST);
    public Biome TRIASSIC_CREEK_SOUTHERN_PLAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_karoo_plains"));
    public int TRIASSIC_CREEK_SOUTHERN_PLAINS_ID = Biome.getIdForBiome(TRIASSIC_CREEK_SOUTHERN_PLAINS);
    public Biome TRIASSIC_CREEK_SOUTHERN_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_karoo_swamp"));
    public int TRIASSIC_CREEK_SOUTHERN_SWAMP_ID = Biome.getIdForBiome(TRIASSIC_CREEK_SOUTHERN_SWAMP);
    public Biome TRIASSIC_LOSSIEMOUTH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek_lossiemouth"));
    public int TRIASSIC_LOSSIEMOUTH_ID = Biome.getIdForBiome(TRIASSIC_LOSSIEMOUTH);

    public Biome TRIASSIC_MOSSY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_plain"));
    public int TRIASSIC_MOSSY_ID = Biome.getIdForBiome(TRIASSIC_MOSSY);
    public Biome TRIASSIC_MOSSY_FLAT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_plain_flat"));
    public int TRIASSIC_MOSSY_FLAT_ID = Biome.getIdForBiome(TRIASSIC_MOSSY_FLAT);

    public Biome TRIASSIC_FLOODED = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_flooded_forest"));
    public int TRIASSIC_FLOODED_ID = Biome.getIdForBiome(TRIASSIC_FLOODED);
    public Biome TRIASSIC_FLOODED_DENSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_flooded_forest_dense"));
    public int TRIASSIC_FLOODED_DENSE_ID = Biome.getIdForBiome(TRIASSIC_FLOODED_DENSE);

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
    public Biome TRIASSIC_WHITE_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach_white"));
    public int TRIASSIC_WHITE_BEACH_ID = Biome.getIdForBiome(TRIASSIC_WHITE_BEACH);
    public Biome TRIASSIC_POLJE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland_polje"));
    public int TRIASSIC_POLJE_ID =  Biome.getIdForBiome(TRIASSIC_POLJE);
    public Biome TRIASSIC_POLJE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland_polje_edge"));
    public int TRIASSIC_POLJE_EDGE_ID =  Biome.getIdForBiome(TRIASSIC_POLJE_EDGE);
    public Biome TRIASSIC_DELTA_MOUND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_delta_flats_mound"));
    public int TRIASSIC_DELTA_MOUND_ID =  Biome.getIdForBiome(TRIASSIC_DELTA_MOUND);
    public Biome TRIASSIC_CHINA_TREES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_china_trees"));
    public int TRIASSIC_CHINA_TREES_ID = Biome.getIdForBiome(TRIASSIC_CHINA_TREES);
    public Biome TRIASSIC_CHINA_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_china_swamp"));
    public int TRIASSIC_CHINA_SWAMP_ID = Biome.getIdForBiome(TRIASSIC_CHINA_SWAMP);
    public Biome RIASSIC_CHINA_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_china_lakes"));
    public int TRIASSIC_CHINA_LAKES_ID = Biome.getIdForBiome(RIASSIC_CHINA_LAKES);

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
                        || aint[i] == TRIASSIC_WHITE_BEACH_ID
                        || aint[i] == TRIASSIC_POLJE_ID
                        || aint[i] == TRIASSIC_POLJE_EDGE_ID
                        || aint[i] == TRIASSIC_DELTA_MOUND_ID
                        || aint[i] == TRIASSIC_CHINA_SWAMP_ID
                        || aint[i] == TRIASSIC_CHINA_TREES_ID
                        || aint[i] == TRIASSIC_CHINA_LAKES_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    Biome biome = Biome.getBiome(aint[i]);
                    if (biome instanceof BiomeTriassic) {
                        BiomeTriassic biomeTriassic = (BiomeTriassic) biome;
                        if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Desert) {
                            aint2[i] = TRIASSIC_CREEK_DESERT_ID;
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.SouthAmericaAusAnt) {
                            if (aint[i] == TRIASSIC_MOSSY_ID || aint[i] == TRIASSIC_MOSSY_FLAT_ID) {
                                aint2[i] = TRIASSIC_CREEK_GONDWANA_MOSSY_ID;
                            }
                            else if (aint[i] == TRIASSIC_FLOODED_ID || aint[i] == TRIASSIC_FLOODED_DENSE_ID) {
                                aint2[i] = TRIASSIC_CREEK_FLOODED_ID;
                            }
                            else {
                                aint2[i] = TRIASSIC_CREEK_GONDWANA_ID;
                            }
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Europe) {
                            if (biome == BiomeTriassicWarmVolcanicHills.biome) {
                                aint2[i] = TRIASSIC_CREEK_LAKELAND_HILLS_ID;
                            }
                            if (biome == BiomeTriassicWarmVolcanicHillsValley.biome) {
                                aint2[i] = TRIASSIC_CREEK_LAKELAND_SWAMP_ID;
                            }
                            if (biome == BiomeTriassicLossiemouth.biome) {
                                aint2[i] = TRIASSIC_LOSSIEMOUTH_ID;
                            }
                            if (biome == BiomeTriassicDeltaFlats.biome) {
                                aint2[i] = TRIASSIC_CREEK_DELTA_FLATS_ID;
                            }
                            if (biome == BiomeTriassicEstuary.biome) {
                                aint2[i] = TRIASSIC_CREEK_ESTUARY_ID;
                            }
                            else {
                                aint2[i] = TRIASSIC_CREEK_LAKELAND_ID;
                            }
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.CentralAfricaIndia) {
                            aint2[i] = TRIASSIC_CREEK_XERIC_ID;
                        }
                        else if (biome == BiomeTriassicRiverbank.biome
                                || biome == BiomeTriassicRiverbankForest.biome
                                || biome == BiomeTriassicCreek.biome) {
                            aint2[i] = TRIASSIC_CREEK_ID;
                        }
                        else if (biome == BiomeTriassicChinleFlats.biome) {
                            aint2[i] = TRIASSIC_CREEK_CHINLE_FLATS_ID;
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.Ocean) {
                            aint2[i] = TRIASSIC_CREEK_COASTAL_ID;
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.USAGreenland) {
                            if (biome == BiomeTriassicWoodlandField.biome) {
                                aint2[i] = TRIASSIC_CREEK_WOODLAND_FIELD_ID;
                            }
                            else {
                                aint2[i] = TRIASSIC_CREEK_WOODLAND_ID;
                            }
                        }
                        else if (biomeTriassic.getBiomeType() == EnumBiomeTypeTriassic.SouthAfricaMadagascar) {
                            if (biome == BiomeTriassicKarooPlains.biome) {
                                aint2[i] = TRIASSIC_CREEK_SOUTHERN_PLAINS_ID;
                            }
                            if (biome == BiomeTriassicKarooForest.biome) {
                                aint2[i] = TRIASSIC_CREEK_SOUTHERN_FOREST_ID;
                            }
                            else {
                                aint2[i] = TRIASSIC_CREEK_SOUTHERN_SWAMP_ID;
                            }
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
