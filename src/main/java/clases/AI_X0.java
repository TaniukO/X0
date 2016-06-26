package clases;

/**
 * Created by SaNcOs on 26.06.2016.
 */
public class AI_X0 {
   int[] toSet=new int[3];
    int whyrebyAIIsPlaying=0;

    public AI_X0(int whyrebyAIIsPlaying) {
        this.whyrebyAIIsPlaying = whyrebyAIIsPlaying;
    }

    public int[] WhatSetIJ(int[][] map){
        int[] tmpToSet = strategy1(map);
        for(int i=0;i<=1;i++) toSet[i]=tmpToSet[i];
        toSet[2] = whyrebyAIIsPlaying;
        return toSet;
    }
    private int[] strategy1(int[][] map){
        int [] strategyToSet=new int[2];
        return strategyToSet;
    }
}
