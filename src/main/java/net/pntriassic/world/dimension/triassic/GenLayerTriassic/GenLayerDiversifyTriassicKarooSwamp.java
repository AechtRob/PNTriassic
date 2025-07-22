package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDiversifyTriassicKarooSwamp extends GenLayer {

    public Biome TRIASSIC_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_forest"));
    public int TRIASSIC_FOREST_ID =  Biome.getIdForBiome(TRIASSIC_FOREST);
    public Biome TRIASSIC_PLAIN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_plains"));
    public int TRIASSIC_PLAIN_ID =  Biome.getIdForBiome(TRIASSIC_PLAIN);

    public Biome TRIASSIC_FOREST_SWAMPEDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_swamp"));
    public int TRIASSIC_FOREST_SWAMPEDGE_ID =  Biome.getIdForBiome(TRIASSIC_FOREST_SWAMPEDGE);

    public Biome TRIASSIC_FOREST_LAKE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_swamp_open"));
    public int TRIASSIC_FOREST_LAKE_ID =  Biome.getIdForBiome(TRIASSIC_FOREST_LAKE);


    private final int SwampBiomes[] = new int[] {
            TRIASSIC_FOREST_SWAMPEDGE_ID,
            TRIASSIC_FOREST_SWAMPEDGE_ID,
            TRIASSIC_FOREST_LAKE_ID
    };

    public GenLayerDiversifyTriassicKarooSwamp(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
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

                if (isForest(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isForest(l1) && isForest(k2) && isForest(j3) && isForest(i4))
                    {
                        aint1[j + i * areaWidth] = SwampBiomes[nextInt(SwampBiomes.length)];;
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

    private boolean isForest(int biomeID) {
        if (biomeID == TRIASSIC_FOREST_ID
            || biomeID == TRIASSIC_PLAIN_ID
        ) {
            return true;
        }
        return false;
    }

}