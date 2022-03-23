package Jvastr;
import java.util.*;
class queen4 {
    int count = 0;
    ArrayDeque<int[][]> arry = new ArrayDeque<>();
    int value;
    queen4(int value1) {
        this.value = value1;
    }
    public boolean isSafe(int[][] array,int row, int col) {
        int row1, col1;
        //horizontal
        for(int i = 0; i< this.value;i++) {
            if(array[row][i] == 1) return false;
        }
        //vertical
        for(int i = 0;i < this.value;i++) {
            if(array[i][col] == 1) return false;
        }
        for(row1 = row,col1 = col;row1<this.value&&col1<this.value;row1++,col1++) {
            if(array[row1][col1] == 1) return false;
        }
        for(row1 = row,col1 = col; row1>= 0&& col1>= 0;row1--,col1--) {
            if(array[row1][col1] == 1) return false;
        }
        for(row1 = row, col1 = col;col1 < this.value && row1 >= 0;col1++,row1--)
            if(array[row1][col1] == 1) return false;
        for(row1 = row, col1 = col;col1>=0 && row1< this.value;col1--,row1++) {
            if(array[row1][col1] == 1) return false;
        }
        return true;

    }
    public void solver(int[][] queen, int row) {
        if(row >= this.value) {
            for(int i = 0; i< this.value;i++) {
                for(int j = 0;j< this.value;j++) {
                    System.out.print(queen[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println( " \n  ");
            count = count  + 1;
            return;
        }
        for(int i= 0;i < this.value;i++) {
            if(isSafe(queen,row,i)) {
                queen[row][i] = 1;
                solver(queen,row + 1);
                queen[row][i] = 0;
            }
        }
    }
    public ArrayDeque<int[][]> return1() {
        return this.arry;
    }

}
class queens4 {
    public static void main(String[] args) {
        queen4 queen = new queen4(4);
        int[][] arr = new int[4][4];
        queen.solver(arr, 0);
        ArrayDeque<int[][]> new1 = queen.return1();

        for(int[][] k: new1) {
            for(int[] k1: k) {
                for(int k2: k1) {
                    System.out.print(k2 + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println(queen.count);

    }
}
