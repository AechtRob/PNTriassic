package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerTriassicDryBayou extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    public Biome COOL_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest"));
    public int COOL_FOREST_ID = Biome.getIdForBiome(COOL_FOREST);
    public Biome COOL_FOREST_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest_hills"));
    public int COOL_FOREST_HILLS_ID = Biome.getIdForBiome(COOL_FOREST_HILLS);
    public Biome COOL_FOREST_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest_crags"));
    public int COOL_FOREST_MOUNTAINS_ID = Biome.getIdForBiome(COOL_FOREST_MOUNTAINS);
    public Biome COOL_PLAIN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_plain"));
    public int COOL_PLAIN_ID = Biome.getIdForBiome(COOL_PLAIN);
    public Biome COOL_PLAIN_FLAT = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_plain_flat"));
    public int COOL_PLAIN_FLAT_ID = Biome.getIdForBiome(COOL_PLAIN_FLAT);
    public Biome COOL_FOREST_CLEARING = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest_clearing"));
    public int COOL_FOREST_CLEARING_ID = Biome.getIdForBiome(COOL_FOREST_CLEARING);

    public Biome FLOODED = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_flooded_forest"));
    public int FLOODED_ID = Biome.getIdForBiome(FLOODED);
    public Biome FLOODED_DENSE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_flooded_forest_dense"));
    public int FLOODED_DENSE_ID = Biome.getIdForBiome(FLOODED_DENSE);

    public Biome DRY_BAYOU = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:triassic_gondwanan_forest_dry_bayou"));
    public int DRY_BAYOU_ID = Biome.getIdForBiome(DRY_BAYOU);


    public GenLayerTriassicDryBayou(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {

                //Add the rivers we want:
                if (aint[i] == COOL_FOREST_ID
                        || aint[i] == COOL_FOREST_HILLS_ID
                        || aint[i] == COOL_FOREST_MOUNTAINS_ID
                        || aint[i] == FLOODED_ID
                        || aint[i] == FLOODED_DENSE_ID
                 ) {
                    aint2[i] = DRY_BAYOU_ID;
                }
                else {
                    aint2[i] = aint[i];
                }
            }
            else {
                aint2[i] = aint[i];
            }
            
        }

        return aint2;
    }

}
