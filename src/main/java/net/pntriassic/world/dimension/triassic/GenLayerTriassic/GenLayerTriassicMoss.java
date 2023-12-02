package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.BiomeTriassicGondwananPlainFlat;
import net.pntriassic.world.biome.triassic.BiomeTriassicWoodlandField;

public class GenLayerTriassicMoss extends GenLayer {

    public Biome TRIASSIC_MOSS_FLAT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_plain_flat"));
    public int TRIASSIC_MOSS_FLAT_ID =  Biome.getIdForBiome(TRIASSIC_MOSS_FLAT);
    public Biome TRIASSIC_MOSS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_plain"));
    public int TRIASSIC_MOSS_ID =  Biome.getIdForBiome(TRIASSIC_MOSS);

    private final int MossBiomes[] = new int[] {
            TRIASSIC_MOSS_ID,
            TRIASSIC_MOSS_FLAT_ID,
            TRIASSIC_MOSS_FLAT_ID,
            TRIASSIC_MOSS_FLAT_ID
    };

    public GenLayerTriassicMoss(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeTriassicGondwananPlainFlat.biome) {
                        output[i] = MossBiomes[nextInt(MossBiomes.length)];
                    }
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}