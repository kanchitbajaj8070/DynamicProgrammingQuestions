import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CellMitosis {
    /*
  There's a scientist named Brook who is interested in budding of cells.
  He has one container which initially contains only a single cell.
  Now Brook wants n number of cells in his container.
  So he can change the number of cells in container in 3 different ways -:

Double the number of cells present in the container.

Increase the number of cells in the container by 1.

Decrease the number of cells in the container by 1.

Now, all the above operations have different costs associated
 with them x,y,z respectively for above operations.
 Help brook in finding the minimum cost to generate n cells in the container starting from
 one cell .
Sample Input
5
2 1 3
Sample Output
4
Explanation
Initial number of cell is 1. Applying 2nd operations four times will give 5 cells in the
 container , and its total cost will be 1x4 = 4. One other way to do is - first adding a
 single cell with operation 2nd ,then doubling the cells , and then again adding one more cell
 , with cost = 1+2+1 =4. */


    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(b.readLine());
        int x=Integer.parseInt(b.readLine());
        int y=Integer.parseInt(b.readLine());
        int z=Integer.parseInt(b.readLine());

        System.out.println(cellMitosisDp(n,x,y,z));

    }

    private static int cellMitosisDp(int n, int x, int y, int z) {
        int [] dp= new int[n+1];
        dp[0]=0;
        dp[1]=0;
        // if i is even -> the cost of coming back from i+1 to i is always more
        // can be seen by trying multiple examples
        // than doubling i/2 or going forward from i-1;
        // if i is odd than we can have i-1 case and doubling to form the next greatest even number
        //and then decrementing it i+1/2 +x +z
        // i/2 holds no significance in case of odd numbers
        for( int i=2;i<=n;i++)
        {
            if(i%2==0)
            {
                dp[i]=Math.min( dp[i/2]+x,dp[i-1]+y);
            }
                else
            {
                dp[i]=Math.min(dp[i-1]+y,dp[(i+1)/2]+x+z);
            }

        }

        return dp[n];
    }
}
