package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.*;

public class GenLayerDiversifyTriassic2 extends GenLayer {

    public Biome TRIASSIC_GONDWANAN_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest"));
    public int TRIASSIC_GONDWANAN_FOREST_ID =  Biome.getIdForBiome(TRIASSIC_GONDWANAN_FOREST);
    public Biome TRIASSIC_GONDWANAN_FOREST_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest_hills"));
    public int TRIASSIC_GONDWANAN_FOREST_HILLS_ID =  Biome.getIdForBiome(TRIASSIC_GONDWANAN_FOREST_HILLS);
    public Biome TRIASSIC_GONDWANAN_FOREST_CRAGS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest_crags"));
    public int TRIASSIC_GONDWANAN_FOREST_CRAGS_ID =  Biome.getIdForBiome(TRIASSIC_GONDWANAN_FOREST_CRAGS);
    public Biome TRIASSIC_DESERT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_desert_rocky"));
    public int TRIASSIC_DESERT_ID =  Biome.getIdForBiome(TRIASSIC_DESERT);
    public Biome TRIASSIC_DESERT_SAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_desert_sandy"));
    public int TRIASSIC_DESERT_SAND_ID =  Biome.getIdForBiome(TRIASSIC_DESERT_SAND);
    public Biome TRIASSIC_DESERT_PLATEAU = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_desert_plateau"));
    public int TRIASSIC_DESERT_PLATEAU_ID =  Biome.getIdForBiome(TRIASSIC_DESERT_PLATEAU);
    public Biome TRIASSIC_XERIC_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_xeric_forest"));
    public int TRIASSIC_XERIC_FOREST_ID =  Biome.getIdForBiome(TRIASSIC_XERIC_FOREST);
    public Biome TRIASSIC_XERIC_SCRUBLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_xeric_scrubland"));
    public int TRIASSIC_XERIC_SCRUBLAND_ID =  Biome.getIdForBiome(TRIASSIC_XERIC_SCRUBLAND);
    public Biome TRIASSIC_WARM_LAKELAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_warm_lakeland"));
    public int TRIASSIC_WARM_LAKELAND_ID =  Biome.getIdForBiome(TRIASSIC_WARM_LAKELAND);
    public Biome TRIASSIC_WARM_VOLCANIC_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_warm_volcanic_hills"));
    public int TRIASSIC_WARM_VOLCANIC_HILLS_ID =  Biome.getIdForBiome(TRIASSIC_WARM_VOLCANIC_HILLS);
    public Biome TRIASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_ocean_shore"));
    public int TRIASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(TRIASSIC_OCEAN_SHORE);

    public Biome TRIASSIC_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_mountains"));
    public int TRIASSIC_MOUNTAINS_ID =  Biome.getIdForBiome(TRIASSIC_MOUNTAINS);


    private final int GondwanaBiomesAustroAntarctic[] = new int[] {
        TRIASSIC_GONDWANAN_FOREST_ID,
        TRIASSIC_GONDWANAN_FOREST_ID,
        TRIASSIC_GONDWANAN_FOREST_HILLS_ID,
        TRIASSIC_GONDWANAN_FOREST_HILLS_ID,
        TRIASSIC_GONDWANAN_FOREST_CRAGS_ID
    };

    //This Forest gets its Auatralian clearings added later (GenLayerDiversifyTriassic4)
    //The Moss meadow gets its hills added later (GenLayerTriassicMoss))
    //The Flooded Forest (Brazil) gets its variation added later (GenLayerDiversifyTriassic3))

     private final int DesertBiomes[] = new int[] {
        TRIASSIC_DESERT_ID,
        TRIASSIC_DESERT_ID,
        TRIASSIC_DESERT_SAND_ID,
        TRIASSIC_DESERT_PLATEAU_ID,
        TRIASSIC_DESERT_PLATEAU_ID
    };

    private final int XericBiomes[] = new int[] {
        TRIASSIC_XERIC_FOREST_ID,
        TRIASSIC_XERIC_SCRUBLAND_ID,
        TRIASSIC_MOUNTAINS_ID
    };

    private final int WarmBiomes[] = new int[] {
        TRIASSIC_WARM_LAKELAND_ID,
        TRIASSIC_WARM_LAKELAND_ID,
        TRIASSIC_WARM_VOLCANIC_HILLS_ID
    };

    private final int OceanBiomes[] = new int[] {
        TRIASSIC_OCEAN_SHORE_ID,
        TRIASSIC_OCEAN_SHORE_ID,
        TRIASSIC_OCEAN_SHORE_ID,
        TRIASSIC_OCEAN_SHORE_ID,
        TRIASSIC_OCEAN_SHORE_ID,
        TRIASSIC_OCEAN_SHORE_ID
    };

    public GenLayerDiversifyTriassic2(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int input[] = this.parent.getInts(x, z, width, height);
        int output[] = IntCache.getIntCache(width * height);
        EnumBiomeTypePermian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeTriassicGondwananForest.biome)
                        output[i] = GondwanaBiomesAustroAntarctic[nextInt(GondwanaBiomesAustroAntarctic.length)];

                    else if (Biome.getBiome(center) == BiomeTriassicDesertRocky.biome)
                        output[i] = DesertBiomes[nextInt(DesertBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeTriassicXericForest.biome)
                        output[i] = XericBiomes[nextInt(XericBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeTriassicWarmLakeland.biome)
                        output[i] = WarmBiomes[nextInt(WarmBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeTriassicOceanShore.biome)
                        output[i] = OceanBiomes[nextInt(OceanBiomes.length)];

                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}