

package algorithim2022_project_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author WEN 10
 */
public class Graph {

    Vertex[][] verticies;
    int veticesNo;
    int edgeNo;
    boolean isDigraph;
    ArrayList<String> labels;

    public Graph() {
    }

    
    public Graph(int veticesNo, int edgeNo, boolean isDigraph) {
        this.veticesNo = veticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        verticies = new Vertex[veticesNo][veticesNo];
        labels = new ArrayList<String>();
    }

    public void makeGraph() {
        Random random = new Random();
        // random weight 
        for (int i = 0; i < veticesNo - 1; i++) {
            int w = random.nextInt(20) + 1;
            addEdge(i, i + 1, w);
        }
// the rest of the edges 
        int remainingEdges = edgeNo - veticesNo - 1;
        for (int i = 0; i < remainingEdges; i++) {
            int source = random.nextInt(veticesNo);
            int target = random.nextInt(veticesNo);

            int weight = random.nextInt(20) + 1;
            if ((source == target)) {
                i--;
            } else {
                addEdge(source, target, weight);
            }
        }
    }

    public void readGraphFromFile(String fileName) throws FileNotFoundException, IOException {
        labels = new ArrayList<String>();
        String source, target;
        int weight;

        File file_graph = new File(fileName);
        Scanner file_input = new Scanner(file_graph);

        file_input.next();
        int type = file_input.nextInt();
        if (type == 0) {
            isDigraph = true;
        } else {
            isDigraph = false;
        }
        veticesNo = 10;
        verticies = new Vertex[veticesNo][veticesNo];
        if (file_input.hasNextLine()) {
            int source_position, target_position;
            while (file_input.hasNextLine()) {
                source = file_input.next();
                target = file_input.next();
                addVertLabel(source);
                addVertLabel(target);
                weight = file_input.nextInt();

                source_position = getVertPos(source);
                target_position = getVertPos(target);
                addEdge_file(source_position, target_position, weight);
            }
        }
        file_input.close();
    }

    public void addEdge(int v, int u, int w) {
        verticies[v][u] = new Vertex(w);
        if (isDigraph) {
            verticies[u][v] = new Vertex(w);
        }
    }

    public void addEdge_file(int v, int u, int w) {
        addEdge(v, u, w);

        if (isDigraph== true) {
            edgeNo++;
        } 
        else {
            edgeNo += 2;
        }
    }

    public int getVertPos(String v) {
        int pos = labels.indexOf(v);
        return pos;
    }

    public boolean addVertLabel(String vLabel) {
        if (!labels.contains(vLabel)) {
            labels.add(vLabel);
            return true;
        } else {
            return false;
        }
    }
    
    
public void Print_Graph() {
  
        System.out.print(" ");
        for (int i = 0; i < veticesNo; i++) {
            System.out.print("  " + labels.get(i) + "\t");
        }
        System.out.println();
        for (int i = 0; i < veticesNo; i++) {
         System.out.print(labels.get(i));
            for (int j = 0; j < veticesNo; j++) {
                if (i == j) {
                    System.out.print("  0\t");

                } else if (verticies[i][j] != null) {

                    if (verticies[i][j].weight == 99999) {
                        System.out.print("  ∞\t");
                    } else {
                        System.out.print("  " + verticies[i][j].weight + "\t");
                    }
                } else {
                    System.out.print("  ∞\t");
                }

            }
            System.out.println("");
        }
        System.out.println("--------------------------");
    }    
    
    
    

}
