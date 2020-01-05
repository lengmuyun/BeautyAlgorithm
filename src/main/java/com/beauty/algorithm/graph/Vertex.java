package com.beauty.algorithm.graph;

public class Vertex {

    /** 顶点编号id */
    public int id;

    /** 从起始顶点，到这个顶点的距离，也就是g(i) */
    public int dist;

    /** 新增：f(i) = g(i) + h(i) */
    public int f;

    /** 新增：顶点在地图中的x轴坐标 */
    public int x;

    /** 新增：顶点在地图中的y轴坐标 */
    public int y;

    public Vertex(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.f = Integer.MAX_VALUE;
        this.dist = Integer.MAX_VALUE;
    }

}
