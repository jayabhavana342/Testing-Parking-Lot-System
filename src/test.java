import java.util.Scanner;
import java.io.InputStream;
import java.util.*;

class BellmanFord {
    private int distances[];
    private static int no_of_nodes = 0;
    public static final int MAX_VALUE = 999;

    public BellmanFord(int N) {
        this.no_of_nodes = N;
        distances = new int[no_of_nodes + 1];
    }

    public static void printMatrix(int[][] matrix, int size) {
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print("\t" + matrix[i][j]);
            }
            System.out.println("\n");
        }
        printGraph(matrix, size);
    }

    public static void printGraph(int[][] matrix, int size) {
        System.out.println("\nPrinting Graph:\n");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print("(" + i + "->" + j + ") : " + matrix[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }

    public void FordsAlgorithm(int source, int matrix[][], int destination) {
        for (int node = 1; node <= no_of_nodes; node++) {
            distances[node] = MAX_VALUE;
        }

        distances[source] = 0;

        //Relaxing edges
        for (int node = 1; node <= no_of_nodes - 1; node++) {
            for (int i = 1; i <= no_of_nodes; i++) {
                for (int j = 1; j <= no_of_nodes; j++) {
                    if (matrix[i][j] != MAX_VALUE) {
                        if (distances[j] > distances[i] + matrix[i][j])
                            distances[j] = distances[i] + matrix[i][j];
                    }
                }
            }
        }

        //main computation
        for (int i = 1; i <= no_of_nodes; i++) {
            for (int j = 1; j <= no_of_nodes; j++) {
                if (matrix[i][j] != MAX_VALUE) {
                    if (distances[j] > distances[i] + matrix[i][j])
                        System.out.println("The Graph contains negative egde cycle");
                }
            }
        }

        System.out.println("\nShortest Distances From Source To All Nodes Are:\n");
        for (int vertex = 1; vertex <= no_of_nodes; vertex++) {
            System.out.println("distance of source  " + source + " to "
                    + vertex + " is " + distances[vertex]);
        }

        System.out.print("\nShortest Dist from " + source + " to Dest " + destination + " : " + distances[destination] + "\n\n");
    }


    public static void main(String... arg) {
        int source, destination;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of Nodes: ");
        no_of_nodes = scanner.nextInt();

        int adj[][] = new int[no_of_nodes + 1][no_of_nodes + 1];

        System.out.println("Printing The Adjacency Matrix: ");

        for (int i = 1; i <= no_of_nodes; i++) {
            for (int j = 1; j <= no_of_nodes; j++) {
                adj[i][j] = (int) (Math.random() * 10) + 1;
                adj[j][i] = adj[i][j];
                if (i == j) {
                    adj[i][j] = 0;
                    continue;
                }
                if (adj[i][j] == 0) {
                    adj[i][j] = 0;
                }
            }
        }

        printMatrix(adj, no_of_nodes);

        System.out.println("Generating source randomly: ");
        source = (int) (Math.random() * no_of_nodes);
        if (source == 0) {
            source = 1;
        }
        System.out.println("Source: " + source);

        System.out.println("Generating destination randomly: ");
        destination = (int) (Math.random() * no_of_nodes) + 1;
        if (destination == 0) {
            destination = 1;
        }
        System.out.println("Destination: " + destination);

        BellmanFord bellmanford = new BellmanFord(no_of_nodes);
        bellmanford.FordsAlgorithm(source, adj, destination);
        scanner.close();
    }

}