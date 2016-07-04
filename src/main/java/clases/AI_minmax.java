package clases;

import java.util.*;
/**
 * Created by sAnCho on 03.07.2016.
 */
class AI_minmax {
    int farMax;
    // FLAG_AI=0;
    // FLAG_MAN=1;
    // FLAG_ISNOTWINN=2;
    //  FLAG_NOTSET=3;
    // FLAG_EQUAL=4;

/*
    public AI_minmax(int whyrebyAIIsPlaying,int farMax) {
        this.farMax=farMax;
    if(whyrebyAIIsPlaying==0){
        FLAG_AI=0;
        FLAG_MAN=1;
    }
    else{
        FLAG_AI=1;
        FLAG_MAN=0;
    }
    }
*/

    public AI_minmax(int farMax) {
    this.farMax=farMax;
    }

//============================================
    public int ai(int[][] map) {
        int r=Math.round(ai(map,0));
        System.out.println(r);
        return  r;

    }

    float ai(int[][] map,int far) {
        List<Float> tmpAlfas = new LinkedList<Float>();
        while(isThereTurn(map)) {
            switch (Arbiter.isWinner(map)) {
                case 2:
                    int[] flag = freeChangeFlag(map);
                    map[flag[0]][flag[1]] = 3;
                    tmpAlfas.add(ai(map, far + 1));
                    break;
                case 0:
                    tmpAlfas.add(1f);
                    break;
                case 1:
                    tmpAlfas.add(-1f);
                    break;
                case 4:
                    tmpAlfas.add(0f);
                    break;
            }
        }

        float maxAlfa=-1;
        for (int i =0;i<tmpAlfas.size();i++) {
            if(maxAlfa<tmpAlfas.get(i))
                maxAlfa=tmpAlfas.get(i);
        }

        if(far==0){
            return tmpAlfas.indexOf(maxAlfa);
        }

        maxAlfa= (float) ( (double) maxAlfa/Math.pow(2,far));
        return maxAlfa;
    }
//==================================================================


    private int[] freeChangeFlag(int[][] map) {
        int[] flag={-1,-1};
        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3 ; j++) {
                if(map[j][i]==2){
                    flag= new int[]{j, i};
                }
            }
        }

        return flag;
    }

    private int[] changeFlag(List list) {
        int[] flag={0,0};

        return flag;
    }


    public boolean isThereTurn(int[][] map) {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(map[j][i]==2) return true;
            }
        }
        return false;
    }
}
