package EMS;

public class Graph {

    private int[][] arr;
    private int vertexNum;

    public Graph(int v){
        arr = new int[v][v];
        vertexNum = v;
    }

    public void addEdge(int source, int dest, int w){
        arr[source][dest] = w;
    }

    
    public void Bellman(int s, int d){

        int INF = 9999999;
        int[] Distance = new int[vertexNum];
        int[] parent = new int[vertexNum];

        
        for(int i = 0; i < vertexNum; i++){
            Distance[i] = INF;
            parent[i] = -1;
        }
        Distance[s] = 0;

        
        for(int v = 0; v < vertexNum - 1; v++){
            for(int crt = 0; crt < vertexNum; crt++){
                for(int i = 0; i < vertexNum; i++){
                    if(arr[crt][i] != 0 && Distance[crt] != INF
                            && Distance[crt] + arr[crt][i] < Distance[i]){
                        Distance[i] = Distance[crt] + arr[crt][i];
                        parent[i] = crt;
                    }
                }
            }
        }

        // no path case
        if(Distance[d] == INF){
            System.out.println("No path");
            return;
        }

        // print distance 
        System.out.println("Shortest path distance from " + (s + 1) +
                           " to " + (d + 1) + " = " + Distance[d]);

        // print path
        System.out.print("Path: ");
        printPath(parent, d);
        System.out.println();
    }

    // recursive path printing 
    private void printPath(int[] parent, int j){
        if(j == -1)
            return;
        printPath(parent, parent[j]);
        System.out.print((j + 1) + " ");
    }
}