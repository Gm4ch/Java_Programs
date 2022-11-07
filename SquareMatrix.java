import java.lang.Math;//importing math

public class SquareMatrix {

    final private int[][] DATA; // contents of matrix
    final private int N; // n = # cols in matrix = # rows in matrix

    public SquareMatrix(int[] data, boolean fillByRow) { //creating constructor class
        int N1;
        int[][] DATA1;

        N1 = (int) Math.sqrt(data.length+1);
        if((data.length)% N1 !=0){ //checking if the data creates a square matrix
            System.out.println("This is not a square matrix"); //if the the data doesnt create a square prints error message
            DATA1 = null;
            N1 = 0;
        }
        this.N = N1;
        if (fillByRow) {
            DATA1 = rowFill(data, N); //if data is to be filled by row rowfill class is run
        }
        else {
            DATA1 = colFill(data, N); //if data is to be filled by column colfill class is run
        }
        this.DATA = DATA1;
    }

    private SquareMatrix(int[][] data){ //creating private version of Square matrix for when a whole matrix is inputed rather than a simple array
        N = data.length;
        DATA = data;
    }

    private int[][] rowFill(int[] data, int n){ //rowfill class to fill the matrix by row
        int counter = 0;
        int[][] DATA1 = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int x = 0; x < N; x++) {
                DATA1[i][x] = data[counter];
                counter++;
            }
        }
        return DATA1;
    }

    private int[][] colFill(int[] data, int n){ //colfill class to fill matrix by column
        int counter = 0;
        int[][] DATA1 = new int[N][N];
        for (int i = 0; i < N; i++){
            for (int x = 0; x < N; x++) {
                DATA1[x][i] = data[counter];
                counter++;
            }
        }
        return DATA1;
    }

    public void print() { //prints the matrix if its a square and null if its not 
        if ((DATA == null) || (N == 0)) {
            System.out.println("Null");
        } else {
            for (int i = 0; i < N; i++) {
                System.out.print("\n|");
                for (int x = 0; x < N; x++) {
                    System.out.print(DATA[i][x] + " ");
                }
                System.out.print("\b|");
            }
            System.out.println("");
        }
    }
    /*
    |a b|    +    |e f|    =    |a+e  b+f|
    |c d|         |g h|         |c+g  d+h|
     */
    public SquareMatrix add(SquareMatrix addend){ //adds two matracies 

        if(addend.DATA.length == N){ 
            int[][] addMatrix = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int x = 0; x<N; x++){
                    addMatrix[i][x] = (DATA[i][x] + addend.DATA[i][x]);
                }
            }

            return new SquareMatrix(addMatrix);
        }
        else{
            System.out.println("these Matrices are not of equal sizes");
            return null;
        }

    }

    /*
    c    *     |a b|    =    |c*a c*b|
               |c d|         |c*c c*d|
     */
    public SquareMatrix scale(int scalar){ //multiplies a matrix by the number given

        int[][] newMatrix = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int x = 0; x<N; x++){
                newMatrix[i][x] = (DATA[i][x] * scalar);
            }
        }
        return new SquareMatrix(newMatrix);


    }

    public SquareMatrix subtract(SquareMatrix subtrahend){ subtracts two matracies.
        return(this.add(subtrahend.scale(-1)));
    }

    public static void main(String[] args) {
        // |1 2|
        // |3 4|
        SquareMatrix A = new SquareMatrix(new int[] {1, 2, 3, 4}, true);
        A.print();
        // |5 7|
        // |6 8|
        SquareMatrix B = new SquareMatrix(new int[] {5, 6, 7, 8}, false);
        B.print();
        // |6 9|
        // |9 12|
        A.add(B).print();
        // |4 5|
        // |3 4|
        B.subtract(A).print();
        SquareMatrix C = new SquareMatrix(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, true);
        // can't print this matrix b/c null pointer exception
        C.add(A); // print message; null
        SquareMatrix D = new SquareMatrix(new int[] {1, 2, 3}, false); // print message
        D.print(); // null
    }
}
