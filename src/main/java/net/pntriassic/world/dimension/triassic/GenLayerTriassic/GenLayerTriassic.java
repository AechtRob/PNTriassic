package net.pntriassic.world.dimension.triassic.GenLayerTriassic;

import net.lepidodendron.LepidodendronConfig;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.*;

public class GenLayerTriassic {

    private static boolean shouldDraw = false;
    protected GenLayer parent;

    public static GenLayer[] initializeAllBiomeGenerators(long seed, WorldType worldType, String options) {

        GenLayer biomes = new GenLayerTriassicBiomes(1L);
        biomes = new GenLayerFuzzyZoom(2000L, biomes);
        if (!LepidodendronConfig.doShrinkBiomes) {
            biomes = new GenLayerZoom(2001L, biomes);
        }
        biomes = new GenLayerDiversifyTriassic(1000L, biomes);
        biomes = new GenLayerSmooth(500L, biomes); //new
        biomes = new GenLayerTriassicCanyons(405, biomes);
        biomes = new GenLayerTriassicDelta(406, biomes);
        biomes = new GenLayerZoom(1000L, biomes);

        biomes = new GenLayerDiversifyTriassic2(1001L, biomes);
        biomes = new GenLayerDiversifyTriassicShallowOcean(1000L, biomes);
        biomes = new GenLayerSmooth(501L, biomes); //new
        biomes = new GenLayerTriassicChinleFlats(983L, biomes);
        biomes = new GenLayerTriassicEuropeOffshore(683L, biomes);
        biomes = new GenLayerZoom(1001L, biomes);

        biomes = new GenLayerTriassicChinleFlats(983L, biomes);
        biomes = new GenLayerTriassicEuropeOffshore(684L, biomes);
        biomes = new GenLayerDiversifyTriassic2(1001L, biomes);
        biomes = new GenLayerXeric(723L, biomes);
        biomes = new GenLayerSmooth(502L, biomes); //new
        biomes = new GenLayerTriassicDeepOcean(1100L, biomes);
        biomes = new GenLayerTriassicShallowOcean(1300L, biomes);
        biomes = new GenLayerTriassicEuropeOffshore2(483L, biomes);
        biomes = new GenLayerZoom(1003L, biomes);

        biomes = new GenLayerDiversifyTriassicKarooSwamp(3236L, biomes);
        biomes = new GenLayerChinaIslands(9L, biomes);
        biomes = new GenLayerTriassicEuropeOffshore2(484L, biomes);
        biomes = new GenLayerSmooth(700L, biomes);
        biomes = new GenLayerDiversifyTriassicKarooPlains(287L, biomes);
        biomes = new GenLayerSmooth(701L, biomes);
        biomes = new GenLayerDiversifyTriassic3(1975L, biomes);
        biomes = new GenLayerTriassicVolcanicValley(6875L, biomes);
        biomes = new GenLayerTriassicSeperateIslands(7856L, biomes);
        biomes = new GenLayerZoom(1004L, biomes);

        biomes = new GenLayerDiversifyTriassicKarooPlains(187L, biomes);
        biomes = new GenLayerDiversifyTriassicPleuromeia(1975L, biomes);
        biomes = new GenLayerDiversifyTriassic4(1975L, biomes);
        biomes = new GenLayerDiversifyTriassicDeltaMounds(365L, biomes);
        biomes = new GenLayerSmooth(703L, biomes);
        biomes = new GenLayerTriassicPolje(703L, biomes);
        biomes = new GenLayerTriassicVolcanicValley(5875L, biomes);
        biomes = new GenLayerTriassicMoss(1975L, biomes);
        biomes = new GenLayerDiversifyTriassicKarooSwampCopse(7L, biomes);
        biomes = new GenLayerTriassicMadagascarFlats(913L, biomes);
        biomes = new GenLayerFuzzyZoom(1000L, biomes);

        biomes = new GenLayerTriassicLakeShore(1404L, biomes);
        biomes = new GenLayerChinaIslandsLakes(92L, biomes);
        biomes = new GenLayerTriassicBeach(1050L, biomes);
        biomes = new GenLayerTriassicBlackBeach(1025L, biomes);
        biomes = new GenLayerTriassicWhiteBeach(1075L, biomes);
        biomes = new GenLayerSmooth(705L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1001L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1002L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1003L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1004L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1005L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1006L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1007L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1008L, biomes);
        biomes = new GenLayerInitRiverDeltaTriassic(1085L, biomes);
        biomes = new GenLayerFuzzyZoom(1001L, biomes);

        biomes = new GenLayerTriassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1001L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1002L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1003L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1004L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1005L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1006L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1007L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1008L, biomes);
        biomes = new GenLayerJoinRiver1Triassic(1086L, biomes);
        biomes = new GenLayerInitRiverCanyonsTriassic(1085L, biomes);
        biomes = new GenLayerInitRiverDeltaTriassic(1087L, biomes);
        biomes = new GenLayerJoinRiver1Triassic(1088L, biomes);
        biomes = new GenLayerJoinRiver2Triassic(1195L, biomes);
        biomes = new GenLayerTriassicRiverBorder(325L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1001L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1002L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1003L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1004L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1005L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1006L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1007L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1008L, biomes);
        biomes = new GenLayerSmooth(706L, biomes);
        biomes = new GenLayerRiverbanksTriassic(1095L, biomes);
        biomes = new GenLayerDiversifyRiverbankTriassic(666, biomes);
        biomes = new GenLayerTriassicPoljeEdge(666, biomes);
        biomes = new GenLayerFuzzyZoom(1002L, biomes);

