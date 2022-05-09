/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithim2022_project_2;

import java.io.IOException;

/**
 *
 * @author WEN 10
 */
public class Algorithim2022_project_2 {

    /**
     * @param args the command line arguments
     */
    static Graph graph;
    static SingleSourceSPAlg singleSourceSPAlg;
    static AllSourceSPAlg allSourceSPAlg;

    public static void main(String[] args) throws IOException {
        
        graph = new Graph();
         long start_time, finesh_time;

        System.out.println("Read From File");
        graph.readGraphFromFile("input_file.txt");
  // to start the time 
        singleSourceSPAlg = new SingleSourceSPAlg(graph);
        start_time = System.currentTimeMillis();
        singleSourceSPAlg.computeDijkstraAlg();
        //finsh the time 
        finesh_time = System.currentTimeMillis();
        System.out.println("Dijkstra Algorithm Time : " + (finesh_time - start_time));
 System.out.println("BEFOR CALL FLOYEDEARSHAL");
        graph.Print_Graph();
        allSourceSPAlg = new AllSourceSPAlg(graph);
        start_time = System.currentTimeMillis();
        System.out.println("AFTER CALL FLOYEDWARSHAL");
        allSourceSPAlg.computeFloyedWarshalAlg();
        finesh_time = System.currentTimeMillis();
        System.out.println("FloyedWarshal Algorithm Time : " + (finesh_time - start_time));

        System.out.println("---------------- End Read From File ------------------------");

        System.out.println("---------------- Using make graph ----------------------------");

        for (int i = 0; i < 5; i++) {
            initialize_graph(i, false);


            allSourceSPAlg = new AllSourceSPAlg(graph);
            start_time = System.currentTimeMillis();
            allSourceSPAlg.computeFloyedWarshalAlg();
            finesh_time = System.currentTimeMillis();
            System.out.println("FloyedWarshal Algorithm Time : " + (finesh_time - start_time));
        }
        // different loops beacuse we have diffrent inputs for algorthims 
        
        
        for (int i = 0; i < 5; i++) {
              initialize_graph2(i, false);

            singleSourceSPAlg = new SingleSourceSPAlg(graph);
            start_time = System.currentTimeMillis();
            singleSourceSPAlg.computeDijkstraAlg();
            finesh_time = System.currentTimeMillis();
            System.out.println("Dijkstra Algorithm Time : " + (finesh_time - start_time));

        }
    }
 // this method initializ th graph for floyd algorthim 
    public static void initialize_graph(int choice, boolean isDigraph) {
        int v_no, ed_no;
        v_no = ed_no = 0;

        if (choice == 0) {
            v_no = 2000;
            ed_no = 10000;
        } else if (choice == 1) {
            v_no = 3000;
            ed_no = 15000;
        } else if (choice == 2) {
            v_no = 4000;
            ed_no = 20000;
        } else if (choice == 3) {
            v_no = 5000;
            ed_no = 25000;
        } else if (choice == 4) {
            v_no = 6000;
            ed_no = 30000;
           } else {
            return;
        }

        System.out.println(choice + 1 + "- Number of verticies = " + v_no + " & Number of Edge = " + ed_no);
        graph = new Graph(v_no, ed_no, isDigraph);
        graph.makeGraph();
        
        
        
        
        
    }
    // this method initializ th graph for dijstra algorthim 
    
     public static void initialize_graph2(int choice, boolean isDigraph) {
        int v_no, ed_no;
        v_no = ed_no = 0;

        if (choice == 0) {
            v_no = 5000;
            ed_no = 25000;
        } else if (choice == 1) {
            v_no = 10000;
            ed_no = 50000;
        } else if (choice == 2) {
            v_no = 15000;
            ed_no = 75000;
        } else if (choice == 3) {
            v_no = 20000;
            ed_no = 100000;
        } else if (choice == 4) {
            v_no = 25000 ;
            ed_no = 125000;
           } else {
            return;
        }

        System.out.println(choice + 1 + "- Number of verticies = " + v_no + " & Number of Edge = " + ed_no);
        graph = new Graph(v_no, ed_no, isDigraph);
        graph.makeGraph();
        
        
        
        
        
    } 
    
}
