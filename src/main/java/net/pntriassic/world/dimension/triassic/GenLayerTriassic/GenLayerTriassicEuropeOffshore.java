package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypeTriassic;
import net.lepidodendron.world.biome.triassic.BiomeTriassic;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.*;

public class GenLayerTriassicEuropeOffshore extends GenLayer
{

    public Biome TRIASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean"));
    public int TRIASSIC_OCEAN_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN);
    public Biome TRIASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_shore"));
    public int TRIASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN_SHORE);

    public Biome TRIASSIC_DESERT_DELTA_FLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_delta_flats"));
    public int TRIASSIC_DESERT_DELTA_FLATS_ID =  Biome.getIdForBiome(TRIASSIC_DESERT_DELTA_FLATS);

    public Biome TRIASSIC_ISLANDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_volcanic_islands"));
    public int TRIASSIC_ISLANDS_ID =  Biome.getIdForBiome(TRIASSIC_ISLANDS);

    public Biome TRIASSIC_ESTUARY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_estuary"));
    public int TRIASSIC_ESTUARY_ID =  Biome.getIdForBiome(TRIASSIC_ESTUARY);

    public GenLayerTriassicEuropeOffshore(long seed, GenLayer genLayer)
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

                if (isOcean(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isEuropeForDelta(l1) || isEuropeForDelta(k2) || isEuropeForDelta(j3) || isEuropeForDelta(i4))
                    {
                        aint1[j + i * areaWidth] = TRIASSIC_DESERT_DELTA_FLATS_ID;
                    }
                    else if (isEuropeForIslands(l1) || isEuropeForIslands(k2) || isEuropeForIslands(j3) || isEuropeForIslands(i4))
                    {
                        aint1[j + i * areaWidth] = TRIASSIC_ISLANDS_ID;
                    }
                    else if (isItalyForEstuary(l1) || isItalyForEstuary(k2) || isItalyForEstuary(j3) || isItalyForEstuary(i4))
                    {
                        aint1[j + i * areaWidth] = TRIASSIC_ESTUARY_ID;
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
        if (biomeID == TRIASSIC_OCEAN_ID || biomeID == TRIASSIC_OCEAN_SHORE_ID) {
            return true;
        }
        return false;
    }

    private boolean isEuropeForDelta(int biomeID) {
        Biome biome = Biome.getBiome(biomeID);
        return biome == BiomeTriassicWarmVolcanicHills.biome
                || biome == BiomeTriassicWarmVolcanicHillsValley.biome;
    }

    private boolean isEuropeForIslands(int biomeID) {
        Biome biome = Biome.getBiome(biomeID);
        return biome == BiomeTriassicLossiemouth.biome
                || biome == BiomeTriassicDesertPleuromeiaBeds.biome;
    }

    private boolean isItalyForEstuary(int biomeID) {
        Biome biome = Biome.getBiome(biomeID);
        return biome == BiomeTriassicWarmLakeland.biome;
    }

}
