package main.course.oop.tictactoe.util;

/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 *
 */
public class TwoDArray {
	
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 * */
		int[][] twoDArr = new int[rows][cols];	//creates a 2D array with #rows = rows, #cols = cols
		//the following for loops will set each value of the 2D array to the defaultVal
		for(int i = 0; i < rows; ++i)
		{
			for(int j = 0; j < cols; ++j)
			{
				towDArr[i][j] = defaultVal;
			}
		}
	}
	
	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		//the following for loops will set each value of the 2D array to the defaultVal
		for(int i = 0; i < rows; ++i)
		{
			for(int j = 0; j < cols; ++j)
			{
				twoDArr[i][j] = defaultVal;
			}
		}
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 * 
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 * 
		 * 3. val is the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 * 
		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		return "Not implemented";
	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 * 
		 */
		return twoDArr[row][col];
	}
	
	public String getArrayDisplay() {
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 * 
		 */
		
		return "Not implemented";
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 
		 * 			)
		 * 
		 */
		int maxUnique = twoDArr.length()*twoDArr[0].length();
		System.out.println("# of rows: " + twoDArr.length());		//prints # of rows
		System.out.println("# of columns: " + twoDrr[0].length());	//prints # of cols
		int[maxUnique][2] uniqueVal = new int[maxUnique][2];	//2D array used to store unique values
		for(int i = 0; i < twoDArr.length(); ++i)
		{
			for(int j = 0; j < twoDArr[i].length(); ++j)
			{
				isUnique(int[i][j] twoDArr)	
			}
		}
		for(int i = 0; i < uniqueVal.length(); ++i)
		{
			if(uniqueVal[i][1] == 0)	//if the value count is 0, we have reached the end of the list
				break;
			else
			{
				System.out.println("value: " + uniqueVal[i][0]);
			}
		}
		//function to tell if a value is unique, basically searches array
		bool isUnique(int value)
		{
			//checks to see if the value in question is unique or not
			for(int k = 0; k < uniqueVal.length(); ++k)
			{
				if(uniqueVal[k][0] == value)	//if the value already exists
				{
					++uniqueVal[k][1];			//increment its count
					return true;
				}
			}
			//looks for open space in uniqueVal array to record a new unique value
			for(int k = 0; k < uniqueVal.length(); ++k)
			{
				if(uniqueVal[k][1] == 0)
				{
					uniqueVal[k][0] = value;
					uniqueVal[k][1] = 1;
					return false;
				}
			}
		}
		return "Not implemented";
	}		

}
