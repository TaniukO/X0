package clases;

import clases.AI_X0;
import clases.MapX0;

import java.util.Scanner;


/**
 * Created by SaNcOs on 26.06.2016.
 */
public class Arbiter {
    static MapX0 m;
    static AI_minmax ai;
    static int wherebyYouPlay;
    public static void main(String[] args) {
        while (true){
            wherebyYouPlay=wherebyYouArePlay();
            m= new MapX0();
            ai =new AI_minmax(3);

            while(isWinner(m.getMap())==2){
                printMap(m.getMap());
                m.setMap(inputMen());
                m.setMap(idToIJ(ai.ai(m.getMap())));
            }
            printMap(m.getMap());

            if(isWinner(m.getMap())==wherebyYouPlay)
            System.out.println("X is winner");
            else System.out.println("zero is winner");

            if(!areYouWantToOneMorePlay())break;
        }
    }

    private static boolean areYouWantToOneMorePlay() {
        Scanner scan = new Scanner(System.in);
        String sOneMorePlay;
        System.out.println("Are you want to play one more time");
        while (true){
            System.out.println("type true or false");
        sOneMorePlay=scan.nextLine();
            if(sOneMorePlay.equals("true") || sOneMorePlay.equals("false")) break;
        }
        boolean oneMorePlay = new Boolean(sOneMorePlay);
        return oneMorePlay;
    }

    private static int wherebyYouArePlay() {
        Scanner scanner=new Scanner(System.in);
        String s;
        int ret;
        while(true){
            System.out.println("Type the char of your play");
            s=scanner.nextLine();
            if(s.equals("x") || s.equals("X")){
                ret = 1;
                break;
            }
            if(s.equals("0") || s.equals("o") || s.equals("O")){
                ret = 0;
                break;
            }
        }


        return ret;
    }

    private static int[] idToIJ(int id) {
        int[] ij=new int[3];
            ij[0]=(int) Math.floor(id/3);
            ij[1]=id-(3*ij[0]);
            ij[2]=0;//FLAG_AI
        return ij;
    }

    private static void printMap(int[][] map) {
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

    private static int[] inputMen() {
        int[] toSet=new int[3];
        int[] tmpToSet=whereToSet();
        for(int i=0;i<=1;i++) toSet[i]=tmpToSet[i];
        toSet[2] = 1;//FLAG_men
        return toSet;
    }

    private static int[] whereToSet() {
        int[]toSet=new int[2];
        Scanner scanner=new Scanner(System.in);
        String s;

        forLoop:
        for(int i=0;i<=1;i++) {
            System.out.println("Where to set your flag?");
            if (i == 0) System.out.println("write number of row");
            else System.out.println("write number of colum");

            while(true){
                s = scanner.nextLine();
                if ((Integer.parseInt(s) <= 3) && (Integer.parseInt(s) >= 1))
                    break;
                System.out.println("your type is bad, please retupe");
                if(s.length()==2 && i==0){
                    for(int j=0;j<=1;j++) {
                        toSet[j] = Integer.parseInt(String.valueOf(s.charAt(j)))-1;
                    }
                    break forLoop;
                }
            }
            toSet[i] = Integer.parseInt(s)-1;
        }
        return toSet;
    }

    static int isWinner(int[][] map) {
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
}
