package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTriassicLakeShore extends GenLayer
{

    public Biome JURASSIC_LAKE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest_clearing_lake"));
    public int JURASSIC_LAKE_ID =  Biome.getIdForBiome(JURASSIC_LAKE);
    public Biome JURASSIC_LAKE_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest_clearing"));
    public int JURASSIC_LAKE_SHORE_ID =  Biome.getIdForBiome(JURASSIC_LAKE_SHORE);


    public GenLayerTriassicLakeShore(long seed, GenLayer genLayer)
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
                this.initChunkSeed(j + areaX, i + areaY);
                int k = aint[j + 1 + (i + 1) * (areaWidth + 2)];

                if (!isLake(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isLakePure(l1) || isLakePure(k2) || isLakePure(j3) || isLakePure(i4))
                    {
                        aint1[j + i * areaWidth] = JURASSIC_LAKE_SHORE_ID;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else
                {
                    aint1[j + i * areaWidth] = k;
                }
            }
        }

        return aint1;
    }

    private boolean isLake(int biomeID) {
        return biomeID == JURASSIC_LAKE_ID || biomeID == JURASSIC_LAKE_SHORE_ID;
    }


    private boolean isLakePure(int biomeID) {
        return biomeID == JURASSIC_LAKE_ID;
    }

}
