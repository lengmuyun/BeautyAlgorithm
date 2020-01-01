package com.beauty.algorithm.graph;

import java.util.LinkedList;

public class DirectedWeightGraph {

    /** 邻接表 */
    private LinkedList<Edge> adj[];

    /** 顶点的个数 */
    private int v;

    public DirectedWeightGraph(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t, int w) {
        this.adj[s].add(new Edge(s, t, w));
    }

    /**
     * 从顶点s到顶点t的最短路径
     * @param s
     * @param t
     */
    public void dijkstra(int s, int t) {
        // 用来还原最短路径
        int[] predecessor = new int[this.v];
        Vertex[] vertexes = new Vertex[this.v];
        for (int i=0; i<this.v; i++) {
            vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
        }
        PriorityQueue queue = new PriorityQueue(this.v);
        // 标记是否进入过队列
        boolean[] inqueue = new boolean[this.v];
        vertexes[s].dist = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
            Vertex minVertex = queue.poll();
            // 最短路径产生了
            if (minVertex.id == t) break;
            for (int i=0; i<adj[minVertex.id].size(); i++) {
                // 取出一条minVertex相连的边
                Edge edge = adj[minVertex.id].get(i);
                Vertex nextVertex = vertexes[edge.tid];
                if (minVertex.dist + edge.w < nextVertex.dist) {
                    nextVertex.dist = minVertex.dist + edge.w;
                    predecessor[nextVertex.id] = minVertex.id;
                    if (inqueue[nextVertex.id]) {
                        queue.update(nextVertex);
                    } else {
                        queue.add(nextVertex);
                        inqueue[nextVertex.id] = true;
                    }
                }
            }
        }
        System.out.println(s);
        print(s, t, predecessor);
    }

    private void print(int s, int t, int[] predecessor) {
        if (s == t) return;
        print(s, predecessor[t], predecessor);
        System.out.println("->" + t);
    }

    private class Edge {

        /** 边的起始顶点编号 */
        public int sid;

        /** 边的终止顶点编号 */
        public int tid;

        /** 权重 */
        public int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }

    }

    public class Vertex {

        /** 顶点的编号ID */
        public int id;

        /** 从起始顶点到这个顶点的距离 */
        public int dist;

        public Vertex(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }

    private class PriorityQueue {

        private Vertex[] nodes;
        private int count;

        public PriorityQueue(int v) {
            this.nodes = new Vertex[v+1];
            this.count = v;
        }

        public Vertex poll() {
            return null;
        }

        public void add(Vertex vertex) {

        }

        /**
         * 更新节点的值，并且从下往上堆化，重新符合堆的定义。
         * 时间复杂度O(logn)
         * @param vertex
         */
        public void update(Vertex vertex) {

        }

        public boolean isEmpty() {
            return false;
        }

    }
}
