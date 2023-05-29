import java.util.Arrays;

class ShortestPath {
    private int[][] graph; //graph is the adjacency matrix of the graph, where graph[i][j] is the weight of the edge from node i
	//to node j, or 0 if there is no such edge. 
	
    private int sourceNode; //sourceNode is the index of the source node
    private int numNodes;  //numNode is the total no. of vertices/nodes in the graph

	//Constructor
    public ShortestPath(int[][] graph, int sourceNode) {
        this.graph = graph;
        this.sourceNode = sourceNode;
        this.numNodes = graph.length;
    }

//The findShortestPaths() method returns an array of the shortest distances from the source node to all other nodes
    public int[] findShortestPaths() {
		
		//The algorithm works by maintaining an array of tentative distances dist, where dist[i] is the current shortest distance
		//from the source node to node i, and a boolean array visited, where visited[i] is true if node i has been visited
		
        int[] dist = new int[numNodes]; //array of temporary distances
        boolean[] visited = new boolean[numNodes];  //visited array
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[sourceNode] = 0;

        for (int i = 0; i < numNodes - 1; i++) {
            int minDist = Integer.MAX_VALUE;
            int minNode = -1;

            // Find the unvisited node with the smallest tentative distance
            for (int j = 0; j < numNodes; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minNode = j;
                }
            }

            // If no such node exists, we're done
            if (minNode == -1) {
                break;
            }

            // Mark the node as visited and update the distances of its neighbors
            visited[minNode] = true;
            for (int j = 0; j < numNodes; j++) {
                if (graph[minNode][j] != 0 && !visited[j]) {
                    int newDist = dist[minNode] + graph[minNode][j];
                    if (newDist < dist[j]) {
                        dist[j] = newDist;
                    }
                }
            }
        }
		
//In each iteration, the algorithm selects the unvisited node with the smallest tentative distance and marks it as visited. 
//It then updates the tentative distances of its unvisited neighbors. The algorithm stops when all nodes have been visited or 
//when there are no more unvisited nodes with finite tentative distances.

        return dist;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 10, 3, 0},
                {0, 0, 1, 2},
                {0, 4, 0, 8},
                {0, 0, 0, 0}
        };
        int sourceNode = 0;

        ShortestPath sp = new ShortestPath(graph, sourceNode);
        int[] dist = sp.findShortestPaths();

        for (int i = 0; i < dist.length; i++) {
            System.out.println("Shortest distance from node " + sourceNode + " to node " + i + " is " + dist[i]);
        }
    }
}
