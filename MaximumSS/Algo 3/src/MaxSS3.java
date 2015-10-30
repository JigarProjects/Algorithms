import javax.swing.text.AbstractDocument.LeafElement;

public class MaxSS3 {
	public static void main(String[] args) {
		int[] inta = new int[args.length];
		for(int i=0;i<args.length;i++){
			inta[i]= Integer.parseInt(args[i]);
		}
		 if( inta.length > 0 )
			System.out.println( maxSumRec( inta, 0, inta.length - 1 )) ;
		
	}
	
	private static int maxSumRec( int [ ] a, int left, int right )
    {
		System.out.println("Started "+ left +" "+right);
        int maxLeftBorderSum = 0, maxRightBorderSum = 0;
        int leftBorderSum = 0, rightBorderSum = 0;
        int center = ( left + right ) / 2;
 
        if( left == right )  // Base case
            return a[ left ] > 0 ? a[ left ] : 0;
 
        int maxLeftSum  = maxSumRec( a, left, center );
        System.out.println("Left Side "+left +" : "+right+" : "+maxLeftSum);
        int maxRightSum = maxSumRec( a, center + 1, right );
        System.out.println("Right Side "+left +" : "+right+" : "+maxRightSum);
        for( int i = center; i >= left; i-- )
        {
            leftBorderSum += a[ i ];
            if( leftBorderSum > maxLeftBorderSum ){
                maxLeftBorderSum = leftBorderSum;
                System.out.println("LeftBorderSum");
            }
        }
 
        for( int i = center + 1; i <= right; i++ )
        {
            rightBorderSum += a[ i ];
            if( rightBorderSum > maxRightBorderSum )
                maxRightBorderSum = rightBorderSum;
        }
 
        return max3( maxLeftSum, maxRightSum,
                     maxLeftBorderSum + maxRightBorderSum );
    }
	
	 private static int max3( int a, int b, int c )
	    {
	        return (a > b) ? ( (a > c) ? a : c) : ((b > c) ? b : c);
	    }
	 
 
}
