package clases;

/**
 * Created by SaNcOs on 26.06.2016.
 */
public class AI_X0 {
   int[] toSet=new int[2];
    int whyrebyAIIsPlaying;

    public AI_X0(int whyrebyAIIsPlaying) {
        this.whyrebyAIIsPlaying = whyrebyAIIsPlaying;
    }

    public int[] WhatSetIJ(int[][] map){

        for(int i=0;i<=1;i++) toSet = strategy1(map);
        toSet[2] = whyrebyAIIsPlaying;
        return toSet;
    }
    private int[] strategy1(int[][] map){
        int [] strategyToSet=new int[1];
        return strategyToSet;
    }
}
