import java.util.Arrays;
import java.util.Scanner;

public class RobotPathsCodeChef {
    /*
  All submissions for this problem are available.
A robot is designed to move on a rectangular grid of M rows and N columns.
 The robot is initially positioned at (1, 1), i.e., the top-left cell. The robot
 has to reach the (M, N) grid cell. In a single step, robot can move only to the cells to
 its immediate east and south directions. That means if the robot is currently at (i, j),
 it can move to either (i + 1, j) or (i, j + 1) cell, provided the robot does not leave
 the grid.

Now somebody has placed several obstacles in random positions on the grid, through
 which the robot cannot pass. Given the positions of the blocked cells, your task is
 to count the number of paths that the robot can take to move from (1, 1) to (M, N).

Since the answer can get very large, output the answer modulo 1000000007.

Input
The first line contains 3 integers M, N and P denoting the number of rows,
 number of columns and number of blocked cells respectively.
In the next P lines, each line has exactly 2 integers i and j denoting that
the cell (i, j) is blocked.

Output
Output should contain a single integer, the number of paths modulo 1000000007.

Constraints
1 <= M, N <= 103
0 <= P <= M * N
1 <= i <= M
1 <= j <= N
Example
Input
4 3 2
3 3
3 1

Output
2

Explanation
The only 2 possible paths are
(1, 1) -> (1, 2) -> (2, 2) -> (3, 2) -> (4, 2) -> (4, 3) and
(1, 1) -> (2, 1) -> (2, 2) -> (3, 2) -> (4, 2) -> (4, 3)*/

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        int p = s.nextInt();
        int[][] dp = new int[m][n];
        for (int[] a : dp)
            Arrays.fill(a, 0);
        for (int i = 1; i <= p; i++) {
            int row = s.nextInt();
            int col = s.nextInt();
            dp[row - 1][col - 1] = -1;// 0 for blocked cells
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]+" ");
            } System.out.println();
        }
        System.out.println(pathsDp(dp,m,n));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]+" ");
            } System.out.println();
        }
    }

    /*
    * Reccurence relation
    * dp[i][j]=dp[i-1][j]+dp[i][j-1]
    * if both not blocked, if blocked then we put 0 int its place
    * First row -> only 1 way to reach each cell so dp[0][i]=1;but if any one cell blocked
    * then dp[0][i]=0 for that block and all blocks after it.
    * same for 1st column
    */
    public static int  pathsDp( int[][]dp,int m, int n)
    {   if(dp[0][0]==-1)
        return 0;
    int f=0;
        for (int i = 0; i <n ; i++) {
            if(dp[0][i]==-1)
                f=1;
            if( f==0)
            dp[0][i]=1;
            else
                dp[0][i]=0;
        }
        f=0;
        for (int i = 0; i < m; i++) {

            if(dp[i][0]==-1)f=1;
            if( f==0)
                dp[i][0]=1;
            else
                dp[i][0]=0;
        }

        for (int i = 1; i <m ; i++) {
            for (int j = 1; j < n; j++) {
                if(dp[i][j]==-1)
                    continue;
                if(dp[i-1][j]!=-1&&dp[i][j-1]!=-1)
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
                else if(dp[i-1][j]==-1)
                    dp[i][j]=dp[i][j-1];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        if(dp[m-1][n-1]==-1)
            return 0;
        else
        return dp[m-1][n-1];
    }
}