        biomes = new GenLayerTriassicRiverBorder(326L, biomes);
        biomes = new GenLayerSmooth(719L, biomes); //ADDED THIS
        biomes = new GenLayerRiverbankWidenTriassic(1095L, biomes);
        biomes = new GenLayerRiverbankWidenTriassic(1096L, biomes);
        biomes = new GenLayerRiverbankWidenTriassic(1097L, biomes);
        biomes = new GenLayerDiversifyRiverbankTriassic(667, biomes);
        biomes = new GenLayerRiverbankRemoveCanyonsTriassic(1001L, biomes);
        biomes = new GenLayerZoom(1006L, biomes);

        biomes = new GenLayerTriassicTryToJoinRiverToSea(1000L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1001L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1002L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1003L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1004L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1005L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1006L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1007L, biomes);
        biomes = new GenLayerTriassicTryToJoinRiverToSea(1008L, biomes);

        //Build and superimpose creeks:
        GenLayer genlayercreek = new GenLayerRiverInit(100L, biomes);
        GenLayer genlayercreek2 = GenLayerZoom.magnify(1000L, genlayercreek, 2);
        GenLayer genlayercreek3 = GenLayerZoom.magnify(1000L, genlayercreek2, 2);
        GenLayer genlayercreek4 = GenLayerZoom.magnify(1000L, genlayercreek3, 2);
        GenLayer genlayercreek5 = GenLayerZoom.magnify(1000L, genlayercreek4, 1);
        GenLayer genlayercreek6 = new GenLayerRiver(1L, genlayercreek5);
        GenLayer genlayercreek7 = new GenLayerSmooth(1000L, genlayercreek6);
        GenLayer genlayercreekfinal = new GenLayerTriassicRiverMix(100L, biomes, genlayercreek7);
        
        //Additional features:
        GenLayer genlayerdeltacreek = new GenLayerRiverInit(200L, biomes);
        GenLayer genlayerdeltacreek2 = GenLayerZoom.magnify(2000L, genlayerdeltacreek, 2);
        GenLayer genlayerdeltacreek3 = GenLayerZoom.magnify(2000L, genlayerdeltacreek2, 2);
        GenLayer genlayerdeltacreek4 = GenLayerZoom.magnify(2000L, genlayerdeltacreek3, 2);
        GenLayer genlayerdeltacreek5 = new GenLayerRiver(2L, genlayerdeltacreek4);
        GenLayer genlayerdeltacreek6 = new GenLayerSmooth(2000L, genlayerdeltacreek5);
        GenLayer genlayerdeltacreekfinal = new GenLayerTriassicRiverMixDeltaSpecial(200L, genlayercreekfinal, genlayerdeltacreek6);

        GenLayer genlayerdeltacreekB = new GenLayerRiverInit(300L, biomes);
        GenLayer genlayerdeltacreekB2 = GenLayerZoom.magnify(3000L, genlayerdeltacreekB, 2);
        GenLayer genlayerdeltacreekB3 = GenLayerZoom.magnify(3000L, genlayerdeltacreekB2, 2);
        GenLayer genlayerdeltacreekB4 = GenLayerZoom.magnify(3000L, genlayerdeltacreekB3, 2);
        GenLayer genlayerdeltacreekB5 = new GenLayerRiver(3L, genlayerdeltacreekB4);
        GenLayer genlayerdeltacreekB6 = new GenLayerSmooth(3000L, genlayerdeltacreekB5);
        GenLayer genlayerdeltacreekBfinal = new GenLayerTriassicRiverMixDeltaSpecial(300L, genlayerdeltacreekfinal, genlayerdeltacreekB6);


