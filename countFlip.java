import java.io.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.Arrays;
  

class countFlip
  {
	static int ROW = 3;
    static int COL = 3;
    static int FLIP(int squares[][], int row, int col)


	// Method for getting the minimum value
	
       {
        // These arrays are used to get row and column numbers
        // of  neighbors of a given cell
		int countLocal=0;
        int rowNbr[] = new int[] { 0,1,2,-1,-2,0,0,1,2,1,2,-1,-2,-1,1,-2,2,-1,0,-2,0};
        int colNbr[] = new int[] { 0,1,2,-1,-2,1,2,0,0,2,1,-2,-1,1,-1,2,-2,0,-1,0,-2};
		int localRow=0;
		int localCol=0;
	    int[][] squaresLocal = new int[3][3];

		for(int i=0; i<ROW; i++)
         for(int j=0; j< COL; j++)
             squaresLocal[i][j]=squares[i][j];
        
        for (int k = 0; k < 21; k++)
		{
			localRow= row+rowNbr[k];
			localCol= col+colNbr[k];
			
			  if(localRow <ROW && localCol < COL && localRow >= 0 && localCol >= 0 )
			 
		        {
				    
					

					if (squaresLocal[localRow][localCol] == '*')
					{
                    
					
						    // Update the orgin with white space
							squaresLocal[localRow][localCol] = '.';	
						
                            if(localRow>0 && localCol>0 && localRow < ROW-1 && localCol < COL-1)
					            {
                    
				             		
                                 squaresLocal[localRow-1][localCol] = '.';
				                 squaresLocal[localRow][localCol-1] = '.';
                                 squaresLocal[localRow+1][localCol] = '.';
                                 squaresLocal[localRow][localCol+1] = '.';
                    
                                 }
					         if(localRow>=0 && localCol>=0 && localRow < ROW-1 && localCol < COL-1)
					             {
						          squaresLocal[localRow+1][localCol] = '.';
						          squaresLocal[localRow][localCol+1] = '.';
					              }

							
							if(localRow>=0 && localCol>0 && localRow < ROW-1 && localCol < COL-1)
								   {
									squaresLocal[localRow][localCol-1] = '.';
									}

							if(localRow>0 && localCol>=0 )
									{
									 squaresLocal[localRow-1][localCol] = '.';
									
									 }

						countLocal++;
				    }
				}
					
		}
	
		return countLocal;	
    }
    
	static int getMin(int[] inputArray){ 
		int minValue = inputArray[0]; 
		for(int i=1;i<inputArray.length;i++){ 
		  if(inputArray[i] < minValue){ 
			minValue = inputArray[i]; 
		  } 
		} 
		return minValue; 
	  } 

	static int countFlips(int squares[][], int m, int n)
	{
		// Initialize result
		int count = 0;
		int[] countInd;
		int numberBlacks;
		int loop = 0;
		numberBlacks=0;
		
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<n; j++)
			{
				if (squares[i][j] == '*')
				{
				numberBlacks++;
			}

			}	
			
		}	
		countInd = new int[numberBlacks];
		for (int i=0; i<m; i++)
		{
			for (int j=0; j<n; j++)
			{
				if (squares[i][j] == '*')
				{
				count = FLIP(squares, i, j);
				//char a = (char) squares[i][j];
				//System.out.println("Total counts of individual counts on each test case:  "+count+"\n");
				countInd[loop]=count;
				loop++;
					    
			   }

			}	
			
		}	
		
		count = getMin(countInd);

		return count;
	}
	
	// Driver program
	public static void main (String[] args) throws FileNotFoundException
	{
		// Size of given matrix is m X n
		int m = 3;
		int n = 3;
		int[][] squares = new int[3][3];
		String nextLine1;

    //    System.out.println(new File(".").getAbsolutePath());
		
			File myObj = new File("C:\\Users\\chmtr\\Desktop\\data.in");
			Scanner myReader = new Scanner(myObj);
			String nextLine0 = myReader.nextLine();
			int NoOfTestCases = Integer.parseInt(nextLine0);
		//	System.out.println("NoOfTestCases = "+NoOfTestCases);
		//	System.out.println("---------------------------------------------");
			for(int i=0; i< NoOfTestCases; i++){
			//	System.out.println("Test Case No =======" +i);
				
				for(int j=0; j<3; j++){
					nextLine1 = myReader.nextLine();
				//	System.out.println("nextLine1 ="+nextLine1);
					squares[j][0] = nextLine1.charAt(0);
					squares[j][1] = nextLine1.charAt(1);
					squares[j][2] = nextLine1.charAt(2);


				}
				//System.out.println(Arrays.deepToString(squares));
				//  System.out.println(nextLine1.charAt(0));
			}


	
		
        
		System.out.println(countFlips(squares, m, n));
		


                      

	}
}
