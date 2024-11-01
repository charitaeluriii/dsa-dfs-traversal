import java.util.*;
class Graph{
    int vertices;
    LinkedList<Integer>[] adjList;
    @SuppressWarnings("unchecked")
    public Graph(int vertices){
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for(int i = 0; i<vertices;i++){
            adjList[i]= new LinkedList<>();
        }
    }
    public void addEdge(int source , int dest){
        adjList[source].add(dest);
        adjList[dest].add(source);
    }
    public void DFS(int startvertex){
        boolean[] visit = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(startvertex);
        visit[startvertex] = true;
        while(!stack.isEmpty()){
            int currentvertex = stack.pop();
            System.out.print(currentvertex+" ");
            for(int neighbor : adjList[currentvertex]){
                if(!visit[neighbor]){
                    stack.push(neighbor);
                    visit[neighbor] = true;
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