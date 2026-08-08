package dsa.blind75Question.graph;

import java.util.*;
import java.util.stream.Collectors;

public class DFSIterative {

    public void traverseGraph(int startVertex){

        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        Map<Integer,ArrayList<Integer>> adjacencyList= new HashMap<>();//hold edges

        stack.push(startVertex);

        while (!stack.isEmpty()){

            int currVertex=stack.pop();

            visited.add(currVertex);
            for(int neighbour : adjacencyList.getOrDefault(currVertex, new ArrayList<>())){
                if(!visited.contains(neighbour))
                    stack.push(neighbour);
            }

        }



    }

}
