package Jvastr;
class sudokoSolver {
    int[][] array = new int[9][9];
    public static boolean issafe(int[][] array, int row, int col, int num) {
        int startRow = row - row%3;
        int startCol = col - col%3;
        for(int i = 0; i <= 8; i++) {
            if(array[row][i] == num) return false;
        }
        for( int j = 0; j<= 8; j++) {
            if (array[j][col] == num) return false;
        }
        for(int i = 0;i < 3; i++) {
            for(int j = 0; j < 3 ; j++) {
                if(array[i+ startRow][j + startCol] == num) return false;
            }
        }
        return true;
    }
    public static boolean Solver(int[][] array, int row, int col) {
        if(row == 8 && col == 9) return true;
        if(col == 9) {
            row = row + 1;
            col = 0;
        }
        if(array[row][col] != 0) return Solver(array,row,col+1);
        for(int num = 1; num < 10; num++) {
            if(issafe(array, row,col,num)) {
                array[row][col] = num;
                if(Solver(array, row,col + 1)) return true;
            }
            array[row][col] = 0;
        }
        return false;
    }
    static void  print(int[][] array) {
        for(int i = 0; i < 9;i++) {
            for(int j = 0; j< 9;j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        if (Solver(grid, 0, 0))
            print(grid);
        else
            System.out.println("No Solution exists");
    }
}
