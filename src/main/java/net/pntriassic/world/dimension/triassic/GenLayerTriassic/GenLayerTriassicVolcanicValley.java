package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.BiomeTriassicWarmVolcanicHills;

public class GenLayerTriassicVolcanicValley extends GenLayer {

    public Biome TRIASSIC_VOLCANIC_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_warm_volcanic_hills"));
    public int TRIASSIC_VOLCANIC_HILLS_ID =  Biome.getIdForBiome(TRIASSIC_VOLCANIC_HILLS);
    public Biome TRIASSIC_VALLEY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_warm_volcanic_hills_valley"));
    public int TRIASSIC_VALLEY_ID =  Biome.getIdForBiome(TRIASSIC_VALLEY);

    private final int ValleysBiomes[] = new int[] {
            TRIASSIC_VALLEY_ID,
            TRIASSIC_VALLEY_ID,
            TRIASSIC_VALLEY_ID,
            TRIASSIC_VALLEY_ID,
            TRIASSIC_VALLEY_ID,
            TRIASSIC_VOLCANIC_HILLS_ID
    };

    public GenLayerTriassicVolcanicValley(long seed, GenLayer genlayer) {
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

        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeTriassicWarmVolcanicHills.biome) {
                        output[i] = ValleysBiomes[nextInt(ValleysBiomes.length)];
                    }
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}