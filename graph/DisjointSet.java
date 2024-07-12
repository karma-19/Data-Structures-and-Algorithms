package graph;

import java.util.ArrayList;

public class DisjointSet {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    public DisjointSet(int V) {
        for(int i=1; i<=V; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if(node == parent.get(node)) {
            return node;
        } 
        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        //ultimate parent same then do nothing, because already connected
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);
        if(ultimateParentU == ultimateParentV) return;

        //else
        if(rank.get(u) < rank.get(v)) {
            parent.set(ultimateParentU, ultimateParentV);
        } else if(rank.get(u) > rank.get(v)) {
            parent.set(ultimateParentV, ultimateParentU);
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            int rankU = rank.get(ultimateParentU);
            rank.set(ultimateParentU, rankU + 1);
        }
    }

    public void unionBySize(int u, int v) {
        //ultimate parent same then do nothing, because already connected
        int ultimateParentU = findParent(u);
        int ultimateParentV = findParent(v);
        if(ultimateParentU == ultimateParentV) return;

        if(size.get(ultimateParentU) < size.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV);
            size.set(ultimateParentV, size.get(ultimateParentU) + size.get(ultimateParentV));
        } else {
            parent.set(ultimateParentV, ultimateParentU);
            size.set(ultimateParentU, size.get(ultimateParentU) + size.get(ultimateParentV));
        }
    }
}
