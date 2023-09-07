public class Main {

    public static void main(String[] args) {
        int N = 4;

        // Matrix A
        // Custom input to matrix
        int[][] A = {{1, 2, 3, 4},
                {4, 3, 0, 1},
                {5, 6, 1, 1},
                {0, 2, 5, 6}};

        // Matrix B
        // Custom input to matrix
        int[][] B = {{1, 0, 5, 1},
                {1, 2, 0, 2},
                {0, 3, 2, 3},
                {1, 2, 1, 2}};

        // Matrix C computations

        // Matrix C calling method to get Result
        int[][] C = multiplyMatrices(A, B);

        // Display message
        System.out.println(
                "\nProduct of matrices A and  B : ");

        // Iterating over elements of 2D matrix
        // using nested for loops

        // Outer loop for rows
        for (int i = 0; i < N; i++) {
            // Inner loop for columns
            for (int j = 0; j < N; j++)

                // Printing elements of resultant matrix
                // with whitespaces in between
                System.out.print(C[i][j] + " ");

            // New line once the all elements
            // are printed for specific row
            System.out.println();

        }
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        // Order of Matrix
        int n = A.length;

        // Create new matrix of size n * n
        int[][] R = new int[n][n];

        // if the matrices are 1 * 1, then calculate R using linear multiplication
        if (n == 1) R[0][0] = A[0][0] * B[0][0];

        else {
            // Create the new quadrants to separate A and B into
            int[][] A11 = new int[n / 2][n / 2];
            int[][] A12 = new int[n / 2][n / 2];
            int[][] A21 = new int[n / 2][n / 2];
            int[][] A22 = new int[n / 2][n / 2];
            int[][] B11 = new int[n / 2][n / 2];
            int[][] B12 = new int[n / 2][n / 2];
            int[][] B21 = new int[n / 2][n / 2];
            int[][] B22 = new int[n / 2][n / 2];

            // Divide matrix A into quadrants
            split(A, A11, 0, 0);
            split(A, A12, 0, n / 2);
            split(A, A21, n / 2, 0);
            split(A, A22, n / 2, n / 2);

            // Divide matrix B into quadrants
            split(B, B11, 0, 0);
            split(B, B12, 0, n / 2);
            split(B, B21, n / 2, 0);
            split(B, B22, n / 2, n / 2);

            // M1:=(A1+A3)×(B1+B2)
            int[][] M1 = multiplyMatrices(add(A11, A22), add(B11, B22));

            // M2:=(A2+A4)×(B3+B4)
            int[][] M2 = multiplyMatrices(add(A21, A22), B11);

            // M3:=(A1−A4)×(B1+A4)
            int[][] M3 = multiplyMatrices(A11, subtract(B12, B22));

            // M4:=A1×(B2−B4)
            int[][] M4 = multiplyMatrices(A22, subtract(B21, B11));

            // M5:=(A3+A4)×(B1)
            int[][] M5 = multiplyMatrices(add(A11, A12), B22);

            // M6:=(A1+A2)×(B4)
            int[][] M6 = multiplyMatrices(subtract(A21, A11), add(B11, B12));

            // M7:=A4×(B3−B1)
            int[][] M7 = multiplyMatrices(subtract(A12, A22), add(B21, B22));

            // P:=M2+M3−M6−M7
            int[][] C11 = add(subtract(add(M1, M4), M5), M7);

            // Q:=M4+M6
            int[][] C12 = add(M3, M5);

            // R:=M5+M7
            int[][] C21 = add(M2, M4);

            // S:=M1−M3−M4−M5
            int[][] C22 = add(subtract(add(M1, M3), M2), M6);

            join(C11, R, 0, 0);
            join(C12, R, 0, n / 2);
            join(C21, R, n / 2, 0);
            join(C22, R, n / 2, n / 2);
        }

        return R;
    }

    // Split the parent matrix into a single child matrix
    public static void split(int[][] parent, int[][] child, int x, int y){

        // Outer loop for rows
        for (int i1 = 0, i2 = x; i1 < child.length; i1++, i2++) {

            // Inner loop for columns
            for (int j1 = 0, j2 = y; j1 < child.length; j1++, j2++) {
                child[i1][j1] = parent[i2][j2];
            }
        }
    }

    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;

        int[][] C = new int[n][n];

        // Outer loop for rows
        for (int i = 0; i < n; i++)

            // Inner loop for columns
            for (int j = 0; j < n; j++)

                // Subtracting corresponding elements
                // from matrices
                C[i][j] = A[i][j] + B[i][j];

        // Returning the resultant matrix
        return C;
    }


    public static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;

        int[][] C = new int[n][n];

        // Outer loop for rows
        for (int i = 0; i < n; i++)

            // Inner loop for columns
            for (int j = 0; j < n; j++)

                // Subtracting corresponding elements
                // from matrices
                C[i][j] = A[i][j] - B[i][j];

        // Returning the resultant matrix
        return C;
    }

    public static void join(int[][] child, int[][] parent, int x, int y) {
        // Outer loop for rows
        for (int i1 = 0, i2 = x; i1 < child.length; i1++, i2++)

            // Inner loop for columns
            for (int j1 = 0, j2 = y; j1 < child.length;
                 j1++, j2++)

                parent[i2][j2] = child[i1][j1];
    }

}

