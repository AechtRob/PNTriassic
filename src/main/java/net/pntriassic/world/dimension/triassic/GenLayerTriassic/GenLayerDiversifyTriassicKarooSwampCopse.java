package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.BiomeTriassicKarooSwampOpen;

public class GenLayerDiversifyTriassicKarooSwampCopse extends GenLayer {

    public Biome TRIASSIC_OPEN_SWAMP = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_swamp_open"));
    public int TRIASSIC_OPEN_SWAMP_ID =  Biome.getIdForBiome(TRIASSIC_OPEN_SWAMP);

    public Biome TRIASSIC_COPSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_karoo_swamp_copse"));
    public int TRIASSIC_COPSE_ID =  Biome.getIdForBiome(TRIASSIC_COPSE);

    private final int SwampBiomes[] = new int[] {
            TRIASSIC_OPEN_SWAMP_ID,
            TRIASSIC_OPEN_SWAMP_ID,
            TRIASSIC_COPSE_ID
    };

    public GenLayerDiversifyTriassicKarooSwampCopse(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeTriassicKarooSwampOpen.biome)
                        output[i] = SwampBiomes[nextInt(SwampBiomes.length)];

                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}