public class MinimumEditDistance {
    public static void main(String[] args) {
        String src="cated";
        String dest="cutedfgt";
        long e,f,g;
        e=System.currentTimeMillis();
        System.out.println(minimumEditDistance(src,dest,0,0));
        f=System.currentTimeMillis();
        System.out.println("normal Time "+ (f-e));
        System.out.println(minimumEditDistanceDp(src,dest));
        g=System.currentTimeMillis();
        System.out.println("Dp time is "+(g-f));
                                                    /*
                                                    13
                                                    normal Time 3966
                                                    13
                                                    Dp time is 0
                                                    */
    }
    public static int minimumEditDistance( String src, String dest ,int i , int j)
    {
        if(i==src.length()&& j==dest.length())
            return 0;
        if( i==src.length())
            return dest.length()-j;//very important step
        //insert remaining of characters of destination to src;
        if(j==dest.length())
            return src.length()-i;//delete the remaiing characters of src

        if( src.charAt(i)!=dest.charAt(j))
        {
            int insert=Integer.MAX_VALUE;
            int delete=Integer.MAX_VALUE;
            int replace=Integer.MAX_VALUE;
            insert=1+minimumEditDistance(src,dest,i,j+1);
            delete=1+minimumEditDistance(src,dest,i+1,j);
            replace=1+minimumEditDistance(src, dest, i+1, j+1);
            return Math.min(Math.min(insert,delete),replace);

        }
        else
            return minimumEditDistance(src,dest,i+1,j+1);
    }
    public static int minimumEditDistanceDp( String src, String dest)
    {
        int n=src.length();
        int m=dest.length();
        int [][]dp= new int[n+1][m+1];
        //each cell gives the cost to change src[0..i]-> desr[0..j]
        dp[0][0]=0;
        for (int i = 1; i <=n; i++) {
            dp[i][0]=i;
        }
        for( int i=1;i<=m;i++)
        {
            dp[0][i]=i;
        }
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(src.charAt(i-1)==dest.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1];
                }
                else
                {
                    int insert=Integer.MAX_VALUE,delete=Integer.MAX_VALUE,replace=Integer.MAX_VALUE;
                    replace=1+dp[i-1][j-1];
                    insert=1+dp[i][j-1];
                    delete=1+dp[i-1][j];
                    dp[i][j]=Math.min(Math.min(insert,delete),replace);
                }
            }
        }
        return dp[n][m];
    }
}
