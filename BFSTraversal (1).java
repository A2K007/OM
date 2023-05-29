import java.io.*;
import java.util.*;
public class BFSTraversal
{
    private int node;
    private LinkedList<Integer> adj[];
    private Queue<Integer> que;
    BFSTraversal(int v)
    {
        node = v;
        adj = new LinkedList[node];
        for (int i=0; i<v; i++)
        {
            adj[i] = new LinkedList<>();
        }
        que = new LinkedList<Integer>();
    }
    void insertEdge(int v,int w)
    {
        adj[v].add(w);
    }
    void BFS(int n)
    {
        boolean nodes[] = new boolean[node];
        int a = 0;
        nodes[n]=true;
        que.add(n);
        while (que.size() != 0)
        {
            n = que.poll();
            System.out.print(n+" ");
            for (int i = 0; i < adj[n].size(); i++)
            {
                a = adj[n].get(i);
                if (!nodes[a])
                {
                    nodes[a] = true;
                    que.add(a);
                }
            }
        }
    }
    public static void main(String args[])
    {Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of vertices");
        int V=sc.nextInt();
        BFSTraversal graph = new BFSTraversal(V);
        System.out.println("Enter total no edges u want to enter:");
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int src=sc.nextInt();
            int dst=sc.nextInt();
            graph.insertEdge(src,dst);
        }

        System.out.println("Breadth First Traversal for the graph is:");
        graph.BFS(0);
    }
}  