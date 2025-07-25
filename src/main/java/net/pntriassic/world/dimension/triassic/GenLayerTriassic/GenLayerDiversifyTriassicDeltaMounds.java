package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.BiomeTriassicDeltaFlats;

public class GenLayerDiversifyTriassicDeltaMounds extends GenLayer {

    public Biome TRIASSIC_DELTA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_delta_flats"));
    public int TRIASSIC_DELTA_ID =  Biome.getIdForBiome(TRIASSIC_DELTA);

    public Biome TRIASSIC_DELTA_MOUND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_delta_flats_mound"));
    public int TRIASSIC_DELTA_MOUND_ID =  Biome.getIdForBiome(TRIASSIC_DELTA_MOUND);


    private final int DeltalBiomes[] = new int[] {
            TRIASSIC_DELTA_ID,
            TRIASSIC_DELTA_ID,
            TRIASSIC_DELTA_MOUND_ID,
    };

    public GenLayerDiversifyTriassicDeltaMounds(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeTriassicDeltaFlats.biome)
                        output[i] = DeltalBiomes[nextInt(DeltalBiomes.length)];

                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}