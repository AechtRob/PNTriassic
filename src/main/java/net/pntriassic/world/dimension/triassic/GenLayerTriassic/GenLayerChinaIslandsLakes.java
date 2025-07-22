package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerChinaIslandsLakes extends GenLayer {

    public Biome TRIASSIC_CHINA_TREES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_china_trees"));
    public int TRIASSIC_CHINA_TREES_ID = Biome.getIdForBiome(TRIASSIC_CHINA_TREES);
    public Biome TRIASSIC_CHINA_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_china_swamp"));
    public int TRIASSIC_CHINA_SWAMP_ID = Biome.getIdForBiome(TRIASSIC_CHINA_SWAMP);
    public Biome RIASSIC_CHINA_LAKES = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_china_lakes"));
    public int TRIASSIC_CHINA_LAKES_ID = Biome.getIdForBiome(RIASSIC_CHINA_LAKES);

    public GenLayerChinaIslandsLakes(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight) {
        return this.getIntsOcean(areaX, areaY, areaWidth, areaHeight);
    }

    private int[] getIntsOcean(int p_151626_1_, int p_151626_2_, int p_151626_3_, int p_151626_4_) {
        int i = p_151626_1_ - 1;
        int j = p_151626_2_ - 1;
        int k = 1 + p_151626_3_ + 1;
        int l = 1 + p_151626_4_ + 1;
        int[] aint = this.parent.getInts(i, j, k, l);
        int[] aint1 = IntCache.getIntCache(p_151626_3_ * p_151626_4_);

        for (int i1 = 0; i1 < p_151626_4_; ++i1) {
            for (int j1 = 0; j1 < p_151626_3_; ++j1) {
                this.initChunkSeed((long) (j1 + p_151626_1_), (long) (i1 + p_151626_2_));
                int k1 = aint[j1 + 1 + (i1 + 1) * k];

                if (isChina(k1)) {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                            (isChina(l1))
                                    && (isChina(i2))
                                    && (isChina(j2))
                                    && (isChina(k2))
                    );
                    if (flag && nextInt(7) == 0) {
                        k1 = TRIASSIC_CHINA_LAKES_ID;
                    }
                }

                aint1[j1 + i1 * p_151626_3_] = k1;
            }
        }

        return aint1;
    }

    private boolean isChina(int biomeID) {
        if (
            biomeID == TRIASSIC_CHINA_TREES_ID
                || biomeID == TRIASSIC_CHINA_SWAMP_ID) {
            return true;
        }
        return false;
    }
}