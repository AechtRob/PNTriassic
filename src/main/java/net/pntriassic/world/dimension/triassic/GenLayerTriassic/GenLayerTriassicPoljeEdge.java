package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTriassicPoljeEdge extends GenLayer
{

    public Biome TRIASSIC_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_river"));
    public int TRIASSIC_RIVER_ID =  Biome.getIdForBiome(TRIASSIC_RIVER);

    public Biome TRIASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_shore"));
    public int TRIASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN_SHORE);
    public Biome TRIASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean"));
    public int TRIASSIC_OCEAN_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN);
    public Biome TRIASSIC_BEACH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach"));
    public int TRIASSIC_BEACH_ID =  Biome.getIdForBiome(TRIASSIC_BEACH);
    public Biome TRIASSIC_BEACH_BLACK = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach_black"));
    public int TRIASSIC_BEACH_BLACK_ID =  Biome.getIdForBiome(TRIASSIC_BEACH_BLACK);
    public Biome TRIASSIC_BEACH_WHITE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_beach_white"));
    public int TRIASSIC_BEACH_WHITE_ID =  Biome.getIdForBiome(TRIASSIC_BEACH_WHITE);

    public Biome TRIASSIC_POLJE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland_polje"));
    public int TRIASSIC_POLJE_ID =  Biome.getIdForBiome(TRIASSIC_POLJE);
    public Biome TRIASSIC_POLJE_EDGE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland_polje_edge"));
    public int TRIASSIC_POLJE_EDGE_ID =  Biome.getIdForBiome(TRIASSIC_POLJE_EDGE);

    public Biome TRIASSIC_OCEAN_CLAM = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_clam_beds"));
    public int TRIASSIC_OCEAN_CLAM_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN_CLAM);
    public Biome TRIASSIC_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_reef"));
    public int TRIASSIC_REEF_ID =  Biome.getIdForBiome(TRIASSIC_REEF);

    public GenLayerTriassicPoljeEdge(long seed, GenLayer genLayer)
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

                if (!isAlreadyWater(k))
                {
                    int l1 = aint[j + 1 + (i + 1 - 1) * (areaWidth + 2)];
                    int k2 = aint[j + 1 + 1 + (i + 1) * (areaWidth + 2)];
                    int j3 = aint[j + 1 - 1 + (i + 1) * (areaWidth + 2)];
                    int i4 = aint[j + 1 + (i + 1 + 1) * (areaWidth + 2)];

                    if (isLake(l1) || isLake(k2) || isLake(j3) || isLake(i4))
                    {
                        aint1[j + i * areaWidth] = TRIASSIC_POLJE_EDGE_ID;
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

    private boolean isAlreadyWater(int biomeID) {
        if (biomeID == TRIASSIC_OCEAN_ID || biomeID == TRIASSIC_OCEAN_SHORE_ID
                || biomeID == TRIASSIC_BEACH_ID || biomeID == TRIASSIC_BEACH_BLACK_ID
                || biomeID == TRIASSIC_POLJE_ID || biomeID == TRIASSIC_POLJE_EDGE_ID
                || biomeID == TRIASSIC_RIVER_ID || biomeID == TRIASSIC_OCEAN_CLAM_ID
                || biomeID == TRIASSIC_REEF_ID || biomeID == TRIASSIC_BEACH_WHITE_ID) {
            return true;
        }
        return false;
    }

    private boolean isLake(int biomeID) {
        if (biomeID == TRIASSIC_POLJE_ID || biomeID == TRIASSIC_POLJE_EDGE_ID) {
            return true;
        }
        return false;
    }

}
