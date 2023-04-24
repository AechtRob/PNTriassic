package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pntriassic.world.biome.triassic.BiomeTriassicWoodlandField;

public class GenLayerTriassicPolje extends GenLayer {

    public Biome TRIASSIC_WOODLAND = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland_field"));
    public int TRIASSIC_WOODLAND_ID =  Biome.getIdForBiome(TRIASSIC_WOODLAND);
    public Biome TRIASSIC_POLJE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_woodland_polje"));
    public int TRIASSIC_POLJE_ID =  Biome.getIdForBiome(TRIASSIC_POLJE);

    private final int WoodlandBiomes[] = new int[] {
            TRIASSIC_POLJE_ID,
            TRIASSIC_WOODLAND_ID,
            TRIASSIC_WOODLAND_ID,
            TRIASSIC_WOODLAND_ID,
            TRIASSIC_WOODLAND_ID
    };

    public GenLayerTriassicPolje(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeTriassicWoodlandField.biome) {
                        output[i] = WoodlandBiomes[nextInt(WoodlandBiomes.length)];
                    }
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}