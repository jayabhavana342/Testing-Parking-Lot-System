import java.util.*;
import java.lang.*;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rextester {
    public static void main(String args[]) {
//        char[][] matrix = {
//                {'1', '0', '1', '1'},
//                {'1', '1', '1', '1'},
//                {'1', '1', '1', '1'},
//                {'1', '1', '1', 'X'}
//        };

        int rows = 9;
        int cols = 10;

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 && j == 1) {
                    matrix[i][j] = '1';
                } else if ((i == 2 && (j == 1 || j == 5)) || (i == 5 && (j == 1 || j == 5))) {
                    matrix[i][j] = '1';
                } else if ((i == 3 && (j == 4 || j == 8)) || (i == 6 && (j == 4 || j == 8))) {
                    matrix[i][j] = '1';
                } else if ((j == 3 && (i == 1 || i == 4)) || (j == 7 && (i == 1 || i == 4))) {
                    matrix[i][j] = '1';
                } else if ((j == 2 && (i == 4 || i == 7)) || (j == 6 && (i == 4 || i == 7))) {
                    matrix[i][j] = '1';
                } else if (((i != 0 && i != rows - 1) && j == 1) ||
                        (i == 1 && (j != 0 && j != cols - 1)) ||
                        (i == rows - 2 && (j != 0 && j != cols - 1)) ||
                        (j == cols - 2 && (i != 0 && i != rows - 1)) ||
                        (i == 4 && (j != 0 && j != cols - 1)) ||
                        (j == 4 && (i != 0 && i != rows - 1)) ||
                        (j == 5 && (i != 0 && i != rows - 1))) {
                    matrix[i][j] = '1';
                } else if (i != 0 && i != rows - 1 && j != 0 && j != cols - 1) {
                    matrix[i][j] = '0';
                } else if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    matrix[i][j] = '0';
                }
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        matrix[6][6] = 'X';
        System.out.println();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        boolean pathExists = pathExists(matrix);

        System.out.println(pathExists ? "YES" : "NO");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean pathExists(char[][] matrix) {
        int N = matrix.length;

        List<Node> queue = new ArrayList<Node>();
        queue.add(new Node(0, 1));
        boolean pathExists = false;

        while (!queue.isEmpty()) {
            Node current = queue.remove(0);
            if (matrix[current.x][current.y] == 'X') {
                pathExists = true;
                break;
            }

            matrix[current.x][current.y] = '0'; // mark as visited

            List<Node> neighbors = getNeighbors(matrix, current);
            queue.addAll(neighbors);
        }

        return pathExists;
    }

    public static List<Node> getNeighbors(char[][] matrix, Node node) {
        List<Node> neighbors = new ArrayList<Node>();

        if (isValidPoint(matrix, node.x - 1, node.y)) {
            neighbors.add(new Node(node.x - 1, node.y));
        }

        if (isValidPoint(matrix, node.x + 1, node.y)) {
            neighbors.add(new Node(node.x + 1, node.y));
        }

        if (isValidPoint(matrix, node.x, node.y - 1)) {
            neighbors.add(new Node(node.x, node.y - 1));
        }

        if (isValidPoint(matrix, node.x, node.y + 1)) {
            neighbors.add(new Node(node.x, node.y + 1));
        }



        return neighbors;
    }

    public static boolean isValidPoint(char[][] matrix, int x, int y) {
        if (!(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0')){
            System.out.println(x + " " + y);
//            matrix[x][y] = '-';
        }
        return !(x < 0 || x >= matrix.length || y < 0 || y >= matrix.length) && (matrix[x][y] != '0');
    }
}
