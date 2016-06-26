import clases.AI_X0;
import clases.MapX0;

import java.util.Scanner;

/**
 * Created by SaNcOs on 26.06.2016.
 */
public class Arbiter {
    public static void main(String[] args) {
        MapX0 m= new MapX0();
        AI_X0 ai =new AI_X0(0);

        while(isWinner(m.getMap())==2){
            printMap();
            m.setMap(inputMen());
            m.setMap(ai.WhatSetIJ(m.getMap()));
        }
        if(isWinner(m.getMap())==0)
        System.out.println("zeros are Winner");
        else System.out.println("ones are winner");
    }

    private static void printMap() {
    
    }

    private static int[] inputMen() {
        int[] toSet=new int[2];
        for(int i=0;i<=1;i++) toSet = whereToSet();
        toSet[2] = 1;
        return toSet;
    }

    private static int[] whereToSet() {
        int[]toSet=new int[1];
        Scanner scanner=new Scanner(System.in);
        String s;
        for(int i=0;i<=1;i++) {
            System.out.println("Where to set your flag?");
            if(i==0)System.out.println("write number of row");
            else System.out.println("write number of colum");
            s = scanner.nextLine();
            toSet[i] = Integer.parseInt(s);
        }
        return toSet;
    }

    private static int isWinner(int[][] map) {
        for(int i=0;i<=2;i++){
            int r = map[i][0];
            if(r==map[i][1] & r == map[i][2]) return r;
        }
        for(int j=0;j<=2;j++){
            int r = map[0][j];
            if(r==map[1][j] & r == map[2][j]) return r;
        }
        int r=map[0][0];
        if(r==map[1][1] & r == map[2][2]) return r;
        r=map[2][0];
        if(r==map[1][1] & r == map[0][2]) return r;
    return 2;
    }
}
