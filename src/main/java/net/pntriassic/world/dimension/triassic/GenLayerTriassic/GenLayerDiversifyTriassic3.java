package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.BiomeTriassicFloodedForest;
import net.pntriassic.world.biome.triassic.BiomeTriassicWarmLakeland;

public class GenLayerDiversifyTriassic3 extends GenLayer {

    public Biome TRIASSIC_FLOODED_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_flooded_forest"));
    public int TRIASSIC_FLOODED_FOREST_ID =  Biome.getIdForBiome(TRIASSIC_FLOODED_FOREST);

    public Biome TRIASSIC_FLOODED_FOREST_DENSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_flooded_forest_dense"));
    public int TRIASSIC_FLOODED_FOREST_DENSE_ID =  Biome.getIdForBiome(TRIASSIC_FLOODED_FOREST_DENSE);

    public Biome TRIASSIC_WARM_LAKELAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_warm_lakeland"));
    public int TRIASSIC_WARM_LAKELAND_ID =  Biome.getIdForBiome(TRIASSIC_WARM_LAKELAND);
    public Biome TRIASSIC_HORSETAILS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_horsetails"));
    public int TRIASSIC_HORSETAILS_ID =  Biome.getIdForBiome(TRIASSIC_HORSETAILS);


    private final int SwampBiomes[] = new int[] {
            TRIASSIC_FLOODED_FOREST_ID,
            TRIASSIC_FLOODED_FOREST_ID,
            TRIASSIC_FLOODED_FOREST_ID,
            TRIASSIC_FLOODED_FOREST_ID,
            TRIASSIC_FLOODED_FOREST_ID,
            TRIASSIC_FLOODED_FOREST_DENSE_ID,
            TRIASSIC_FLOODED_FOREST_DENSE_ID
    };

    private final int LakelandBiomes[] = new int[] {
            TRIASSIC_WARM_LAKELAND_ID,
            TRIASSIC_WARM_LAKELAND_ID,
            TRIASSIC_WARM_LAKELAND_ID,
            TRIASSIC_WARM_LAKELAND_ID,
            TRIASSIC_WARM_LAKELAND_ID,
            TRIASSIC_HORSETAILS_ID,
            TRIASSIC_HORSETAILS_ID
    };

    public GenLayerDiversifyTriassic3(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeTriassicFloodedForest.biome)
                        output[i] = SwampBiomes[nextInt(SwampBiomes.length)];
                    if (Biome.getBiome(center) == BiomeTriassicWarmLakeland.biome)
                        output[i] = LakelandBiomes[nextInt(LakelandBiomes.length)];

                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}