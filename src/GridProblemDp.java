public class GridProblemDp {
    public static void main(String[] args) {

        int [][] grid ={ {1,2,3},{4,8,2},{1,5,3}};
        System.out.println(minPathCost(0,0,grid));
        System.out.println(solveGridDpSolution(grid));
    }
    public static int minPathCost( int i , int j ,int [][]grid)
    {
        if(i==grid.length-1&&j==grid.length-1)
            return grid[i][j];
        if(i>=grid.length||j>=grid.length)
            return 0;
        int horizontalMove= minPathCost(i,j+1,grid);
        int verticalMove=minPathCost(i+1,j,grid);
        if(horizontalMove==0&&verticalMove>0)
            return grid[i][j]+verticalMove;
        else if (verticalMove==0&&horizontalMove>0)
            return grid[i][j]+horizontalMove;
        else
        return grid[i][j]+ Math.min(horizontalMove,verticalMove);


    }
    public static int solveGridDpSolution( int [][] grid)
    {

        int [][]dp=grid;
        for (int i = 1; i < grid.length; i++) {
            dp[0][i]+=dp[0][i-1];
            dp[i][0]+=dp[i-1][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j <grid.length ; j++) {
                dp[i][j]+=Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[grid.length-1][grid.length-1];
    }
}
