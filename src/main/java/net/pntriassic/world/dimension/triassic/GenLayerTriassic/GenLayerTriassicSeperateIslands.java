package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypeTriassic;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTriassicSeperateIslands extends GenLayer
{

    public Biome TRIASSIC_VOLCANIC_ISLANDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_volcanic_islands"));
    public int TRIASSIC_VOLCANIC_ISLANDS_ID =  Biome.getIdForBiome(TRIASSIC_VOLCANIC_ISLANDS);

    public Biome TRIASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_shore"));
    public int TRIASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN_SHORE);
    public Biome TRIASSIC_CLAM_BEDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_clam_beds"));
    public int TRIASSIC_CLAM_BEDS_ID =  Biome.getIdForBiome(TRIASSIC_CLAM_BEDS);
    public Biome TRIASSIC_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_reef"));
    public int TRIASSIC_REEF_ID =  Biome.getIdForBiome(TRIASSIC_REEF);
    public Biome TRIASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean"));
    public int TRIASSIC_OCEAN_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN);
    public Biome TRIASSIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach"));
    public int TRIASSIC_BEACH_ID =  Biome.getIdForBiome(TRIASSIC_BEACH);
    public Biome TRIASSIC_PUMICE_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach_black"));
    public int TRIASSIC_PUMICE_BEACH_ID =  Biome.getIdForBiome(TRIASSIC_PUMICE_BEACH);
    public Biome TRIASSIC_WHITE_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach_white"));
    public int TRIASSIC_WHITE_BEACH_ID =  Biome.getIdForBiome(TRIASSIC_WHITE_BEACH);

    public GenLayerTriassicSeperateIslands(long seed, GenLayer genLayer)
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

                int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                if (k == TRIASSIC_VOLCANIC_ISLANDS_ID
                        && ((l1 != TRIASSIC_VOLCANIC_ISLANDS_ID && !isOceanOrBeach(l1))
                        || (k2 != TRIASSIC_VOLCANIC_ISLANDS_ID && !isOceanOrBeach(k2))
                        || (j3 != TRIASSIC_VOLCANIC_ISLANDS_ID && !isOceanOrBeach(j3))
                        || (i4 != TRIASSIC_VOLCANIC_ISLANDS_ID && !isOceanOrBeach(i4)))
                ){
                    aint1[j + i * areaWidth] = TRIASSIC_OCEAN_SHORE_ID;
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }

            }
        }

        return aint1;
    }

    private boolean isOceanOrBeach(int biomeID) {
        if (biomeID == TRIASSIC_OCEAN_ID || biomeID == TRIASSIC_OCEAN_SHORE_ID
                || biomeID == TRIASSIC_CLAM_BEDS_ID || biomeID == TRIASSIC_REEF_ID
                || biomeID == TRIASSIC_BEACH_ID || biomeID == TRIASSIC_PUMICE_BEACH_ID
                || biomeID == TRIASSIC_WHITE_BEACH_ID) {
            return true;
        }
        return false;
    }

}