        GenLayer genlayerbayou = new GenLayerRiverInit(120L, biomes);
        genlayerbayou = new GenLayerRiverInit(140L, genlayerbayou);
        GenLayer genlayerbayou2 = GenLayerZoom.magnify(1201L, genlayerbayou, 2);
        GenLayer genlayerbayou3 = GenLayerZoom.magnify(1201L, genlayerbayou2, 1);
        GenLayer genlayerbayou4 = GenLayerZoom.magnify(1001L, genlayerbayou3, 1);
        GenLayer genlayerbayou5 = new GenLayerRiver(12L, genlayerbayou4);
        GenLayer genlayerbayou6 = new GenLayerSmooth(1200L, genlayerbayou5);
        genlayerbayou6 = new GenLayerZoom(1676L, genlayerbayou6);
        genlayerbayou6 = new GenLayerZoom(1677L, genlayerbayou6);
        genlayerbayou6 = new GenLayerZoom(1678L, genlayerbayou6);
        genlayerbayou6 = new GenLayerZoom(1680L, genlayerbayou6);
        genlayerbayou6 = new GenLayerSmooth(1681L, genlayerbayou6);
        GenLayer genlayerbayoufinal = new GenLayerTriassicDryBayou(1200L, genlayerdeltacreekBfinal, genlayerbayou6);

        GenLayer genlayer2bayou = new GenLayerRiverInit(130L, biomes);
        genlayer2bayou = new GenLayerRiverInit(150L, genlayer2bayou);
        GenLayer genlayer2bayou2 = GenLayerZoom.magnify(1202L, genlayer2bayou, 2);
        GenLayer genlayer2bayou3 = GenLayerZoom.magnify(1202L, genlayer2bayou2, 1);
        GenLayer genlayer2bayou4 = GenLayerZoom.magnify(1002L, genlayer2bayou3, 1);
        GenLayer genlayer2bayou5 = new GenLayerRiver(12L, genlayer2bayou4);
        GenLayer genlayer2bayou6 = new GenLayerSmooth(1200L, genlayer2bayou5);
        genlayer2bayou6 = new GenLayerZoom(1676L, genlayer2bayou6);
        genlayer2bayou6 = new GenLayerZoom(1677L, genlayer2bayou6);
        genlayer2bayou6 = new GenLayerZoom(1678L, genlayer2bayou6);
        genlayer2bayou6 = new GenLayerZoom(1680L, genlayer2bayou6);
        genlayer2bayou6 = new GenLayerSmooth(1681L, genlayer2bayou6);
        GenLayer genlayer2bayoufinal = new GenLayerTriassicDryBayou(1201L, genlayerbayoufinal, genlayer2bayou6);

        GenLayer genlayer3bayou = new GenLayerRiverInit(5430L, biomes);
        genlayer3bayou = new GenLayerRiverInit(5431, genlayer3bayou);
        GenLayer genlayer3bayou2 = GenLayerZoom.magnify(1203L, genlayer3bayou, 2);
        GenLayer genlayer3bayou3 = GenLayerZoom.magnify(1203L, genlayer3bayou2, 1);
        GenLayer genlayer3bayou4 = GenLayerZoom.magnify(1003L, genlayer3bayou3, 1);
        GenLayer genlayer3bayou5 = new GenLayerRiver(12L, genlayer3bayou4);
        GenLayer genlayer3bayou6 = new GenLayerSmooth(1200L, genlayer3bayou5);
        genlayer3bayou6 = new GenLayerZoom(1676L, genlayer3bayou6);
        genlayer3bayou6 = new GenLayerZoom(1677L, genlayer3bayou6);
        genlayer3bayou6 = new GenLayerZoom(1678L, genlayer3bayou6);
        genlayer3bayou6 = new GenLayerZoom(1680L, genlayer3bayou6);
        genlayer3bayou6 = new GenLayerSmooth(1681L, genlayer3bayou6);
        GenLayer genlayer3bayoufinal = new GenLayerTriassicDryBayou(1202L, genlayer2bayoufinal, genlayer3bayou6);

        GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, genlayer3bayoufinal);

        genlayer3bayoufinal.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        biomes.initWorldGenSeed(seed);

        biomes.initWorldGenSeed(seed);
        genlayervoronoizoom.initWorldGenSeed(seed);
        return (new GenLayer[] { genlayer3bayoufinal, genlayervoronoizoom, genlayer3bayoufinal });
    }

}