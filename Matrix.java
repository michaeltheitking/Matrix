
/**
 * The class Matrix creates and performs various operations on matrices.
 * 
 * @author michael king
 * @version 02.26.02
 */
public class Matrix
{
    private int [][] myMatrix;

    /**
     * Default constructor
     * pre: none
     * post: creates a default matrix of size 1 x 1 that contains 0
     * Big O: O(c) <constant time>
     */
    public Matrix()
    {
        this(1, 1, 0);
    }

    /**
     * Constructor that takes in a 2D array param
     * pre: none
     * post: creates a matrix equal to the paramater matrix
     * @param: int [][] mat is a 2D int array
     * Big O: O(N^2)
     */
    public Matrix(int[][] mat)
    {
        myMatrix = new int[mat.length][mat[0].length];
        for(int row = 0; row < mat.length; row++)
        {
            for(int col = 0; col < mat[0].length; col++)
            {
                myMatrix[row][col] = mat[row][col];
            }
        }
    }

    /**
     * Constructor to set num of rows, columns, and initial values
     * pre: numRows, numCols > 0
     * post: creates a matrix of size numRows x numCols that contains initialVal
     * @param: int numRows, int NumCols, int initialVal
     * Big O: O(N^2)
     */
    public Matrix(int numRows, int numCols, int initialVal)
    {
        myMatrix = new int[numRows][numCols];

        for(int row = 0; row < numRows; row++)
        {
            for(int col = 0; col < numCols; col++)
            {
                myMatrix[row][col] = initialVal;
            }
        }
    }

    /**
     * Constructor that takes object of type Matrix and copies it
     * pre: none
     * post: creates a deep copy of Matrix param
     * Big O: O(C) <constant time>
     */
    public Matrix(Matrix other)
    {
        this(other.myMatrix);
    }

    /**
     * Method to change an element of a matrix
     * pre: row and column are in bounds of matrix
     * post: the array is changed at position (row, column) with a new value of newValue
     * @param: int row, int column, int newValue
     * Big O: O(c) <constant time>
     */
    public void changeElement(int row, int column, int newValue)
    {
        myMatrix[row-1][column-1] = newValue;
    }

    /**
     * Method to change all elements of a given row to a given value
     * pre: row is a valid row in the matrix
     * post: every element in the specified row is changed to the specified number
     * @param: int row, int newValue
     * Big O: O(N)
     */
    public void changeRow(int row, int newValue)
    {
        for(int col = 0; col < myMatrix[row].length; col++)
        {
            myMatrix[row-1][col] = newValue; //compensates for the input starting at 1, rather than 0
        }
    }

    /**
     * Method to change all the elements of a given column to a given value
     * pre: col is a valid column in the matrix
     * post: every element in the specified column is changed to the specified number
     * @param: int col, int newValue
     * Big O: O(N)
     */
    public void changeColumn(int col, int newValue)
    {
        for(int row = 0; row < numRows(); row++)
        {
            myMatrix[row][col-1] = newValue; //compensates for the input starting at 1, rather than 0
        }
    }

    /**
     * Method to return the number of rows in a matrix
     * pre: none
     * post: returns an int = to number of rows
     * Big O: O(c) <constant time>
     */
    public int numRows()
    {
        return myMatrix.length;
    }
    
    /**
     * Method to return the number of columns in a matrix
     * pre: this is not a ragged array
     * post: returns an int = to number of columns
     * Big O: O(c) <constant time>
     */
    public int numCols()
    {
        return myMatrix[0].length;
    }

    /**
     * Method to change the number of rows in a matrix
     * pre: newNumRows > 0
     * post: numRows() = newNumRows, all new rows have value newValue
     * @param: int newNumRows, int newValue
     * Big O: O(N)
     */
    public void changeNumRows(int newNumRows, int newValue)
    {
        int [][]tempMatrix = new int[newNumRows][this.numCols()];
        
        for(int row = 0; row < newNumRows; row++)
        {
            for(int col = 0; col < myMatrix[0].length; col++)
            {
                //if this is a matrix expansion, set new elements to a new value
                if(row >= myMatrix.length)
                {
                    tempMatrix[row][col] = newValue;
                }
                else
                tempMatrix[row][col] = myMatrix[row][col];
            }
        }
        myMatrix = tempMatrix;
    }

