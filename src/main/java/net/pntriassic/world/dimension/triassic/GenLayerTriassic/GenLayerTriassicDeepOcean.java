package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTriassicDeepOcean extends GenLayer
{

    public Biome TRIASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean"));
    public  int TRIASSIC_OCEAN_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN);
    public  Biome TRIASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_shore"));
    public  int TRIASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN_SHORE);
    
    public GenLayerTriassicDeepOcean(long seed, GenLayer genLayer)
    {
        super(seed);
        this.parent = genLayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        return this.getIntsOcean(areaX, areaY, areaWidth, areaHeight);
    }

    private int[] getIntsOcean(int p_151626_1_, int p_151626_2_, int p_151626_3_, int p_151626_4_)
    {
        int i = p_151626_1_ - 1;
        int j = p_151626_2_ - 1;
        int k = 1 + p_151626_3_ + 1;
        int l = 1 + p_151626_4_ + 1;
        int[] aint = this.parent.getInts(i, j, k, l);
        int[] aint1 = IntCache.getIntCache(p_151626_3_ * p_151626_4_);

        for (int i1 = 0; i1 < p_151626_4_; ++i1)
        {
            for (int j1 = 0; j1 < p_151626_3_; ++j1)
            {
                this.initChunkSeed((long)(j1 + p_151626_1_), (long)(i1 + p_151626_2_));
                int k1 = aint[j1 + 1 + (i1 + 1) * k];

                if (k1 == TRIASSIC_OCEAN_SHORE_ID)
                {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                        (
                        (l1 == TRIASSIC_OCEAN_ID || l1 == TRIASSIC_OCEAN_SHORE_ID)
                        && (i2 == TRIASSIC_OCEAN_ID || i2 == TRIASSIC_OCEAN_SHORE_ID)
                        && (j2 == TRIASSIC_OCEAN_ID || j2 == TRIASSIC_OCEAN_SHORE_ID)
                        && (k2 == TRIASSIC_OCEAN_ID || k2 == TRIASSIC_OCEAN_SHORE_ID)
                        )
                        //|| (l1 == TRIASSIC_MOUNTAINS_ID
                        //    || i2 == TRIASSIC_MOUNTAINS_ID
                        //    || j2 == TRIASSIC_MOUNTAINS_ID
                        //    || k2 == TRIASSIC_MOUNTAINS_ID
                        //)
                    );
                    if (flag)
                    {
                        k1 = TRIASSIC_OCEAN_ID;
                    }
                }

                aint1[j1 + i1 * p_151626_3_] = k1;
            }
        }

        return aint1;
    }
    
}
