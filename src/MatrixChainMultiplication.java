public class MatrixChainMultiplication {
    public static void main(String[] args) {

        int arr[] = new int[]{1, 2, 3, 4, 3};
        int n = arr.length;

        System.out.println("Minimum number of multiplications is " +
                MatrixChainOrder(arr, 1, n - 1));
        System.out.println(matrixChainOrderDp(arr));
    }


    /*
    A1,A2,A3
        |
      /      \
 [A1,A2][A3]  [A1] [A2,A3]

    * */
    private static int MatrixChainOrder(int[] arr, int i, int j) {

        if (i >= j)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {

            int costij = MatrixChainOrder(arr, i, k) + MatrixChainOrder(arr, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
            min = Math.min(costij, min);
        }

        return min;

    }

    public static int matrixChainOrderDp( int [] arr)
    {
        int n= arr.length;
        int[][] dp= new int [n+1][n+1];

        for (int leng = 2; leng <=n ; leng++) {
            for (int i = 1; i <=n-leng ; i++) {
                int j=i+leng-1;
                    int ans=Integer.MAX_VALUE;
                for(int k=i;k<j;k++)
                {
                ans=Math.min( ans,dp[i][k]+dp[k+1][j] +arr[i-1]*arr[k]*arr[j]);
                }
                dp[i][j]=ans;
            }

            }
            return dp[1][n-1];
        }

}