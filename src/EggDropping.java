import java.util.Arrays;

public class EggDropping {
    public static void main(String[] args) {
        int n=2;
        int k=10;
        int[][] memo= new int [n+1][k+1];
        for(int[]m:memo)
            Arrays.fill(m,-1);
        for (int i = 0; i <=k ; i++) {
            memo[0][i]=0;
            memo[1][i]=i;
        }
        for(int i=0;i<=n;i++)
            memo[i][0]=0;

        System.out.println(worstCaseDroppings(2,10));

    }
    public static int worstCaseDroppings(int n, int k)
    {
        if(n==1)
            return k;
        if(k==1||k==0)
            return k;
        int m=Integer.MAX_VALUE;
        for (int i = 1; i <=k ; i++) {
            int notbreak = 1+worstCaseDroppings(n, k-i);
            int eggbreak =  1+worstCaseDroppings(n-1,i-1);
            int max=Math.max(notbreak,eggbreak);
            m=Math.min(max,m);
        }
        return m;
    }
}
