import java.util.*;
class Graph{
    int vertices;
    LinkedList<Integer> adjlist[];
    public Graph(int vertices){
        this.vertices = vertices;
        adjlist = new LinkedList[vertices];
        for(int i = 0; i<vertices;i++){
            adjlist[i]= new LinkedList<>();
        }
    }
    public void addEdge(int source , int dest){
        adjlist[source].add(dest);
        adjlist[dest].add(source);
    }
    public void DFS(int startvertex){
        boolean visited[] = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(startvertex);
        visited[startvertex] = true;
        while(!stack.isEmpty()){
            int currentvertex = stack.pop();
            System.out.print(currentvertex+" ");
            for(int neighbor : adjlist[currentvertex]){
                if(!visited[neighbor]){
                    stack.push(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}
class Main{
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.DFS(2);
    }
}