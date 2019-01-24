package main.course.oop.tictactoe.util;

/**
 * You must implement the following methods to accept the expected 
 * parameters and return accurate results.
 * You are allowed and expected to add any class attributes and methods 
 * needed to complete this assignment. 
 * 
 * Name: Gregory DeCanio
 * Date: January 24th, 2019
 * Course: COP 4331 - Object Oriented Programming
 * Instructor: Philippa Brown
 */
public class TwoDArray {
	//instance variables
	int numRows;		//holds number of rows for 2D array
	int numCols;		//holds number of columns for 2D array
	int defaultVal;		//holds the default value that each array cell holds
	int[][] twoDArr;	//the 2D array that will be holding the values
	int[][] uniqueVal;	//a 2D array that will keep track of the unique values in twoDArr
	
	public TwoDArray(int rows, int cols, int defaultVal){
		/*TODO - Create a 2D integer array consisting of 
		 * the number of rows and columns given. Initialize 
		 * the array by setting each int to be the defaulVal. 
		 */
		this.numRows = rows;			//stores number of rows in this 2D array for future use
		this.numCols = cols;			//stores number of columns in this 2D array for future use
		this.defaultVal = defaultVal;	//stores what the default value is in this 2D array for future use
		twoDArr = new int[rows][cols];	//creates a 2D array with #rows = rows, #cols = cols
		
		//the following for loops will set each value of the 2D array to the defaultVal
		for(int i = 0; i < rows; ++i)
		{
			for(int j = 0; j < cols; ++j)
			{
				twoDArr[i][j] = defaultVal;
			}
		}
	}
	
	public void initArray(int defaultVal) {
		/*TODO - (Re)Initialize the array by 
		 * setting each int to be the defaulVal 
		 */
		//the following for loops will set each value of the 2D array to the defaultVal
		for(int i = 0; i < numRows; ++i)
		{
			for(int j = 0; j < numCols; ++j)
			{
				twoDArr[i][j] = defaultVal;
			}
		}
	}
	
	public String insertInt(int row, int col, int val) {
		/*TODO - "Insert" based on the following conditions:
		 * 		 * Note: Print the int value in place of (). 
		 * e.g., replace (val) with val.
		 */
		StringBuffer returnMsg = new StringBuffer();		//StringBuffer allows us to append parts of a string continually on each other
		 /*
		 * 1. The location [row][col] is still set to the default value
		 * 		-return "Success! (val) was inserted.
		 */
		if(twoDArr[row][col] == defaultVal)
		{
			twoDArr[row][col] = val;
			System.out.println("Success! " + val + " was inserted");	//comment this line out if you don't want message to print
			returnMsg.append("Success! ").append(val).append(" was inserted.");
		}
		 /*
		 * 2. The location [row][col] is no longer the default value
		 * 		-return "Failure: (row), (col) is not empty.
		 */
		else if(twoDArr[row][col] != defaultVal)
		{
			System.out.println("Failure: " + row + ", " + col + " is not empty");	//comment this line out if you don't want message to print
			returnMsg.append("Failure: ").append(row).append(", ").append(col).append(" is not empty.");
		}
		 /*
		 * 3. val is the default value; 
		 * 		-return "Failure: (val) is not allowed."
		 */
		else
		{
			System.out.println("Failure: " + val + "is not allowed.");	//comment this line out if you don't want message to print
			returnMsg.append("Failure: ").append(val).append(" is not allowed.");
		}
		return returnMsg.toString();
	}
	
	public int getInt(int row, int col) {
		/*TODO - Return the value at the specified row, col
		 */
		return twoDArr[row][col];
	}
	
	public String getArrayDisplay() {
		/*TODO - Create a 2D display of the Array
		 * e.g. 
		 * 	1	0	1
		 *  0	1	0
		 *  0	1	1
		 */
		StringBuffer matrix = new StringBuffer();	//StringBuffer allows us to append parts of a string continually on each other
		String separator = " ";
		for (int i = 0; i < numRows; ++i)
		{
		  for (int j = 0; j < numCols; ++j)
		    if (j > 0)
		      matrix.append(separator).append(twoDArr[i][j]);
		    else
		      matrix.append(separator).append("\n").append(twoDArr[i][j]);
		}
		return matrix.toString();
		//return "Not implemented";
	}
	
	public String getArrayDetails() {
		/*TODO - List the following:
		 * # rows
		 * # columns
		 * How many unique values (in the above example, this would be 2
		 * Value and count of each (e.g. 
		 * 			value:1 count:5
		 * 			value:0 count:4
		 * 			)
		 */
		StringBuffer details = new StringBuffer();	//StringBuffer allows us to append parts of a string continually on each other
		int maxUnique = numRows*numCols;
		details.append("\n");
		details.append("# of rows: ").append(numRows).append("\n");		//prints # of rows
		details.append("# of columns: ").append(numCols);				//prints # of cols
		uniqueVal = new int[maxUnique][2];	//2D array used to store unique values
		//this for loop iterates through the twoDArr and calls isUnique() to see
		//if each value is unique, and record how many instances there are of each entry
		for(int i = 0; i < numRows; ++i)
		{
			for(int j = 0; j < numCols; ++j)
			{
				isUnique(twoDArr[i][j]);
			}
		}
		//this for loop loop prints the unique values in order of when they were found
		for(int i = 0; i < uniqueVal.length; ++i)
		{
			if(uniqueVal[i][1] == 0)	//if the value count is 0, we have reached the end of the list
				break;
			else
			{
				details.append("\n").append("value: ").append(uniqueVal[i][0]);
				details.append(" count: ").append(uniqueVal[i][1]);
			}
		}
		return details.toString();
		//return "Not implemented";
	}
	
	public boolean isUnique(int value)
	//function to tell if a value is unique, basically searches array
	{
		//checks to see if the value in question is unique or not
		for(int k = 0; k < uniqueVal.length; ++k)
		{
			if(uniqueVal[k][0] == value)	//if the value already exists
			{
				++uniqueVal[k][1];			//increment its count
				return true;
			}
		}
		//looks for open space in uniqueVal array to record a new unique value
		for(int k = 0; k < uniqueVal.length; ++k)
		{
			if(uniqueVal[k][1] == 0)
			{
				uniqueVal[k][0] = value;
				uniqueVal[k][1] = 1;
				return false;
			}
		}
		return false;
	}

}
