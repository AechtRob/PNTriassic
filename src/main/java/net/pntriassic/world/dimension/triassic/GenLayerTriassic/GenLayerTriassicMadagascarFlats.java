package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypeTriassic;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTriassicMadagascarFlats extends GenLayer
{

    public Biome TRIASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean"));
    public int TRIASSIC_OCEAN_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN);
    public Biome TRIASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_shore"));
    public int TRIASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN_SHORE);

    public Biome TRIASSIC_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_madagascar_flats"));
    public int TRIASSIC_FLATS_ID =  Biome.getIdForBiome(TRIASSIC_FLATS);

    public GenLayerTriassicMadagascarFlats(long seed, GenLayer genLayer)
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

                if (isOcean(k)
                        && nextInt(3) == 0
                )
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isGondwana(l1) || isGondwana(k2) || isGondwana(j3) || isGondwana(i4))
                    {
                        aint1[j + i * areaWidth] = TRIASSIC_FLATS_ID;
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
        if (biomeID == TRIASSIC_OCEAN_ID || biomeID == TRIASSIC_OCEAN_SHORE_ID
            || biomeID == TRIASSIC_FLATS_ID) {
            return true;
        }
        return false;
    }

    private boolean isGondwana(int biomeID) {
        Biome biome = Biome.getBiome(biomeID);
        if (biome instanceof BiomeTriassic) {
            return (((BiomeTriassic)biome).getBiomeType() == EnumBiomeTypeTriassic.CentralAfricaIndia
                    || ((BiomeTriassic)biome).getBiomeType() == EnumBiomeTypeTriassic.SouthAfricaMadagascar
                    || ((BiomeTriassic)biome).getBiomeType() == EnumBiomeTypeTriassic.SouthAmericaAusAnt);
        }
        return false;
    }

}
