
public class MaxSS4 {
	public static void main(String[] args) {
		int maxSum=0, thisSum=0;
		int[] inta = new int[args.length];
		for(int i=0;i<args.length;i++){
			inta[i]= Integer.parseInt(args[i]);
		}
		
		for(int j=0;j<args.length-1;j++){
			thisSum = thisSum + inta[j];
			if(thisSum >maxSum)
				maxSum=thisSum;
			else if(thisSum<0){
				thisSum=0;
			}
		}
		System.out.println(maxSum);
	}
}
