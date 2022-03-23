package Jvastr;

import java.util.ArrayDeque;
import java.util.ArrayList;

class Bishops {
    public static void main(String[] args) {
        ArrayDeque<int[][]> arry = new ArrayDeque<>();
        int[][] array1 = {{1,2},{3,4}};
        arry.add(array1);
        int[][] ary = arry.getFirst();
        for(int[] k : ary) {
            for(int k1: k) {
                System.out.print(k1);
            }
            System.out.println();
        }
    }
}