import java.util.*;

class DFSTraversal {
    private LinkedList<Integer> adj[];
    private boolean visited[];


    DFSTraversal(int V)
    {
        adj = new LinkedList[V];
        visited = new boolean[V];

        for (int i = 0; i < V; i++)
            adj[i] = new LinkedList<Integer>();
    }

    /* Adding an edge to the graph */
    void insertEdge(int src, int dest) {
        adj[src].add(dest);
    }

    void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> it = adj[vertex].listIterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFS(n);
        }
    }

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int V=sc.nextInt();
        DFSTraversal graph = new DFSTraversal(V);
        System.out.println("Enter total no edges u want to enter:");

        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int src=sc.nextInt();
            int dst=sc.nextInt();
            graph.insertEdge(src,dst);
        }

        System.out.println("Depth First Traversal for the graph is:");
        graph.DFS(0);
    }
}  