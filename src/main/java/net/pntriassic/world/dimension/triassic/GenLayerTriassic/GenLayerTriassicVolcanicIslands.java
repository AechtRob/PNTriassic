package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTriassicVolcanicIslands extends GenLayer
{

    public Biome TRIASSIC_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_reef"));
    public int TRIASSIC_REEF_ID =  Biome.getIdForBiome(TRIASSIC_REEF);
    public Biome TRIASSIC_VOLCANIC_ISLANDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_volcanic_islands"));
    public int TRIASSIC_VOLCANIC_ISLANDS_ID =  Biome.getIdForBiome(TRIASSIC_VOLCANIC_ISLANDS);

    public GenLayerTriassicVolcanicIslands(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    private final int IslandBiomes[] = new int[] {
            TRIASSIC_VOLCANIC_ISLANDS_ID,
            TRIASSIC_VOLCANIC_ISLANDS_ID,
            TRIASSIC_VOLCANIC_ISLANDS_ID,
            TRIASSIC_VOLCANIC_ISLANDS_ID,
            TRIASSIC_REEF_ID
    };

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

                //if (!hasNoBeach(k))
                //{
                    if (k == TRIASSIC_REEF_ID)
                    {
                        int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                        int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                        int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                        int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                        if (l1 == TRIASSIC_REEF_ID
                            && k2== TRIASSIC_REEF_ID
                            && j3== TRIASSIC_REEF_ID
                            && i4== TRIASSIC_REEF_ID
                        )
                        {
                            aint1[j + i * areaWidth] = IslandBiomes[nextInt(IslandBiomes.length)];
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

}
