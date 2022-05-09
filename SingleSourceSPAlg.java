/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithim2022_project_2;

/**
 *
 * @author WEN 10
 */
public class SingleSourceSPAlg extends ShortestPathAlgorithm {

    public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }

    public void computeDijkstraAlg() {
        int nVertices = graph.veticesNo;

        // shortest[i] will hold the shortest distance from src to i
        Vertex[] shortest = new Vertex[nVertices];

        // added[i] will true if vertex i is included / in shortest path tree
        // or shortest distance from src to i is finalized
        boolean[] added = new boolean[nVertices];

        // Initialize all distances as INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < nVertices;
                vertexIndex++) {
            shortest[vertexIndex] = new Vertex(Integer.MAX_VALUE);
            added[vertexIndex] = false;
        }

        // Distance of source vertex from itself is always 0
        shortest[0].weight = 0;

        // Parent array to store shortest path tree
        int[] parents = new int[nVertices];

        // The starting vertex does not have a parent
        parents[0] = -1;

        // Find shortest path for all vertices
        for (int i = 1; i < nVertices; i++) {

            // Pick the minimum distance vertex from the set of vertices not yet
            // processed. nearestVertex is always equal to startNode in
            // first iteration.
            int nearestVertex = -1;
            int shortestDistance = Integer.MAX_VALUE;
            for (int vertexIndex = 0;
                    vertexIndex < nVertices;
                    vertexIndex++) {
                if (!added[vertexIndex]
                        && shortest[vertexIndex].weight
                        < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortest[vertexIndex].weight;
                }
            }

            // Mark the picked vertex as processed
            added[nearestVertex] = true;

            // Update dist value of the adjacent vertices of the picked vertex.
            for (int vertexIndex = 0;
                    vertexIndex < nVertices;
                    vertexIndex++) {
                int edgeDistance = 0;
                if (graph.verticies[nearestVertex][vertexIndex] != null) {
                    edgeDistance = graph.verticies[nearestVertex][vertexIndex].weight; //adjacencyMatrix[nearestVertex][vertexIndex];
                }

                if (edgeDistance > 0
                        && ((shortestDistance + edgeDistance)
                        < shortest[vertexIndex].weight)) {
                    parents[vertexIndex] = nearestVertex;
                    shortest[vertexIndex].weight = shortestDistance + edgeDistance;
                }
            }
        }
if(graph.veticesNo==10){
    
    
    
        printSolution(shortest, parents);
    }}
// the printer all info 
    public void printSolution(Vertex dist[], int[] parents) {
        System.out.println("Vertex      Distance     Path");
        for (int i = 0; i < graph.veticesNo; i++) {
            if (graph.labels.size() != 0) {
                System.out.print(graph.labels.get(i) + "             " + dist[i].weight + "           ");
            } else {
                System.out.print(i + "             " + dist[i].weight  + "           ");
            }
            print_Shortest_Path(i, parents);
            System.out.println();
        }
    }
//just the shourt path
    private void print_Shortest_Path(int current, int[] parents) {
        if (current == -1) {
            return;
        }
        print_Shortest_Path(parents[current], parents);
        if (graph.labels.size() != 0) {
            System.out.print(graph.labels.get(current) + " ");
        } else {
            System.out.print(current + " ");
        }
    }

}
