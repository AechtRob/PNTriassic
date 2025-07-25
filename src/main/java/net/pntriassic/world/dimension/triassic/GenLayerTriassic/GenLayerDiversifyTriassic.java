package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.*;

public class GenLayerDiversifyTriassic extends GenLayer {

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
//    public Biome TRIASSIC_XERIC_SCRUBLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_xeric_scrubland"));
//    public int TRIASSIC_XERIC_SCRUBLAND_ID =  Biome.getIdForBiome(TRIASSIC_XERIC_SCRUBLAND);
    public Biome TRIASSIC_WARM_LAKELAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_warm_lakeland"));
    public int TRIASSIC_WARM_LAKELAND_ID =  Biome.getIdForBiome(TRIASSIC_WARM_LAKELAND);
    public Biome TRIASSIC_WARM_VOLCANIC_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_warm_volcanic_hills"));
    public int TRIASSIC_WARM_VOLCANIC_HILLS_ID =  Biome.getIdForBiome(TRIASSIC_WARM_VOLCANIC_HILLS);
    public Biome TRIASSIC_GONDWANAN_PLAIN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_plain_flat"));
    public int TRIASSIC_GONDWANAN_PLAIN_ID =  Biome.getIdForBiome(TRIASSIC_GONDWANAN_PLAIN);
    public Biome TRIASSIC_FLOODED_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_flooded_forest"));
    public int TRIASSIC_FLOODED_FOREST_ID =  Biome.getIdForBiome(TRIASSIC_FLOODED_FOREST);
    public Biome TRIASSIC_LOSSIEMOUTH = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_lossiemouth"));
    public int TRIASSIC_LOSSIEMOUTH_ID =  Biome.getIdForBiome(TRIASSIC_LOSSIEMOUTH);
    public Biome TRIASSIC_WOODLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland"));
    public int TRIASSIC_WOODLAND_ID =  Biome.getIdForBiome(TRIASSIC_WOODLAND);
    public Biome TRIASSIC_WOODLAND_FIELDS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland_field"));
    public int TRIASSIC_WOODLAND_FIELDS_ID =  Biome.getIdForBiome(TRIASSIC_WOODLAND_FIELDS);

    public Biome TRIASSIC_SOUTHERN_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_swamp"));
    public int TRIASSIC_SOUTHERN_SWAMP_ID =  Biome.getIdForBiome(TRIASSIC_SOUTHERN_SWAMP);
    public Biome TRIASSIC_SOUTHERN_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_forest"));
    public int TRIASSIC_SOUTHERN_FOREST_ID =  Biome.getIdForBiome(TRIASSIC_SOUTHERN_FOREST);

    private final int GondwanaBiomes[] = new int[] {
        TRIASSIC_GONDWANAN_FOREST_ID,
        TRIASSIC_GONDWANAN_PLAIN_ID,
        TRIASSIC_FLOODED_FOREST_ID,
            TRIASSIC_SOUTHERN_FOREST_ID,
            TRIASSIC_XERIC_FOREST_ID
    };

     private final int DesertBiomes[] = new int[] {
        TRIASSIC_DESERT_ID,
        TRIASSIC_DESERT_ID,
        TRIASSIC_DESERT_SAND_ID,
        TRIASSIC_DESERT_PLATEAU_ID,
        TRIASSIC_DESERT_PLATEAU_ID
    };

//    private final int XericBiomes[] = new int[] {
//        TRIASSIC_XERIC_FOREST_ID,
//        TRIASSIC_XERIC_SCRUBLAND_ID,
//        TRIASSIC_SOUTHERN_FOREST_ID,
//        TRIASSIC_SOUTHERN_FOREST_ID
//    };

    private final int EurasiaBiomes[] = new int[] {
        TRIASSIC_WARM_LAKELAND_ID,
        TRIASSIC_LOSSIEMOUTH_ID
    };

    private final int WoodlandBiomes[] = new int[] {
        TRIASSIC_WOODLAND_ID,
        TRIASSIC_WOODLAND_ID,
        TRIASSIC_WOODLAND_FIELDS_ID
    };

//    private final int SwampBiomes[] = new int[] {
//        TRIASSIC_FLOODED_FOREST_ID,
//        TRIASSIC_FLOODED_FOREST_ID,
//        TRIASSIC_FLOODED_FOREST_ID,
//        TRIASSIC_FLOODED_FOREST_ID,
//        TRIASSIC_MOUNTAINS_ID,
//        TRIASSIC_MOUNTAINS_ID,
//        TRIASSIC_MOUNTAINS_ID
//    };

    public GenLayerDiversifyTriassic(long seed, GenLayer genlayer) {
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
                        output[i] = GondwanaBiomes[nextInt(GondwanaBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeTriassicDesertRocky.biome)
                        output[i] = DesertBiomes[nextInt(DesertBiomes.length)];
//                    else if (Biome.getBiome(center) == BiomeTriassicXericForest.biome)
//                        output[i] = XericBiomes[nextInt(XericBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeTriassicWarmLakeland.biome)
                        output[i] = EurasiaBiomes[nextInt(EurasiaBiomes.length)];
//                    else if (Biome.getBiome(center) == BiomeTriassicFloodedForest.biome)
//                        output[i] = SwampBiomes[nextInt(SwampBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeTriassicWoodland.biome)
                        output[i] = WoodlandBiomes[nextInt(WoodlandBiomes.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}