    /**
     * Method to change the number of rows in a matrix
     * pre: newNumRows > 0
     * post: numRows() = newNumRows, all new rows have value 0
     * @param: int newNumRows
     * Big O: O(C) <constant time>
     */
    public void changeNumRows(int newNumRows)
    {
        changeNumRows(newNumRows, 0);
    }

    /**
     * Method to change the number of columns in a matrix
     * pre: newNumCols > 0
     * post: numCols() = newNumCols, all new columns have value newValue
     * @param: int newNumCols, int newValue
     * Big O: O(N)
     */
    public void changeNumCols(int newNumCols, int newValue)
    {
        int [][] tempMatrix = new int[myMatrix.length][newNumCols];
        
        for(int r = 0; r < myMatrix.length; r++)
        {
            for(int c = 0; c < newNumCols; c++)
            {
                if(c >= myMatrix[r].length)
                    tempMatrix[r][c] = newValue;
                else
                    tempMatrix[r][c] = myMatrix[r][c];
            }
        }
        myMatrix = tempMatrix;
    }

    /**
     * Method to change the number of columns in a matrix
     * pre: newNumCols > 0
     * post: numCols() = newNumCols, all new columns have value 0
     * @param: int newNumCols
     * Big O: O(N)
     */
    public void changeNumCols(int newNumCols)
    {
        changeNumCols(newNumCols, 0);
    }

    /**
     * Method to change the number of rows and columns in a matrix
     * pre: newNumRows > 0, newNumCols > 0
     * post: numRows() = newNumRows, numCols() = newNumCols, all new elements have value newValue
     * @param: int newNumRows, newNumCols, newValue
     * Big O: O(C) <constant time>
     */
    public void changeSize(int newNumRows, int newNumCols, int newValue)
    {
        changeNumRows(newNumRows, newValue);
        changeNumCols(newNumCols, newValue);
    }

    /**
     * Method to change the number of rows and columns in a matrix
     * pre: newNumRows > 0, newNumCols > 0
     * post: numRows() = newNumRows, numCols() = newNumCols, all new elements have value 0
     * @param: int newNumRows, newNumCols
     * Big O: O(C) <constant time>
     */
    public void changeSize(int newNumRows, int newNumCols)
    {
        changeNumRows(newNumRows, 0);
        changeNumCols(newNumCols, 0);
    }

    /**
     * Method to get the value of an element in a matrix
     * pre: row and col are within bounds of matrix
     * post: returns the int in element (row, column)
     * @param: int row, int col
     * Big O: O(C) <constant time>
     */
    public int getVal(int row, int col)
    {
        return myMatrix[row-1][col-1];
    }

    /**
     * Method to add two matrices together
     * pre: calling matrix and param must be of same dimension, M x N
     * post: returns a Matrix of the result of matrix addition
     * @param: Matrix rhs
     * Big O: O(N^2)
     */
    public Matrix add(Matrix rhs)
    {
        Matrix tempMatrix = new Matrix(this.numRows(), this.numCols(), 0);
        int sum = 0;
    
        for(int r = 0; r < numRows(); r++)
        {
            for(int c = 0; c < numCols(); c++)
            {
                sum = myMatrix[r][c] +  rhs.myMatrix[r][c];
                tempMatrix.myMatrix[r][c] = sum;
            }
        }
        return tempMatrix;
    }

