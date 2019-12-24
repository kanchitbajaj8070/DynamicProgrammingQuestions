public class MinimumEditDistance {
    public static void main(String[] args) {
        String src="cast";
        String dest="cat";
        System.out.println(minimumEditDistance(src,dest,0,0));
    }
    public static int minimumEditDistance( String src, String dest ,int i , int j)
    {
        if(i>=src.length()|| j>=dest.length())
            return 0;
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
}
