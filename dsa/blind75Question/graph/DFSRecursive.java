package dsa.blind75Question.graph;

import java.util.*;

public class DFSRecursive {

    public void traverseGraph(int startVertex){

        Set<Integer> visited = new HashSet<>();
        traverseGraphRecursive(startVertex,visited);

    }

    public void traverseGraphRecursive(int vertex,Set<Integer> visited){

        Map<Integer, ArrayList<Integer>> adjacencyList= new HashMap<>();//hold edges
        visited.add(vertex);

            for(int neighbour : adjacencyList.getOrDefault(vertex, new ArrayList<>())){
                if(!visited.contains(neighbour))
                    traverseGraphRecursive(neighbour,visited);
            }

        }



    }