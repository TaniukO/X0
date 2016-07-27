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
            m= new MapX0(wherebyYouPlay);
            ai =new AI_minmax(3);

            while(m.isWinner()==2){
                m.printMap();
                m.setFlag(inputMen());
                m.setFlag(idToIJ(ai.ai(m)));
            }
            m.printMap();

            if(m.isWinner()==wherebyYouPlay)
            System.out.println("X is winner");
            else System.out.println("zero is winner");

            if(!areYouWantToOneMorePlay())break;
        }
    }
    private static int[] idToIJ(int id) {
        int[] ij=new int[3];
        ij[0]=(int) Math.floor(id/3);
        ij[1]=id-(3*ij[0]);
        ij[2]=0;//FLAG_AI
        return ij;
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

                if(s.length()==2 && i==0){
                    for(int j=0;j<=1;j++) {
                        toSet[j] = Integer.parseInt(String.valueOf(s.charAt(j)))-1;
                    }
                    break forLoop;
                }
                System.out.println("your type is bad, please retupe");
            }
            toSet[i] = Integer.parseInt(s)-1;
        }
        return toSet;
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




}
