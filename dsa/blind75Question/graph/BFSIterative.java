package dsa.blind75Question.graph;

import java.util.*;

public class BFSIterative {


    public void BFSIterativeMethod(int startVertex){

        Queue<Integer> queue=new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();

        Map<Integer, ArrayList<Integer>> adjacencyList= new HashMap<>();//hold edges

        queue.offer(startVertex);

        while(!queue.isEmpty()){

            int curr_vertex=queue.poll();
            visited.add(curr_vertex);
            System.out.print(curr_vertex + " ");

            for(int neighbour : adjacencyList.getOrDefault(curr_vertex, new ArrayList<>())){
                if(!visited.contains(neighbour)){
                    queue.offer(neighbour);
                }
            }

        }


    }

}
