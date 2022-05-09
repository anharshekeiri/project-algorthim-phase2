/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithim2022_project_2;

import java.util.Vector;

/**
 *
 * @author WEN 10
 */
public class AllSourceSPAlg extends ShortestPathAlgorithm {

    final static int INF = 99999;

    public AllSourceSPAlg(Graph graph) {
        super(graph);
    }
    
    public void computeFloyedWarshalAlg() {
        // Get number of vertices
        int numOfVertices = graph.veticesNo;
        // Start the algorithm
        for (int k = 0; k < numOfVertices; k++) {
            for (int i = 0; i < numOfVertices; i++) {
                for (int j = 0; j < numOfVertices; j++) {
                    int i_j , i_k , k_j;
                    if(graph.verticies[i][j] == null)
                    {
                        graph.verticies[i][j] = new Vertex(INF);
                        i_j = INF ;
                    }
                    else
                    {
                        i_j = graph.verticies[i][j].weight;
                    }
                    
                    if(graph.verticies[i][k] == null)
                    {
                        graph.verticies[i][k] = new Vertex(INF);
                        i_k = INF ;
                    }
                    else
                    {
                        i_k = graph.verticies[i][k].weight;
                    }
                    
                    if(graph.verticies[k][j] == null)
                    {
                        graph.verticies[k][j] = new Vertex(INF);
                        k_j = INF ;
                    }
                    else
                    {
                        k_j = graph.verticies[k][j].weight;
                    }
                    
                    graph.verticies[i][j].weight = Math.min(i_j,( i_k + k_j));
                }
            }
//            printGraph();
if(graph.veticesNo==10){
    System.out.println("***D( " + k+ " )***");
graph.Print_Graph();
        }
    }
    }
    public void printGraph() {
        int numVertix = graph.veticesNo;

        for (int i = 0; i < numVertix; i++) {
            for (int j = 0; j < numVertix; j++) {
                if (graph.verticies[i][j].weight == INF) {
                    System.out.print("∞ ,");
                } else {
                    System.out.printf("%-2d, ", graph.verticies[i][j].weight);
                }
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
