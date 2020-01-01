package com.beauty.algorithm.graph;

import java.util.LinkedList;

public class DirectedGraph extends AbstractGraph {

    public DirectedGraph(int v) {
        super(v);
    }

    @Override
    protected void addEdge(int s, int t) { // s先于t，边s->t
        adj[s].add(t);
    }

    public void topoSortByKahn() {
        int[] inDegree = new int[v];
        for (int i=0; i<v; i++) {
            for (int j=0; j<adj[i].size(); j++) {
                Integer w = adj[i].get(j);
                inDegree[w]++;
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0; i<v; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer i = queue.remove();
            System.out.println("->" + i);
            for (int j=0; j<adj[i].size(); j++) {
                Integer k = adj[i].get(j);
                inDegree[k]--;
                if (inDegree[k] == 0) queue.add(k);
            }
        }
    }

    public void topoSortByDFS() {
        // 先构建逆邻接表，边s->t表示，s依赖于t，t先于s
        LinkedList<Integer>[] inverseAdj = new LinkedList[v];
        for (int i=0; i<v; i++) { // 申请空间
            inverseAdj[i] = new LinkedList<>();
        }
        for (int i=0; i<v; i++) {
            for (int j=0; j<adj[i].size(); j++) {
                Integer w = adj[i].get(j); // i->w
                inverseAdj[w].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        for (int i=0; i<v; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, inverseAdj, visited);
            }
        }
    }

    private void dfs(int vertex, LinkedList<Integer>[] inverseAdj, boolean[] visited) {
        for (int i=0; i<inverseAdj[vertex].size(); i++) {
            int w = inverseAdj[vertex].get(i);
            if (visited[w]) continue;
            visited[w] = true;
            dfs(w, inverseAdj, visited);
        } // 先把vertex这个顶点可达的所有顶点打印出来，再打印他自己
        System.out.println("->" + vertex);
    }

}
