package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.BiomeTriassicDesertPlateauBroken;

public class GenLayerInitRiverDeltaTriassic extends GenLayer {

    public  Biome TRIASSIC_DESERT_PLATEAU_BROKEN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_desert_plateau_broken"));
    public  int TRIASSIC_DESERT_PLATEAU_BROKEN_ID =  Biome.getIdForBiome(TRIASSIC_DESERT_PLATEAU_BROKEN);
    public  Biome TRIASSIC_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_creek"));
    public  int TRIASSIC_RIVER_ID =  Biome.getIdForBiome(TRIASSIC_RIVER);

    private final int BiomeMix[] = new int[] {
        TRIASSIC_DESERT_PLATEAU_BROKEN_ID,
        TRIASSIC_DESERT_PLATEAU_BROKEN_ID,
        TRIASSIC_DESERT_PLATEAU_BROKEN_ID,
        TRIASSIC_DESERT_PLATEAU_BROKEN_ID,
        TRIASSIC_DESERT_PLATEAU_BROKEN_ID,
        TRIASSIC_RIVER_ID
    };

    public GenLayerInitRiverDeltaTriassic(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeTriassicDesertPlateauBroken.biome)
                        output[i] = BiomeMix[nextInt(BiomeMix.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}