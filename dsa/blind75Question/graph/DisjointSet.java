package dsa.blind75Question.graph;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node))
            return node;
        int ultParent = findParent(parent.get(node));
        parent.set(node, ultParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ultP_u = findParent(u);
        int ultP_v = findParent(v);
        if (ultP_v == ultP_u)
            return;
        if (rank.get(ultP_u) < rank.get(ultP_v))
            parent.set(ultP_u, ultP_v);
        else if (rank.get(ultP_u) > rank.get(ultP_v))
            parent.set(ultP_v, ultP_u);
        else {
            parent.set(ultP_u, ultP_v);
            int rankU = rank.get(ultP_u);
            rank.set(ultP_u, rankU + 1);
        }

    }


}
