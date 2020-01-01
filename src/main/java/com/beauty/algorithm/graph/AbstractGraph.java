package com.beauty.algorithm.graph;

import java.util.LinkedList;

public abstract class AbstractGraph {

    protected int v;
    protected LinkedList<Integer> adj[];

    public AbstractGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    protected abstract void addEdge(int s, int t);

}
