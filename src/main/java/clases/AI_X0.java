package clases;
/**
 * Created by SaNcOs on 26.06.2016.
 */
public class AI_X0 {
   int[] toSet=new int[3];
    int AI_FLAG=0;
    int man_FLAG=1;
    public AI_X0(int whyrebyAIIsPlaying) {

        if(whyrebyAIIsPlaying==0){
            AI_FLAG=0;
            man_FLAG=1;
        }
        else{
            AI_FLAG=1;
            man_FLAG=0;
        }
    }

    public int[] ai(MapX0 map) {
        int[] flag = changeFlag(map.getMap());

        if (aiGraph(flag, map) == true) {
            return flag;

        } else {
            map.setFlag(flag[0],flag[1],3);
            ai(map);
        }
        int[] r={0,0,AI_FLAG};
        return r;
    }

        private boolean aiGraph(int[] flag,MapX0 map){

            if(map.isWinner()==2) {

                map.setFlag(flag[0],flag[1],flag[2]);
                flag=changeFlag(map.getMap());
                aiGraph(flag,map);
            }else{
                if(map.isWinner()==AI_FLAG) return true;
                else{
                    if(map.isWinner()==man_FLAG /*or isWiner()==FLAG_EQALS*/) return false;
                }
            }
            return false;
        }

    int[] changeFlag(int[][] map){
        return  map[1] ;
    }

//    public int[] WhatSetIJ(int[][] map){
//        int[] tmpToSet = strategy1(map);
//        for(int i=0;i<=1;i++) toSet[i]=tmpToSet[i];
//        toSet[2] = whyrebyAIIsPlaying;
//        return toSet;
//    }
//    private int[] strategy1(int[][] map){
//        int [] strategyToSet=new int[2];
//        return strategyToSet;
//    }
//

}
