
public class MaxSS {
	public static void main(String[] args) {
		System.out.println("input size is "+args.length);
		int length= args.length;
		int currentsum=0;
		int maxSum=0;
		for(int i=0;i<length-1;i++){
			currentsum=0;
			for(int j=0;j<length-1;j++){
				
				currentsum= currentsum + Integer.parseInt(args[j]);
				System.out.println( i + " "+j+ " "+ currentsum);
				if(currentsum>maxSum){
					maxSum=currentsum;
				}
			}
			
		}
		System.out.println("maximum is "+maxSum);
	}
}
