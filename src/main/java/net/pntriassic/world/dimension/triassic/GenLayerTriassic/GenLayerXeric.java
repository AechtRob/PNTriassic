package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerXeric extends GenLayer {

    public Biome TRIASSIC_XERIC_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_xeric_forest"));
    public int TRIASSIC_XERIC_FOREST_ID =  Biome.getIdForBiome(TRIASSIC_XERIC_FOREST);
    public Biome TRIASSIC_XERIC_SCRUBLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_xeric_scrubland"));
    public int TRIASSIC_XERIC_SCRUBLAND_ID =  Biome.getIdForBiome(TRIASSIC_XERIC_SCRUBLAND);
    public Biome TRIASSIC_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_mountains"));
    public int TRIASSIC_MOUNTAINS_ID =  Biome.getIdForBiome(TRIASSIC_MOUNTAINS);
    public Biome TRIASSIC_XERIC_LAKE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_xeric_scrubland_lakes"));
    public int TRIASSIC_XERIC_LAKE_ID =  Biome.getIdForBiome(TRIASSIC_XERIC_LAKE);


    private final int BiomesXeric[] = new int[]{
            TRIASSIC_XERIC_FOREST_ID,
            TRIASSIC_XERIC_SCRUBLAND_ID,
            TRIASSIC_XERIC_SCRUBLAND_ID,
            TRIASSIC_XERIC_SCRUBLAND_ID,
            TRIASSIC_MOUNTAINS_ID,
            TRIASSIC_MOUNTAINS_ID,
            TRIASSIC_MOUNTAINS_ID,
            TRIASSIC_XERIC_LAKE_ID,
            TRIASSIC_XERIC_LAKE_ID,
            TRIASSIC_XERIC_LAKE_ID
    };

    public GenLayerXeric(long seed, GenLayer genlayer) {
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

                if (isXeric(k1)) {
                    int l1 = aint[j1 + 1 + (i1 + 1 - 1) * k];
                    int i2 = aint[j1 + 1 + 1 + (i1 + 1) * k];
                    int j2 = aint[j1 + 1 - 1 + (i1 + 1) * k];
                    int k2 = aint[j1 + 1 + (i1 + 1 + 1) * k];
                    boolean flag = (
                            (isXeric(l1))
                                    && (isXeric(i2))
                                    && (isXeric(j2))
                                    && (isXeric(k2))
                    );
                    if (flag) {
                        k1 = BiomesXeric[nextInt(BiomesXeric.length)];
                    }
                }

                aint1[j1 + i1 * p_151626_3_] = k1;
            }
        }

        return aint1;
    }

    private boolean isXeric(int biomeID) {
        if (
                biomeID == TRIASSIC_XERIC_FOREST_ID
                || biomeID == TRIASSIC_XERIC_SCRUBLAND_ID) {
            return true;
        }
        return false;
    }
}