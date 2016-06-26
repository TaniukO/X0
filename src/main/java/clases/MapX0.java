package clases;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by SaNcOs on 26.06.2016.
 */
public class MapX0 {
int[][] map;

    public MapX0() {
        map =new int[3][3];
        for(int i=0;i<3;i++) Arrays.fill(map[i],2);
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[] toSet) {
        map[toSet[0]][toSet[1]]=toSet[2];
    }
}
