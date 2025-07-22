package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTriassicWhiteBeach extends GenLayer
{

    public Biome TRIASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean"));
    public int TRIASSIC_OCEAN_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN);
    public Biome TRIASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_shore"));
    public int TRIASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN_SHORE);
    public Biome TRIASSIC_CLAM_BEDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_clam_beds"));
    public int TRIASSIC_CLAM_BEDS_ID =  Biome.getIdForBiome(TRIASSIC_CLAM_BEDS);
    public Biome TRIASSIC_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_reef"));
    public int TRIASSIC_REEF_ID =  Biome.getIdForBiome(TRIASSIC_REEF);

    public Biome TRIASSIC_CHINA_TREES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_china_trees"));
    public int TRIASSIC_CHINA_TREES_ID = Biome.getIdForBiome(TRIASSIC_CHINA_TREES);
    public Biome TRIASSIC_CHINA_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_china_swamp"));
    public int TRIASSIC_CHINA_SWAMP_ID = Biome.getIdForBiome(TRIASSIC_CHINA_SWAMP);
    public Biome RIASSIC_CHINA_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_china_lakes"));
    public int TRIASSIC_CHINA_LAKES_ID = Biome.getIdForBiome(RIASSIC_CHINA_LAKES);

    public Biome TRIASSIC_BEACH_WHITE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach_white"));
    public int TRIASSIC_BEACH_WHITE_ID =  Biome.getIdForBiome(TRIASSIC_BEACH_WHITE);

    public GenLayerTriassicWhiteBeach(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.parent.getInts(areaX - 1, areaY - 1, areaWidth + 2, areaHeight + 2);
        int[] aint1 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaHeight; ++i)
        {
            for (int j = 0; j < areaWidth; ++j)
            {
                this.initChunkSeed((long)(j + areaX), (long)(i + areaY));
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];
                //Biome biome = Biome.getBiome(k);

                if (isOcean(k))
                {
                    //if (!isOcean(k))
                    //{
                        int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                        int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                        int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                        int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                        if (isIsland(l1) || isIsland(k2) || isIsland(j3) || isIsland(i4))
                        {
                            aint1[j + i * areaWidth] = aint1[j + i * areaWidth] = TRIASSIC_BEACH_WHITE_ID;;
                        }
                        else
                        {
                            aint1[j + i * areaWidth] = k;
                        }
                    //}
                    //else
                    //{
                    //    aint1[j + i * areaWidth] = k;
                   //}
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isOcean(int biomeID) {
        if (biomeID == TRIASSIC_OCEAN_ID 
                || biomeID == TRIASSIC_OCEAN_SHORE_ID 
                || biomeID == TRIASSIC_CLAM_BEDS_ID
                || biomeID == TRIASSIC_REEF_ID) {
            return true;
        }
        return false;
    }

    private boolean isIsland(int biomeID) {
        if (biomeID == TRIASSIC_CHINA_TREES_ID
                || biomeID == TRIASSIC_CHINA_SWAMP_ID
                || biomeID == TRIASSIC_CHINA_LAKES_ID) {
            return true;
        }
        return false;
    }

}
