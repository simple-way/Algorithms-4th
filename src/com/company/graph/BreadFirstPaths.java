package com.company.graph;

import com.company.base.Queue;
import com.company.base.Stack;

public class BreadFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];//到达该顶点的最短路径已知吗？
        edgeTo = new int[G.V()];//到达该顶点的一支路径上的最后一个顶点
        this.s = s;//起点
        bfs(G,s);
    }

    private void bfs(Graph G, int s){
        Queue<Integer> queue = new Queue<>();
        marked[s] = true;//标记起点
        queue.enqueue(s);//将它列入队列
        while (!queue.isEmpty()){
            int v = queue.dequeue();//从队列中删去下一顶点
            for(int w : G.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;//保存最短路径的最后一条边
                    marked[w] = true;//标记它，因为最短路径已知
                    queue.enqueue(w);//并将它添加到队列中
                }
            }
        }
    }
    public boolean hasPathTo(int v){ return marked[v];}
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<>();
        for(int x = v;x != s; x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
