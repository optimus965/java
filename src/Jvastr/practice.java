package Jvastr;
public class practice {
    final int N;
    int[][] board;
    int count = 0;
    public practice(int value) {
        this.N = value;
        board = new int[value][value];
        this.solveNQUtil(board,0);
    }
    boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }
     void solveNQUtil(int board[][], int col)
    {
        if (col >= N) {
            for (int i = 0; i < this.N; i++) {
                for (int j = 0; j < this.N; j++) {
                    System.out.print(board[i][j] + "  ");
                }
                System.out.println();
            }
            count = count + 1;
            System.out.println("____________________________________________________________________________________");
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                solveNQUtil(board, col + 1);
                board[i][col] = 0;
            }
        }
    }
    public static void main(String args[])
    {
        practice Queen = new practice(12);
        System.out.println(Queen.count);
    }
}
