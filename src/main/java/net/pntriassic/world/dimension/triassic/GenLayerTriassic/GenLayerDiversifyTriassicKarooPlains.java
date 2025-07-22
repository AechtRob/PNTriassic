package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.*;

public class GenLayerDiversifyTriassicKarooPlains extends GenLayer {

    public Biome TRIASSIC_KAROO_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_forest"));
    public int TRIASSIC_KAROO_FOREST_ID =  Biome.getIdForBiome(TRIASSIC_KAROO_FOREST);
    public Biome TRIASSIC_KAROO_PLAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_plains"));
    public int TRIASSIC_KAROO_PLAINS_ID =  Biome.getIdForBiome(TRIASSIC_KAROO_PLAINS);

    private final int KarooBiomes[] = new int[] {
        TRIASSIC_KAROO_FOREST_ID,
        TRIASSIC_KAROO_PLAINS_ID,
    };

    public GenLayerDiversifyTriassicKarooPlains(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeTriassicKarooForest.biome)
                        output[i] = KarooBiomes[nextInt(KarooBiomes.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}