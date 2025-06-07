package graph;

import java.util.ArrayList;
/*
You use a Disjoint Set Union (DSU) data structure (also called Union-Find)
when you need to manage a collection of elements partitioned into a number of disjoint (non-overlapping) sets.

It provides two main operations:

find(element): Determines which set an element belongs to. It returns the "representative" (or "root") of that set.
union(element1, element2): Merges the sets containing element1 and element2 into a single set.

Connectivity Problems: Determining if two elements are connected (e.g., in a graph).
Grouping/Clustering: Grouping elements based on some equivalence relation.
Finding Components: Identifying connected components in a graph.
Cycle Detection: Efficiently detecting cycles in a graph (if union tries to merge elements already in the same set,
a cycle is found).

 */

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
    //Not sure, below is from chatgpt
    public void unionByRankByGpt(int u, int v) {
        int ultimateParentU = findParent(u); // Get the true root of u
        int ultimateParentV = findParent(v); // Get the true root of v

        if (ultimateParentU == ultimateParentV) {
            return; // Already in the same set
        }

        // Compare ranks of the *roots*
        if (rank.get(ultimateParentU) < rank.get(ultimateParentV)) {
            parent.set(ultimateParentU, ultimateParentV); // Make ultimateParentV the parent of ultimateParentU
        } else if (rank.get(ultimateParentU) > rank.get(ultimateParentV)) {
            parent.set(ultimateParentV, ultimateParentU); // Make ultimateParentU the parent of ultimateParentV
        } else {
            // Ranks are equal: Make one the parent of the other (e.g., ultimateParentV becomes parent of ultimateParentU)
            // And then increment the rank of the *new* root (ultimateParentV in this case)
            parent.set(ultimateParentU, ultimateParentV);
            // Get the current rank of ultimateParentV, increment it, and set it back
            rank.set(ultimateParentV, rank.get(ultimateParentV) + 1);
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
