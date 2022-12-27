package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypeJurassic;
import net.lepidodendron.world.biome.jurassic.BiomeJurassic;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTriassicTryToJoinRiverToSea extends GenLayer
{
    public  Biome TRIASSIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach"));
    public  int TRIASSIC_BEACH_ID =  Biome.getIdForBiome(TRIASSIC_BEACH);

    public  Biome TRIASSIC_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_river"));
    public  int TRIASSIC_RIVER_ID =  Biome.getIdForBiome(TRIASSIC_RIVER);

    public  Biome TRIASSIC_SHALLOW_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_shore"));
    public  int TRIASSIC_SHALLOW_OCEAN_ID =  Biome.getIdForBiome(TRIASSIC_SHALLOW_OCEAN);

    public GenLayerTriassicTryToJoinRiverToSea(long seed, GenLayer genLayer)
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

                if (isBeach(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if ((isOcean(l1)
                            && ((isRiver(k2) && !isRiver(j3) && !isRiver(i4))
                            || (isRiver(j3) && !isRiver(k2) && !isRiver(i4))
                            || (isRiver(i4) && !isRiver(k2) && !isRiver(j3))
                        ))
                            ||
                        (isOcean(k2)
                            && ((isRiver(l1) && !isRiver(j3) && !isRiver(i4))
                            || (isRiver(j3) && !isRiver(l1) && !isRiver(i4))
                            || (isRiver(i4) && !isRiver(l1) && !isRiver(j3))
                        ))
                            ||
                        (isOcean(j3)
                            && ((isRiver(l1) && !isRiver(k2) && !isRiver(i4))
                            || (isRiver(k2) && !isRiver(l1) && !isRiver(i4))
                            || (isRiver(i4) && !isRiver(l1) && !isRiver(k2))
                        ))
                            ||
                        (isOcean(i4)
                            && ((isRiver(l1) && !isRiver(k2) && !isRiver(j3))
                            || (isRiver(k2) && !isRiver(l1) && !isRiver(j3))
                            || (isRiver(j3) && !isRiver(l1) && !isRiver(k2))
                        ))
                        )
                    {
                        aint1[j + i * areaWidth] = TRIASSIC_RIVER_ID;
                    }
                    if (isRiver(l1) ||
                            isRiver(k2) ||
                            isRiver(j3) ||
                            isRiver(i4)
                        )
                    {
                        aint1[j + i * areaWidth] = TRIASSIC_SHALLOW_OCEAN_ID;
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

    private boolean isOcean(int biomeID) {
        Biome biome = Biome.getBiome(biomeID);
        if (biome instanceof BiomeJurassic) {
            BiomeJurassic biomeJurassic = (BiomeJurassic) biome;
            if (biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Ocean
                    && biomeID != TRIASSIC_BEACH_ID) {
                return true;
            }
        }
        return false;
    }

    private boolean isBeach(int biomeID) {
        if (biomeID == TRIASSIC_BEACH_ID) {
            return true;
        }
        return false;
    }

    private boolean isRiver(int biomeID) {
        if (biomeID == TRIASSIC_RIVER_ID) {
            return true;
        }
        return false;
    }


}