    /**
     * Method to subtract two matrices together
     * pre: calling matrix and param must be of same dimension, M x N
     * post: returns a Matrix of the result of matrix subtraction
     * @param: Matrix rhs
     * Big O: O(N^2)
     */
    public Matrix subtract(Matrix rhs)
    {
        Matrix tempMatrix = new Matrix(this.numRows(), this.numCols(), 0);
        int difference = 0;
    
        for(int r = 0; r < numRows(); r++)
        {
            for(int c = 0; c < numCols(); c++)
            {
                difference = myMatrix[r][c] -  rhs.myMatrix[r][c];
                tempMatrix.myMatrix[r][c] = difference;
            }
        }
        return tempMatrix;         
    }

    /**
     * Method to multiply two matrices together
     * pre: calling matrix column and param row must be equal
     * post: returns a Matrix of the product of two matrices
     * @param: Matrix rhs
     * Big O: O(N^3)
     */
    public Matrix multiply(Matrix rhs)
    {
        Matrix tempMatrix = new Matrix(this.numRows(), rhs.numCols(), 0);
        int sum = 0;        

        for(int r = 0; r < this.numRows(); r++)
        {
            for(int c = 0; c < rhs.numCols(); c++)
            {
                sum = 0;
                for(int place = 0; place < this.numCols(); place++)
                {
                    sum += this.myMatrix[r][place] * rhs.myMatrix[place][c];
                }
                tempMatrix.myMatrix[r][c] = sum;
            }
        }
        return tempMatrix;
    } 

    /**
     * Method to get the transposition of a matrix
     * pre: none
     * post: returns a Matrix of the transposition of a matrix
     * @param: none
     * Big O: O(C) <constant time>
     */
    public Matrix getTranspose()
    {
        Matrix temp = new Matrix(numCols(), numRows(),0);

        for(int r = 0; r < numCols(); r++)
        {
            for(int c = 0; c < numRows(); c++)
            {
                temp.myMatrix[r][c] = myMatrix[c][r];
            }
        }
    return temp;
    }

    /**
     * Method to transpose a matrix
     * pre: none
     * post: transposes a matrix (reverses rows and columns)
     * @param: none
     * Big O: O(N^2)
     */
    public void transpose()
    {
        for(int r = 0; r < numCols(); r++)
        {
            for(int c = 0; c < numRows(); c++)
            {
                myMatrix[r][c] = myMatrix[c][r];
            }
        }
    }

    /**
     * Method to see if two matrices are symmetric
     * pre: none
     * post: returns true if a matrix transposition == original matrix 
     * @param: none
     * Big O: O(N^2)
     */
    public boolean isSymmetric()
    {
        Matrix temp = this.getTranspose();
        if(this.equals(temp) )
        {   return true;    }

        return false;
    }

    /**
     * Method to see if two matrices are equal
     * pre: none
     * post: returns true if the matrices have all equal values
     * @param: Object rhs
     * Big O: O(N^2)
     */
    public boolean equals(Object rhs)
    {
        boolean allMatch = false;

        if(!(rhs instanceof Matrix) || rhs == null)
            return false;
        if(this == rhs)
            return true;

        Matrix temp = (Matrix) rhs;

        //matrices can only be == if they have same dimensions
        if(this.numRows() != temp.numRows() || this.numCols() != temp.numCols())
            return false;
    
        for(int r = 0; r < numRows(); r++)
        {
            for(int c = 0; c < numCols(); c++)
            {
                if(this.myMatrix[r][c] == temp.myMatrix[r][c])
                    allMatch = true;
                else
                    return false;
            }
        }
        return allMatch;
    }

    /**
     * Method to convert a matrix to a string
     * pre: none of the elements are greater than 6 characters
     * post: prints out the matrix with up to six spaces of padding
     * @param: 
     * Big O: O(N^2)
     */
    public String toString()
    {
        String intString = "";
        String matrixString = "";
        int numLength = 0;
        
        for(int r = 0; r < numRows(); r++)
        {
            for(int c = 0; c < numCols(); c++)
            {
                intString = String.valueOf(myMatrix[r][c]).toString();
                numLength = intString.length();

                while(numLength <=6)
                {
                    intString += " ";
                    numLength++;
                }
                matrixString += " " + intString;
            }
                matrixString += '\n';
        }
        return matrixString;
    }                
}
