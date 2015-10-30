package com.mm;

import java.util.ArrayList;

public class MMOrdering {

	public int N[][];
	public int d[];
	//for 4 matrices.
	public int SIZE = 5;
	public static void main( String [ ] args ) throws Exception
    {
		MMOrdering mcm = new MMOrdering();

    	// Initialize N and d
    	mcm.init();

    	// Compute the minimum number of element multiplications required for the matrices defined in init.
    	int result = mcm.minMCM();

    	System.out.println("result = " + result);
    }

	// This method initializes N and d
	// The dimensions of d are hard-coded
	public void init()
	{
		N = new int[SIZE][SIZE];
    	d = new int[SIZE+1];//dimension array

		// N is initialized with everything at infinity, except the diagonals.
		for (int i = 0; i < SIZE; i++)
    	{
    		for (int j = 0; j < SIZE; j++)
    		{
    			if (i == j)
    				N[i][j] = 0;
    			else
    				N[i][j] = 999;
    		}
    	}

		// d stores the dimensions of the arrays, as defined in the notes A0 is a d0xd1 matrix, A1 is a d1xd2 matrix, etc.
		// which is why d has SIZE + 1 dimensions.
    	d[0] = 5;
		d[1] = 3;
		d[2] = 1;
		d[3] = 4;
		d[4] = 6;
		d[5] = 1;
	}

	// This method calculates the minimum number of element multiplications required
	// to multiply the number of matrices given and their given dimensions.
    public int minMCM()
    {
    	// Algorithm defined in Arup's CS II notes.
    	// Basically we are looking for the optimal way to "split" the matrices, where k defines the "split".
    	for (int i = 1; i <= SIZE; i++)
    	{
    		for (int j = 0; j <= SIZE-i; j++)
    		{
    			for (int k = j; k < j+i-1; k++)
    			{
    				System.out.println(" "+i+":"+" "+j+":"+" "+k+":-----"+j+" : "+(j+i-1));
    				if (N[j][j+i-1] > N[j][k]+N[k+1][j+i-1] + d[j]*d[k+1]*d[i+j])
    				{
    					N[j][j+i-1] = N[j][k]+N[k+1][j+i-1] + d[j]*d[k+1]*d[i+j];
    				}
    			}
    		}
    	}

		// Output the final N matrix
    	System.out.println("N = ");
    	for (int i = 0; i < SIZE; i++)
    	{
    		for (int j = 0; j < SIZE; j++)
    		{
    			System.out.print(N[i][j] + "\t");
    		}
    		System.out.println();
    	}

		System.out.println();

		// The result is stored in the first row, last column of N
		return N[0][SIZE-1];
    }
}
