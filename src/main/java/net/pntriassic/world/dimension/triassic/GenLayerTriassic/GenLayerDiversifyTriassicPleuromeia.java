package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDiversifyTriassicPleuromeia extends GenLayer {

    public Biome TRIASSIC_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_desert_rocky"));
    public int TRIASSIC_DESERT_ID =  Biome.getIdForBiome(TRIASSIC_DESERT);
    public Biome TRIASSIC_DESERT_SAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_desert_sandy"));
    public int TRIASSIC_DESERT_SAND_ID =  Biome.getIdForBiome(TRIASSIC_DESERT_SAND);

    public Biome TRIASSIC_PLEUROMEIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_desert_pleuromeia_beds"));
    public int TRIASSIC_PLEUROMEIA_ID =  Biome.getIdForBiome(TRIASSIC_PLEUROMEIA);

     private final int DesertSandBiomes[] = new int[] {
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_DESERT_SAND_ID,
             TRIASSIC_PLEUROMEIA_ID

    };
    private final int DesertRockBiomes[] = new int[] {
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_DESERT_ID,
            TRIASSIC_PLEUROMEIA_ID
    };

    public GenLayerDiversifyTriassicPleuromeia(long seed, GenLayer genlayer) {
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

                if (isSandyDesert(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isDesert(l1) && isDesert(k2) && isDesert(j3) && isDesert(i4))
                    {
                        aint1[j + i * areaWidth] = DesertSandBiomes[nextInt(DesertSandBiomes.length)];;
                    }
                    else
                    {
                        aint1[j + i * areaWidth] = k;
                    }
                }
                else if (isRockyDesert(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isDesert(l1) && isDesert(k2) && isDesert(j3) && isDesert(i4))
                    {
                        aint1[j + i * areaWidth] = DesertRockBiomes[nextInt(DesertRockBiomes.length)];;
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

    private boolean isDesert(int biomeID) {
        if (biomeID == TRIASSIC_DESERT_ID
                || biomeID == TRIASSIC_DESERT_SAND_ID
        ) {
            return true;
        }
        return false;
    }

    private boolean isSandyDesert(int biomeID) {
        if (biomeID == TRIASSIC_DESERT_SAND_ID
        ) {
            return true;
        }
        return false;
    }

    private boolean isRockyDesert(int biomeID) {
        if (biomeID == TRIASSIC_DESERT_ID
        ) {
            return true;
        }
        return false;
    }

}