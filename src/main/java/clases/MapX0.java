package clases;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by SaNcOs on 26.06.2016.
 */

class MapX0 {
private int[][] map;
private int wherebyYouPlay;
    private int nextFlag;


    MapX0(int wherebyYouPlay) {
        this.wherebyYouPlay=wherebyYouPlay;
        map =new int[3][3];
        for(int i=0;i<3;i++) Arrays.fill(map[i],2);
        nextFlag=wherebyYouPlay;getNextFlag();
    }
    MapX0(MapX0 map){
        this.map=map.getMap();
    }

    public void setNextFlag(int nextFlag) {
        this.nextFlag = nextFlag;
    }

    int[][] getMap() {
        return map;
    }

    void setFlag(int[] toSet) {
        map[toSet[0]][toSet[1]]=toSet[2];
    }
    void setFlag(int toSetJ,int toSetI,int toSetValue) {
        map[toSetJ][toSetI]=toSetValue;
    }
    public int getWherebyYouPlay() {
        return wherebyYouPlay;
    }


    public boolean isThereTurn() {
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(map[j][i]==2) return true;
            }
        }
        return false;
    }
    void printTraserMap() {
        int wr;
        System.out.println("===============");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(wherebyYouPlay==1) {
                    wr=map[i][j];
                }else{
                    wr=map[i][j];
                }
                System.out.print(" | "+wr);
            }
            System.out.print(" |\n -------------\n");
        }
        System.out.println("===============");
    }
    void printMap() {
        char wr;
        System.out.println("===============");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(wherebyYouPlay==1) {
                    switch (map[i][j]) {
                        case 0: wr = '0';break;
                        case 1: wr = 'X';break;
                        case 2: wr = ' ';break;
                        default: wr = ' ';break;
                    }
                }else{
                    switch (map[i][j]){
                        case 1 : wr='0';break;
                        case 0 : wr='X';break;
                        case 2 : wr=' ';break;
                        default : wr=' ';break;
                    }
                }
                System.out.print(" | "+wr);
            }
            System.out.print(" |\n -------------\n");
        }
        System.out.println("===============");
    }
    int isWinner() {
        int r;
        for(int i=0;i<=2;i++){
            if(map[i][0]==0 || map[i][0]==1){
                r=map[i][0];
                if(r==map[i][1] & r == map[i][2]) return r;
            }
        }
        for(int j=0;j<=2;j++) {
            if (map[0][j] == 0 || map[0][j] == 1) {
                r = map[0][j];
                if (r == map[1][j] & r == map[2][j]) return r;
            }
        }
        if(map[0][0]==0 || map[0][0]==1) {
            r = map[0][0];
            if (r == map[1][1] & r == map[2][2]) return r;
        }
        if(map[2][0]==0 || map[2][0]==1) {
            r = map[2][0];
            if (r == map[1][1] & r == map[0][2]) return r;
        }
        return 2;
    }

    public int getNextFlag() {
        if(nextFlag==1){
            nextFlag=0;
        }else{
            nextFlag=1;
        }
        return nextFlag;
    }
}
