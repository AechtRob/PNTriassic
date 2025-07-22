package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerDiversifyTriassicPleuromeia extends GenLayer {

    public Biome TRIASSIC_SANDY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_lossiemouth"));
    public int TRIASSIC_SANDY_ID =  Biome.getIdForBiome(TRIASSIC_SANDY);

    public Biome TRIASSIC_PLEUROMEIA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_desert_pleuromeia_beds"));
    public int TRIASSIC_PLEUROMEIA_ID =  Biome.getIdForBiome(TRIASSIC_PLEUROMEIA);

     private final int DesertSandBiomes[] = new int[] {
             TRIASSIC_SANDY_ID,
             TRIASSIC_SANDY_ID,
             TRIASSIC_SANDY_ID,
             TRIASSIC_SANDY_ID,
             TRIASSIC_SANDY_ID,
             TRIASSIC_SANDY_ID,
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

                if (isSandy(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isSandy(l1) && isSandy(k2) && isSandy(j3) && isSandy(i4))
                    {
                        aint1[j + i * areaWidth] = DesertSandBiomes[nextInt(DesertSandBiomes.length)];;
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

    private boolean isSandy(int biomeID) {
        if (biomeID == TRIASSIC_SANDY_ID
        ) {
            return true;
        }
        return false;
    }

}