package data_structures;

class nextDistance {
    int[][] transversed;
    public void nextDistanceNear(int[][] data,int maxCol,int maxRow,int currRow,int currCol,int[][] transversed,int dist) {
        if(currCol<0 || currRow<0 || currRow >= maxRow || currCol >= maxCol) {
            return;
        }
        if(transversed[currCol][currRow] <= dist) {
            return;
        }
        transversed[currCol][currRow] = dist;
        nextDistanceNear(data,maxCol,maxRow,currRow + 1,currCol,transversed,dist + 1);
        nextDistanceNear(data,maxCol,maxRow,currRow-1,currCol,transversed,dist+1);
        nextDistanceNear(data,maxCol,maxRow,currRow,currCol + 1,transversed,dist + 1);
        nextDistanceNear(data,maxCol,maxRow,currRow,currCol-1,transversed,dist+1);
    }
    public void nearest(int[][] arr, int maxCol,int maxRow) {
        transversed = new int[maxCol][maxRow];
        for(int i = 0; i < maxCol;i++) {
            for(int j = 0;j < maxRow;j++) {
                transversed[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0;i < maxCol;i++) {
            for( int j = 0;j < maxRow;j++) {
                if(arr[i][j] == 1) {
                    nextDistanceNear(arr,maxCol,maxRow,i,j,transversed,0);
                }
            }
        }
        for(int i = 0;i < maxCol;i++) {
            for(int j = 0; j < maxRow;j++) {
                System.out.print(" " + transversed[i][j]);
            }
            System.out.println("\n");
        }
    }
}
class rottenFruit {
    public static  void main(String args[]) {
        int arr1[][] =
                {
                        { 1, 0, 1, 1, 0 },
                        { 1, 1, 0, 1, 0 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 0, 0, 0, 0, 1 }
                };
        nextDistance new1 = new nextDistance();
        new1.nearest(arr1,5,5);
    }
}

