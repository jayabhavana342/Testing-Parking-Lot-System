class ShortestPath {
    // M x N matrix
    private static final int M = 9;
    private static final int N = 10;

    // Check if it is possible to go to (x, y) from current position. The
    // function returns false if the cell has value 0 or already visited
    private static boolean isSafe(int mat[][], int visited[][], char path[][], int x, int y) {
        if (!(mat[x][y] == 0 || visited[x][y] != 0)){
            path[x][y] = '-';
        }
        return !(mat[x][y] == 0 || visited[x][y] != 0);
    }

    // if not a valid position, return false
    private static boolean isValid(int x, int y) {
        return (x < M && y < N && x >= 0 && y >= 0);
    }

    // Find Shortest Possible Route in a Matrix mat from source cell (0, 0)
    // to destination cell (x, y)

    // 'min_dist' stores length of longest path from source to destination
    // found so far and 'dist' maintains length of path from source cell to
    // the current cell (i, j)

    public static int findShortestPath(int mat[][], int visited[][], char path[][],
                                       int i, int j, int x, int y, int min_dist, int dist) {
        // if destination is found, update min_dist
        if (i == x && j == y) {
            return Integer.min(dist, min_dist);
        }

        // set (i, j) cell as visited
        visited[i][j] = 1;

        // go to bottom cell
        if (isValid(i + 1, j) && isSafe(mat, visited, path, i + 1, j)) {
//            path[i+1][j] = '-';
            min_dist = findShortestPath(mat, visited, path, i + 1, j, x, y,
                    min_dist, dist + 1);
        }

        // go to right cell
        if (isValid(i, j + 1) && isSafe(mat, visited, path, i, j + 1)) {
//            path[i][j+1] = '-';
            min_dist = findShortestPath(mat, visited, path, i, j + 1, x, y,
                    min_dist, dist + 1);
        }

        // go to top cell
        if (isValid(i - 1, j) && isSafe(mat, visited, path, i - 1, j)) {
//            path[i-1][j] = '-';
            min_dist = findShortestPath(mat, visited, path, i - 1, j, x, y,
                    min_dist, dist + 1);
        }

        // go to left cell
        if (isValid(i, j - 1) && isSafe(mat, visited, path, i, j - 1)) {
//            path[i][j-1] = '-';
            min_dist = findShortestPath(mat, visited, path, i, j - 1, x, y,
                    min_dist, dist + 1);
        }

        // Backtrack - Remove (i, j) from visited matrix
        visited[i][j] = 0;

        return min_dist;
    }

    public static void main(String[] args) {
        int mat[][] =
                {
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 1, 1, 1, 1, 1, 0, 1, 0, 1},
                        {0, 0, 1, 0, 1, 1, 1, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                        {0, 1, 1, 1, 1, 1, 1, 1, 0, 0},
                        {1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
                        {0, 0, 1, 0, 0, 1, 1, 0, 0, 1},
                };

        int rows = 9;
        int cols = 10;

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 1) {
                    matrix[i][j] = 1;
                } else if ((i == 2 && (j == 1 || j == 5)) || (i == 5 && (j == 1 || j == 5))) {
                    matrix[i][j] = 1;
                } else if ((i == 3 && (j == 4 || j == 8)) || (i == 6 && (j == 4 || j == 8))) {
                    matrix[i][j] = 1;
                } else if ((j == 3 && (i == 1 || i == 4)) || (j == 7 && (i == 1 || i == 4))) {
                    matrix[i][j] = 1;
                } else if ((j == 2 && (i == 4 || i == 7)) || (j == 6 && (i == 4 || i == 7))) {
                    matrix[i][j] = 1;
                } else if (((i != 0 && i != rows - 1) && j == 1) ||
                        (i == 1 && (j != 0 && j != cols - 1)) ||
                        (i == rows - 2 && (j != 0 && j != cols - 1)) ||
                        (j == cols - 2 && (i != 0 && i != rows - 1)) ||
                        (i == 4 && (j != 0 && j != cols - 1)) ||
                        (j == 4 && (i != 0 && i != rows - 1)) ||
                        (j == 5 && (i != 0 && i != rows - 1))) {
                    matrix[i][j] = 1;
                } else if (i != 0 && i != rows - 1 && j != 0 && j != cols - 1) {
                    matrix[i][j] = 0;
                } else if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    matrix[i][j] = 0;
                }
            }
        }

        matrix[2][2] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(i + ":" + j + " ");
            }
            System.out.println();
        }

        System.out.println();


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        char[][] path = new char[rows][cols];

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                path[i][j] = ' ';
            }

        }

        // construct a matrix to keep track of visited cells
        int[][] visited = new int[rows][cols];

        int min_dist = findShortestPath(matrix, visited, path, 0, 1, 2, 2,
                Integer.MAX_VALUE, 0);

        System.out.println();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }

        if (min_dist != Integer.MAX_VALUE) {
            System.out.println("The shortest path from source to destination "
                    + "has length " + min_dist);
        } else {
            System.out.println("Destination can't be reached from source");
        }
    }
}
